import java.util.Scanner;
public class praktikum2 {
    private final int vertices;
    private final int[][] twoD_array;
    public praktikum2(int v){
        vertices = v;
        twoD_array = new int[vertices + 1][vertices + 1];
    }
    public void makeEdge(int to, int from, int edge){
        try {
            twoD_array[to][from] = edge;
        } catch(ArrayIndexOutOfBoundsException index){
            System.out.println("Vertex tidak ada");
        }
    }
    public int getEdge(int to, int from){
        try {
            return twoD_array[to][from];
        } catch (ArrayIndexOutOfBoundsException index){
            System.out.println("Vertex tidak ada");
        }
        return -1;
    }
}
class praktikum2Main{
    public static void main(String[] args) {
        int v, e, count = 1, to = 0, from = 0;
        Scanner sc = new Scanner(System.in);
        praktikum2 graph;
        try {
            System.out.print("Masukkan jumlah vertices : ");
            v = sc.nextInt();
            System.out.print("Masukkan jumlah edges : ");
            e = sc.nextInt();
            graph = new praktikum2(v);
            System.out.print("Masukkan edges : <to> <from>");
            while (count <= e){
                to = sc.nextInt();
                from =  sc.nextInt();
                graph.makeEdge(to, from, 1);
                count++;
            }
            System.out.print("Array 2D sebagai representasi graph sbb : ");
            System.out.print("  ");
            for(int i=1; i<=v; i++){
                System.out.print(i + " ");
            }
            System.out.println();
            for(int i=1; i<= v; i++){
                System.out.print(i + " ");
                for(int j=1; j<=v; j++){
                    System.out.print(graph.getEdge(i, j) + " ");
                }
                System.out.println();
            }
        } catch (Exception E) {
            System.out.println("Error. Silahkan cek kembali\n" +  E.getMessage());
        }
        sc.close();
    }
}