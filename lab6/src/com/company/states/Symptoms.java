package com.company.states;

import com.company.individuals.Individual;

import java.util.Objects;
import java.util.Random;

import static com.company.Constants.PROBABILITY_OF_RECOVER;

public class Symptoms implements IState{

    private int illnessCounter = 0;

    public int getIllnessCounter() {
        return illnessCounter;
    }

    public void setIllnessCounter(int illnessCounter) {
        this.illnessCounter = illnessCounter;
    }

    @Override
    public void handle(Individual individual) {
        int countToGetResistance = this.getIllnessCounter() / 25;
        if(countToGetResistance >= 10 && countToGetResistance < 30){
            if(new Random().nextInt(PROBABILITY_OF_RECOVER) == 0){
                individual.setState(new Resist());
            }
        } else if(countToGetResistance >= 30){
            individual.setState(new Resist());
        }
        this.setIllnessCounter(this.illnessCounter+1);
    }

    public IState getCopy() {
        return new Symptoms();
    }

    @Override
    public String getName() {
        return "symptoms";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IState that = (IState) o;
        return Objects.equals(this.getName(), that.getName());
    }
}
