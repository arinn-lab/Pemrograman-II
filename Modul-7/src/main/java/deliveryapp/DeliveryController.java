package deliveryapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class DeliveryController {

    @FXML private TextField txtReceiptNo;
    @FXML private TextField txtSender;
    @FXML private TextField txtDestination;
    @FXML private TextField txtWeight;
    @FXML private ComboBox<String> cmbServiceType;

    @FXML private TableView<BasePackage> tablePackages;
    @FXML private TableColumn<BasePackage, String> colReceipt;
    @FXML private TableColumn<BasePackage, String> colSender;
    @FXML private TableColumn<BasePackage, String> colDest;
    @FXML private TableColumn<BasePackage, Double> colWeight;
    @FXML private TableColumn<BasePackage, String> colService;
    @FXML private TableColumn<BasePackage, Double> colCost;

    private final DeliveryService service = new DeliveryRepository();

    private ObservableList<BasePackage> observablePackages;

    @FXML
    public void initialize() {
        cmbServiceType.setItems(FXCollections.observableArrayList("Regular Service", "Express One Day"));
        cmbServiceType.getSelectionModel().selectFirst();

        colReceipt.setCellValueFactory(new PropertyValueFactory<>("receiptNumber"));
        colSender.setCellValueFactory(new PropertyValueFactory<>("senderName"));
        colDest.setCellValueFactory(new PropertyValueFactory<>("destination"));
        colWeight.setCellValueFactory(new PropertyValueFactory<>("weight"));

        colService.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getServiceType()));
        colCost.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue().calculateTotalCost()));

        observablePackages = FXCollections.observableArrayList(service.getAllPackages());
        tablePackages.setItems(observablePackages);

        tablePackages.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                showPacketDetails(newVal);
            }
        });
    }

    @FXML
    private void handleAdd() {
        if (isInputValid()) {
            BasePackage newPackage = createPackageFromForm();

            service.addPackage(newPackage);
            refreshTable();
            handleClear();
        }
    }

    @FXML
    private void handleUpdate() {
        BasePackage selected = tablePackages.getSelectionModel().getSelectedItem();
        int index = tablePackages.getSelectionModel().getSelectedIndex();

        if (selected != null && isInputValid()) {
            String currentType = selected.getServiceType();
            String newType = cmbServiceType.getValue();

            if (!currentType.equals(newType)) {
                BasePackage newPackage = createPackageFromForm();
                service.updatePackage(index, newPackage);
                refreshTable();
            }
            else {
                selected.setReceiptNumber(txtReceiptNo.getText());
                selected.setSenderName(txtSender.getText());
                selected.setDestination(txtDestination.getText());
                selected.setWeight(Double.parseDouble(txtWeight.getText()));

                tablePackages.refresh();
            }

            handleClear();
        } else {
            showAlert("Please select a package to update!");
        }
    }

    @FXML
    private void handleDelete() {
        BasePackage selected = tablePackages.getSelectionModel().getSelectedItem();
        if (selected != null) {
            service.deletePackage(selected);
            refreshTable();
            handleClear();
        } else {
            showAlert("Please select a package to delete!");
        }
    }

    @FXML
    private void handleClear() {
        txtReceiptNo.clear();
        txtSender.clear();
        txtDestination.clear();
        txtWeight.clear();
        cmbServiceType.getSelectionModel().selectFirst();
        tablePackages.getSelectionModel().clearSelection();
    }

    private void refreshTable() {
        observablePackages.setAll(service.getAllPackages());
    }

    private void showPacketDetails(BasePackage pkg) {
        txtReceiptNo.setText(pkg.getReceiptNumber());
        txtSender.setText(pkg.getSenderName());
        txtDestination.setText(pkg.getDestination());
        txtWeight.setText(String.valueOf(pkg.getWeight()));

        if (pkg instanceof RegularPackage) {
            cmbServiceType.getSelectionModel().select("Regular Service");
        } else {
            cmbServiceType.getSelectionModel().select("Express One Day");
        }
    }

    private boolean isInputValid() {
        String errorMessage = "";
        if (txtReceiptNo.getText() == null || txtReceiptNo.getText().isEmpty()) {
            errorMessage += "No. Resi invalid!\n";
        }
        if (txtSender.getText() == null || txtSender.getText().isEmpty()) {
            errorMessage += "Sender name invalid!\n";
        }
        if (txtWeight.getText() == null || txtWeight.getText().isEmpty()) {
            errorMessage += "Weight invalid!\n";
        } else {
            try {
                Double.parseDouble(txtWeight.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Weight must be a number!\n";
            }
        }

        if (errorMessage.isEmpty()) {
            return true;
        } else {
            showAlert(errorMessage);
            return false;
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private BasePackage createPackageFromForm() {
        String receipt = txtReceiptNo.getText();
        String sender = txtSender.getText();
        String dest = txtDestination.getText();
        double weight = Double.parseDouble(txtWeight.getText());
        String type = cmbServiceType.getValue();

        if (type.equals("Regular Service")) {
            return new RegularPackage(receipt, sender, dest, weight);
        } else {
            return new ExpressPackage(receipt, sender, dest, weight);
        }
    }
}