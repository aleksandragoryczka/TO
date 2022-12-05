package com.company.population;

import com.company.area.Area;
import com.company.individuals.Ids;
import com.company.individuals.Individual;
import com.company.individuals.IndividualMoves;
import com.company.states.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

import static com.company.Constants.*;

public class PopulationGenerator {
    private static final Random random = new Random();

    private static Individual getIndividual(Area area, IState iState){
        double x = 0;
        double y = 0;

        if(random.nextInt(PROBABILITY_OF_ENTRY) == 0){
            x = random.nextDouble() * area.getWidth() *0.1 ;
        }
        else{
            y = random.nextDouble() * area.getHeight() *0.1;
        }

        LinkedHashMap<Integer, Double> distances = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> times = new LinkedHashMap<>();
        IndividualMoves individualMoves = new IndividualMoves(distances, times);
        return new Individual(iState, Ids.createID(),individualMoves,true,x,y);

    }

    public static Individual getNoResistSingleIndividual(Area area){
        IState iState;
        if(random.nextInt(PROBABILITY_OF_ILL) != 0){
            iState = new Healthy();
        } else if(random.nextInt(PROBABILITY_OF_SYMPTOMS) == 0){
            iState = new Symptoms();
        } else{
            iState = new NoSymptoms();
        }
        return getIndividual(area, iState);
    }


    public static Population generateNotResistPopulation(int individualsCounter, Area area){
        List<Individual> individuals = new ArrayList<>();
        for(int i=0;i< individualsCounter; i++){
            individuals.add(getNoResistSingleIndividual(area));
        }
        return new Population(individuals);
    }


    private static Individual getResistSingleIndividual(Area area){
        IState iState;
        if(random.nextInt(PROBABILITY_OF_RESIST) == 0){
            iState = new Resist();
        } else if(random.nextInt(PROBABILITY_OF_ILL) == 0){
            iState = new Healthy();
        } else if(random.nextInt(PROBABILITY_OF_SYMPTOMS) == 2){
            iState = new Symptoms();
        }else{
            iState = new NoSymptoms();
        }
        return getIndividual(area, iState);
    }


    public static Population generateResistPopulation(int individualsCounter, Area area){
        List<Individual> individuals = new ArrayList<>();
        for(int i=0;i< individualsCounter; i++){
            if(random.nextInt(PROBABILITY_OF_BEING_RESIST) < 2){
                individuals.add(getResistSingleIndividual(area));
            }else{
                individuals.add(getNoResistSingleIndividual(area));
            }
        }
        return new Population(individuals);
    }



}
