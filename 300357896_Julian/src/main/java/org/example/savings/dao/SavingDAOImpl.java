package org.example.savings.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.savings.model.Saving;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class SavingDAOImpl implements SavingDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Saving saving) {
        entityManager.persist(saving);
    }

    @Override
    public List<Saving> findAll() {
        return entityManager.createQuery("from Saving", Saving.class).getResultList();
    }

    @Override
    public Saving findById(int id) {
        return entityManager.find(Saving.class, id);
    }

    @Override
    public void update(Saving saving) {
        entityManager.merge(saving);
    }

    @Override
    public void delete(int id) {
        Saving saving = findById(id);
        entityManager.remove(saving);
    }
}
