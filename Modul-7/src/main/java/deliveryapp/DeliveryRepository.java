package deliveryapp;

import java.util.ArrayList;
import java.util.List;

public class DeliveryRepository implements DeliveryService {
    private final List<BasePackage> packageList;

    public DeliveryRepository() {
        this.packageList = new ArrayList<>();
    }

    @Override
    public void addPackage(BasePackage newPackage) {
        packageList.add(newPackage);
    }

    @Override
    public List<BasePackage> getAllPackages() {
        return packageList;
    }

    @Override
    public void updatePackage(int index, BasePackage updatedPackage) {
        if (index >= 0 && index < packageList.size()) {
            packageList.set(index, updatedPackage);
        }
    }

    @Override
    public void deletePackage(BasePackage packetToRemove) {
        packageList.remove(packetToRemove);
    }
}