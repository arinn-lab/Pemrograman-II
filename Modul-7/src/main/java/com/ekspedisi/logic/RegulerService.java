package com.ekspedisi.logic;

public class RegulerService implements LayananPengiriman {
    @Override
    public double hitungOngkir(double berat) {
        // Misal: 5000 per kg
        return berat * 5000;
    }

    @Override
    public String getNamaLayanan() {
        return "Reguler";
    }
}