package br.usp.ime.topicosweb.atividade.analyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashSet;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.LowerCaseFilter;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.standard.StandardTokenizer;

public class MeuAnalyzer extends Analyzer {

    private HashSet<String> stopWords;

    public MeuAnalyzer() {
        try {
            stopWords = new HashSet<String>();
            BufferedReader reader = new BufferedReader(new FileReader(
                    "src/main/resources/stop-words-utf-8.txt"));
            String word = reader.readLine();
            while (word != null) {
                stopWords.add(word);
                word = reader.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TokenStream tokenStream(String fieldName, Reader reader) {
        Tokenizer tokenizer = new StandardTokenizer(reader);
        TokenStream lowerCaseFilter = new LowerCaseFilter(tokenizer);
        StopFilter stopFilter = new StopFilter(lowerCaseFilter, stopWords);
        return stopFilter;
    }

}
