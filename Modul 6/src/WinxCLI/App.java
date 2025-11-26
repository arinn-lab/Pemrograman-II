package WinxCLI;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class App {
    private final Scanner scanner;
    private final Map<String, Page> pages;
    private Page currentPage;
    private boolean isRunning;

    private final FairyRepository fairyRepository;

    public App() {
        this.scanner = new Scanner(System.in);
        this.pages = new HashMap<>();
        this.isRunning = true;

        this.fairyRepository = new FairyRepository();

        initPages();

        this.currentPage = pages.get("main");
    }

    private void initPages() {
        pages.put("main", PageFactory.createPage("main", this, fairyRepository));
        pages.put("view", PageFactory.createPage("view", this, fairyRepository));
        pages.put("addTransform", PageFactory.createPage("addTransform", this, fairyRepository));
        pages.put("removeTransform", PageFactory.createPage("removeTransform", this, fairyRepository));
        pages.put("search", PageFactory.createPage("search", this, fairyRepository));
    }

    public void run() {
        while (isRunning) {
            currentPage.display();
        }
        System.out.println("\nTerima kasih telah mengunjungi Alfea!");
        scanner.close();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setCurrentPage(String pageName) {
        this.currentPage = pages.getOrDefault(pageName, pages.get("main"));
    }

    public void stop() {
        this.isRunning = false;
    }
}