package soal2;

import java.util.HashMap;

public class Country {
    private String countryName;
    private String leadershipType;
    private String leaderName;
    private int independenceDay;
    private int independenceMonth;
    private int independenceYear;

    public Country(String countryName, String leadershipType, String leaderName,
                   int independenceDay, int independenceMonth, int independenceYear){
        this.countryName = countryName;
        this.leadershipType = leadershipType;
        this.leaderName = leaderName;
        this.independenceDay = independenceDay;
        this.independenceMonth = independenceMonth;
        this.independenceYear = independenceYear;
    }

    public Country(String countryName, String leadershipType, String leaderName){
        this.countryName = countryName;
        this.leadershipType = leadershipType;
        this.leaderName = leaderName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getLeadershipType() {
        return leadershipType;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public int getIndependenceDay() {
        return independenceDay;
    }

    public int getIndependenceMonth() {
        return independenceMonth;
    }

    public int getIndependenceYear() {
        return independenceYear;
    }

    private String capitalize(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }

    public void displayCountryInfo(HashMap<Integer, String> monthMap) {
        if(getLeadershipType().equalsIgnoreCase("monarki")) {
            System.out.println("Negara " + getCountryName() + " mempunyai Raja bernama "
                    + getLeaderName());
        } else {
            String monthName = monthMap.get(getIndependenceMonth());
            String capitalizedLeadership = capitalize(getLeadershipType());
            System.out.println("Negara " + getCountryName() + " mempunyai "
                    + capitalizedLeadership + " bernama " + getLeaderName());
            System.out.println("Deklarasi Kemerdekaan pada Tanggal "
                    + getIndependenceDay() + " " + monthName + " "
                    + getIndependenceYear());
        }
        System.out.println();
    }
}