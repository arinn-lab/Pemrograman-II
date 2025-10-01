import java.util.Scanner;

public class PRAK101_2410817120018_ArindaDitaPratiwi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Nama Lengkap: ");
        String fullName = scanner.nextLine();

        System.out.print("Masukkan Tempat Lahir: ");
        String birthPlace = scanner.nextLine();

        System.out.print("Masukkan Tanggal Lahir: ");
        int birthDate = scanner.nextInt();

        System.out.print("Masukkan Bulan Lahir: ");
        int birthMonth = scanner.nextInt();

        System.out.print("Masukkan Tahun Lahir: ");
        int birthYear = scanner.nextInt();

        System.out.print("Masukkan Tinggi Badan: ");
        int height = scanner.nextInt();

        System.out.print("Masukkan Berat Badan: ");
        double weight = scanner.nextDouble();

        String monthName = "";
        switch (birthMonth) {
            case 1 -> monthName = "Januari";
            case 2 -> monthName = "Februari";
            case 3 -> monthName = "Maret";
            case 4 -> monthName = "April";
            case 5 -> monthName = "Mei";
            case 6 -> monthName = "Juni";
            case 7 -> monthName = "Juli";
            case 8 -> monthName = "Agustus";
            case 9 -> monthName = "September";
            case 10 -> monthName = "Oktober";
            case 11 -> monthName = "November";
            case 12 -> monthName = "Desember";
        }

        System.out.println("Nama Lengkap " + fullName + ", Lahir di " + birthPlace + " pada Tanggal " + birthDate + " " + monthName + " " + birthYear);
        System.out.println("Tinggi Badan " + height + " cm dan Berat Badan " + weight + " kilogram");

        scanner.close();
    }
}