import java.util.Scanner;

public class NilaiUjian {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== SISTEM ANALISIS NILAI MAHASISWA ===");

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jml = sc.nextInt();

        int nilaiMhs[] = new int[jml];

        // input nilai
        for(int i = 0; i < jml; i++){
            int n;

            do{
                System.out.print("Masukkan nilai mahasiswa ke-" + (i+1) + ": ");
                n = sc.nextInt();

                if(n < 0 || n > 100){
                    System.out.println("Nilai tidak valid! Masukkan antara 0-100.");
                }

            }while(n < 0 || n > 100);

            nilaiMhs[i] = n;
        }

        int total = 0;
        int max = nilaiMhs[0];
        int min = nilaiMhs[0];
        int lulus = 0;

        // hitung statistik
        for(int i = 0; i < jml; i++){

            total = total + nilaiMhs[i];

            if(nilaiMhs[i] > max){
                max = nilaiMhs[i];
            }

            if(nilaiMhs[i] < min){
                min = nilaiMhs[i];
            }

            if(nilaiMhs[i] > 75){
                lulus++;
            }
        }

        double rata = (double) total / jml;

        int atasRata = 0;

        for(int i = 0; i < jml; i++){
            if(nilaiMhs[i] > rata){
                atasRata = atasRata + 1;
            }
        }

        System.out.println("\n--- HASIL ANALISIS ---");

        for(int i = 0; i < jml; i++){

            if(nilaiMhs[i] > 75){
                System.out.println("Mahasiswa " + (i+1) + ": " + nilaiMhs[i] + " (Lulus)");
            }else{
                System.out.println("Mahasiswa " + (i+1) + ": " + nilaiMhs[i] + " (Tidak Lulus)");
            }

        }

        System.out.println("----------------------------");

        System.out.println("Nilai Rata-rata: " + String.format("%.2f", rata));
        System.out.println("Nilai Tertinggi: " + max);
        System.out.println("Nilai Terendah : " + min);
        System.out.println("Jumlah Mahasiswa Lulus: " + lulus);
        System.out.println("Jumlah Mahasiswa di Atas Rata-rata: " + atasRata);

        System.out.println("======================================");
    }
}