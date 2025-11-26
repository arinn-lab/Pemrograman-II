package WinxCLI;

import java.util.List;

public class ViewFairiesPage extends AbstractPage {
    private final FairyRepository repository;

    public ViewFairiesPage(App app, FairyRepository repository) {
        super("Daftar Peri Winx", app);
        this.repository = repository;
    }

    public void display() {
        printTitle();
        List<Fairy> fairies = repository.getAll();

        while (true) {
            System.out.println("Pilih peri untuk melihat detail:");
            for (int i = 0; i < fairies.size(); i++) {
                System.out.println((i + 1) + ". " + fairies.get(i).getName());
            }
            System.out.println("0. Kembali ke Menu Utama");

            String choiceStr = getInput("Pilihan opsi: ");
            try {
                int choice = Integer.parseInt(choiceStr);
                if (choice == 0) {
                    app.setCurrentPage("main");
                    break;
                } else if (choice > 0 && choice <= fairies.size()) {
                    showFairyDetails(fairies.get(choice - 1));
                } else {
                    System.out.println("\nPilihan tidak valid.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInput harus berupa angka.\n");
            }
        }
    }

    private void showFairyDetails(Fairy fairy) {
        System.out.println("\n=== Detail Peri: " + fairy.getName() + " ===");
        printFairyDetailsAsNarrative(fairy);
        getInput("\nTekan Enter untuk kembali ke daftar peri...");
        printTitle();
    }
}