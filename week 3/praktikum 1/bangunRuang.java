import java.util.Scanner;
public class bangunRuang {
class Kubus{
    public int sisi;

    public int Kubus(int s){
        sisi = s;
        return sisi;
    }

    public int luasPermukaanKubus(){
        return 6*(sisi*sisi);
    }

    public int volumeKubus(){
        return sisi*sisi*sisi;
    }
}
class Balok{
    public int panjang, lebar, tinggi;

    public int Balok(int p, int l, int t){
        panjang = p;
        lebar = l;
        tinggi = t;
        return 0;
    }

    public int luasPermukaanBalok(){
        return 2*((panjang*lebar)+(panjang*tinggi)+(lebar*tinggi));
    }

    public int volumeBalok(){
        return panjang*lebar*tinggi;
    }
}

class Tabung {
    public int jariJari, tinggi;
    public int Tabung (int r, int t){
        jariJari = r;
        tinggi = t;
        return 0;
    }

    public double luasPermukaanTabung(){
        return 2*3.14*jariJari*(jariJari+tinggi);
    }
    public double volumeTabung(){
        return 3.14*(jariJari*jariJari)*tinggi;
    }
}

class BangunRuang {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        int jml;
        char lagi ='y';
        do{
            System.out.println("\nBangun Ruang :");
            System.out.println("1. Kubus");
            System.out.println("2. Balok");
            System.out.println("3. Tabung");
            System.out.print("\nBangun ruang apa yang anda ingin hitung? ");
            int a = input.nextInt();
            
            switch(a){
                case 1:
                System.out.println("=======");
                System.out.println("-Kubus-");
                System.out.println("=======");
                System.out.print("Masukkan jumlah kubus: ");
                jml = input.nextInt();
                Kubus[] kbsArray = new Kubus[jml];
                
                for(int i=0; i<jml; i++){
                    kbsArray[i] = new Kubus();
                    System.out.print("Masukkan sisi ke-"+(i+1)+" :");
                    kbsArray[i].sisi = input.nextInt();
                }
                
                for(int j=0; j<jml; j++){
                    System.out.println();
                    System.out.println("Kubus ke-"+(j+1));
                    System.out.println("Sisi: "+kbsArray[j].sisi);
                    System.out.println("Volume Kubus: "+kbsArray[j].volumeKubus());
                    System.out.println("Luas Permukaan Kubus: "+kbsArray[j].luasPermukaanKubus());
                }
                break;
                case 2:
                System.out.println("=======");
                System.out.println("-Balok-");
                System.out.println("=======");
                System.out.print("Masukkan jumlah balok: ");
                jml = input.nextInt();
                Balok[] blkArray = new Balok[jml];
                
                for(int i=0; i<jml; i++){
                    blkArray[i] = new Balok();
                    System.out.print("Masukkan panjang ke-"+(i+1)+" :");
                    blkArray[i].panjang = input.nextInt();
                    System.out.print("Masukkan lebar ke-"+(i+1)+" :");
                    blkArray[i].lebar = input.nextInt();
                    System.out.print("Masukkan tinggi ke-"+(i+1)+" :");
                    blkArray[i].tinggi = input.nextInt();
                    System.out.println();
                }
                
                for(int j=0; j<jml; j++){
                    System.out.println();
                    System.out.println("Balok ke-"+(j+1));
                    System.out.println("Panjang: "+blkArray[j].panjang);
                    System.out.println("Lebar: "+blkArray[j].lebar);
                    System.out.println("Tinggi: "+blkArray[j].tinggi);
                    System.out.println("Volume Balok: "+blkArray[j].volumeBalok());
                    System.out.println("Luas Permukaan Balok: "+blkArray[j].luasPermukaanBalok());
                }
                break;
                case 3:
                System.out.println("========");
                System.out.println("-Tabung-");
                System.out.println("========");
                System.out.print("Masukkan jumlah tabung: ");
                jml = input.nextInt();
                Tabung[] tbgArray = new Tabung[jml];
                
                for(int i=0; i<jml; i++){
                    tbgArray[i] = new Tabung();
                    System.out.print("Masukkan jari-jari ke-"+(i+1)+" :");
                    tbgArray[i].jariJari = input.nextInt();
                    System.out.print("Masukkan tinggi ke-"+(i+1)+" :");
                    tbgArray[i].tinggi = input.nextInt();
                    System.out.println();
                }
                
                for(int j=0; j<jml; j++){
                    System.out.println("Tabung ke-"+(j+1));
                    System.out.println("Jari-Jari: "+tbgArray[j].jariJari);
                    System.out.println("Tinggi: "+tbgArray[j].tinggi);
                    System.out.println("Volume Tabung: "+tbgArray[j].volumeTabung());
                    System.out.println("Luas Permukaan Tabung: "+tbgArray[j].luasPermukaanTabung());
                    System.out.println();
                }
                break;
                default:
                System.out.println("Kode yang Anda masukkan salah");
            }
            System.out.print("Kembali ke menu utama ?(Y/T) :");
            lagi = input.next().charAt(0);
        }
        while(lagi == 'y' || lagi == 'Y');
        System.out.println("========================================");
        System.out.println("             TERIMA KASIH               ");
        System.out.println("========================================");
    }
}
}