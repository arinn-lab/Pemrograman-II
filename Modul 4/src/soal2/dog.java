package soal2;

public class dog extends pet {
    private String furColor;
    private String[] abilities;

    public dog(String n, String r, String w, String[] k) {
        super(n, r);
        this.furColor = w;
        this.abilities = k;
    }

    public String getFurColor() {
        return furColor;
    }

    public String[] getAbilities() {
        return abilities;
    }

    public void displayDogDetails() {
        super.display();
        System.out.println("Memiliki warna bulu : " + getFurColor());
        System.out.print("Memiliki Kemampuan : ");

        for (int i = 0; i < abilities.length; i++) {
            System.out.print(abilities[i]);
            if (i < abilities.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}