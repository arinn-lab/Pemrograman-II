package praktikum2.soal3;

//Pada baris ini terjadi error karena nama class tidak sesuai dengan nama file
//public class Employee
public class Pegawai {
    public String nama;

    // Pada baris ini terjadi error karena tipe data 'asal' seharusnya String, bukan char
    // public char asal;
    public String asal;
    public String jabatan;
    public int umur;

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }

    // Pada baris ini terjadi error karena method setJabatan tidak memiliki parameter 'j',
    // namun di dalam method ada penggunaan variabel 'j' yang tidak dideklarasikan.
    // public void setJabatan() {
    //     this.jabatan = j;
    // }
    public void setJabatan(String j) {
        this.jabatan = j;
    }
}