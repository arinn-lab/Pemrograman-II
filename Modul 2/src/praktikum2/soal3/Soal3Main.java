package praktikum2.soal3;

public class Soal3Main {
    public static void main(String[] args) {
        Pegawai p1 = new Pegawai();

        // Error kompilasi karena tidak ada titik koma
        // p1.nama = "Roi"
        p1.nama = "Roi";
        p1.asal = "Kingdom of Orvel";
        p1.setJabatan("Assasin");

        //Menambahkan assignment untuk umur agar output tidak 0 karena awalnya tidak ada baris ini
        p1.umur = 17;

        //Output yang diperlukan adalah "Nama: Roi", jadi kata Pegawai dihapus aja.
        //System.out.println("Nama Pegawai: " + p1.getNama());
        System.out.println("Nama: " + p1.getNama());
        System.out.println("Asal: " + p1.getAsal());
        System.out.println("Jabatan: " + p1.jabatan);

        //Untuk mencetak kata tahun diakhir kalimat, jadi tambahkan (+ " tahun")
        //System.out.println("Umur: " + p1.umur);
        System.out.println("Umur: " + p1.umur + " tahun");
    }
}