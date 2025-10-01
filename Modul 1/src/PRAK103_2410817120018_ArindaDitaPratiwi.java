import java.util.Scanner;

public class PRAK103_2410817120018_ArindaDitaPratiwi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int number = scan.nextInt();
        int row = 0;

        do {
            if (number % 2 != 0) {
                System.out.print(number);
                row++;

                if (row < n) {
                    System.out.print(", ");
                }
            }
            number++;
        } while (row < n);

        scan.close();
    }
}