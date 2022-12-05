package com.company.population;

import com.company.individuals.Individual;
import com.company.states.*;

import java.util.*;

public class Population{
    private final List<Individual> population;

    public Population(List<Individual> population) {
        this.population = population;
    }

    public Population getCopy(){
        List<Individual> copiedList = new ArrayList<>();

        for(Individual individual:population){
            copiedList.add(individual.getCopy());
        }
        return new Population(copiedList);
    }

    public List<Individual> getPopulation() {
        return population;
    }

    public void addIndividual(Individual individual){
        this.population.add(individual);
    }

    public Individual getIndividualViaId(int id){
        for (Individual individual:population){
            if(individual.getId() == id){
                return individual;
            }
        }
        return null;
    }

    public void deleteIfExited(){
        for(Individual individual:population){
            if(!individual.getIsInArea())
                population.remove(individual);
        }
    }

    private List<Individual> getIndividualsViaState(IState state){
        List<Individual> filteredIndividuals = new LinkedList<>();
        for(Individual individual:population){
            if(individual.getState().equals(state)){
                filteredIndividuals.add(individual);
            }
        }
        return filteredIndividuals;
    }


    public List<Individual> getSymptoms(){
        return getIndividualsViaState(new Symptoms());
    }

    public List<Individual> getNoSymptoms(){
        return getIndividualsViaState(new NoSymptoms());
    }

    //zwraca zainfekowanych z symptomami i bez symptomów
    public List<Individual> getInfected(){
        List<Individual> infectedIndividuals = new LinkedList<>();
        infectedIndividuals.addAll(getSymptoms());
        infectedIndividuals.addAll(getNoSymptoms());
        return infectedIndividuals;
    }

    public List<Individual> getResist(){
        return getIndividualsViaState(new Resist());
    }

    public List<Individual> getHealthy(){
        return getIndividualsViaState(new Healthy());
    }

    public List<Individual> getNoInfected(){
        List<Individual> noInfectedIndividuals = new LinkedList<>();
        noInfectedIndividuals.addAll(getResist());
        noInfectedIndividuals.addAll(getHealthy());
        return noInfectedIndividuals;
    }

    public List<Individual> getPossibleInfected(){
        return getHealthy();
    }










}
