package com.bursucserban.tema9.Repository;

import com.bursucserban.tema9.Entities.ContinentsEntity;
import com.bursucserban.tema9.Entities.CountriesEntity;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

public class CountryRepository extends DataRepository
{
    private EntityManager em;
    public CountryRepository(EntityManager em)
    {
        super(em);
    }

    public List<CountriesEntity> findByName(String name)
    {
        return em.createNamedQuery("entities.CountriesEntity.findByName", CountriesEntity.class).setParameter("name", name).getResultList();
    }
}
