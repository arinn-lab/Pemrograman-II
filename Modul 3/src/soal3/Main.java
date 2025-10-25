package soal3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
            System.out.println("3. Cari Mahasiswa berdasarkan NIM");
            System.out.println("4. Tampilkan Daftar Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
                    String studentId = scanner.nextLine();

                    boolean idExists = false;
                    for (Student student : studentList) {
                        if (student.getStudentId().equals(studentId)) {
                            idExists = true;
                            break;
                        }
                    }

                    if (idExists) {
                        System.out.println("NIM sudah terdaftar. Mahasiswa tidak ditambahkan.");
                    } else {
                        Student newStudent = new Student(name, studentId);
                        studentList.add(newStudent);
                        System.out.println("Mahasiswa " + name + " ditambahkan.");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
                    String idToDelete = scanner.nextLine();

                    boolean found = false;
                    for (int i = 0; i < studentList.size(); i++) {
                        if (studentList.get(i).getStudentId().equals(idToDelete)) {
                            studentList.remove(i);
                            System.out.println("Mahasiswa dengan NIM " + idToDelete + " dihapus.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Mahasiswa dengan NIM " + idToDelete + " tidak ditemukan.");
                    }
                    break;

                case 3:
                    System.out.print("Masukkan NIM Mahasiswa yang akan dicari: ");
                    String idToSearch = scanner.nextLine();

                    boolean exists = false;
                    for (Student student : studentList) {
                        if (student.getStudentId().equals(idToSearch)) {
                            System.out.println("NIM: " + student.getStudentId() + ", Nama: " + student.getName());
                            exists = true;
                            break;
                        }
                    }
                    if (!exists) {
                        System.out.println("Mahasiswa dengan NIM " + idToSearch + " tidak ditemukan.");
                    }
                    break;

                case 4:
                    if (studentList.isEmpty()) {
                        System.out.println("Daftar Mahasiswa kosong.");
                    } else {
                        System.out.println("Daftar Mahasiswa:");
                        for (Student student : studentList) {
                            System.out.println("NIM: " + student.getStudentId() + ", Nama: " + student.getName());
                        }
                    }
                    break;

                case 0:
                    studentList.clear();
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }

            if (choice != 0) {
                System.out.println();
            }

        } while (choice != 0);

        scanner.close();
    }
}