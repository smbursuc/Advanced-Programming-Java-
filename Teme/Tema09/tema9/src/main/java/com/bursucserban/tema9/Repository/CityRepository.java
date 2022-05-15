package com.bursucserban.tema9.Repository;

import com.bursucserban.tema9.Entities.CitiesEntity;
import com.bursucserban.tema9.Entities.ContinentsEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class CityRepository extends DataRepository
{
    private EntityManager em;

    public CityRepository(EntityManager em)
    {
        super(em);
    }

    public List<CitiesEntity> findByName(String name)
    {
        return em.createNamedQuery("entities.CitiesEntity.findByName", CitiesEntity.class).setParameter("name", name).getResultList();
    }

    public List<CitiesEntity> findAll()
    {
        return em.createNamedQuery("entities.CitiesEntity.findAll", CitiesEntity.class).getResultList();
    }
}
