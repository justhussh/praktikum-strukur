import java.util.Scanner;
public class BarangMain1 {
    public static void main(String[] args) {
        Barang1 t1 = new Barang1();
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama barang : ");
        t1.nama = sc.nextLine();
        System.out.print("Masukkan harga satuan barang : ");
        t1.hargaSatuan = sc.nextInt();
        System.out.print("Masukkan jumlah barang : ");
        t1.jumlah = sc.nextInt();
        System.out.println("====================================");
        System.out.println("");
        int totalHarga = t1.hitungHargaTotal(t1.hargaSatuan, t1.jumlah);
        System.out.println("Total  : " + totalHarga);
        double diskon = t1.hitungDiskon();
        System.out.println("Diskon : " + diskon);
        double bayar = t1.hitungHargaBayar();
        System.out.println("Total Bayar : " + bayar);
    }
}
