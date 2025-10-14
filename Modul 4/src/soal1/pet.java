package soal1;

public class pet {
    private String name;
    private String breed;

    public pet(String n, String r) {
        this.name = n;
        this.breed = r;
    }

    public void display(){
        System.out.println(" ");
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah : " + this.name);
        System.out.println("Dengan ras : " + this.breed);
    }
}