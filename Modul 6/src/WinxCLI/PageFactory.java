package WinxCLI;

public class PageFactory {
    public static Page createPage(String type, App app, FairyRepository repository) {
        switch (type) {
            case "main":
                return new MainPage(app);
            case "view":
                return new ViewFairiesPage(app, repository);
            case "addTransform":
                return new AddTransformPage(app, repository);
            case "removeTransform":
                return new RemoveTransformPage(app, repository);
            case "search":
                return new SearchPage(app, repository);
            default:
                throw new IllegalArgumentException("Tipe halaman tidak dikenal: " + type);
        }
    }
}