package WinxCLI;

public class AddTransformPage extends AbstractPage {
    public AddTransformPage(App app) {
        super("Tambah Transformasi Peri", app);
    }

    public void display() {
        printTitle();
        String name = getInput("Masukkan nama peri: ");
        Fairy fairy = findFairyByName(name);

        if (fairy == null) {
            System.out.println("Peri dengan nama '" + name + "' tidak ditemukan.");
        } else {
            String transform = getInput("Masukkan nama transformasi baru: ");
            fairy.addTransformation(transform);
        }
        pause();
    }
}