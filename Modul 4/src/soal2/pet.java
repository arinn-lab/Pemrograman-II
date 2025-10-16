package soal2;

public class pet {
    private String name;
    private String breed;

    public pet(String n, String r) {
        this.name = n;
        this.breed = r;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public void display(){
        System.out.println(" ");
        System.out.println("Detail Hewan Peliharaan:");
        System.out.println("Nama hewan peliharaanku adalah : " + getName());
        System.out.println("Dengan ras : " + getBreed());
    }
}