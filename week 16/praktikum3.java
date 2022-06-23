import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
    public class praktikum3 {
        String nim;
        String nama;
        String notelp;
        public praktikum3() {
        }
        public praktikum3(String nim, String nama, String notelp){
                this.nim = nim;
                this.nama = nama;
                this.notelp = notelp;
        }
        public String toString(){
                return "Mahasiswa{" + "nim= " + nim + ", nama=" + nama + ", notelp=" + notelp + '}';
        }
    }
    class ListMahasiswa {
        List<praktikum3> mahasiswas = new ArrayList<>();
        public void tambah(praktikum3... mahasiswa) {
                mahasiswas.addAll(Arrays.asList(mahasiswa));
        }
        public void hapus(int index) {
                mahasiswas.remove(index);
        }
        public void update(int index, praktikum3 mhs) {
                mahasiswas.set(index, mhs);
        }
        public void tampil() {
                mahasiswas.stream().forEach(mhs -> {
                        System.out.println("" + mhs.toString());
                });
        }
        int LinearSearch(String nim) {
                for(int i=0; i<mahasiswas.size(); i++) {
                        if(nim.equals(mahasiswas.get(i).nim)) {
                                return i;
                        }
                }
                return -1;
        }
        public static void main(String[] args) {
                ListMahasiswa lm = new ListMahasiswa();
                praktikum3 m = new praktikum3("201234", "Noureen", "021xx1");
                praktikum3 m1 = new praktikum3("201235", "Akhleema", "021xx2");
                praktikum3 m2 = new praktikum3("201236", "Shannum", "021xx3");
                lm.tambah(m, m1, m2);
                lm.tampil();
                lm.update(lm.LinearSearch("201235"), new praktikum3("201235", "Akhleema Lela", "021xx2"));
                System.err.println("");
                lm.tampil();
        }
    }