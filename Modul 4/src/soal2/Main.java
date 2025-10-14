package soal2;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Pilih jenis hewan yang ingin diinputkan:");
        System.out.println("1 = Kucing");
        System.out.println("2 = Anjing");
        System.out.print("Masukkan pilihan: ");
        int options = input.nextInt();
        input.nextLine();

        if(options == 1){
            System.out.print("Nama hewan peliharaan: ");
            String name = input.nextLine();
            System.out.print("Ras: ");
            String breed = input.nextLine();
            System.out.print("Warna Bulu: ");
            String furColor = input.nextLine();

            cat myCat = new cat(name,breed,furColor);
            myCat.displayCatDetails();
        }

        else if(options == 2){
            System.out.print("Nama hewan peliharaan: ");
            String name = input.nextLine();
            System.out.print("Ras: ");
            String breed = input.nextLine();
            System.out.print("Warna Bulu: ");
            String furColor = input.nextLine();
            System.out.print("Kemampuan: ");
            String abilities = input.nextLine();
            String[] petAbilities = abilities.split(", ");

            dog myDog = new dog(name,breed,furColor,petAbilities);
            myDog.displayDogDetails();
        }

        else{
            System.out.println("Pilihan tidak valid.");
        }

        input.close();
    }
}