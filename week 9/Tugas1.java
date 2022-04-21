import java.util.Scanner;
public class Tugas1 {
        int size;
        int top;
        PakaianTugas data[];
        public Tugas1(int size){
            this.size = size;
            data = new PakaianTugas[size];
            top = -1;
        }
    
        public boolean IsEmpty(){
            if (top == -1){
                return true;
            }else{
                return false;
            }
        }
    
        public boolean IsFull(){
            if (top == size -1){
                return true;
            }else{
                return false;
            }
        }
    
        public void push(PakaianTugas pkn){
            if (!IsFull()){
                top++;
                data[top] = pkn;
            }else{
                System.out.println("Isi stack penuh!");
            }
        }
    
        public void pop(){
            if (!IsEmpty()){
                PakaianTugas x = data[top];
                top--;
                System.out.println("Data yang keluar: " + x.jenis + " " + x.warna + " " + x.merk + " " + x.ukuran + " " + x.harga);
            }else{
                System.out.println("Stack masih kosong");
            }
        }
    
        public void peek(){
            System.out.println("Elemen teratas: " + data[top].jenis + " " + data[top].warna + " " + data[top].merk + " " + data[top].ukuran + " " + data[top].harga);
        }
    
        public void print(){
            System.out.println("Isi stack: ");
            for (int i = top; i >= 0; i--){
                System.out.println(data[i].jenis + " " + data[i].warna + " " + data[i].merk + " " + data[i].ukuran + " " + data[i].harga + " ");
            }
            System.out.println("");
        }
    
        public void clear(){
            if (!IsEmpty()){
                for (int i = top; i >= 0; i--){
                    top--;
                }
                System.out.println("Stack sudah dikosongkan");
            }else{
                System.out.println("Stack masih kosong");
            }
        }
    
        public void getMin(){
            double hrgMin = data[0].harga;
            int idn = 0;
            for(int i = 1; i <= top; i++){
                if (hrgMin > data[i].harga){
                    idn = i;
                    hrgMin = data[i].harga;
                }
            }
            System.out.println("Harga Pakaian Terendah adalah\t: "+data[idn].harga);
            System.out.println("Dengan merk\t\t\t: "+data[idn].merk);
    }
}
class StackMainTugas {
    public static void main(String[] args) {
        Tugas1 stk = new Tugas1(5);
    
        Scanner sc = new Scanner(System.in);
        Scanner sd = new Scanner(System.in);
    
        char pilih;
        do{
            System.out.println("------------------------------------");
            System.out.println("             PILIHAN MENU           ");
            System.out.println("------------------------------------");
            System.out.println(" 1. Push\n 2. Pop\n 3. Peek\n 4. Print\n 5. Harga Terendah\n");
            int pilihan;
            System.out.print("Pilih Menu (masukkan angka 1-4): ");
            pilihan = sd.nextInt();
        
            switch (pilihan){
                case 1:
                    do{
                        System.out.print("Jenis\t\t: ");
                        String jenis = sc.nextLine();
                        System.out.print("Warna\t\t: ");
                        String warna = sc.nextLine();
                        System.out.print("Merk\t\t: ");
                        String merk = sc.nextLine();
                        System.out.print("Ukuran\t\t: ");
                        String ukuran = sc.nextLine();
                        System.out.print("Harga\t\t: ");
                        double harga = sd.nextInt();
                        System.out.println("");
                        PakaianTugas p = new PakaianTugas(jenis, warna, merk, ukuran, harga);
                        System.out.print("Apakah anda akan menambahkan data baru ke stack (y/n)? ");
                        pilih = sc.next().charAt(0);
                        sc.nextLine();
                        stk.push(p);
                    }while (pilih == 'y');
                    break;
                case 2:
                    stk.pop();
                    break;
                case 3:
                    stk.peek();
                    break;
                case 4:
                    stk.print();
                    break;
                case 5:
                    stk.getMin();
                    break;               
                default:
                    System.out.println("Input yang anda masukkan salah");
                    System.exit(0);
            }if(pilihan == 5){
                pilih ='t';
            }else{
                System.out.print("Kembali ke menu Utama (y/t) ");
                pilih = sc.next().charAt(0);
            }
        }while (pilih == 'y');
    }
}