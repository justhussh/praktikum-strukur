import java.util.Scanner;
public class Mahasiswa {
    String nim, nama;
    int absen;
    double ipk;
    Mahasiswa next;

    Mahasiswa(String nim, String nama, int absen, double ipk, Mahasiswa next){
        this.nim = nim;
        this.nama = nama;
        this.absen = absen;
        this.ipk = ipk;
        this.next = next;
    }
}

class SLLMahasiswa{
    Mahasiswa head;
    Mahasiswa tail;

    public boolean IsEmpty(){
        return head == null;
    }

    public void print(){
        if(!IsEmpty()){
            Mahasiswa tmp = head;
            int sort = 0;
            while(tmp != null){
                System.out.println("Mahasiswa ke-" + sort + " : " +"\nNIM\t: "+tmp.nim + "\nNama\t: " + 
                tmp.nama + "\nAbsen\t: " + tmp.absen + "\nIPK\t: " + tmp.ipk);
                tmp = tmp.next;
                sort++;
            }
        }else{
            System.out.println("Antrian Masih Kosong!");
        }
    }

    public void antrianTerdepan(){
        if(!IsEmpty()){
            Mahasiswa tmp = head;
            System.out.println("Antrian paling depan: "+"\nNIM\t: "+tmp.nim + "\nNama\t: " + 
            tmp.nama + "\nAbsen\t: " + tmp.absen + "\nIPK\t: " + tmp.ipk);
        }else{
            System.out.println("Antrian masing kosong!");
        }
    }

    public void antrianTerbelakang(){
        if(!IsEmpty()){
            Mahasiswa tmp = head;
            while(tmp != null){
                if(tmp == tail){
                    System.out.println("Antrian paling belakang: " +"\nNIM\t: "+tmp.nim + "\nNama\t: " + 
                    tmp.nama + "\nAbsen\t: " + tmp.absen + "\nIPK\t: " + tmp.ipk);
                }
                tmp = tmp.next;
            }
        }else{
            System.out.println("Antrian masih kosong!");
        }
    }

    public void addData(String nim, String nama, int absen, double ipk){
        Mahasiswa ndInput = new Mahasiswa(nim, nama, absen, ipk, null);
        if(IsEmpty()){
            head = ndInput;
            tail = ndInput;
        }else{
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    public void searchDataOfIndex(int index){
        if(IsEmpty()){
            System.out.println("Antrian masih kosong!");
        }else{
            Mahasiswa tmp = head;
            for(int i=1; i<index; i++){
                tmp = tmp.next;
            }
            System.out.println("Data Mahasiswa dengan Nomor Antrian " + index + " : " +"\nNIM\t: "+tmp.nim + "\nNama\t: " + 
            tmp.nama + "\nAbsen\t: " + tmp.absen + "\nIPK\t: " + tmp.ipk);
        }
    }

    public void searchDataOfNim(String key){
        Mahasiswa tmp = head;
        int index = 0;
        while (tmp != null && (!(tmp.nim.equals(key)))){
            tmp = tmp.next;
            index++;
        }
        if(tmp == null){
            System.out.println("Antrian Kosong!");
        }else{
            System.out.println("Mahasiswa dengan NIM: " + key + " berada pada index ke - " + index);
        }
        System.out.println("Data Mahasiswa: " +"\nNIM\t: "+tmp.nim + "\nNama\t: " + 
        tmp.nama + "\nAbsen\t: " + tmp.absen + "\nIPK\t: " + tmp.ipk);
    }

    public void remove(){
        if(IsEmpty()){
            System.out.println("Antrian Masih Kosong, tidak dapat dihapus!");
        }else if (head == tail){
            head = tail = null;
        }else{
            Mahasiswa temp = head;
            while(temp.next != tail){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }
}

class MahasiswaMain{
    public static void menu(){
        System.out.println("\n=============================== MENU ===============================");
        System.out.println("1. Antrian baru");
        System.out.println("2. Antrian keluar");
        System.out.println("3. Cek Antrian paling depan");
        System.out.println("4. Cek Antrian Paling Belakang");
        System.out.println("5. Cek Semua Antrian");
        System.out.println("6. Cek Antrian Mahasiswa");
        System.out.println("7. Cetak Data Mahasiswa");
        System.out.println("8. Exit");
        System.out.println("=====================================================================");
    }   
    public static void main(String[] args) {
        SLLMahasiswa sllM = new SLLMahasiswa();
        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        int pilih;
        do{
            menu();
            System.out.print("Masukkan pilihan: ");
            pilih = sc.nextInt();
            sc.nextLine();
            switch(pilih){
                case 1:
                    System.out.print("\nNIM: ");
                    String nim = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Absen: ");
                    int absen = sc.nextInt();
                    System.out.print("IPK: ");
                    double ipk = sc.nextDouble();
                    sllM.addData(nim, nama, absen, ipk);
                    System.out.println("");
                    break;
                case 2:
                    sllM.remove();
                    System.out.println("");
                    break;
                case 3:
                    sllM.antrianTerdepan();
                    System.out.println("");
                    break;
                case 4:
                    sllM.antrianTerbelakang();
                    System.out.println("");
                    break;
                case 5:
                    sllM.print();
                    System.out.println("");
                    break;
                case 6:
                    System.out.print("Masukkan NIM : ");
                    String cari = input.nextLine();
                    sllM.searchDataOfNim(cari);
                    System.out.println("");
                    break;
                case 7:
                    System.out.print("Masukkan Nomor Antrian: ");
                    int index = sc.nextInt();
                    sllM.searchDataOfIndex(index);
                    break;
                case 8:
                    System.out.println("TERIMA KASIH....");
                    System.exit(0);
                    break;
            }
        } while (pilih > 0 && pilih < 9);
        System.out.println("TERIMA KASIH...");
    }
}
