import java.util.Scanner;
public class Tiket {
    String maskapai, asal, tujuan;
    int harga;
    Tiket(String m, int h, String a, String t){
        maskapai = m;
        harga = h;
        asal = a;
        tujuan = t;
    } 
    void tampilData(){
        System.out.println("-=========================================================");
        System.out.println("                     NGANG AIRPORT                        ");
        System.out.println("==========================================================");
        System.out.println("NAMA MASKAPAI   : "+maskapai);
        System.out.println("ASAL            : "+asal);
        System.out.println("TUJUAN          : "+tujuan);
        System.out.println("HARGA           : "+harga);
    }
}
class TiketService{
    Tiket tiket[] = new Tiket[10];
    int tkt;
    void tambah(Tiket mskp){
       if(tkt < tiket.length){
           tiket[tkt] = mskp;
           tkt++;
       }
    }
    void tampilData(){
        for(Tiket mskp : tiket){
            mskp.tampilData();
        }
    }
    void bubbleSort(){
        for(int i=0; i<tiket.length; i++){
            for(int j=1; j<tiket.length; j++){
                if(tiket[j].harga > tiket[j-1].harga){
                    //swap
                    Tiket swp = tiket[j];
                    tiket[j] = tiket[j-1];
                    tiket[j-1] = swp;
                }
            }
        }
    }
    void selectionSort(){
        for(int i=0; i<tiket.length; i++){
            int idxMin = i;
            for(int j=i+1; j<tiket.length; j++){
                if(tiket[j].harga < tiket[idxMin].harga){
                    idxMin = j;
                }
                Tiket swap = tiket[idxMin];
                tiket[idxMin] = tiket[i];
                tiket[i] = swap;
            }
        }
    }
}
class MainTiket{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        TiketService a = new TiketService();
        Tiket tkt1 = new Tiket("Sriwijaya", 400000, "Bandung", "Jakarta");
        Tiket tkt2 = new Tiket("Lion Air", 900000, "pontianak", "Malang");
        Tiket tkt3 = new Tiket("Garuda", 1000000, "Pekanbaru", "Yogyakarta");
        Tiket tkt4 = new Tiket("AirAsia", 850000, "Bandung", "Kupang");
        Tiket tkt5 = new Tiket("Batik Air", 900000, "Bali", "Jakarta");
        a.tambah(tkt1);
        a.tambah(tkt2);
        a.tambah(tkt3);
        a.tambah(tkt4);
        a.tambah(tkt5);
        char ulang = 'Y';
        do{
            System.out.println("==========================================================");
            System.out.println("                    DATA SEBELUM SORTING                  ");
            System.out.println("==========================================================");
            a.tampilData();
            System.out.println("\nPilihan Sorting: ");
            System.out.println("1. Ascending ");
            System.out.println("2. Descending ");
            System.out.print("Masukkan Pilihan: ");
            int c = sc.nextInt(); 
            switch(c){
                case 1:
                System.out.println("\n\n==========================================================");
                System.out.println("                        Ascending                         ");
                System.out.println("==========================================================");
                a.bubbleSort();
                a.tampilData();
                break;
                case 2:
                System.out.println("\n\n==========================================================");
                System.out.println("                      Descending                          ");
                System.out.println("==========================================================");
                a.selectionSort();
                a.tampilData();
                break;
                default:
                System.out.println("Maaf, pilihan anda tidak ada");
            }
            System.out.print("Apakah ingin melakukan sorting lagi? (Y/T) :");
            ulang = sc.next().charAt(0);
        }while(ulang == 'Y' || ulang == 'y');
    }
}