package br.usp.ime.topicosweb.atividade.termvector;

public class TagMagnitude {

    private String tag;
    private double magnitude;

    public TagMagnitude(String tag, double magnitude) {
        this.tag = tag;
        this.magnitude = magnitude;
    }

    public void adicionaMagnitude(double magnitude) {
        this.magnitude += magnitude;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getTag() {
        return tag;
    }
}
