package WinxCLI;

public class SearchPage extends AbstractPage {
    private final FairyRepository repository;

    public SearchPage(App app, FairyRepository repository) {
        super("Cari Karakter Peri", app);
        this.repository = repository;
    }

    public void display() {
        printTitle();
        String searchTerm = getInput("Masukkan nama peri yang dicari: ");
        boolean found = false;

        for (Fairy fairy : repository) {
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