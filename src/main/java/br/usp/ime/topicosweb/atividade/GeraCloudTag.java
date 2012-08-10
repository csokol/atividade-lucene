package br.usp.ime.topicosweb.atividade;

import java.io.FileWriter;
import java.io.IOException;

import br.usp.ime.topicosweb.atividade.termvector.GeradorDeTagCloud;
import br.usp.ime.topicosweb.atividade.termvector.TermVector;

public class GeraCloudTag {

    public static void main(String[] args) throws IOException {
        TermVector termVector = geraTermVector();
        GeradorDeTagCloud gerador = new GeradorDeTagCloud();
        String html = gerador.gera(termVector);
        FileWriter writer = new FileWriter("cloud.html");
        writer.write(html);
        writer.close();
    }

    private static TermVector geraTermVector() {
        TermVector termVector = new TermVector();
        termVector.processaTermo("web");
        termVector.processaTermo("web");
        termVector.processaTermo("web");
        termVector.processaTermo("web");
        termVector.processaTermo("web");
        termVector.processaTermo("web");
        termVector.processaTermo("web");
        termVector.processaTermo("web");
        termVector.processaTermo("web");
        termVector.processaTermo("web");
        termVector.processaTermo("web");
        
        termVector.processaTermo("collective intelligence");
        termVector.processaTermo("collective intelligence");
        termVector.processaTermo("collective intelligence");
        termVector.processaTermo("collective intelligence");
        
        termVector.processaTermo("java");
        termVector.processaTermo("java");
        termVector.processaTermo("java");
        
        termVector.processaTermo("lucene");
        termVector.processaTermo("lucene");
        termVector.processaTermo("lucene");
        termVector.processaTermo("lucene");
        termVector.processaTermo("lucene");
        
        termVector.processaTermo("tokenizer");
        termVector.processaTermo("tokenizer");
        
        return termVector;
    }
}
