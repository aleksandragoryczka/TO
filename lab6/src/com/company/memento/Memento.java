package com.company.memento;

import com.company.population.Population;

public class Memento {
    private final Population population;

    public Memento(Population newPopulation) {
        this.population = newPopulation;
    }

    public Population getPopulation() {
        return population;
    }
}
