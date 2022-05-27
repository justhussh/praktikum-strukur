import java.util.Scanner;
public class Tugas1 {
        node head;
        int size;
    
        public Tugas1(){
            head = null;
            size = 1;    
        }
        public boolean isEmpty(){
            return head == null;
        }
        public void addLast(int nomor, String nama){
            if (isEmpty()){
                head  = new node(null, nomor, nama, null);
            }else{
                node current = head;
                while (current.next != null){
                    current = current.next;
                }
                node newNode = new node(current, nomor, nama,null);
                current.next = newNode;
                size++;
            }
        }
        public void removeFirst() throws Exception{
            if(isEmpty()){
                throw new Exception("Linked List Masih kosong, tidak dapat dihapus!");
            }else if (size == 1){
                removeLast();
            }else{
                System.out.println(head.nama+"Sudah Divaksin");
                head = head.next;
                head.prev = null;
                size--;
            }
        }
        public void removeLast() throws Exception {
            if(isEmpty()){
                throw new Exception("Linked list masih kosong, tidak dapat dihapus!");
            }else if (head.next == null){
                System.out.println(head.nama+"Sudah Divaksin");
                head = null;
                size--;
                return;
            }
            node current = head;
            while (current.next.next != null){
                current = current.next;
            }
            current.next = null;
            size--;
        }
        public void print(){
            System.out.println("+------------------------");
            System.out.println("  DAFTAR ANTRIAN VAKSIN  ");
            System.out.println("-------------------------"); 
            System.out.println("| No\t| Nama"+"\t\t|");
            if(!isEmpty()){
                node tmp = head;
                while (tmp != null){
                    System.out.print("| "+tmp.nomor+"\t| "+tmp.nama+" "+"\t|\n");
                    tmp = tmp.next;
                }
                System.out.println("\nSisa Antrian "+size);
            }else{
                System.out.println("Linked List Kosong");
            }
        }
    }
    class Tugas1Main {
        public static void menu(){
            System.out.println("-------------------------");
            System.out.println("      ANTRIAN VAKSIN     ");
            System.out.println("-------------------------");
            System.out.println(" 1. Tambah Data Penerima Vaksin\n 2. Hapus Data Pengantri Vaksin\n 3. Daftar Penerima Vaksin\n 4. Keluar");
            System.out.println("-----------------------------------");
        }
        public static void main(String[] args)throws Exception  {
            Scanner a = new Scanner(System.in);
            Scanner b = new Scanner(System.in);
            Tugas1 dll = new Tugas1();
            int pilih;
            do{
                menu();
                pilih = a.nextInt();
                a.nextLine();
                switch(pilih){
                    case 1:
                        System.out.print("Nomor Antrian\t: ");
                        int nim = b.nextInt();
                        System.out.print("Nama Penerima\t: ");
                        String nama = a.nextLine();
                        dll.addLast(nim, nama);
                        b.nextLine();
                    break;
                    case 2:
                        dll.removeFirst();
                        dll.print();
                    break;
                    case 3:
                        dll.print();
                    break;
                    case 4:
                        System.exit(0);
                    break;
                } 
            }while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 );
    }
}