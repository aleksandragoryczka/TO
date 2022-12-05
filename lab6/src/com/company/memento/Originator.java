package com.company.memento;

import com.company.population.Population;

public class Originator {
    private Population population;

    public void setPopulation(Population newPopulation) {
        this.population = newPopulation;
    }

    public Memento storeInMemento(){
        return new Memento(population);
    }

    public Population restoreFromMemento(Memento memento){
        population = memento.getPopulation();
        return population;
    }
}
