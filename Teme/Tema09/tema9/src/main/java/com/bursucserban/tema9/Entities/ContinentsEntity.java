package com.bursucserban.tema9.Entities;

import javax.persistence.*;

@Entity
@Table(name = "continents", schema = "public", catalog = "postgres")
@NamedQueries({
        @NamedQuery(name = "entities.ContinentsEntity.findAll",
                query = "select e from ContinentsEntity e order by e.name"),
        @NamedQuery(name = "entities.ContinentsEntity.findById",
                query = "select e from ContinentsEntity e where e.id = :id"),
        @NamedQuery(name = "entities.ContinentsEntity.findByName",
                query = "select e from ContinentsEntity e where e.name = :name"),
})

public class ContinentsEntity extends AbstractEntity
{
    @Basic
    @Id
    @Column(name = "id")
    private String id;
    @Basic
    @Column(name = "name")
    private String name;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
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
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinentsEntity that = (ContinentsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public ContinentsEntity()
    {

    }

    public ContinentsEntity(String id, String name)
    {
        this.id=id;
        this.name=name;
    }
}
