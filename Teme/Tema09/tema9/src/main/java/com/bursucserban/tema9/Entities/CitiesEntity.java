package com.bursucserban.tema9.Entities;

import javax.persistence.*;

@Entity
@Table(name = "cities", schema = "public", catalog = "postgres")
@NamedQueries({
        @NamedQuery(name = "entities.CitiesEntity.findAll",
                query = "select e from CitiesEntity e order by e.name"),
        @NamedQuery(name = "entities.CitiesEntity.findById",
                query = "select e from CitiesEntity e where e.id = :id"),
        @NamedQuery(name = "entities.CitiesEntity.findByName",
                query = "select e from CitiesEntity e where e.name = :name"),
})
public class CitiesEntity extends AbstractEntity
{
    @Basic
    @Column(name = "id")
    @Id
    private Integer id;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "capital")
    private String capital;
    @Basic
    @Column(name = "latitude")
    private Double latitude;
    @Basic
    @Column(name = "longitude")
    private Double longitude;

    @Basic
    @Column(name = "population")
    private Integer population;

    public CitiesEntity(int id, String country, String name, String capital, double latitude, double longitude, Integer population)
    {
        this.id=id;
        this.country = country;
        this.name = name;
        this.capital =capital;
        this. latitude = latitude;
        this.longitude=longitude;
        this.population=population;
    }

    public CitiesEntity()
    {

    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCapital()
    {
        return capital;
    }

    public void setCapital(String capital)
    {
        this.capital = capital;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(Double latitude)
    {
        this.latitude = latitude;
    }

    public Double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(Double longitude)
    {
        this.longitude = longitude;
    }

    public Integer getPopulation()
    {
        return population;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CitiesEntity that = (CitiesEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (capital != null ? !capital.equals(that.capital) : that.capital != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        return result;
    }
}
