public class Tugas2 {
        int size;
        int top;
        StrukTugas data[];
    
        public Tugas2(int size){
            this.size = size;
            data = new StrukTugas[size];
            top = -1;
        }
        public boolean IsEmpty(){
            if(top == -1){
                return true;
            }else{
                return false;
            }
        }
        public boolean IsFull(){
            if(top == size - 1){
                return true;
            }else{
                return false;
            }
        }
    
        public void push(StrukTugas sb){
            if(!IsFull()){
                top++;
                data[top] = sb;
            }else{
                System.out.println("Isi stack penuh!");
            }
        }
        public void pop(){
            if(!IsEmpty()){
                StrukTugas x = data[top];
                top--;
                System.out.println("Data yang keluar: " + x.noTransaksi + " " + x.tanggal + " " + x.namaBarang + " " + x.jmlh + " " + x.total);
            }else{
                System.out.println("Stock masih kosong");
            }
        }
        public void peek(){
            System.out.println("Elemen teratas: " + data[top].noTransaksi +"."+ " " + data[top].tanggal + " " + data[top].namaBarang + " " + data[top].jmlh + " " + data[top].total);
        }
        public void print(){
            System.out.println("Isi stack: ");
            for(int i = top; i >= 0; i--){
                System.out.println(data[i].noTransaksi + " " + data[i].tanggal + " " + data[i].namaBarang + " " + data[i].jmlh + " " + data[i].total);
            }
            System.out.println("");
        }
        public void clear(){
            if(!IsEmpty()){
                for(int i = top; i >= 0; i--){
                    top--;
                }
                System.out.println("Stock sudah dikosongkan");
            }else{
                System.out.println("Stock masih kosong");
            }
        }
}