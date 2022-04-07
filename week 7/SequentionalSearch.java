import java.util.Scanner;
public class SequentionalSearch {
    int nim;
    String nama;
    int umur;
    double ipk;
    SequentionalSearch(int ni, String n, int u, double i){
        nim = ni;
        nama = n;
        umur = u;
        ipk = i;
    }
    void tampil(){
        System.out.println("NIM = "+nim);
        System.out.println("Nama = "+nama);
        System.out.println("Umur = "+umur);
        System.out.println("IPK = "+ipk);
    }
}
class PencarianMhs {
    SequentionalSearch listMhs[] = new SequentionalSearch[5];
    int idx;
    void tambah(SequentionalSearch m){
        if(idx<listMhs.length){
            listMhs[idx] = m;
            idx++;
        }else{
            System.out.println("Data Sudah Penuh!!");
        }
    }
    void tampil(){
        for(SequentionalSearch m : listMhs){
            m.tampil();
            System.out.println("-----------------------------------");
        }
    }
    int FindSeqSearch(int cari) {
        int posisi = -1;
        for (int j = 0; j < listMhs.length; j++) {
            if (listMhs[j].nim == cari) {
                posisi = j;
                break;
            }
        }
        return posisi;
    }
    int FindBinarySearch (int cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (cari == listMhs[mid].nim) {
                return (mid);
            } else if (listMhs[mid].nim > cari) {
                return FindBinarySearch(cari, left, mid - 1);
            } else {
                return FindBinarySearch(cari, mid + 1, right);
            }
        }
        return -1;
    }
    void TampilPosisi(int x,int pos) {
        if (pos!= -1) {
            System.out.println("Data : " + x + "ditemukan pada indeks " + pos);
        } else {
            System.out.println("Data : " + x + "tidak ditemukan");
        }
    }
    void TampilData (int x, int pos) {
        if (pos!= -1) {
            System.out.println("NIM\t : " + x);
            System.out.println("Nama\t : " + listMhs[pos].nama);
            System.out.println("Umur\t : " + listMhs[pos].umur);
            System.out.println("IPK\t : " + listMhs[pos].ipk);
        } else {
            System.out.println("Data " + x + "tidak ditemukan");
        }
    }
}
class MahasiswaMain{
    public static void main(String[] args){
        Scanner a = new Scanner(System.in);
        Scanner b = new Scanner(System.in);
        PencarianMhs data = new PencarianMhs();
        int jumlahMhs = 5;
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Masukkan data mahasiswa secara urut dari NIM terkecil");
        for(int i = 0; i < jumlahMhs; i++) {
            System.out.println("-------------------------------");
            System.out.print("NIM\t : ");
            int nim = a.nextInt();
            System.out.print("Nama\t : ");
            String nama = b.nextLine();
            System.out.print("Umur\t : ");
            int umur = a.nextInt();
            System.out.print("IPK\t : ");
            double ipk = a.nextDouble();
            SequentionalSearch m = new SequentionalSearch(nim, nama, umur, ipk);
            data.tambah(m);
        }
        System.out.println("-----------------------------------");
        System.out.println("Data Keseluruhan Mahasiswa : ");
        data.tampil();
        System.out.println("________________________________________________________");
        System.out.println("________________________________________________________");
        System.out.println("Pencarian Data : ");
        System.out.println("Masukkan NIM Mahasiswa yang dicari : ");
        System.out.print("NIM : ");
        int cari = a.nextInt();
        System.out.println("Menggunakan Sequential Search");
        int posisi = data.FindSeqSearch(cari);
        data.TampilPosisi(cari, posisi);
        data.TampilData(cari, posisi);
        System.out.println("======================");
        System.out.println("menggunakan binary search");
        posisi = data.FindBinarySearch(cari, 0, jumlahMhs - 1);
        data.TampilPosisi(cari, posisi);
        data.TampilData(cari, posisi);
    }
}