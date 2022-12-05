package com.company.states;

import com.company.individuals.Individual;

public interface IState {
    void handle(Individual individual);
    IState getCopy();
    String getName();


}
