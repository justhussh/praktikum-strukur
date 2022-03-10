import java.util.Scanner;
public class mahasiswa {
    public String nama, nim;
    public char jenisKelamin;
    public double ipk;

    public mahasiswa(String nm, String ni, char jk, double ip ){
        nama = nm;
        nim = ni;
        jenisKelamin = jk;
        ipk = ip;
    }
}

class mahasiswaMain{
    public static void main(String args[]) {
        Scanner mhs = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jml = mhs.nextInt();
        mahasiswa[] mhsArray = new mahasiswa[jml];
        System.out.println();
        for(int i=0; i<jml; i++){
            System.out.println("Masukkan data mahasiswa ke- "+(i+1));
            System.out.print("Masukkan nama: ");
            String nm = mhs.next();
            System.out.print("Masukkan nim: ");
            String ni = mhs.next();
            System.out.print("Masukkan jenis kelamin: ");
            char jk = mhs.next().charAt(0);
            System.out.print("Masukkan IPK: ");
            double ip = mhs.nextDouble();
            System.out.println();
            
            mhsArray[i] = new mahasiswa(nm, ni, jk, ip);
        }
        
        for(int j=0; j<jml; j++){
            System.out.println();
            System.out.println("Data Mahasiswa ke-"+(j+1));
            System.out.println("nama : "+mhsArray[j].nama);
            System.out.println("nim : "+mhsArray[j].nim);
            System.out.println("Jenis Kelamin : "+mhsArray[j].jenisKelamin);
            System.out.println("Nilai IPK : "+mhsArray[j].ipk);
        }
    }
}