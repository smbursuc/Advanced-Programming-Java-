package com.bursucserban.tema9.Repository;

import com.bursucserban.tema9.Entities.ContinentsEntity;

import java.util.List;

import javax.persistence.EntityManager;

public class ContinentRepository
{

    private EntityManager em;

    public ContinentRepository(EntityManager em)
    {
        this.em = em;
    }

    public void create(ContinentsEntity continent)
    {
        em.persist(continent);
    }

    public ContinentsEntity findById(int id)
    {
        return em.find(ContinentsEntity.class, id);
    }

    public List<ContinentsEntity> findByName(String name)
    {
        return em.createNamedQuery("entities.ContinentsEntity.findByName", ContinentsEntity.class).setParameter("name", name).getResultList();
    }

}
