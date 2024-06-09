package Pertemuan14.TugasBesar;

public class Transaksi {
    private Pembeli pembeli;
    private Ayam ayam;
    private int jumlah;


    public Transaksi(Pembeli pembeli, Ayam ayam, int jumlah) {
        this.pembeli = pembeli;
        this.ayam = ayam;
        this.jumlah = jumlah;
    }


    public double hitungTotal() {
        return ayam.getHarga() * jumlah;
    }


    public Pembeli getPembeli() {
        return pembeli;
    }


    public Ayam getAyam() {
        return ayam;
    }


    public int getJumlah() {
        return jumlah;
    }
}

