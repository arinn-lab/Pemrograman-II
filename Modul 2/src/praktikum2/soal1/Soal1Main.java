package praktikum2.soal1;

public class Soal1Main {
    public static void main(String[] args) {
        Fruit apple = new Fruit();
        apple.setName("Apel");
        apple.setPrice(7000);
        apple.setWeight(0.4);
        apple.setPurchaseAmount(40);
        apple.display();

        Fruit mango = new Fruit();
        mango.setName("Mangga");
        mango.setPrice(3500);
        mango.setWeight(0.2);
        mango.setPurchaseAmount(15);
        mango.display();

        Fruit avocado = new Fruit();
        avocado.setName("Alpukat");
        avocado.setPrice(10000);
        avocado.setWeight(0.25);
        avocado.setPurchaseAmount(12);
        avocado.display();
    }
}
