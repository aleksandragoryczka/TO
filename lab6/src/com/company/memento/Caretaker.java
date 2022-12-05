package com.company.memento;

import java.util.ArrayList;

public class Caretaker {
    ArrayList<Memento> savedPopulations = new ArrayList<>();

    public void addMemento(Memento memento){savedPopulations.add(memento);}

    public Memento getMemento(int id){
        Memento memento = savedPopulations.get(id);
        savedPopulations.remove(id);
        return memento;
    }
}
