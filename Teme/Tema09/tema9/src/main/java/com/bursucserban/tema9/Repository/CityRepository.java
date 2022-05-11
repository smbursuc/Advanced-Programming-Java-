package com.bursucserban.tema9.Repository;

import com.bursucserban.tema9.Entities.CitiesEntity;
import com.bursucserban.tema9.Entities.ContinentsEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class CityRepository
{
    private EntityManager em;

    public CityRepository(EntityManager em)
    {
        this.em = em;
    }

    public void create(CitiesEntity city)
    {
        em.persist(city);
    }

    public CitiesEntity findById(int id)
    {
        return em.find(CitiesEntity.class, id);
    }

    public List<CitiesEntity> findByName(String name)
    {
        return em.createNamedQuery("entities.CitiesEntity.findByName", CitiesEntity.class).setParameter("name", name).getResultList();
    }
}
