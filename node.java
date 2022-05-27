public class node {
    int nomor;
    String nama;
    node prev, next;
    node(node prev, int nomor, String nama, node next){
        this.prev = prev;
        this.nomor = nomor;
        this.nama = nama;
        this.next = next;
    }
}
