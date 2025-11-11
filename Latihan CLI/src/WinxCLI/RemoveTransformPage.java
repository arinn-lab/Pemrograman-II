package WinxCLI;

public class RemoveTransformPage extends AbstractPage {
    public RemoveTransformPage(App app) {
        super("Hapus Transformasi Peri", app);
    }

    public void display() {
        printTitle();
        String name = getInput("Masukkan nama peri: ");
        Fairy fairy = findFairyByName(name);

        if (fairy == null) {
            System.out.println("Peri dengan nama '" + name + "' tidak ditemukan.");
        } else {
            System.out.println("Transformasi " + name + " saat ini: " + fairy.getTransformations());
            String transform = getInput("Masukkan nama transformasi yang akan dihapus: ");
            fairy.removeTransformation(transform);
        }
        pause();
    }
}