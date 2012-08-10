package br.usp.ime.topicosweb.atividade;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;

import br.usp.ime.topicosweb.atividade.analyzer.MeuAnalyzer;

public class Main {
    public static void main(String[] args) throws IOException {
        MeuAnalyzer meuAnalyzer = new MeuAnalyzer();
        String text = "Programação orientada a objetos é uma péssima ideia, " +
                "que só poderia ter nascido na Califórnia.";
        StringReader reader = new StringReader(text);
        TokenStream tokenStream = meuAnalyzer.tokenStream(null, reader);
        Token token = tokenStream.next();
        while (token != null) {
            System.out.println(token.termText());
            token = tokenStream.next();
        }
    }
}
