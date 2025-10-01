import java.util.Scanner;

public class PRAK104_2410817120018_ArindaDitaPratiwi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Tangan Abu: ");
        String[] AbusHand = scan.nextLine().split(" ");
        System.out.print("Tangan Bagas: ");
        String[] BagasHand = scan.nextLine().split(" ");

        int ScoreA = 0; int ScoreB = 0;
        for (int i = 0; i < 3; i++) {
            if(AbusHand[i].charAt(0) == 'B' && BagasHand[i].charAt(0) == 'G' ||
                    AbusHand[i].charAt(0) == 'G' && BagasHand[i].charAt(0) == 'K' ||
                    AbusHand[i].charAt(0) == 'K' && BagasHand[i].charAt(0) == 'B') {
                ScoreA++; }
            else if(BagasHand[i].charAt(0) == 'B' && AbusHand[i].charAt(0) == 'G' ||
                    BagasHand[i].charAt(0) == 'G' && AbusHand[i].charAt(0) == 'K' ||
                    BagasHand[i].charAt(0) == 'K' && AbusHand[i].charAt(0) == 'B') {
                ScoreB++; } }

        if(ScoreA > ScoreB) {
            System.out.print("Abu"); }
        else if(ScoreB > ScoreA) {
            System.out.print("Bagas"); }
        else {
            System.out.print("Seri"); }

        scan.close();
    }
}