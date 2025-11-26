package WinxCLI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FairyRepository implements Iterable<Fairy> {
    private final List<Fairy> fairyDatabase;

    public FairyRepository() {
        this.fairyDatabase = new ArrayList<>();
        initData();
    }

    private void initData() {
        fairyDatabase.add(new Fairy("Bloom", "Peri Penjaga Api Naga dari Domino", Arrays.asList("Magic Winx", "Charmix", "Enchantix")));
        fairyDatabase.add(new Fairy("Stella", "Peri Matahari, Bulan, dan Bintang dari Solaria", Arrays.asList("Magic Winx", "Charmix", "Enchantix")));
        fairyDatabase.add(new Fairy("Flora", "Peri Alam dari Linphea", Arrays.asList("Magic Winx", "Charmix", "Enchantix")));
        fairyDatabase.add(new Fairy("Musa", "Peri Musik dari Melody", Arrays.asList("Magic Winx", "Charmix", "Enchantix")));
        fairyDatabase.add(new Fairy("Tecna", "Peri Teknologi dari Zenith", Arrays.asList("Magic Winx", "Charmix", "Enchantix")));
        fairyDatabase.add(new Fairy("Aisha", "Peri Gelombang dari Andros", Arrays.asList("Magic Winx", "Charmix", "Enchantix")));
    }

    @Override
    public Iterator<Fairy> iterator() {
        return fairyDatabase.iterator();
    }

    public List<Fairy> getAll() {
        return fairyDatabase;
    }

    public Fairy findByName(String name) {
        for (Fairy fairy : fairyDatabase) {
            if (fairy.getName().equalsIgnoreCase(name)) {
                return fairy;
            }
        }
        return null;
    }
}