package soal1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Dice> listofDice = new LinkedList<>();

        int diceAmount = input.nextInt();

        for(int i = 0; i < diceAmount; i++){
            Dice d = new Dice();
            listofDice.add(d);
        }

        int totalValue = 0;
        for(int i = 0; i < listofDice.size(); i++){
            System.out.println("Dadu ke-" + (i + 1) + " bernilai " + listofDice.get(i).getValue());
            totalValue += listofDice.get(i).getValue();
        }

        System.out.println("Total nilai dadu keseluruhan " + totalValue);
        input.close();
    }
}