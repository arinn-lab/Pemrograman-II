package com.ekspedisi.logic;

public class ExpressService implements LayananPengiriman {
    @Override
    public double hitungOngkir(double berat) {
        // Misal: 10000 per kg + biaya tetap 2000
        return (berat * 10000) + 2000;
    }

    @Override
    public String getNamaLayanan() {
        return "Express";
    }
}