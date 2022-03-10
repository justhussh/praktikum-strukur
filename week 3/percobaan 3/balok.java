public class balok {
        public int panjang;
        public int lebar;
        public int tinggi;
    
        public balok(int p, int l, int t){
            panjang = p;
            lebar = l;
            tinggi = t;
        }
    
        public int hitungVolume(){
            return panjang*lebar*tinggi;
        }
    }
    
    class ArrayBalok {
        public static void main(String args[]) {
            balok[] b1Array = new balok[3];
    
            b1Array[0] = new balok(100,30,12);
            b1Array[1] = new balok(120,40,15);
            b1Array[2] = new balok(210,50,25);
    
            for(int i=0; i<3;i++){
                System.out.println("Volume balok ke "+i+": "+b1Array[i].hitungVolume());
            }
        }
    }