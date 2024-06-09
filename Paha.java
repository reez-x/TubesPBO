package Pertemuan14.TugasBesar;

public class Paha {
    private double harga;
    private int stok;

    public Paha(double harga, int stok) {
        this.harga = harga;
        this.stok = stok;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void kurangiStok(int jumlah) {
        this.stok -= jumlah;
    }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }
}