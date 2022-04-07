public class Tugas3 {
    int[] data;
    int max = 0;
    int posisi;
    int jumlah = 0;
    Tugas3(int nilai[]) {
        data = nilai;
    }
    void tampil() {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
            System.out.println();
        }
    }
    void bubblesort() {
        for (int i = 0; i < data.length - 1; i++) {
            for (int n = 1; n < data.length - i; n++) {
                if (data[n] > data[n - 1]) {
                    int tmp = data[n];
                    data[n] = data[n - 1];
                    data[n - 1] = tmp;
                }
            }
        }
    }
    int search(int cari, int kiri, int kanan) {
        int mid;
        if (kanan >= kiri) {
            mid = (kiri + kanan) / 2;
            if (cari == data[mid]) {
                return (mid);
            } else if (data[mid] > cari) {
                return search(cari, mid + 1, kanan);
            } else {
                return search(cari, kiri, mid - 1);
            }
        }
        return -1;
    }
    int nilaiTerbesar() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        System.out.println("Nilai Terbesar : " + max);
        return max;
    }
    void posisi(int pos) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == max) {
                jumlah++;
            }
        }
        System.out.print("Jumlah " + jumlah);
        System.out.println();
        posisi = max;
        for (int i = 0; i < data.length; i++) {
            if (posisi == data[i]) {
                pos = i;
                System.out.println("Data Ditemukan Pada Indeks Ke-" + pos);
            }
        }
    }
}
class Tugas3Main {
    public static void main(String[] args) {
        int bil[] = {12, 17, 2, 1, 70, 50, 90, 17, 2, 90};
        Tugas3 arr = new Tugas3(bil); 
        int jum = 10;
        int max = 0;
        System.out.println("===============================");
        System.out.println("              DATA             ");
        System.out.println("===============================");
        arr.tampil();
        arr.bubblesort();
        System.out.println("===============================");
        System.out.println("       Setelah Di Sorting      ");
        System.out.println("===============================");
        arr.tampil();
        arr.nilaiTerbesar();
        arr.search(max, 0, jum - 1);
        arr.posisi(max);
    }
}