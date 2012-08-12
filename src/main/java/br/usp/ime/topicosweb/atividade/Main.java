package br.usp.ime.topicosweb.atividade;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;

import br.usp.ime.topicosweb.atividade.analyzer.MeuAnalyzer;
import br.usp.ime.topicosweb.atividade.termvector.GeradorDeTagCloud;
import br.usp.ime.topicosweb.atividade.termvector.TermVector;

public class Main {
    
    public static void main(String[] args) throws IOException {
        MeuAnalyzer meuAnalyzer = new MeuAnalyzer();
        
        Reader reader = new FileReader("src/main/resources/artigo.txt");
        
        TokenStream tokenStream = meuAnalyzer.tokenStream(null, reader);
        Token token = tokenStream.next();
        TermVector termVector = new TermVector();
        while (token != null) {
            termVector.processaTermo(token.termText());
            token = tokenStream.next();
        }
        GeradorDeTagCloud gerador = new GeradorDeTagCloud();
        String html = gerador.gera(termVector);
        FileWriter writer = new FileWriter("cloud.html");
        writer.write(html);
    }
    
}
