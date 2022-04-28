import java.util.Scanner;
public class Tugas2{
        int max, size, front, rear;
        Mahasiswa[] antrian;
        
        public Tugas2(int n){
            max = n;
            antrian = new Mahasiswa [max];
            size = 0;
            front = rear = -1;
        }
        public boolean IsEmpty(){
            if(size == 0){
                return true;
            }else{
                return false;
            }
        }
        public boolean IsFull(){
            if(size == max){
                return true;
            }else {
                return false;
            }
        }
        public void peek(){
            if(!IsEmpty()){
                System.out.println("Elemen terdepan : "+antrian[front].nama+ " "+antrian[front].nim+" "+antrian[front].absen+" "+antrian[front].ipk);
            }else{
                System.out.println("Queue masih kosong");
            }
        }
        public void peekRear(){
            if(!IsEmpty()){
                System.out.println("Elemen yang belakang : "+antrian[rear].nama+ " "+antrian[rear].nim+" "+antrian[rear].absen+" "+antrian[rear].ipk);
            }else{
                System.out.println("Queue masih kosong");
            }
        }
        public void print(){
            if(IsEmpty()){
                System.out.println("Queue masih kosong");
            }else {
                int i = front;
                while(i != rear){
                    System.out.println(antrian[i].nama + " "+antrian[i].nim + " "+antrian[i].absen + " "+antrian[i].ipk);
                    i = (i + 1) % max;
                }
                System.out.println(antrian[i].nama + " "+antrian[i].nim + " "+antrian[i].absen + " "+antrian[i].ipk);
                System.out.println("Jumlah elemen = "+ size);
            }
        }
        public void clear(){
            if(!IsEmpty()){
                front = rear = -1;
                size = 0;
                System.out.println("queue berhasil dikosongkan");
            }else{
                System.out.println("Queue masih kosong");
            }
        }
        public void enqueue(Mahasiswa dt){
            if(IsFull()){
                System.out.println("Queue sudah penuh");
            }else{
                if(IsEmpty()){
                    front = rear = 0;
                }else{
                    if (rear == max -1){
                        rear = 0;
                    }else{
                        rear++;
                    }
                }
                antrian[rear] = dt;
                size++;
            }
        }
        public Mahasiswa dequeue(){
            Mahasiswa dt = new Mahasiswa();
            if(IsEmpty()){
                System.out.println("Queue masih kosong");
            }else{
                dt = antrian[front];
                size--;
                if(IsEmpty()){
                    front = rear = -1;
                }else{
                    if(front == max -1){
                        front = 0;
                    }else{
                        front++;
                    }
                }
            }
            return dt;
        }
        public void peekPosition(String nim){
            int i = front;
            boolean j = true;
            while (j) {
                if (nim.equals(this.antrian[i].nim)) {
                System.out.println("data " + antrian[i].nim + " ada di index ke-" + i);
                j = false;
            }
            i++;
        }
        }
        public void printMahasiswa (int posisi){
            int i = front;
            boolean j = true;
            while(j){
                if(posisi == i){
                    System.out.println("data pada index ke - "+i+" adalah "+this.antrian[i].nim+" "+this.antrian[i].nama+" "+this.antrian[i].absen+" "+this.antrian[i].ipk);
                    j = false;
                }
                i++;
            }
        }
    }
    class Tugas2Main {
        public static void menu(){
            System.out.println("\nPilih Menu ");
            System.out.println(" 1. Antrian baru\n 2. Antrian Keluar\n 3. Cek Antrian Terdepan\n 4. Cek Semua Antrian\n 5. Cek Antrian Paling Belekang\n 6. Cari index Mahasiswa dengan Nim\n 7. Cek data mahasiswa berdasarkan antrian\n 8. Hapus Antrian\n 0. Exit");
            System.out.println("-----------------------------------");   
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Scanner sd = new Scanner(System.in);
            Scanner se = new Scanner(System.in);
            
            System.out.print("Masukkan kapasitas queue : ");
            int jumlah = sc.nextInt();
            Tugas2 antri = new Tugas2(jumlah);
            
            int pilih;
            do{
                menu();
                pilih = sc.nextInt();
                sc.nextLine();
                
                switch(pilih){
                    case 1:
                        
                        System.out.print("Nim Mahasiswa\t: ");
                        String nim = sc.nextLine();
                        System.out.print("Nama Mahasiswa\t: ");
                        String nama = sc.nextLine();
                        System.out.print("Absen Mahasiswa\t: ");
                        int absen = sd.nextInt();
                        System.out.print("IPK Mahasiswa\t: ");
                        double ipk = se.nextDouble();
                        Mahasiswa nb = new Mahasiswa(nim, nama, absen, ipk);
                        sc.nextLine();
                        antri.enqueue(nb);
                        break;
                    case 2:
                        Mahasiswa data = antri.dequeue();
                        if(!"".equals(data.nim) && !"".equals(data.nama) &&!"".equals(data.absen) && data.ipk !=0){
                            System.out.println("Antrian yang keluar : " + data.nim+ " "+ data.nama+" "+ data.absen+" "+data.ipk);
                    }
                        break;
                    case 3:
                        antri.peek();
                        break;
                    case 4:
                        antri.print();
                        break;
                    case 5:
                        antri.peekRear();
                        break;
                    case 6:
                        System.out.print("Masukkan nim Mahasiswa\t\t:");
                        String nimm = sc.nextLine();
                        antri.peekPosition(nimm);
                        break;
                    case 7:
                        System.out.print("Masukkan indeks Antrian yang akan dicek\t:");
                        int posisi = sc.nextInt();
                        antri.printMahasiswa(posisi);
                        break;
                    case 8:
                        antri.clear();
                        break;
                }
            }while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5 || pilih == 6 || pilih == 7 || pilih == 8);
        }
    }