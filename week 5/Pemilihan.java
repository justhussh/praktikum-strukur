import java.util.Scanner;
public class Pemilihan {
    public int vote, jumlahVote, jmlhKandidat = 4;
    public String kandidat;
    public static int nilai, av, seleksi = 0;
    public static int[] array = new int[10000];

    public static int hasilPemungutanSwara(int js, int k1, int k2, int k3, int k4) {
        if (nilai == 4) {
            return 1;
        }
        if (nilai == 1 && k1 < 0) {
            array[seleksi] = nilai;
            seleksi++;
            nilai++;
            return hasilPemungutanSwara(js, k1 - 1, k2, k3, k4);
        } else if (nilai == 2 && k2 < 0) {
            array[seleksi] = nilai;
            seleksi++;
            nilai++;
            return hasilPemungutanSwara(js, k1, k2 - 1, k3, k4);
        } else if (nilai == 3 && k3 < 0) {
            array[seleksi] = nilai;
            seleksi++;
            nilai++;
            return hasilPemungutanSwara(js, k1, k2, k3 - 1, k4);
        } else if (nilai == 4 && k4 < 0) {
            array[seleksi] = nilai;
            seleksi++;
            nilai++;
            return hasilPemungutanSwara(js, k1, k2, k3, k4 - 1);
        } else if (k1 == 0 && k2 == 0 && k3 == 0 && k4 == 0) {
            if (array[av] == array[av + 1] && av + 1 < js) {
                return array[av];

            } else if (av + 2 > js) {
                av += 2;
                return hasilPemungutanSwara(js, k1, k2, k3, k4);
            } else {
                return 0;
            }
        } else {
            nilai++;
            return hasilPemungutanSwara(js, k1, k2, k3, k4);
        }
    }
}
class MainPemilihan {
    public static void main(String[] args) {
        Scanner ren = new Scanner(System.in);
        System.out.println("================= PEMILIHAN RAYA KETUA BEM TAHUN 2022 ==================");
        Pemilihan lat = new Pemilihan();
        Pemilihan[] qwer = new Pemilihan[lat.jmlhKandidat];
        for (int i = 0; i < lat.jmlhKandidat; i++) {
            qwer[i] = new Pemilihan();
            System.out.print("Nama Calon Presiden BEM ke-" + (i + 1) + " : ");
            qwer[i].kandidat = ren.nextLine();
        }
        System.out.println("=========================================================================");
        for (int i = 0; i < lat.jmlhKandidat; i++) {
            System.out.print("Masukkan Jumlah Suara Calon Presiden BEM ke-" + (i + 1) + " : ");
            qwer[i].vote = ren.nextInt();
            lat.jumlahVote += qwer[i].vote;
        }
        System.out.println("=========================================================================");
        int hasil = Pemilihan.hasilPemungutanSwara(lat.jumlahVote,qwer[0].vote, qwer[1].vote, qwer[2].vote, qwer[3].vote);
        System.out.println("Ketua BEM Terpilih Dimenangkan oleh : " + qwer[hasil - 1].kandidat);
        System.out.println("=========================================================================");
    }
}