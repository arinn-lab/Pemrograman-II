package soal2;

public class cat extends pet{
    private String furColor;

    public cat(String n, String r, String w){
        super(n, r);
        this.furColor = w;
    }

    public void displayCatDetails(){
        super.display();
        System.out.println("Memiliki warna bulu : " + this.furColor);
    }
}