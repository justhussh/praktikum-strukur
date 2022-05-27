public class node2 {
    int id;
    String judulFilm;
    double rating;

    node2 prev, next;

    node2(node2 prev, int id, String judulFilm, double rating, node2 next){
        this.prev = prev;
        this.id = id;
        this.judulFilm = judulFilm;
        this.rating = rating;
        this.next = next;
    }
}