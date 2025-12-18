package com.ekspedisi.controller;

import com.ekspedisi.data.ResiRepository;
import com.ekspedisi.logic.ExpressService;
import com.ekspedisi.logic.LayananPengiriman;
import com.ekspedisi.logic.RegulerService;
import com.ekspedisi.model.Resi;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.UUID;

public class ResiController {

    @FXML private TextField txtNama;
    @FXML private TextField txtBerat;
    @FXML private ComboBox<String> cmbLayanan;
    @FXML private TableView<Resi> tblResi;
    @FXML private TableColumn<Resi, String> colId;
    @FXML private TableColumn<Resi, String> colNama;
    @FXML private TableColumn<Resi, Double> colBerat;
    @FXML private TableColumn<Resi, String> colLayanan;
    @FXML private TableColumn<Resi, Double> colOngkir;
    @FXML private Label lblTotalBiaya;

    private ResiRepository repository;

    @FXML
    public void initialize() {
        repository = ResiRepository.getInstance();

        // Setup ComboBox
        cmbLayanan.getItems().addAll("Reguler", "Express");

        // Setup Table Columns
        colId.setCellValueFactory(cell -> cell.getValue().idProperty());
        colNama.setCellValueFactory(cell -> cell.getValue().namaPenerimaProperty());
        colBerat.setCellValueFactory(cell -> cell.getValue().beratProperty().asObject());
        colLayanan.setCellValueFactory(cell -> cell.getValue().jenisLayananProperty());
        colOngkir.setCellValueFactory(cell -> cell.getValue().totalOngkirProperty().asObject());

        // Bind data ke tabel
        tblResi.setItems(repository.getAll());

        // Listener seleksi tabel untuk mengisi form saat edit
        tblResi.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtNama.setText(newSelection.getNamaPenerima());
                txtBerat.setText(String.valueOf(newSelection.getBerat()));
                cmbLayanan.setValue(newSelection.getJenisLayanan());
            }
        });
    }

    @FXML
    private void handleTambah() {
        try {
            String nama = txtNama.getText();
            double berat = Double.parseDouble(txtBerat.getText());
            String jenis = cmbLayanan.getValue();

            // Factory logic sederhana / Strategy Pattern Selection
            LayananPengiriman service = getServiceStrategy(jenis);

            double ongkir = service.hitungOngkir(berat);
            String id = UUID.randomUUID().toString().substring(0, 8); // Auto ID

            Resi resiBaru = new Resi(id, nama, berat, jenis, ongkir);
            repository.add(resiBaru);

            clearForm();
        } catch (NumberFormatException e) {
            showAlert("Input Error", "Berat harus berupa angka!");
        } catch (Exception e) {
            showAlert("Error", "Pastikan semua data terisi!");
        }
    }

    @FXML
    private void handleUpdate() {
        Resi selected = tblResi.getSelectionModel().getSelectedItem();
        if (selected != null) {
            try {
                String nama = txtNama.getText();
                double berat = Double.parseDouble(txtBerat.getText());
                String jenis = cmbLayanan.getValue();

                LayananPengiriman service = getServiceStrategy(jenis);
                double ongkir = service.hitungOngkir(berat);

                Resi resiBaru = new Resi(selected.getId(), nama, berat, jenis, ongkir);
                repository.update(selected, resiBaru);

                clearForm();
            } catch (Exception e) {
                showAlert("Error", "Gagal update data");
            }
        }
    }

    @FXML
    private void handleDelete() {
        Resi selected = tblResi.getSelectionModel().getSelectedItem();
        if (selected != null) {
            repository.delete(selected);
            clearForm();
        }
    }

    @FXML
    private void handleClear() {
        clearForm();
    }

    // Helper method untuk memilih strategi (Strategy Pattern)
    private LayananPengiriman getServiceStrategy(String jenis) {
        if ("Express".equals(jenis)) {
            return new ExpressService();
        } else {
            return new RegulerService();
        }
    }

    private void clearForm() {
        txtNama.clear();
        txtBerat.clear();
        cmbLayanan.getSelectionModel().clearSelection();
        tblResi.getSelectionModel().clearSelection();
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}