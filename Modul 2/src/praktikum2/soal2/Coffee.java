package praktikum2.soal2;

public class Coffee {
    public String nameCoffee;
    public String size;
    public double price;
    private String buyer;
    public double tax;

    public void info() {
        System.out.println("Nama Kopi: " + nameCoffee);
        System.out.println("Ukuran: " + size);
        System.out.println("Harga: Rp. " + price);
    }

    public void setBuyer(String buyerName) {
        this.buyer = buyerName;
    }

    public String getBuyer() {
        return this.buyer;
    }

    public double getTax() {
        tax = price * 0.11;
        return tax;
    }
}