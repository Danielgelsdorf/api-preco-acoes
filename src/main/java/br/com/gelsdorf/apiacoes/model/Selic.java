package br.com.gelsdorf.apiacoes.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Selic {
    @JsonAlias("value")
    private String value;
    private final LocalDate data = LocalDate.now();

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public LocalDate getData(){
        return  data;
    }
}
