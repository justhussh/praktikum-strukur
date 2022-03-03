public class Barang1 {
    String nama;
    int hargaSatuan, jumlah;
    
    Barang1(){

    }

    int hitungHargaTotal(int hs, int jmh){
        hargaSatuan = hs;
        jumlah = jmh;
        return hs*jmh;
    }
    
    int hitungDiskon(){
        int ht = hitungHargaTotal(hargaSatuan, jumlah);
        double d = 0;
        int dis;
        if( ht > 100000){
            d = ht * 0.1;
            dis = (int) d;
            return dis;
        }else if(ht <= 100000 && ht >= 50000){
            d = ht * 0.05;
            dis = (int) d;
            return dis;
        } else return 0;
        
    }

    int hitungHargaBayar(){
        int hb = hitungHargaTotal(hargaSatuan, jumlah) - hitungDiskon();
        return hb; 
    }

    
}
