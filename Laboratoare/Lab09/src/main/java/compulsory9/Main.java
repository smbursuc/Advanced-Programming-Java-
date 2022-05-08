package compulsory9;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main
{

	public static void main(String[] args)
	{
		EntityManagerFactory emf = Manager.getEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Continent continent = new Continent(0,"test");
        em.persist(continent);
        Continent c = (Continent) em.createQuery(
                        "select e from Continent e where e.name='test'")
                .getSingleResult();
        c.setName("newname");
        System.out.println(c.getName());
        em.close();
        emf.close();

	}

}
