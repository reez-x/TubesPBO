package Pertemuan14.TugasBesar;

public class Pembeli extends Pengguna {
    private double saldo;

    public Pembeli(String nama, double saldo) {
        super(nama);
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void beliAyamUtuh(Ayam ayam, int jumlah) {
        double totalHarga = ayam.getHarga() * jumlah;
        if (totalHarga <= this.saldo && ayam.getStok() >= jumlah) {
            this.saldo -= totalHarga;
            ayam.kurangiStok(jumlah);
            System.out.println("Pembelian ayam utuh berhasil.");
        } else {
            System.out.println("Pembelian ayam utuh gagal. Saldo tidak mencukupi atau stok ayam tidak mencukupi.");
        }
    }

    public void beliSayap(Sayap sayap, int jumlah) {
        double totalHarga = sayap.getHarga() * jumlah;
        if (totalHarga <= this.saldo && sayap.getStok() >= jumlah) {
            this.saldo -= totalHarga;
            sayap.kurangiStok(jumlah);
            System.out.println("Pembelian sayap ayam berhasil.");
        } else {
            System.out.println("Pembelian sayap ayam gagal. Saldo tidak mencukupi atau stok sayap tidak mencukupi.");
        }
    }

    public void beliPaha(Paha paha, int jumlah) {
        double totalHarga = paha.getHarga() * jumlah;
        if (totalHarga <= this.saldo && paha.getStok() >= jumlah) {
            this.saldo -= totalHarga;
            paha.kurangiStok(jumlah);
            System.out.println("Pembelian paha ayam berhasil.");
        } else {
            System.out.println("Pembelian paha ayam gagal. Saldo tidak mencukupi atau stok paha tidak mencukupi.");
        }
    }

    public void tambahSaldo(double jumlah) {
        this.saldo += jumlah;
    }
}
