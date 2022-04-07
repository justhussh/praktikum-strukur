import java.util.Scanner;
public class Tugas2 {
    int nim;
    String nama;
    int umur;
    double ipk;
    Tugas2(int ni, String n, int u, double i) {
        nim = ni;
        nama = n;
        umur = u;
        ipk = i;
    }
    void tampil() {
        System.out.println("NIM   = " + nim);
        System.out.println("Nama  = " + nama);
        System.out.println("Umur  = " + umur);
        System.out.println("IPK   = " + ipk);
    }
}
class pencarianMhs {
    Tugas2 listMhs[];
    int idx;
    void tambah(Tugas2 m) {
        if (idx < listMhs.length) {
            listMhs[idx] = m;
            idx++;
        } else {
            System.out.println("Data Sudah Penuh !!");
        }

    }
    void tampil() {
        for (Tugas2 m : listMhs) {
            m.tampil();
            System.out.println("--------------------");
        }
    }
    int FindSeqSearch(int cari) {
        int posisi = -1;
        for (int i = 0; i < listMhs.length; i++) {
            if (listMhs[i].nim == cari) {
                posisi = i;
                break;
            }
        }
        return posisi;
    }
    void selectionSort() {
        for (int i = 0; i < listMhs.length; i++) {
            int idxMin = i;
            for (int j = i + 1; j < listMhs.length; j++) {
                if (listMhs[j].nim < listMhs[idxMin].nim) {
                    idxMin = j;
                }
            }
            Tugas2 tmp = listMhs[idxMin];
            listMhs[idxMin] = listMhs[i];
            listMhs[i] = tmp;
        }
    }
    void TampilPosisi(int x, int pos) {
        if (pos != -1) {
            System.out.println("Data : " + x + " Ditemukan pada indeks " + pos);
        } else {
            System.out.println("Data : " + x + " Tidak Ditemukan");
        }
    }
    void TampilData(int x, int pos) {
        if (pos != -1) {
            System.out.println("Nim  : " + x);
            System.out.println("Nama : " + listMhs[pos].nama);
            System.out.println("Umur : " + listMhs[pos].umur);
            System.out.println("IPK  : " + listMhs[pos].ipk);
        } else {
            System.out.println("Data " + x + " Tidak Ditemukan");
        }

    }
    int FindBinarySearch(int cari, int left, int right) {
        int mid;
        if (right >= left) {
            mid = (left + right) / 2;
            if (cari == listMhs[mid].nim) {
                return (mid);
            } else if (listMhs[mid].nim > cari) {
                return FindBinarySearch(cari, mid + 1, right);
            } else {
                return FindBinarySearch(cari, mid - 1, left);
            }
        }
        return -1;
    }
}
class Tugas2Main {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        Scanner b = new Scanner(System.in);
        pencarianMhs data = new pencarianMhs();
        System.out.print("Masukkan jumlah mahasiswa  : ");
        int jumMhs = a.nextInt();
        Tugas2[] x = new Tugas2[jumMhs];
        data.listMhs = x;
        System.out.println("-------------------------------------------------------");
        System.out.println("Masukkan data Mahasiswa secara urut dari Nim terkecil : ");
        for (int i = 0; i < jumMhs; i++) {
            System.out.println("---------------------------");
            System.out.print("NIM  : ");
            int nim = a.nextInt();
            System.out.print("Nama : ");
            String nama = b.nextLine();
            System.out.print("Umur : ");
            int umur = a.nextInt();
            System.out.print("IPK  : ");
            double ipk = a.nextDouble();
            Tugas2 m = new Tugas2(nim, nama, umur, ipk);
            data.tambah(m);
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("Data Keseluruhan Mahasiswa");
        data.tampil();
        System.out.println("Data Mahasiswa setelah sorting asc berdasarkan nim");
        data.selectionSort();
        data.tampil();
        System.out.println("_________________________________________________________");
        System.out.println("_________________________________________________________");
        System.out.println("Pencarian Data");
        System.out.println("Masukkan NIM Mahasiswa yang di cari : ");
        System.out.print("NIM   : ");
        int cari = a.nextInt();
        System.out.println("Menggunakan Sequential Search");
        int posisi = data.FindSeqSearch(cari);
        data.TampilPosisi(cari, posisi);
        data.TampilData(cari, posisi);
        System.out.println("=======================================================");
        System.out.println("Menggunakan Binary Search");
        posisi = data.FindBinarySearch(cari, 0, jumMhs - 1);
        data.TampilPosisi(cari, posisi);
        data.TampilData(cari, posisi);
    }
}