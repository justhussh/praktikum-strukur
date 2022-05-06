public class Praktikum1{
    int data;
    Praktikum1 next;
    
    public Praktikum1 (int data, Praktikum1 berikutnya){
        this.data = data;
        this.next = berikutnya;
    }
}    
class SingleLinkedList{
    Praktikum1 head;
    Praktikum1 tail;
    public boolean IsEmpty(){
        return head == null;
    }    
    public void print(){
        if(!IsEmpty()){
            Praktikum1 tmp =head;
            System.out.print("Isi Linked List:\t");
            while (tmp != null){
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("");
        }else{
            System.out.println("Linked list kosong");
        }
    }
    public void addFirst(int input){
        Praktikum1 ndInput = new Praktikum1(input, null);
        if(IsEmpty()){
            head = ndInput;
            tail = ndInput;
        }else{
            ndInput.next = head;
            head = ndInput;
        }
    }
    public void addLast(int input){
        Praktikum1 ndInput = new Praktikum1(input, null);
        if(IsEmpty()){
            head = ndInput;
            tail = ndInput;
        }else{
            tail.next = ndInput;
            tail = ndInput;
        }
    }
    public void insertAfter(int key, int input){
        Praktikum1 ndInput = new Praktikum1(input, null);
        Praktikum1 temp = head;
        do{
            if(temp.data == key){
                ndInput.next = temp.next;
                temp.next = ndInput;
                if(ndInput.next == null) tail = ndInput;
                break;
            }
            temp = temp.next;
        }while (temp != null);
    }
    public void insertAt(int index, int input){
        if(index < 0){
            System.out.println("indeks salah");
        }else if(index == 0){
            addFirst(input);
        }else{
            Praktikum1 temp = head;
            for(int i=0; i<index-1; i++){
                temp = temp.next;
            }
            temp.next = new Praktikum1(input, temp.next);
            if(temp.next.next == null) tail = temp.next;
        }
    }
}    
class SLLMain{
    public static void main(String[] args) {
        SingleLinkedList singLL = new SingleLinkedList();
        singLL.print();
        singLL.addFirst(890);
        singLL.print();
        singLL.addLast(760);
        singLL.print();
        singLL.addFirst(700);
        singLL.print();
        singLL.insertAfter(700, 999);
        singLL.print();
        singLL.insertAt(3, 833);
        singLL.print();
    }
}