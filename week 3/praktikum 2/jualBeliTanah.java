import java.util.Scanner;
public class jualBeliTanah {
    public int panjang, lebar;

    public int luasTanah(){
        return panjang*lebar;
    }

    public int tanahTerluas(int luas[]){
        int terluas=0, a=0;
        for(int l=0; l<luas.length; l++){
            if(luas[l]>terluas){
                terluas = luas[l];
                a=l;
            }
        }
        return a;
    }

}

class tanahMain{
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("\nMasukkan jumlah tanah: ");
        int jml = sc.nextInt();
        System.out.println();
        

        Tanah[] tnhArray = new Tanah[jml];

        for(int i=0; i<jml; i++){
            tnhArray[i] = new Tanah();
            System.out.println("Tanah "+(i+1));
            System.out.print("Masukkan panjang: ");
            tnhArray[i].panjang = sc.nextInt();
            System.out.print("Masukkan lebar: ");
            tnhArray[i].lebar = sc.nextInt();
        }

        for(int j=0; j<jml; j++){
            System.out.println("Luas Tanah "+(j+1)+": "+tnhArray[j].luasTanah());
        }
        System.out.println();
        int luas[] = new int[jml];
        for(int k=0; k<jml; k++){
            luas[k] = tnhArray[k].luasTanah();
        }
        int b = tnhArray[0].tanahTerluas(luas);
        System.out.println("Tanah terluas : Tanah "+(b+1));
    }
}