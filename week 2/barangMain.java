public class barangMain {
    public static void main(String[] args) {
        barang bl = new barang(); 
        
        bl.namaBarang = "Corsair 2 GB";
        bl.jenisBarang = "DDR";
        bl.hargaSatuan = 250000;
        bl.stok = 10;
        bl.tambahStok(1);
        bl.kurangiStok(3);
        bl.tampilBarang();
        int hargaTotal = bl.hitungHargaTotal(4);
        System.out.println("Harga 4 buah = "+hargaTotal);
        barang b2 = new barang ("Logitech", "wireles mouse", 25, 150000);
        b2.tampilBarang();
        barang b3 = new barang ("Sony HXR NX100", "Provesional Kamera", 10, 17000000);
        b3.tampilBarang();
    }
}
