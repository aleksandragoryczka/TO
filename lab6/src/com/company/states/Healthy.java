package com.company.states;

import com.company.individuals.Individual;

import java.util.Objects;
import java.util.Random;

import static com.company.Constants.PROBABILITY_OF_SYMPTOMS;

public class Healthy implements IState{

    public Healthy getCopy(){
        return new Healthy();
    }

    @Override
    public void handle(Individual individual){
        if(!individual.getState().equals(new NoSymptoms())){
            if(new Random().nextInt(PROBABILITY_OF_SYMPTOMS) == 0){
                individual.setState(new Symptoms());
            }else{
                individual.setState(new NoSymptoms());
            }
        }
    }
    @Override
    public String getName() {
        return "healthy";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IState that = (IState) o;
        return Objects.equals(this.getName(), that.getName());
    }





}
