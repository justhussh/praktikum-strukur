import java.util.Scanner;
public class Tugas2 {
        node2 head;
        int size;
    
        public Tugas2(){
            head = null;
            size = 0;    
        }
        public boolean isEmpty(){
            return head == null;
        }
        public void addFirst(int id, String judulFilm, double rating){
            if (isEmpty()){
                head  = new node2(null, id, judulFilm, rating, null);
            }else{
                node2 newNode = new node2(null, id, judulFilm, rating, head);
                head.prev = newNode;
                head = newNode;
            }
            size++;
        }
        public void addLast(int id, String judulFilm, double rating){
            if (isEmpty()){
                addFirst(id, judulFilm, rating);
            }else{
                node2 current = head;
                while (current.next != null){
                    current = current.next;
                }
                node2 newNode = new node2(current, id, judulFilm, rating, null);
                current.next = newNode;
                size++;
            }
        }
        public void add(int id, String judulFilm, double rating, int index) throws Exception {
            if (isEmpty()){
                addFirst(id, judulFilm, rating);
            }else if (index <0 || index > size){
                throw new Exception("Nilai indeks di luar batas");
            }else{
                node2 current = head;
                int i = 0;
                while(i<index){
                    current = current.next;
                    i++;
                }
                if(current.prev == null){
                    node2 newNode = new node2(null, id, judulFilm, rating, current);
                    current.prev = newNode;
                    head = newNode;
                }else{
                    node2 newNode = new node2(current.prev, id, judulFilm, rating, current);
                    newNode.prev = current.prev;
                    newNode.next = current;
                    current.prev.next = newNode;
                    current.prev = newNode;
                }
            }
            size++;
        }
        public void removeFirst() throws Exception{
            if(isEmpty()){
                throw new Exception("Linked List Masih kosong, tidak dapat dihapus!");
            }else if (size == 1){
                removeLast();
            }else{
                head = head.next;
                head.prev = null;
                size--;
            }
        }
        public void removeLast() throws Exception {
            if(isEmpty()){
                throw new Exception("Linked list masih kosong, tidak dapat dihapus!");
            }else if (head.next == null){
                head = null;
                size--;
                return;
            }
            node2 current = head;
            while (current.next.next != null){
                current = current.next;
            }
            current.next = null;
            size--;
        }
        public void remove(int index) throws Exception {
            if (isEmpty() || index >= size){
                throw new Exception("Nilai indeks di luar batas");
            }else if (index == 0){
                removeFirst();
            }else{
                node2 current = head;
                int i=0;
                while (i<index){
                    current = current.next;
                    i++;
                }
                if(current.next == null){
                    current.prev.next = null;
                }else if(current.prev == null){
                    current = current.next;
                    current.prev = null;
                    head = current;
                }else{
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
            }
        }
        public void print(){
            System.out.println("-----------------------");
            System.out.println("     Data Saat Ini     "); 
            if(!isEmpty()){
                node2 tmp = head;
                while (tmp != null){
                    System.out.println("ID \t\t: "+tmp.id);
                    System.out.println("Judul Film \t: "+tmp.judulFilm);
                    System.out.println("Rating \t\t: "+tmp.rating);
                    System.out.println();
                    tmp = tmp.next;
                }
            }else{
                System.out.println("Linked List Kosong");
            }
        }
        public int findSeqSearch(int cari){
            node2 tmp = head;
            int posisi = -1;
            int index = 0;
            while (tmp != null){
                if(tmp.id == cari){
                    posisi = index;
                    break;
                }
                index++;
                tmp = tmp.next;
            }
            return posisi;
        }
        public void tampilPosisi(int x, int pos){
            if(pos != -1){
                System.out.println("ID\t\t: "+ x +" ditemukan pada indeks "+pos);
            }else {
                System.out.println("ID\t\t"+ x +" tidak ditemukan");
            }
        }
        public void sort(){
            node2 current = null, index = null;
            int tempID;
            String tempJD;
            Double tempRT;
            if (head == null) {
                return;
            } else {
                for (current = head; current.next != null; current = current.next) {
                    for (index = current.next; index != null; index = index.next) {
                        if (current.rating < index.rating) {
                            tempRT = current.rating;
                            current.rating = index.rating;
                            index.rating = tempRT;
                            tempID = current.id;
                            current.id = index.id;
                            index.id = tempID;
                            tempJD = current.judulFilm;
                            current.judulFilm = index.judulFilm;
                            index.judulFilm = tempJD;
                        }
                    }
                }
                print();
            }
        } 
    }
    class Tugas2Main {
        public static void menu(){
            System.out.println("-------------------------");
            System.out.println("        Data Film        ");
            System.out.println("-------------------------");
            System.out.println(" 1. Tambah Data Awal\n 2. Tambah Data Akhir\n 3. Tambah Data Index Tertentu\n 4. Hapus Data Pertama\n 5. Hapus Data Terakhir\n 6. Hapus Data Tertentu\n 7. Cetak\n 8. Cari ID Film\n 9. Urut Data Rating Film DESC\n 10. Keluar\n");
            System.out.println("-----------------------------------");
            System.out.print("Pilihan data : ");
        }
        public static void main(String[] args) throws Exception {
        Scanner a = new Scanner(System.in);
        Scanner b = new Scanner(System.in);
        Scanner c = new Scanner(System.in);
        Tugas2 dll = new Tugas2();
        int pilih;
        do{
            menu();
            pilih = a.nextInt();
            a.nextLine();
            switch(pilih){
                case 1:
                    System.out.println("Masukkan Data Film Posisi Awal");
                    System.out.print("ID Film\t\t: ");
                    int id = b.nextInt();
                    System.out.print("Judul Film\t: ");
                    String judulFilm = a.nextLine();
                    System.out.print("Rating\t\t: ");
                    double rating = c.nextDouble();
                    dll.addFirst(id, judulFilm, rating);
                    a.nextLine();
                break;
                case 2:
                    System.out.println("Masukkan Data Film Posisi Akhir");
                    System.out.print("ID Film\t\t: ");
                    int idD = b.nextInt();
                    System.out.print("Judul Film\t: ");
                    String judulFilmM = a.nextLine();
                    System.out.print("Rating\t\t: ");
                    double ratingG = c.nextDouble();
                    dll.addLast(idD, judulFilmM, ratingG);
                    a.nextLine();
                break;
                case 3:
                    System.out.println("Masukkan Data Film Posisi yang diinginkan");
                    System.out.print("Urutan ke - ");
                    int idx = b.nextInt();
                    System.out.print("ID Film\t\t: ");
                    int idDD = b.nextInt();
                    System.out.print("Judul Film\t: ");
                    String judulFilmMM = a.nextLine();
                    System.out.print("Rating\t\t: ");
                    double ratingGG = c.nextDouble();
                    dll.add(idDD, judulFilmMM, ratingGG, idx);
                    a.nextLine();
                    break;
                case 4:
                    dll.removeFirst();
                    dll.print();
                break;
                case 5:
                    dll.removeLast();
                    dll.print();
                break;
                case 6:
                    System.out.println("hapus Data Film Posisi yang diinginkan");
                    System.out.print("Urutan ke - ");
                    int index = b.nextInt();
                    dll.remove(index);
                    dll.print();
                break;
                case 7:
                    dll.print();
                break;
                case 8:
                    System.out.println("Cari ID Film Yang ingin dicari");
                    System.out.print("Masukkan ID\t: ");
                    int cari = b.nextInt();
                    int idF = dll.findSeqSearch(cari);
                    dll.tampilPosisi(cari, idF);
                break;
                case 9:
                    System.out.println("Data Akan diurut secara DESC");
                    dll.sort();
                break;
                case 10:
                    System.exit(0);
                break;
            } 
        }while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5 || pilih == 6 || pilih == 7 || pilih == 8 || pilih == 9 || pilih == 10);
    }
}