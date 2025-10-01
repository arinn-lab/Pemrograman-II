import java.util.Scanner;

public class PRAK105_2410817120018_ArindaDitaPratiwi {
    static final double phi = 3.14;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan jari-jari: ");
        double radius = scan.nextDouble();

        System.out.print("Masukkan tinggi: ");
        double height = scan.nextDouble();

        double volume = phi * radius * radius * height;

        System.out.printf("Volume tabung dengan jari-jari %.1f cm dan tinggi %.1f cm adalah %.3f m3",
                radius, height, volume);

        scan.close();
    }
}