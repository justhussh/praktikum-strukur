import java.util.Scanner;
public class Tugas1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char s = 'y'; 
        int biayaTotal = 0;
        int totalBayar;
        do{
            boolean succes = true;
            do{
                System.out.print("Berapa kg laundry anda : ");
                int berat = sc.nextInt();
                int biaya = berat * 4500;
                if(berat > 10){
                    int diskon = 5 *biaya /100; 
                    totalBayar = biaya - diskon;
                }else{
                    totalBayar = biaya;
            }biayaTotal += totalBayar;
            System.out.println("Total harganya : Rp" + totalBayar);
            }while(!succes);
            System.out.print("\napakah ingin melanjutkan? (Y/T) ");
            s = sc.next().charAt(0);
        }while(s=='Y'||s=='y');
        System.out.println("Keuntungan smile laundry hari ini: Rp" + biayaTotal);
    }
}