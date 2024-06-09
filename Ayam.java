package Pertemuan14.TugasBesar;

public class Ayam {
    private String jenis;
    private double harga;
    private int stok;
    private Sayap sayap;
    private Paha paha;

    public Ayam(String jenis, double harga, int stok, double hargaSayap, int stokSayap, double hargaPaha, int stokPaha) {
        this.jenis = jenis;
        this.harga = harga;
        this.stok = stok;
        this.sayap = new Sayap(hargaSayap, stokSayap);
        this.paha = new Paha(hargaPaha, stokPaha);
    }

    public String getJenis() {
        return jenis;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public Sayap getSayap() {
        return sayap;
    }

    public Paha getPaha() {
        return paha;
    }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void kurangiStok(int jumlah) {
        this.stok -= jumlah;
    }
}
