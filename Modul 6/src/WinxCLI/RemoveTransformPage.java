package WinxCLI;

public class RemoveTransformPage extends AbstractPage {
    private final FairyRepository repository;

    public RemoveTransformPage(App app, FairyRepository repository) {
        super("Hapus Transformasi Peri", app);
        this.repository = repository;
    }

    public void display() {
        printTitle();
        String name = getInput("Masukkan nama peri: ");
        Fairy fairy = repository.findByName(name);

        if (fairy == null) {
            System.out.println("Peri dengan nama '" + name + "' tidak ditemukan.");
        } else {
            System.out.println("Transformasi " + name + " saat ini: " + fairy.getTransformations());
            String transform = getInput("Masukkan nama transformasi yang akan dihapus: ");

            boolean isRemoved = fairy.removeTransformation(transform);

            if (isRemoved) {
                System.out.println("Transformasi '" + transform + "' berhasil dihapus dari " + name);
            } else {
                System.out.println("Gagal: " + name + " tidak memiliki transformasi " + transform);
            }
        }
        pause();
    }
}