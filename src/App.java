import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Scanner;

class driver{
    public String no_sim;
}

class kendaraan{
    public String merk;
    public String warna;
    public String platNomor;
    public int jumlahPenumpang;
    public int maxPenumpang;

    public driver supir;

    public kendaraan(String pn, String m, int max){
        this.merk = m;
        this.platNomor = pn;
        this.jumlahPenumpang = 0;
        this.maxPenumpang = max;

        System.out.println("Halo saya objek dari kelas Kendaraan dengan plat nomor : " + this.platNomor);
        cekPenumpang();
    }

    public void cekPenumpang(){
        System.out.println("Penumpang saat ini: "+this.jumlahPenumpang);
    }

    public void penumpangNaik(int naik){
        System.out.println("ada penumpang mau naik: "+naik);
        int current = this.jumlahPenumpang;
        if (current + naik > this.maxPenumpang){
            System.out.println("maaf penumpang melebihi kapasitas");
        }
        else{
            this.jumlahPenumpang += naik;
            System.out.println("penumpang berhasil naik");
        }
        cekPenumpang();
    }

    public void penumpangTurun(int turun){
        System.out.println("ada penumpang mau turun: "+turun);
        int current = this.jumlahPenumpang;
        if (current - turun < 0){
            System.out.println("maaf penumpang ghoib yang turun");
        }
        else{
            this.jumlahPenumpang -= turun;
            System.out.println("penumpang berhasil turun");
        }
        cekPenumpang();
    }

    public void maju(){
        System.out.println(this.merk + " " + this.platNomor +" Maju");
    }

    public void mundur(){
        System.out.println(this.merk + " " + this.platNomor+ " Mundur");
    }

    public void belok(){
        System.out.println(this.merk + " " + this.platNomor+ " Belok");
    }

    public void berhenti(){
        System.out.println(this.merk + " " + this.platNomor+ " Berhenti");
    }

    public void showSIM(){
        System.out.println(this.supir.no_sim);
    }
    
}

class truk extends kendaraan{
    int kapasitasMuatan;

    public truk(String pn, String m, int max){
        super(pn, m, max);
    }

    public void setKapasitas(int kapasitas){
        this.kapasitasMuatan = kapasitas;
    }
}

class bus extends kendaraan{
    int isToilet;
    public bus(String pn, String m, int max){
        super(pn, m, max);
    }
}

class motor extends kendaraan{
    int standar;
    public motor(String pn, String m, int max){
        super(pn, m, max);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        int pilihan =0;
        //kendaraan becak1 = new kendaraan("N0001XX","bajaj",10);        
        truk t1 = new truk("N 1234 YY", "HINO", 3);

        driver s1 = new driver();
        s1.no_sim = "123456";
        t1.supir = s1; 

        t1.showSIM();

        Scanner scanner = new Scanner(System.in);
        while (pilihan != 4) {
        // Menampilkan menu
        System.out.println("Menu:");
        System.out.println("1. Naik");
        System.out.println("2. Turun");
        System.out.println("3. Cek Penumpang");
        System.out.println("4. Keluar");
        
        // Meminta input dari pengguna
        System.out.print("Pilih menu (masukkan angka): ");
        pilihan = scanner.nextInt();
        
        // Proses pemilihan menu
        switch (pilihan) {
            case 1:
                System.out.println("Berapa jumlah penumpang naik?");
                System.out.print("(masukkan angka): ");
                int naik = scanner.nextInt();
                t1.penumpangNaik(naik);
                break;
            case 2:
                System.out.println("Berapa jumlah penumpang turun?");
                System.out.print("(masukkan angka): ");
                int turun = scanner.nextInt();
                t1.penumpangTurun(turun);
                break;
            case 3:
                t1.cekPenumpang();
                break;
            case 4:
                System.out.println("Terima kasih. Program berhenti.");
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan pilih antara 1-4.");
        }
        }    
        scanner.close();

    
        /*
        System.out.println("\n");

        kendaraan dokar1 = new kendaraan("B4444JAY","mercedes",3);
        dokar1.maju();
        dokar1.belok();
        dokar1.berhenti();
        dokar1.penumpangNaik(10);
        */
    }
}
