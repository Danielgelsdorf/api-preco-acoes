package br.com.gelsdorf.apiacoes.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Acao {
    @JsonAlias("longName")
    private String longName;
    @JsonAlias("regularMarketPrice")
    private double regularMarketPrice;
    @JsonAlias("regularMarketDayHigh")
    private double regularMarketDayHigh;
    @JsonAlias("regularMarketDayLow")
    private double regularMarketDayLow;

    public Acao(String longName, double regularMarketPrice, double regularMarketDayHigh, double regularMarketDayLow) {
        this.longName=longName;
        this.regularMarketPrice = regularMarketPrice;
        this.regularMarketDayHigh = regularMarketDayHigh;
        this.regularMarketDayLow = regularMarketDayLow;
    }

    public Acao() {
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public double getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public void setRegularMarketPrice(double regularMarketPrice) {
        this.regularMarketPrice = regularMarketPrice;
    }

    public double getRegularMarketDayHigh() {
        return regularMarketDayHigh;
    }

    public void setRegularMarketDayHigh(double regularMarketDayHigh) {
        this.regularMarketDayHigh = regularMarketDayHigh;
    }

    public double getRegularMarketDayLow() {
        return regularMarketDayLow;
    }

    public void setRegularMarketDayLow(double regularMarketDayLow) {
        this.regularMarketDayLow = regularMarketDayLow;
    }
}
