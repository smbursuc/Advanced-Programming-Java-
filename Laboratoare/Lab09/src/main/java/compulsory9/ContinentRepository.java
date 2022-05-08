package compulsory9;

import java.util.List;

import javax.persistence.EntityManager;

public class ContinentRepository
{

	private EntityManager em;

	public ContinentRepository(EntityManager em)
	    {
	        this.em = em;
	    }

	public void create(Continent continent)
	{
		em.persist(continent);
	}

	public Continent findById(int id)
	{
		return em.find(Continent.class, id);
	}

	public List<Continent> findByName(String name)
	{
		return em.createNamedQuery("entity.City.findByName", Continent.class).setParameter("name", name).getResultList();
	}

}
