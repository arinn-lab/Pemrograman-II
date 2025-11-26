package WinxCLI;

public class AddTransformPage extends AbstractPage {
    private final FairyRepository repository;

    public AddTransformPage(App app, FairyRepository repository) {
        super("Tambah Transformasi Peri", app);
        this.repository = repository;
    }

    public void display() {
        printTitle();
        String name = getInput("Masukkan nama peri: ");
        Fairy fairy = repository.findByName(name);

        if (fairy == null) {
            System.out.println("Peri dengan nama '" + name + "' tidak ditemukan.");
        } else {
            String transform = getInput("Masukkan nama transformasi baru: ");
            boolean isSuccess = fairy.addTransformation(transform);

            if (isSuccess) {
                System.out.println("Transformasi '" + transform + "' berhasil ditambahkan untuk " + name);
            } else {
                System.out.println("Gagal: " + name + " sudah memiliki transformasi " + transform);
            }
        }
        pause();
    }
}