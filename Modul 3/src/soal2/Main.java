package soal2;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Country> countryList = new LinkedList<>();
        HashMap<Integer, String> monthMap = new HashMap<>();

        monthMap.put(1, "Januari");
        monthMap.put(2, "Februari");
        monthMap.put(3, "Maret");
        monthMap.put(4, "April");
        monthMap.put(5, "Mei");
        monthMap.put(6, "Juni");
        monthMap.put(7, "Juli");
        monthMap.put(8, "Agustus");
        monthMap.put(9, "September");
        monthMap.put(10, "Oktober");
        monthMap.put(11, "November");
        monthMap.put(12, "Desember");

        int countryCount = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < countryCount; i++) {
            String name = scanner.nextLine().trim();
            String leadershipType = scanner.nextLine().trim();
            String leaderName = scanner.nextLine().trim();

            if(leadershipType.equalsIgnoreCase("monarki")) {
                countryList.add(new Country(name, leadershipType, leaderName));
            } else {
                int day = scanner.nextInt();
                int month = scanner.nextInt();
                int year = scanner.nextInt();
                scanner.nextLine();

                countryList.add(new Country(name, leadershipType, leaderName, day, month, year));
            }
        }

        for(Country country : countryList) {
            country.displayCountryInfo(monthMap);
        }

        scanner.close();
    }
}