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

    public String getName() { return name; }
    public String getDescription() { return description; }
    public List<String> getTransformations() { return new ArrayList<>(transformations); }

    public boolean addTransformation(String transformation) {
        if (!transformations.contains(transformation)) {
            transformations.add(transformation);
            return true;
        }
        return false;
    }

    public boolean removeTransformation(String transformation) {
        return transformations.remove(transformation);
    }
}