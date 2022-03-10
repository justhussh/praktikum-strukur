import java.util.Scanner;
public class pertanyaan {
    public int panjang, lebar;


    public int luasP(){
        return panjang*lebar;
    }
}
class main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah: ");
        int jml = sc.nextInt();
        pertanyaan[][] array1 = new pertanyaan[jml][jml];
        
        for(int i=0; i<jml; i++){
            array1[i][i] = new pertanyaan();
            System.out.print("Masukkan panjang ke-"+(i+1)+": ");
            array1[i][i].panjang = sc.nextInt();
            System.out.print("Masukkan lebar ke-"+(i+1)+": ");
            array1[i][i].lebar = sc.nextInt();
        }
        
        for(int j=0; j<jml; j++){
            System.out.println();
            System.out.println("Perhitungan yang ke-"+(j+1));
            System.out.println("panjang: "+array1[j][j].panjang);
            System.out.println("lebar: "+array1[j][j].lebar);
            System.out.println("luas: "+array1[j][j].luasP());
        }
    }
}

}
