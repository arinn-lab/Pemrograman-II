module com.ekspedisi { // Sesuaikan nama modul ini dengan nama folder projectmu jika perlu
    requires javafx.controls;
    requires javafx.fxml;

    // 1. Export package utama (tempat MainApp.java berada)
    exports com.ekspedisi.App;

    // 2. Buka package Controller ke javafx.fxml
    // (Supaya tombol & textfield @FXML bisa terbaca/di-inject)
    opens com.ekspedisi.controller to javafx.fxml;

    // 3. PENTING: Buka package Model ke javafx.base
    // (Supaya TableView bisa membaca getter/setter di class Resi)
    opens com.ekspedisi.model to javafx.base;
}