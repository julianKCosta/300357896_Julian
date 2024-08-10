package org.example.savings.dao;

import org.example.savings.model.Saving;
import java.util.List;

public interface SavingDAO {
    void save(Saving saving);
    List<Saving> findAll();
    Saving findById(int id);
    void update(Saving saving);
    void delete(int id);
}