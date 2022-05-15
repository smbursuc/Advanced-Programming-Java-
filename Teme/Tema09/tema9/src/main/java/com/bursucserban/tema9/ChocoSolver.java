package com.bursucserban.tema9;

import com.bursucserban.tema9.Entities.CitiesEntity;
import com.bursucserban.tema9.Repository.CityRepository;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;


import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChocoSolver
{

    public List<CitiesEntity> citiesByRestraints(String letter, int bound1, int bound2, EntityManager em)
    {
        CityRepository cr = new CityRepository(em);
        List<CitiesEntity> cities = cr.findAll().stream().distinct().collect(Collectors.toList());
        Model model = new Model("Choco Solver");

        for(int i=0;i<cities.size();i++)
        {
            int countryCode = 0;
            for(int j=0;j<cities.get(i).getCountry().length();j++)
            {
                countryCode = countryCode + (int)cities.get(i).getCountry().charAt(j);
            }



        }
        return null;


    }
}
