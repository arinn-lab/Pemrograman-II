package com.ekspedisi.model;

import javafx.beans.property.*;

public class Resi {
    // Encapsulation: Private fields
    private final StringProperty id;
    private final StringProperty namaPenerima;
    private final DoubleProperty berat;
    private final StringProperty jenisLayanan;
    private final DoubleProperty totalOngkir;

    public Resi(String id, String namaPenerima, double berat, String jenisLayanan, double totalOngkir) {
        this.id = new SimpleStringProperty(id);
        this.namaPenerima = new SimpleStringProperty(namaPenerima);
        this.berat = new SimpleDoubleProperty(berat);
        this.jenisLayanan = new SimpleStringProperty(jenisLayanan);
        this.totalOngkir = new SimpleDoubleProperty(totalOngkir);
    }

    // Getters & Setters (Property Accessors)
    public String getId() { return id.get(); }
    public StringProperty idProperty() { return id; }
    public void setId(String id) { this.id.set(id); }

    public String getNamaPenerima() { return namaPenerima.get(); }
    public StringProperty namaPenerimaProperty() { return namaPenerima; }
    public void setNamaPenerima(String namaPenerima) { this.namaPenerima.set(namaPenerima); }

    public double getBerat() { return berat.get(); }
    public DoubleProperty beratProperty() { return berat; }
    public void setBerat(double berat) { this.berat.set(berat); }

    public String getJenisLayanan() { return jenisLayanan.get(); }
    public StringProperty jenisLayananProperty() { return jenisLayanan; }
    public void setJenisLayanan(String jenisLayanan) { this.jenisLayanan.set(jenisLayanan); }

    public double getTotalOngkir() { return totalOngkir.get(); }
    public DoubleProperty totalOngkirProperty() { return totalOngkir; }
    public void setTotalOngkir(double totalOngkir) { this.totalOngkir.set(totalOngkir); }
}