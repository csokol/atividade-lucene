package br.usp.ime.topicosweb.atividade.termvector;

import java.util.List;

public class GeradorDeTagCloud {
    private static final String HEADER = "<html><head><title>Tag Cloud</title></head><body><div style='margin:auto; width=900px; text-align:center;'>";
    private static final String FOOTER = "</div></body></html>";

    public String gera(TermVector termVector) {
        StringBuffer html = new StringBuffer(HEADER);
        html.append("<h1>Tag cloud!</h1>");
        List<TagMagnitude> magnitudes = termVector.getMagnitudes();
        for (TagMagnitude tagMagnitude : magnitudes) {
            int magnitude = (int) tagMagnitude.getMagnitude();
            html.append("<a href='#' style='float:left; margin-left:10px; font-size:");
            html.append(magnitude * 3 + "px;'>");
            html.append(tagMagnitude.getTag());
            html.append("</a>");
        }
        html.append(FOOTER);
        return html.toString();
    }

}
