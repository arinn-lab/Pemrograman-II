package WinxCLI;

public class SearchPage extends AbstractPage {
    public SearchPage(App app) {
        super("Cari Karakter Peri", app);
    }

    public void display() {
        printTitle();
        String searchTerm = getInput("Masukkan nama peri yang dicari: ");
        boolean found = false;

        for (Fairy fairy : app.getFairyDatabase()) {
            if (fairy.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("\nPeri Ditemukan:");

                printFairyDetailsAsNarrative(fairy);

                found = true;
            }
        }

        if (!found) {
            System.out.println("Tidak ada peri yang cocok dengan '" + searchTerm + "'.");
        }
        pause();
    }
}