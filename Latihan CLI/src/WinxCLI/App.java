package WinxCLI;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class App {
    private final Scanner scanner;
    private final Map<String, Page> pages;
    private Page currentPage;
    private boolean isRunning;
    private final List<Fairy> fairyDatabase;

    public App() {
        this.scanner = new Scanner(System.in);
        this.pages = new HashMap<>();
        this.fairyDatabase = new ArrayList<>();
        this.isRunning = true;
        initData();
        initPages();
        this.currentPage = pages.get("main");
    }

    private void initData() {
        fairyDatabase.add(new Fairy("Bloom", "Peri Penjaga Api Naga dari Domino", Arrays.asList("Magic Winx", "Charmix", "Enchantix")));
        fairyDatabase.add(new Fairy("Stella", "Peri Matahari, Bulan, dan Bintang dari Solaria", Arrays.asList("Magic Winx", "Charmix", "Enchantix")));
        fairyDatabase.add(new Fairy("Flora", "Peri Alam dari Linphea", Arrays.asList("Magic Winx", "Charmix", "Enchantix")));
        fairyDatabase.add(new Fairy("Musa", "Peri Musik dari Melody", Arrays.asList("Magic Winx", "Charmix", "Enchantix")));
        fairyDatabase.add(new Fairy("Tecna", "Peri Teknologi dari Zenith", Arrays.asList("Magic Winx", "Charmix", "Enchantix")));
        fairyDatabase.add(new Fairy("Aisha", "Peri Gelombang dari Andros", Arrays.asList("Magic Winx", "Charmix", "Enchantix")));
    }

    private void initPages() {
        pages.put("main", new MainPage(this));
        pages.put("view", new ViewFairiesPage(this));
        pages.put("addTransform", new AddTransformPage(this));
        pages.put("removeTransform", new RemoveTransformPage(this));
        pages.put("search", new SearchPage(this));
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

    public List<Fairy> getFairyDatabase() {
        return fairyDatabase;
    }

    public void setCurrentPage(String pageName) {
        this.currentPage = pages.getOrDefault(pageName, pages.get("main"));
    }

    public void stop() {
        this.isRunning = false;
    }
}