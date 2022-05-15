package com.bursucserban.tema9;

import com.bursucserban.tema9.Entities.CitiesEntity;
import com.bursucserban.tema9.Entities.ContinentsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.time.Instant;

import com.bursucserban.tema9.Repository.CityRepository;
import com.opencsv.CSVReader;

public class Main
{

    public static void addCitiesFromRoCSV(String file, EntityManager em)
    {

        try
        {
            FileReader filereader = new FileReader(file);

            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            Integer id = 0;

            nextRecord = csvReader.readNext(); // skip first line
            nextRecord = csvReader.readNext();
            CitiesEntity cpt =
                    new CitiesEntity(id, nextRecord[3], nextRecord[0], "capital",
                            Double.valueOf(nextRecord[1]), Double.valueOf(nextRecord[2]), Integer.valueOf(nextRecord[7])); //Bucuresti
            CityRepository cr = new CityRepository(em);
            cr.create(cpt);

            id++;
            while ((nextRecord = csvReader.readNext()) != null)
            {
                CitiesEntity ct =
                        new CitiesEntity(id, nextRecord[3], nextRecord[0], "non capital",
                                Double.valueOf(nextRecord[1]), Double.valueOf(nextRecord[2]), Integer.valueOf(nextRecord[7]));
                cr.create(ct);
                id++;
            }
            csvReader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void addCitiesFromWorldCitiesCSV(String file, EntityManager em)
    {

        try
        {
            FileReader filereader = new FileReader(file);

            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            Integer id = 0;

            nextRecord = csvReader.readNext(); // skip first line
            CityRepository cr = new CityRepository(em);
            while ((nextRecord = csvReader.readNext()) != null)
            {

                if(nextRecord[9].equals(""))
                    nextRecord[9]="0";

                if(nextRecord[9].contains("."))
                {
                    String[] result = nextRecord[9].split("\\.");
                    nextRecord[9] = result[0];
                }
                CitiesEntity ct =
                        new CitiesEntity(id, nextRecord[4], nextRecord[0], nextRecord[8],
                                Double.valueOf(nextRecord[2]), Double.valueOf(nextRecord[3]), Integer.valueOf(nextRecord[9]));
                cr.create(ct);
                id++;

            }
            csvReader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        EntityManagerFactory emf = Manager.getEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        ContinentsEntity continent = new ContinentsEntity("2", "Oceania");
        //em.persist(continent);
        ContinentsEntity c = (ContinentsEntity) em.createQuery(
                        "select e from ContinentsEntity e where e.name='Oceania'")
                .getSingleResult();


        //System.out.println(c.getName());

        /*Instant start = Instant.now();
        addCitiesFromWorldCitiesCSV("worldcities.csv", em);
        PT10M51.5794959S
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end));*/

        em.close();
        emf.close();

    }

}
