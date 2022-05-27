public class DoubleLinkedList3 {
        Node head;
        int size;
    public class Node{
        int data;
        Node prev, next;
        Node(Node prev, int data, Node next){
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
    public DoubleLinkedList3(){
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
        if (isEmpty()){
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
    public void add(int item, int index) throws Exception {
        if (isEmpty()){
            addFirst(item);
        }else if (index <0 || index > size){
            throw new Exception("Nilai indeks di luar batas");
        }else{
            Node current = head;
            int i = 0;
            while(i<index){
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
                System.out.print(tmp.data+"\t");;
                tmp = tmp.next;
            }
            System.out.println("\nberhasil diisi");
        }else{
            System.out.println("Linked List Kosong");
        }
    }
    public int getFirst() throws Exception {
        if(isEmpty()){
            throw new Exception("Linked List Kosong");
        }
        return head.data;
    }
    public int getLast() throws Exception {
        if(isEmpty()){
            throw new Exception("Linked List Kosong");
        }
        Node tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        return tmp.data;
    }
    public int get(int index) throws Exception{
        if(isEmpty() || index >= size){
            throw new Exception ("nilai indeks diluar batas");
        }
        Node tmp = head;
        for (int i =0; i<index; i++){
            tmp = tmp.next;
        }
        return tmp.data;
    }
    public class doublelinkedlistMain {
        public static void main(String[] args) throws Exception {
            DoubleLinkedList3 dll = new DoubleLinkedList3();
            dll.print();
            System.out.println("Size : "+dll.size());
            System.out.println("===============================");
            dll.addFirst(3);
            dll.addLast(4);
            dll.addFirst(7);
            dll.print();
            System.out.println("Size : "+dll.size());
            System.out.println("===============================");
            dll.add(40, 1);
            dll.print();
            System.out.println("Size : "+dll.size());
            System.out.println("===============================");
            System.out.println("Data Awal pada linked list adalah : "+dll.getFirst());
            System.out.println("Data akhir pada linked list adalah : "+ dll.getLast());
            System.out.println("Data Pada indeks ke-1 pada linked list adalah : "+dll.get(1));
        } 
    }
}