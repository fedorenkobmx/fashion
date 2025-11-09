package com.moda;

public class ModalInfoDTO {
    private String pokupets;
    private String kuturie;
    private String data_primirky;
    private String model_vyrobu;
    private String rozmiry;
    private String tkanini;
    private String riven_klienta;
    private String stazh_kutyrie;
    private String adres;
    private String telefon;

    public ModalInfoDTO(String pokupets, String kuturie, String data_primirky,
                        String model_vyrobu, String rozmiry, String tkanini,
                        String riven_klienta, String stazh_kutyrie,
                        String adres, String telefon) {
        this.pokupets = pokupets;
        this.kuturie = kuturie;
        this.data_primirky = data_primirky;
        this.model_vyrobu = model_vyrobu;
        this.rozmiry = rozmiry;
        this.tkanini = tkanini;
        this.riven_klienta = riven_klienta;
        this.stazh_kutyrie = stazh_kutyrie;
        this.adres = adres;
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s | %s | %s | %s | %s | %s",
            pokupets, kuturie, data_primirky, model_vyrobu, rozmiry, tkanini, riven_klienta, stazh_kutyrie, adres, telefon);
    }


    public String getPokupets() { return pokupets; }
    public String getKuturie() { return kuturie; }
    public String getData_primirky() { return data_primirky; }
    public String getModel_vyrobu() { return model_vyrobu; }
    public String getRozmiry() { return rozmiry; }
    public String getTkanini() { return tkanini; }
    public String getRiven_klienta() { return riven_klienta; }
    public String getStazh_kutyrie() { return stazh_kutyrie; }
    public String getAdres() { return adres; }
    public String getTelefon() { return telefon; }
}