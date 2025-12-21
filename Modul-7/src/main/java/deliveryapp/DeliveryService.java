package deliveryapp;

import java.util.List;

public interface DeliveryService {
    void addPackage(BasePackage newPackage);
    List<BasePackage> getAllPackages();
    void updatePackage(int index, BasePackage updatedPackage);
    void deletePackage(BasePackage packetToRemove);
}