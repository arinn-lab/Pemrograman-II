package praktikum2.soal1;

public class Fruit {
    String name;
    double weight;
    double price;
    double purchaseAmount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public double getTotalPriceBeforeDiscount() {
        return (purchaseAmount / weight) * price;
    }

    public double getDiscountAmount() {
        return (int)(purchaseAmount/4) * (4 * price) * 0.02;
    }

    public double getTotalPriceAfterDiscount() {
        return getTotalPriceBeforeDiscount() - getDiscountAmount();
    }

    public void display() {
        System.out.println("Nama Buah: " + name);
        System.out.println("Berat: " + weight);
        System.out.println("Harga: " + price);
        System.out.println("Jumlah Beli: " + purchaseAmount + "kg");
        System.out.printf("Harga Sebelum Diskon: Rp%.2f%n", getTotalPriceBeforeDiscount());
        System.out.printf("Total Diskon: Rp%.2f%n", getDiscountAmount());
        System.out.printf("Harga Setelah Diskon: Rp%.2f%n%n", getTotalPriceAfterDiscount());
    }
}