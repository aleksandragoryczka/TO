package com.company.states;

import com.company.individuals.Individual;

import java.util.Objects;

public class Resist implements IState{

    public Resist getCopy(){
        return new Resist();
    }

    @Override
    public String getName() {
        return "resist";
    }

    @Override
    public void handle(Individual individual0){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IState that = (IState) o;
        return Objects.equals(this.getName(), that.getName());
    }

}
