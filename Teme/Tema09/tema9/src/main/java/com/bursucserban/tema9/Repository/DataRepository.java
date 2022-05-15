package com.bursucserban.tema9.Repository;

import com.bursucserban.tema9.Entities.AbstractEntity;
import com.bursucserban.tema9.Entities.CitiesEntity;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class DataRepository<T extends AbstractEntity, ID extends Serializable>
{
    private Class<T> classT;
    private EntityManager em; //create it somehow

    public DataRepository(EntityManager em)
    {
        this.em=em;
    }

    public T findById(ID id)
    {
        return em.find(classT, id);
    }

    public void create(T entity)
    {
        try
        {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}