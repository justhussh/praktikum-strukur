import java.util.Scanner;
class Node{
    int data;
    Node prev, next;
    Node(Node prev, int data, Node next){
        this.prev = prev;
        this.data = data;
        this.next =  next;
    }
}
class LinkedLists {
    Node head;
    int size;
    public LinkedLists(){
        head = null;
        size = 0;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void addFirst(int item){
        if(isEmpty()){
            head = new Node(null, item, null);
        }else{
            Node newNode = new Node(null, item, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    public void addLast(int item){
        if(isEmpty()){
            addFirst(item);
        }else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            Node newNode = new Node(current, item, null);
            current.next = newNode;
            size++;
        }
    }
    public void add(int item, int index) throws Exception{
        if(isEmpty()){
            addFirst(item);
        }else if (index < 0 || index > size){
            throw new Exception("Nilai index di luar batas");
        }else{
            Node current = head;
            int i = 0;
            while (i < index){
                current = current.next;
                i++;
            }
            if(current.prev == null){
                Node newNode = new Node(null, item, current);
                current.prev = newNode;
                head = newNode;
            }else{
                Node newNode = new Node(current.prev, item, current);
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }
        size++;
    }
    public int size(){
        return size;
    }
    public void clear(){
        head = null;
        size = 0;
    }
    public void print(){
        if(!isEmpty()){
            Node tmp = head;
            while (tmp != null){
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("\nBerhasil Diisi");
        }else{
            System.out.println("Linked List Kosong");
        }
    }
    public void removeFirst() throws Exception {
        if (isEmpty()){
            throw new Exception("Linked List masih kosong, tidak dapat dihapus");
        }else if (size == 1){
            removeLast();
        }else{
            head = head.next;
            head.prev = null;
            size--;
        }
    }
    public void removeLast() throws Exception {
        if (isEmpty()){
            throw new Exception("Linked List masih kosong, tidak dapat dihapus");
        }else if (head.next == null){
            head = null;
            size--;
            return;
        }
        Node current = head;
        while (current.next.next != null){
            current = current.next;
        }
        current.next = null;
        size--;
    }
    public void remove(int index) throws Exception {
        if (isEmpty()){
            throw new Exception("Nilai index di luar batas");
        }else if (index == 0){
            removeFirst();
        }else{
            Node current = head;
            int i=0;
            while (i < index){
                current = current.next;
                i++;
            }
            if(current.next == null){
                current.prev.next = null;
            }else if (current.prev == null){
                current = current.next;
                current.prev = null;
                head = current;
            }else{
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
    }
    public int getFirst() throws Exception {
        if (isEmpty()){
            throw new Exception("Nilai index di luar batas");
        }
        return head.data;
    }
    public int getLast() throws Exception {
        if (isEmpty()){
            throw new Exception("Linked List Kosong");
        }
        Node tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        return tmp.data;
    }
    public int get(int index) throws Exception {
        if (isEmpty() || index >= size){
            throw new Exception("Nilai index di luar batas");
        }
        Node tmp = head;
        for(int i = 0; i < index; i++){
            tmp = tmp.next;
        }
        return tmp.data;
    }
}
public class tugas4{
    int vertex;
    LinkedLists list[];
    public tugas4(int vertex){
        this.vertex = vertex;
        list = new LinkedLists[vertex];
        for(int i=0; i<vertex; i++){
            list[i] = new LinkedLists();
        }
    }
    public void addEdge(int source, int destination){
        list[source].addFirst(destination);
        list[destination].addFirst(source);
    }
    public void degree(int source) throws Exception{
        System.out.println("degree vertex " + source + " : " + list[source].size());
        int k, totalIn = 0, totalOut = 0;
        for(int i=0; i<vertex; i++){
            for(int j=0; j<list[i].size(); j++){
                if(list[i].get(j) == source){
                    ++totalIn;
                }
            }
            for(k=0; k<list[source].size(); k++){
                list[source].get(k);
            }
            totalOut = k;
        }
        System.out.println("Indegree dari vertex " + source + " : " + totalIn);
        System.out.println("Outdegree dari vertex " + source + " : " + totalOut);
        System.out.println("degree vertex " + source + " : " + (totalIn+totalOut));
    }
    public void removeEdge(int source, int destination) throws Exception{
        for(int i=0; i<vertex; i++){
            if(i == destination){
                list[source].remove(destination);
            }
        }
    }
    public void removeAllEdges(){
        for(int i=0; i<vertex; i++){
            list[i].clear();
        }
        System.out.println("Graph berhasil dikosongkan");
    }
    public void printGraph() throws Exception{
        String kota = "";
        for(int i=0; i<vertex; i++){
            if(list[i].size() > 0){
                if ( i == 0){
                    kota = "Jakarta";
                } else if (i == 1){
                    kota = "Bandung";
                } else if (i == 2){
                    kota = "Bekasi";
                } else if (i == 3){
                    kota = "Cikarang";
                } else if (i == 4){
                    kota = "Depok";
                } else {
                    kota = "Tanggerang";
                }
                System.out.print("Vertex " + kota + " terhubung dengan: ");
                for(int j=0; j<list[i].size(); j++){
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println("");
            }
        }
    }
    public boolean graphType(boolean pilih){
        return pilih;
    }
}
class tugas4Main{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean type;
        int pil;
        char ulang;
        do {
            System.out.println("Jenis-Jenis Graph: ");
            System.out.println("1. Directed ");
            System.out.println("2. Undirected ");
            System.out.print("Masukkan pilihan jenis graph: ");
            pil =  sc.nextInt();
            do {
                switch(pil){
                    case 1:
                        System.out.println("\nDIRECTED GRAPH");
                        type = true;
                        break;
                    case 2:
                        System.out.println("\n UNDIRECTED GRAPH");
                        type = false;
                        break;
                    default:
                        System.out.println("Inputan Anda Salah!");
                        System.exit(0);
                        break;
                }
                System.out.println();
                System.out.print("Masukkan vertex: ");
                int vertex = sc.nextInt();
                tugas4 graph = new tugas4(vertex);
                System.out.print("Masukkan jumlah edge: ");
                int edge = sc.nextInt();
                System.out.println();
                for(int i=0; i<edge; i++){
                    System.out.print("Masukkan Source Ke-" + (i+1) + " : ");
                    int source = sc.nextInt();
                    System.out.print("Masukkan Destination Ke-" + (i+1) + " : ");
                    int dest = sc.nextInt();
                    graph.addEdge(source, dest);
                }
                System.out.println();
                graph.printGraph();
                graph.degree(2);
                graph.removeEdge(1, 2);
                graph.printGraph();
            } while (pil == 1 && pil == 2);
                System.out.print("Apakah ingin kembali ke menu jenis graph (Y/N): ");
                ulang = sc.next().charAt(0);
                System.out.println();
        } while (ulang == 'y' || ulang == 'Y');
          System.out.println("TERIMA KASIH...");
          sc.close();
    }
}