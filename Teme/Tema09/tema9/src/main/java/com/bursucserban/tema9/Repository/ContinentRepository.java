package com.bursucserban.tema9.Repository;

import com.bursucserban.tema9.Entities.ContinentsEntity;

import java.util.List;

import javax.persistence.EntityManager;

public class ContinentRepository extends DataRepository
{

    private EntityManager em;

    public ContinentRepository(EntityManager em)
    {
        super(em);
    }

    public List<ContinentsEntity> findByName(String name)
    {
        return em.createNamedQuery("entities.ContinentsEntity.findByName", ContinentsEntity.class).setParameter("name", name).getResultList();
    }

}
