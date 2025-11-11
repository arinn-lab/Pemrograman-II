package WinxCLI;

import java.util.List;
import java.util.ArrayList;

public class Fairy {
    private final String name;
    private final String description;
    private final List<String> transformations;

    public Fairy(String name, String description, List<String> initialTransformations) {
        this.name = name;
        this.description = description;
        this.transformations = new ArrayList<>(initialTransformations);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTransformations() {
        return new ArrayList<>(transformations);
    }

    public void addTransformation(String transformation) {
        if (!transformations.contains(transformation)) {
            transformations.add(transformation);
            System.out.println("Transformasi '" + transformation + "' ditambahkan untuk " + name);
        } else {
            System.out.println(name + " sudah memiliki transformasi " + transformation);
        }
    }

    public void removeTransformation(String transformation) {
        boolean removed = transformations.remove(transformation);
        if (removed) {
            System.out.println("Transformasi '" + transformation + "' dihapus dari " + name);
        } else {
            System.out.println(name + " tidak memiliki transformasi " + transformation);
        }
    }
}