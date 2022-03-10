import java.util.Scanner;
public class segitiga {
    public int alas;
    public int tinggi;
    public int miring;
    public int segitiga(int a, int t, int m) {
        alas = a;
        tinggi = t;
        miring =m;
        return 0;
    }

    public int hitungLuas(){
        return alas*tinggi/2;
    }

    public int hitungKeliling(){
        return alas+tinggi+miring;
    }
}

class segitigaMain{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah segitiga: ");
        int jml = sc.nextInt();
        
        segitiga[] sgt = new segitiga[jml];
        
        sgt[0] = new segitiga();
        sgt[0].alas = 10;
        sgt[0].tinggi = 4;
        
        sgt[1] = new segitiga();
        sgt[1].alas = 20;
        sgt[1].tinggi = 10;

        sgt[2] = new segitiga();
        sgt[2].alas = 15;
        sgt[2].tinggi = 6;

        sgt[3] = new segitiga();
        sgt[3].alas = 25;
        sgt[3].tinggi = 10;

        for(int i=0; i<jml; i++){
            sgt[i] = new segitiga();
            System.out.print("Masukkan miring segitiga: ");
            sgt[i].miring = sc.nextInt();
        }
        
        for(int j=0; j<jml; j++){
            System.out.println();
            System.out.println("Segitiga ke-"+(j));
            System.out.println("Alas : "+sgt[j].alas);
            System.out.println("tinggi : "+sgt[j].tinggi);
            System.out.println("Miring : "+sgt[j].miring);
            System.out.println("Luas : "+sgt[j].hitungLuas());
            System.out.println("Keliling : "+sgt[j].hitungKeliling());
        }
    }
}