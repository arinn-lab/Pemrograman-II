package soal1;

public class Paint {
    private double coverage;

    public Paint(double c) {
        setCoverage(c);
    }

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double c) {
        this.coverage = c;
    }

    public double amount(Shape s) {
        System.out.println("Computing amount for " + s);
        return s.area() / getCoverage();
    }
}