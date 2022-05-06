public class implementasiStack {
    String data;
    implementasiStack next;
    public implementasiStack(String data, implementasiStack next){
        this.data = data;
        this.next = next;
    }
}
class implementasiStackSSL{
    implementasiStack head;
    implementasiStack tail;   
    public boolean isEmpty(){
        return head == null;
    }
    public void print(){
        if (!isEmpty()){
            implementasiStack tmp = head;
            System.out.println("");
            while (tmp != null){
                System.out.println(tmp.data);
                tmp = tmp.next;
            }
            System.out.println();
        }else{
            System.out.println("Stack Masih Kosong!");
        }
    }
    public void peek(){
        if(!isEmpty()){
            implementasiStack tmp = head;
            System.out.println("Isi Stack Teratas : " + tmp.data);
        }else{
            System.out.println("Stack Masing Kosong!");
        }
    }
    public void pushAwal(String input){
        implementasiStack ndInput = new implementasiStack(input, null);
        if(isEmpty()){
            head = ndInput;
            tail = ndInput;
        }else{
            ndInput.next = head;
            head = ndInput;
        }
    }
}
class implementasiStackMain{
    public static void main(String[] args) {
        implementasiStackSSL sllStack = new implementasiStackSSL();
        sllStack.pushAwal("Bahasa");
        sllStack.print();
        sllStack.pushAwal("Android");
        sllStack.print();
        sllStack.pushAwal("Komputer");
        sllStack.print();
        sllStack.pushAwal("Basis Data");
        sllStack.print();
        sllStack.pushAwal("Matematika");
        sllStack.print();
        sllStack.pushAwal("Algoritma");
        sllStack.print();
        sllStack.pushAwal("Statistika");
        sllStack.print();
        sllStack.pushAwal("Multimedia");
        sllStack.print();
        System.out.println("Isi Stack: ");
        sllStack.print();
        sllStack.peek();
    }
}