package org.example.models;

public class Moneda {
    private String divisaOriginal;
    private String divisaConvertir;
    private Double valorConversion;

    public moneda() {
    }

    public moneda(String monedaOriginal, String divisaConvertir, Double valorConversion) {
        this.monedaOriginal = divisaOriginal;
        this.monedaConvertir = monedaConvertir;
        this.valorConversion = valorConversion;
    }

    public String getMoedaOriginal() {
        return this.monedaOriginal;
    }

    public void setMonedaOriginal(String monedaOriginal) {
        this.monedaOriginal = monedaOriginal;
    }

    public String getMonedaConvertir() {
        return this.monedaConvertir;
    }

    public void setMonedaConvertir(String monedaConvertir) {
        this.monedaConvertir = monedaConvertir;
    }

    public Double getValorConversion() {
        return this.valorConversion;
    }

    public void setValorConversion(Double valorConversion) {
        this.valorConversion = valorConversion;
    }
}