import java.util.Scanner;
public class PRAK102_2410817120018_ArindaDitaPratiwi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int row = 0;

        while (row < 11) {
            if(number % 5 == 0) {
                System.out.print(number / 5 - 1);
            } else {
               System.out.print(number);
            }
            if(row < 10) {
                System.out.print(", ");
            }
            number ++;
            row++;
        }

        scan.close();
    }
}