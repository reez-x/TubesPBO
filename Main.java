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
        // Daftar ayam yang tersedia
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
        frame.setSize(900, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        // Panel utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 3));


        // Membuat informasi untuk masing-masing jenis ayam (stok dan harga)
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


        JLabel labelPembeli = new JLabel("Nama :");
        labelPembeli.setBounds(50, 25, 100, 25);
        transaksiPanel.add(labelPembeli);


        JLabel labelNamaPembeli = new JLabel(pembeli.getNama());
        labelNamaPembeli.setBounds(150, 25, 150, 25);


       


        // Mwmbuat border
        Border border = BorderFactory.createLineBorder(Color.GRAY, 1);
        labelNamaPembeli.setBorder(border);
        labelNamaPembeli.setBackground(Color.WHITE); 
        labelNamaPembeli.setOpaque(true);


        transaksiPanel.add(labelNamaPembeli);


        // ComboBox untuk memilih jenis ayam
        JLabel labelJenisAyam = new JLabel("Jenis Ayam:");
        labelJenisAyam.setBounds(50, 75, 100, 25);
        transaksiPanel.add(labelJenisAyam);


        JComboBox<String> comboAyam = new JComboBox<>();
        for (Ayam ayam : ayamList) {
            comboAyam.addItem(ayam.getJenis());
        }
        comboAyam.setBounds(150, 75, 150, 25);
        transaksiPanel.add(comboAyam);


        // ComboBox untuk memilih bagian ayam
        JLabel labelBagianAyam = new JLabel("Bagian Ayam:");
        labelBagianAyam.setBounds(50, 100, 100, 25);
        transaksiPanel.add(labelBagianAyam);


        JComboBox<String> comboBagian = new JComboBox<>(new String[]{"Utuh", "Sayap", "Paha"});
        comboBagian.setBounds(150, 100, 150, 25);
        transaksiPanel.add(comboBagian);


        // Label dan input box untuk jumlah ayam yang dibeli
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
        buttonTambahSaldo.setBounds(175, 200, 125, 25);
        transaksiPanel.add(buttonTambahSaldo);


        // Label untuk menampilkan saldo
        JLabel labelSaldo = new JLabel("Saldo: Rp. " + pembeli.getSaldo());
        labelSaldo.setBounds(50, 250, 200, 25);
        transaksiPanel.add(labelSaldo);


        // Label untuk menampilkan total harga
        JLabel labelTotal = new JLabel("Total Harga: Rp 0");
        labelTotal.setBounds(50, 275, 200, 25);
        transaksiPanel.add(labelTotal);






        // Function untuk button beli ayam
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
                        if (pembeli.getSaldo() >= totalHarga) {
                            pembeli.beliAyamUtuh(selectedAyam, jumlah);
                            // Function update stok utuh secara dinamis pada GUI
                            JPanel selectedAyamPanel = (JPanel) mainPanel.getComponent(selectedIndexAyam);
                            JLabel labelStokUtuh = (JLabel) selectedAyamPanel.getComponent(0);
                            labelStokUtuh.setText("Stok Utuh: " + selectedAyam.getStok());
                        } else {
                            JOptionPane.showMessageDialog(frame, "Saldo tidak mencukupi.");
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Stok ayam utuh tidak mencukupi.");
                        return;
                    }
                    break;


                    case "Sayap":
                        totalHarga = selectedAyam.getSayap().getHarga() * jumlah;
                        if (selectedAyam.getSayap().getStok() >= jumlah ) {
                            if (pembeli.getSaldo() >= totalHarga) {
                            pembeli.beliSayap(selectedAyam.getSayap(), jumlah);
                            // Function update stok sayap secara dinamis
                            JPanel selectedAyamPanel = (JPanel) mainPanel.getComponent(selectedIndexAyam);
                            JLabel labelStokSayap = (JLabel) selectedAyamPanel.getComponent(2);
                            labelStokSayap.setText("Stok Sayap: " + selectedAyam.getSayap().getStok());
                        } else {
                            JOptionPane.showMessageDialog(frame, "Saldo tidak mencukupi.");
                            return;
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Stok sayap utuh tidak mencukupi.");
                        return;
                    }
                    break;
                    case "Paha":
                        totalHarga = selectedAyam.getPaha().getHarga() * jumlah;
                        if (selectedAyam.getPaha().getStok() >= jumlah) {
                            if (pembeli.getSaldo() >= totalHarga) {
                            pembeli.beliPaha(selectedAyam.getPaha(), jumlah);
                            // Function untuk memperbarui stok paha secara dinamis
                            JPanel selectedAyamPanel = (JPanel) mainPanel.getComponent(selectedIndexAyam);
                            JLabel labelStokPaha = (JLabel) selectedAyamPanel.getComponent(4);
                            labelStokPaha.setText("Stok Paha: " + selectedAyam.getPaha().getStok());
                        } else {
                            JOptionPane.showMessageDialog(frame, "Saldo tidak mencukupi.");
                            return;
                        }
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








        // Function untuk button tambah saldo
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

