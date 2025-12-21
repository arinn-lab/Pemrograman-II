package deliveryapp;

public class ExpressPackage extends BasePackage {
    private static final double RATE_PER_KG = 10000;
    private static final double EXPRESS_MULTIPLIER = 1.5;

    public ExpressPackage(String receiptNumber, String senderName, String destination, double weight) {
        super(receiptNumber, senderName, destination, weight);
    }

    @Override
    public double calculateTotalCost() {
        return (this.weight * RATE_PER_KG) * EXPRESS_MULTIPLIER;
    }

    @Override
    public String getServiceType() {
        return "Express One Day";
    }
}