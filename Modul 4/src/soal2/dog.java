package soal2;

public class dog extends pet {
    private String furColor;
    private String[] abilities;

    public dog(String n, String r, String w, String[] k) {
        super(n, r);
        this.furColor = w;
        this.abilities = k;
    }

    public void displayDogDetails() {
        super.display();
        System.out.println("Memiliki warna bulu : " + this.furColor);
        System.out.print("Memiliki Kemampuan : ");

        for (int i = 0; i < abilities.length; i++) {
            System.out.print(abilities[i]);
            if (i < abilities.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}