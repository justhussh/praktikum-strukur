import java.util.Scanner;
public class pertanyaan {
    public int panjang;
    public int lebar;
}

class ArrayObjects1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan length array: ");
        int pjg = sc.nextInt();
        PersegiPanjang[] ppArray = new PersegiPanjang[pjg];
        
        for(int i=0; i<pjg;i++){
            ppArray[i] = new PersegiPanjang();
            ppArray[0] = new PersegiPanjang();
            System.out.println("Persegi panjang ke-"+(i+1));
            System.out.print("Masukkan panjang: ");
            ppArray[i].panjang = sc.nextInt();
            System.out.print("Masukkan lebar: ");
            ppArray[i].lebar = sc.nextInt();
        }
        
        for(int i=0; i<pjg;i++){
            System.out.println();
            System.out.println("Persegi Panjang ke-"+(i+1));
            System.out.println("Panjang: "+ppArray[i].panjang+", lebar: "+ppArray[i].lebar);
        }
    }
}