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
    @NamedQuery(name = "Continent.findAll",
            query = "select e from Continent e order by e.name"),
    @NamedQuery(name = "Continent.findByName",
            query = "select e from Continent e where e.name = :name"),
})
public class Continent implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "id")
	@Column(name = "name")
	private String name;
	
	public Continent()
	{
		
	}
	
	public Continent(String name)
	{
		super();
		this.name = name;
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
		return "Continent [name=" + name + "]";
	}
	
	

}
