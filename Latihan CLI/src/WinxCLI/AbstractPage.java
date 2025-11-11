package WinxCLI;

import java.util.List;

public abstract class AbstractPage implements Page {
    protected final String title;
    protected final App app;

    public AbstractPage(String title, App app) {
        this.title = title;
        this.app = app;
    }

    protected void printTitle() {
        System.out.println("\n========== " + title + " ==========");
    }

    protected String getInput(String prompt) {
        System.out.print(prompt);
        return app.getScanner().nextLine();
    }

    protected Fairy findFairyByName(String name) {
        for (Fairy fairy : app.getFairyDatabase()) {
            if (fairy.getName().equalsIgnoreCase(name)) {
                return fairy;
            }
        }
        return null;
    }

    protected void pause() {
        getInput("\nTekan Enter untuk kembali ke menu utama...");
        app.setCurrentPage("main");
    }

    protected void printFairyDetailsAsNarrative(Fairy fairy) {
        String name = fairy.getName();
        String description = fairy.getDescription();
        List<String> transforms = fairy.getTransformations();

        String lowerDesc = description.substring(0, 1).toLowerCase() + description.substring(1);

        String sentence1 = String.format("%s adalah %s.", name, lowerDesc);

        String sentence2;
        if (transforms.isEmpty()) {
            sentence2 = "Saat ini ia belum memiliki transformasi.";
        } else {
            String transformList = String.join(", ", transforms);
            sentence2 = String.format("Transformasi yang ia miliki adalah %s.", transformList);
        }

        System.out.println(sentence1);
        System.out.println(sentence2);
    }

    public abstract void display();
}