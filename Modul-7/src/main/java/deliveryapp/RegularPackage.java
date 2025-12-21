package deliveryapp;

public class RegularPackage extends BasePackage {
    private static final double RATE_PER_KG = 10000;

    public RegularPackage(String receiptNumber, String senderName, String destination, double weight) {
        super(receiptNumber, senderName, destination, weight); // Oper ke bapak (BasePackage)
    }

    @Override
    public double calculateTotalCost() {
        return this.weight * RATE_PER_KG;
    }

    @Override
    public String getServiceType() {
        return "Regular Service";
    }
}