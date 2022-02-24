import java.util.Scanner;
public class array {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int [][]toko={
            {10,5,15,7},
            {6,11,9,12},
            {2,10,10,5},
            {5,7,12,9}
        };   
        int aglonema=0,keladi=0,alocasia=0,mawar=0;
        int harga_aglo=75000;
        int harga_Kel=50000;
        int harga_alo=60000;
        int harga_ma=10000;
        for(int i=0;i<toko.length;i++){
            for(int j=0;j<toko[0].length;j++){
                switch(j){
                    case 0:
                    aglonema+=toko[i][0];
                    break;
                    case 1:
                    keladi+=toko[i][1];
                    break;
                    case 2:
                    alocasia+=toko[i][2];
                    break;
                    case 3:
                    mawar+=toko[i][3];
                    break;
                }
            }
        }
        int total=0;
        total+=keladi+aglonema+alocasia+mawar;
        System.out.println("Total Stock seluruh cabang: "+total);
        System.out.println("Stock bunga Aglonema : "+aglonema);
        System.out.println("Stock bunga Keladi : "+keladi);
        System.out.println("Stock bunga Alocasia : "+alocasia);
        System.out.println("Stock bunga Mawar : "+mawar);
        int ryl_aglo=0,ryl_kel=0,ryl_alo=0,ryl_ma=0;
        int ryl1=0;
        ryl_aglo=aglonema-14;
        ryl_kel=keladi-30;
        ryl_alo=alocasia-31;
        ryl_ma=mawar-31;
        for(int i=0;i<1;i++){
            ryl1=ryl_aglo*harga_aglo+ryl_kel*harga_Kel+ryl_alo*harga_alo+ryl_ma*harga_ma;
        }
        System.out.println("Total penjualan Royal Garden 1 : "+ryl1);
}
}