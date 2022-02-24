import java.util.Scanner;
public class perulangan {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Masukkan NIM : ");
        n=sc.nextInt();
        System.out.println("=========================");
        n=n%100;
        if(n<10){
            n+=10;
        }
        System.out.println("n : "+n);
        for(int i=1;i<=n;i++){
            if(i%7==1){
                System.out.print("Senin ");
            }else if(i%7==2){
                System.out.print("Selasa ");
            }else if(i%7==3){
                System.out.print("Rabu " );
            }else if(i%7==4){
                System.out.print("Kamis ");
            }else if(i%7==5){
                System.out.print("jumat ");
            }else if(i%7==6){
                System.out.print("Sabtu ");
            }else{
                System.out.print("Minggu ");
            }
        }
        sc.close();
    }
}