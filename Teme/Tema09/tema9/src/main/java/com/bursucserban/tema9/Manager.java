package com.bursucserban.tema9;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Manager
{


    private static EntityManagerFactory emf;

    public static EntityManagerFactory getEntityManagerFactory(String aDefault)
    {
        if (emf == null)
        {
            emf = Persistence.createEntityManagerFactory(aDefault);
        }
        return emf;
    }
}

