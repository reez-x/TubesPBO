package Pertemuan14.TugasBesar;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static Pembeli pembeli;
    private static Ayam[] ayamList;

    public static void main(String[] args) {
        // Membuat daftar ayam yang tersedia
        ayamList = new Ayam[]{
                new Ayam("Ayam Broiler", 38000, 10, 5000, 10, 10000, 5),
                new Ayam("Ayam Kampung", 50000, 5, 6000, 8, 12000, 4),
                new Ayam("Ayam Petelur", 45000, 8, 5500, 6, 11000, 3)
        };

        // Dialog untuk memasukkan nama Pembeli
        String namaPembeli = JOptionPane.showInputDialog("Masukkan nama Pembeli:");
        if (namaPembeli == null || namaPembeli.isEmpty()) {
            namaPembeli = "Pembeli";
        }
        double saldoAwal = Double.parseDouble(JOptionPane.showInputDialog("Masukkan saldo awal Pembeli:"));

        // Membuat instance Pembeli
        pembeli = new Pembeli(namaPembeli, saldoAwal);

        // Membuat frame
        JFrame frame = new JFrame("Transaksi Jual Beli Ayam di Pasar");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 3)); // 1 row, 3 columns

        // Membuat informasi untuk masing-masing jenis ayam
for (Ayam ayamm : ayamList) {
    JPanel ayamPanel = new JPanel();
    ayamPanel.setLayout(new GridLayout(4, 1)); // 4 rows, 1 column
    ayamPanel.setBorder(BorderFactory.createTitledBorder(ayamm.getJenis()));

    JLabel labelStokUtuh = new JLabel("Stok Utuh: " + ayamm.getStok());
    JLabel labelHargaUtuh = new JLabel("Harga Utuh: Rp " + ayamm.getHarga());
    JLabel labelStokSayap = new JLabel("Stok Sayap: " + ayamm.getSayap().getStok());
    JLabel labelHargaSayap = new JLabel("Harga Sayap: Rp " + ayamm.getSayap().getHarga());
    JLabel labelStokPaha = new JLabel("Stok Paha: " + ayamm.getPaha().getStok());
    JLabel labelHargaPaha = new JLabel("Harga Paha: Rp " + ayamm.getPaha().getHarga());

    ayamPanel.add(labelStokUtuh);
    ayamPanel.add(labelHargaUtuh);
    ayamPanel.add(labelStokSayap);
    ayamPanel.add(labelHargaSayap);
    ayamPanel.add(labelStokPaha);
    ayamPanel.add(labelHargaPaha);

    mainPanel.add(ayamPanel);

        // Panel untuk transaksi
        JPanel transaksiPanel = new JPanel();
        transaksiPanel.setLayout(null);

        JLabel labelPembeli = new JLabel("Nama: " + pembeli.getNama());
        labelPembeli.setBounds(25, 25, 200, 25);

        // Create a border
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        labelPembeli.setBorder(border);
        labelPembeli.setBackground(Color.YELLOW); // Change the color as needed
        labelPembeli.setOpaque(true);

        transaksiPanel.add(labelPembeli);

        // ComboBox untuk memilih jenis ayam
        JLabel labelJenisAyam = new JLabel("Jenis Ayam:");
        labelJenisAyam.setBounds(50, 50, 100, 25);
        transaksiPanel.add(labelJenisAyam);

        JComboBox<String> comboAyam = new JComboBox<>();
        for (Ayam ayam : ayamList) {
            comboAyam.addItem(ayam.getJenis());
        }
        comboAyam.setBounds(150, 50, 150, 25);
        transaksiPanel.add(comboAyam);

        // ComboBox untuk memilih bagian ayam
        JLabel labelBagianAyam = new JLabel("Bagian Ayam:");
        labelBagianAyam.setBounds(50, 100, 100, 25);
        transaksiPanel.add(labelBagianAyam);

        JComboBox<String> comboBagian = new JComboBox<>(new String[]{"Utuh", "Sayap", "Paha"});
        comboBagian.setBounds(150, 100, 150, 25);
        transaksiPanel.add(comboBagian);

        // Label dan TextField untuk jumlah ayam yang dibeli
        JLabel labelJumlah = new JLabel("Jumlah:");
        labelJumlah.setBounds(50, 150, 100, 25);
        transaksiPanel.add(labelJumlah);

        JTextField textJumlah = new JTextField();
        textJumlah.setBounds(150, 150, 150, 25);
        transaksiPanel.add(textJumlah);

        // Button untuk membeli ayam
        JButton buttonBeli = new JButton("Beli");
        buttonBeli.setBounds(50, 200, 100, 25);
        transaksiPanel.add(buttonBeli);

        // Button untuk menambah saldo
        JButton buttonTambahSaldo = new JButton("Tambah Saldo");
        buttonTambahSaldo.setBounds(200, 200, 150, 25);
        transaksiPanel.add(buttonTambahSaldo);

        // Label untuk menampilkan saldo
        JLabel labelSaldo = new JLabel("Saldo: Rp " + pembeli.getSaldo());
        labelSaldo.setBounds(50, 250, 200, 25);
        transaksiPanel.add(labelSaldo);

        // // Label untuk menampilkan stok ayam
        // JLabel labelStok = new JLabel("Stok Ayam: " + ayamList[0].getStok());
        // labelStok.setBounds(50, 280, 200, 25);
        // transaksiPanel.add(labelStok);

        // Label untuk menampilkan total harga
        JLabel labelTotal = new JLabel("Total Harga: Rp 0");
        labelTotal.setBounds(50, 310, 200, 25);
        transaksiPanel.add(labelTotal);

        // // Action listener untuk ComboBox jenis ayam
        // comboAyam.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         int selectedIndex = comboAyam.getSelectedIndex();
        //         labelStok.setText("Stok Ayam: " + ayamList[selectedIndex].getStok());
        //     }
        // });

// Action listener untuk button beli ayam
buttonBeli.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedIndexAyam = comboAyam.getSelectedIndex();
        Ayam selectedAyam = ayamList[selectedIndexAyam];

        String bagianAyam = (String) comboBagian.getSelectedItem();
        int jumlah = Integer.parseInt(textJumlah.getText());
        double totalHarga = 0;

        switch (bagianAyam) {
            case "Utuh":
                totalHarga = selectedAyam.getHarga() * jumlah;
                if (selectedAyam.getStok() >= jumlah) {
                    pembeli.beliAyamUtuh(selectedAyam, jumlah);
                    // Perbarui label stok utuh pada panel ayam yang sesuai
                    JPanel selectedAyamPanel = (JPanel) mainPanel.getComponent(selectedIndexAyam);
                    JLabel labelStokUtuh = (JLabel) selectedAyamPanel.getComponent(0);
                    labelStokUtuh.setText("Stok Utuh: " + selectedAyam.getStok());
                } else {
                    JOptionPane.showMessageDialog(frame, "Stok ayam utuh tidak mencukupi.");
                    return;
                }
                break;
            case "Sayap":
                totalHarga = selectedAyam.getSayap().getHarga() * jumlah;
                if (selectedAyam.getSayap().getStok() >= jumlah) {
                    pembeli.beliSayap(selectedAyam.getSayap(), jumlah);
                    // Perbarui label stok sayap pada panel ayam yang sesuai
                    JPanel selectedAyamPanel = (JPanel) mainPanel.getComponent(selectedIndexAyam);
                    JLabel labelStokSayap = (JLabel) selectedAyamPanel.getComponent(2);
                    labelStokSayap.setText("Stok Sayap: " + selectedAyam.getSayap().getStok());
                } else {
                    JOptionPane.showMessageDialog(frame, "Stok sayap tidak mencukupi.");
                    return;
                }
                break;
            case "Paha":
                totalHarga = selectedAyam.getPaha().getHarga() * jumlah;
                if (selectedAyam.getPaha().getStok() >= jumlah) {
                    pembeli.beliPaha(selectedAyam.getPaha(), jumlah);
                    // Perbarui label stok paha pada panel ayam yang sesuai
                    JPanel selectedAyamPanel = (JPanel) mainPanel.getComponent(selectedIndexAyam);
                    JLabel labelStokPaha = (JLabel) selectedAyamPanel.getComponent(4);
                    labelStokPaha.setText("Stok Paha: " + selectedAyam.getPaha().getStok());
                } else {
                    JOptionPane.showMessageDialog(frame, "Stok paha tidak mencukupi.");
                    return;
                }
                break;
        }

        labelTotal.setText("Total Harga: Rp " + totalHarga);
        labelSaldo.setText("Saldo: Rp " + pembeli.getSaldo());
        JOptionPane.showMessageDialog(frame, "Pembelian berhasil.");
    }
});




        // Action listener untuk button tambah saldo
        buttonTambahSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jumlahStr = JOptionPane.showInputDialog("Masukkan jumlah saldo yang akan ditambahkan:");
                double jumlah = Double.parseDouble(jumlahStr);
                pembeli.tambahSaldo(jumlah);
                labelSaldo.setText("Saldo: Rp " + pembeli.getSaldo());
            }
        });

        frame.add(mainPanel, BorderLayout.NORTH);
        frame.add(transaksiPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}
}
