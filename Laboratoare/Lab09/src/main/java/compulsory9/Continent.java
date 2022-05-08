package compulsory9;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "continents")
@NamedQueries({
    @NamedQuery(name = "entity.Continent.findAll",
            query = "select e from Continent e order by e.name"),
    @NamedQuery(name = "entity.Continent.findById",
            query = "select e from Continent e where e.id = :id"),
    @NamedQuery(name = "entity.City.findByName",
            query = "select e from Continent e where e.name = :name"),
})
public class Continent implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;
	
	public Continent(Integer id, String name)
	{
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "Continent [id=" + id + ", name=" + name + "]";
	}
	
	

}
