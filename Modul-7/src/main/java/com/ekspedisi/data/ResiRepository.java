package com.ekspedisi.data;

import com.ekspedisi.model.Resi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ResiRepository {
    // Singleton pattern (opsional, tapi bagus agar data konsisten)
    private static ResiRepository instance;
    private ObservableList<Resi> listResi;

    private ResiRepository() {
        listResi = FXCollections.observableArrayList();
    }

    public static ResiRepository getInstance() {
        if (instance == null) {
            instance = new ResiRepository();
        }
        return instance;
    }

    public ObservableList<Resi> getAll() {
        return listResi;
    }

    public void add(Resi resi) {
        listResi.add(resi);
    }

    public void update(Resi oldResi, Resi newResi) {
        int index = listResi.indexOf(oldResi);
        if (index >= 0) {
            listResi.set(index, newResi);
        }
    }

    public void delete(Resi resi) {
        listResi.remove(resi);
    }
}