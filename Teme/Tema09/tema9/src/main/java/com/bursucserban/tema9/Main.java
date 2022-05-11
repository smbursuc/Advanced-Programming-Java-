package com.bursucserban.tema9;

import com.bursucserban.tema9.Entities.ContinentsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main
{

    public static void main(String[] args)
    {
        EntityManagerFactory emf = Manager.getEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        ContinentsEntity continent = new ContinentsEntity("2","Oceania");
        em.persist(continent);
        ContinentsEntity c = (ContinentsEntity) em.createQuery(
                        "select e from ContinentsEntity e where e.name='Oceania'")
                .getSingleResult();


        System.out.println(c.getName());

        em.close();
        emf.close();

    }

}
