package br.usp.ime.topicosweb.atividade.termvector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TermVector {
    
    private Map<String, TagMagnitude> magnitudes;
    
    public TermVector() {
        magnitudes = new HashMap<String, TagMagnitude>();
    }
    
    public void processaTermo(String termo) {
        TagMagnitude tagMagnitude = magnitudes.get(termo);
        if (tagMagnitude == null) {
            magnitudes.put(termo, new TagMagnitude(termo, 1.0));
        } else {
            tagMagnitude.adicionaMagnitude(1.0);
        }
    }
    
    public List<TagMagnitude> getMagnitudes() {
        List<TagMagnitude> values = new ArrayList<TagMagnitude>(magnitudes.values());
        return Collections.unmodifiableList(values);
    }
}
