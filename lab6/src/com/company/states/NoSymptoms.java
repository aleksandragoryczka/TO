package com.company.states;

import com.company.individuals.Individual;

import java.util.Objects;
import java.util.Random;

import static com.company.Constants.PROBABILITY_OF_RECOVER;

public class NoSymptoms implements IState{

    private int illnessCounter = 0;


    public int getIllnessCounter() {
        return illnessCounter;
    }

    public void setIllnessCounter(int illnessCounter) {
        this.illnessCounter = illnessCounter;
    }


    //Zakażony osobnik podtrzymuje zakażenie od 20 do 30 sekund,
    // po czym zdrowieje uzyskujac odporność

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IState that = (IState) o;
        return Objects.equals(this.getName(), that.getName());
    }



    public NoSymptoms getCopy(){
        return new NoSymptoms();
    }

    @Override
    public String getName() {
        return "noSymptoms";
    }


}
