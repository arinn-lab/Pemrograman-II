package deliveryapp;

public abstract class BasePackage {
    protected String receiptNumber; // Nomor Resi
    protected String senderName;    // Nama Pengirim
    protected String destination;   // Kota Tujuan
    protected double weight;        // Berat (Kg)

    public BasePackage(String receiptNumber, String senderName, String destination, double weight) {
        this.receiptNumber = receiptNumber;
        this.senderName = senderName;
        this.destination = destination;
        this.weight = weight;
    }

    public abstract double calculateTotalCost();

    public abstract String getServiceType();

    public String getReceiptNumber() { return receiptNumber; }
    public void setReceiptNumber(String receiptNumber) { this.receiptNumber = receiptNumber; }

    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
}