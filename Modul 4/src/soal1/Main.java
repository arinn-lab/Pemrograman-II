package soal1;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nama Hewan Peliharaan: ");
        String petName = input.nextLine();
        System.out.print("Ras: ");
        String petBreed = input.nextLine();

        pet myPet = new pet(petName, petBreed);
        myPet.display();
        input.close();
    }
}