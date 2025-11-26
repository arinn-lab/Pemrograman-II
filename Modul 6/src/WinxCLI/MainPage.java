package WinxCLI;

public class MainPage extends AbstractPage {
    public MainPage(App app) {
        super("Portal Alfea", app);
    }

    public void display() {
        printTitle();
        System.out.println("1. Tampilkan Nama Peri");
        System.out.println("2. Tambah Transformasi");
        System.out.println("3. Hapus Transformasi");
        System.out.println("4. Cari Karakter Peri");
        System.out.println("5. Keluar");

        String choice = getInput("Pilih opsi: ");
        switch (choice) {
            case "1": app.setCurrentPage("view"); break;
            case "2": app.setCurrentPage("addTransform"); break;
            case "3": app.setCurrentPage("removeTransform"); break;
            case "4": app.setCurrentPage("search"); break;
            case "5": app.stop(); break;
            default: System.out.println("\nPilihan tidak valid.");
        }
    }
}