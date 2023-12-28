package com.example.kalk_zdol_ktedytowej;

public class ParseItem1 {

    String id;
    String imgBanku;
    String RRSO;
    String prowizja;
    String oferta;
    String wklad;
    String marza;
    String rata;
    String kwota;

    public ParseItem1() {
    }

    public ParseItem1(String id, String imgBanku, String RRSO, String prowizja, String oferta, String wklad, String marza, String rata, String kwota) {
        this.id = id;
        this.imgBanku = imgBanku;
        this.RRSO = RRSO;
        this.prowizja = prowizja;
        this.oferta = oferta;
        this.wklad = wklad;
        this.marza = marza;
        this.rata = rata;
        this.kwota = kwota;

    }

    public String getRata() {
        return rata;
    }

    public void setRata(String rata) {
        this.rata = rata;
    }

    public String getKwota() {
        return kwota;
    }

    public void setKwota(String kwota) {
        this.kwota = kwota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgBanku() {
        return imgBanku;
    }

    public void setImgBanku(String imgBanku) {
        this.imgBanku = imgBanku;
    }

    public String getRRSO() {
        return RRSO;
    }

    public void setRRSO(String RRSO) {
        this.RRSO = RRSO;
    }

    public String getProwizja() {
        return prowizja;
    }

    public void setProwizja(String prowizja) {
        this.prowizja = prowizja;
    }

    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    public String getWklad() {
        return wklad;
    }

    public void setWklad(String wklad) {
        this.wklad = wklad;
    }

    public String getMarza() {
        return marza;
    }

    public void setMarza(String marza) {
        this.marza = marza;
    }
}
