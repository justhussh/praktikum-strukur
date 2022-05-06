public class insertBefore {
    char data;
    insertBefore next;
    public insertBefore(char data, insertBefore next){
        this.data = data;
        this.next = next;
    }
}
class SingleLinkedList_Tugas{
    insertBefore head;
    insertBefore tail;
    public boolean isEmpty(){
        return head == null;
    }
    public void print(){
        if(!isEmpty()){
            insertBefore tmp = head;
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
    public void addFirst(char input){
        insertBefore ndInput = new insertBefore(input, null);
        if(isEmpty()){
            head = ndInput;
            tail = ndInput;
        }else{
            ndInput.next = head;
            head = ndInput;
        }
    }
    public void addLast(char input){
        insertBefore ndInput = new insertBefore(input, null);
        if(isEmpty()){
            head = ndInput;
            tail = ndInput;
        }else{
            tail.next = ndInput;
            tail = ndInput;
        }
    }
    public void insertAfter(char key, char input){
        insertBefore ndInput = new insertBefore(input, null);
        insertBefore temp = head;
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
    public void insertBefore(char key, char input){
        insertBefore ndInput = new insertBefore(input, null);
        insertBefore temp = head;
        do{
            if((temp.data == key) && (temp == head)){
                this.addFirst(input);
                break;
            }else if (temp.next.data == key){
                ndInput.next = temp.next;
                temp.next = ndInput;
                break;
            }
            temp = temp.next;
        }while (temp != null);
    }
    public void insertAt(int index, char input){
        if(index < 0){
            System.out.println("indeks salah");
        }else if(index == 0){
            addFirst(input);
        }else{
            insertBefore temp = head;
            for(int i=0; i<index-1; i++){
                temp = temp.next;
            }
            temp.next = new insertBefore(input, temp.next);
            if(temp.next.next == null) tail = temp.next;
        }
    }
}
class SLLMain{
    public static void main(String[] args) {
        SingleLinkedList_Tugas ilusSLL = new SingleLinkedList_Tugas();
        ilusSLL.print();
        ilusSLL.addFirst('b');
        ilusSLL.print();
        ilusSLL.addLast('d');
        ilusSLL.print();
        ilusSLL.insertAfter('d', 'e');
        ilusSLL.print();
        ilusSLL.insertBefore('d', 'c');
        ilusSLL.print();
        ilusSLL.insertAt(0, 'a');
        ilusSLL.print();
    }
}