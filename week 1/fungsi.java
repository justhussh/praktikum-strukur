public class fungsi {
    public static java.util.Scanner in=new java.util.Scanner(System.in);
        static int [][]bunga={
            {10,5,15,7},
            {6,11,9,12},
            {2,10,10,5},
            {5,7,12,9}
        };
    public static void main(String[] args) {
        tampilanTabel();
        menghitungStock();
    }
    static void tampilanTabel(){
        System.out.println("===================================================================================");
        System.out.println("\t\tAglonema    |   Keladi    |      Alocasia    |   Mawar");
        System.out.println("===================================================================================");
        System.out.println("Royal Garden 1 =    "+bunga[0][0]+"\t\t  "+bunga[0][1]+"\t    \t   "+bunga[0][2]+"   \t  "+bunga[0][3]);
        System.out.println("Royal Garden 2 =    "+bunga[1][0]+"\t\t  "+bunga[1][1]+"\t    \t   "+bunga[1][2]+"   \t   \t "+bunga[1][3]);
        System.out.println("Royal Garden 3 =    "+bunga[2][0]+"\t\t  "+bunga[2][1]+"\t    \t   "+bunga[2][2]+"   \t  "+bunga[2][3]);
        System.out.println("Royal Garden 4 =    "+bunga[3][0]+"\t\t  "+bunga[3][1]+"\t    \t   "+bunga[3][2]+"   \t  "+bunga[3][3]);
    }
    static void menghitungStock(){
        boolean sukses=true;
        while (sukses){
        System.out.println("Ingin melihat stock bunga apa?");
        System.out.println("1. Alognema");
        System.out.println("2. Keladi");
        System.out.println("3. Alocasia");
        System.out.println("4. Mawar");
        System.out.println("5. Keluar");
        System.out.print("Pilihan menu :");
        int x=in.nextInt();
        if(x==1){
            int alog=0;
        for(int i=0;i<bunga.length;i++){
            for(int j=0;j<bunga[0].length;j++){
                if(j==0){
                    alog+=bunga[i][j];
                    
                }
            }
        }System.out.println("Stok Bunga Alognema : "+alog);
        }
        if(x==2){
            int keladi=0;
            for(int i=0;i<bunga.length;i++){
                for(int j=0;j<bunga[0].length;j++){
                    if(j==1){
                        keladi+=bunga[i][j];
                    }
                }
            }System.out.println("Stok Bunga Keladi : "+keladi);
        }
        if(x==3){
            int alocasia=0;
            for(int i=0;i<bunga.length;i++){
                for(int j=0;j<bunga[0].length;j++){
                    if(j==2){
                        alocasia+=bunga[i][j];
                    }
                }
            }System.out.println("Stok Bunga Keladi : "+alocasia);
        }
        if(x==4){
            int mawar=0;
            for(int i=0;i<bunga.length;i++){
                for(int j=0;j<bunga[0].length;j++){
                    if(j==3){
                        mawar+=bunga[i][j];
                    }
                }
            }System.out.println("Stok Bunga Keladi : "+mawar);
        }
        else if(x==5){
            sukses=false;
        }
    }
    }
}