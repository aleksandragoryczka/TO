package com.company.gui;

import com.company.area.Area;
import com.company.individuals.Individual;
import com.company.individuals.IndividualMoves;
import com.company.memento.Caretaker;
import com.company.memento.Originator;
import com.company.population.Population;
import com.company.population.PopulationGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainWindow extends JFrame{
    public JButton saveButton, backButton;

    Caretaker caretaker = new Caretaker();
    Originator originator = new Originator();

    int savedPops = 0;

    private Population population;

    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }


    public MainWindow(int width, int height, int individualsNumber, boolean resistanceOption){
        Random random = new Random();
        Area area = new Area(width, height);

        if(resistanceOption){
            setPopulation(PopulationGenerator.generateNotResistPopulation(individualsNumber, area));
        }else{
            setPopulation(PopulationGenerator.generateResistPopulation(individualsNumber, area));
        }


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLocation(50,50);
        this.setTitle("Symualcja");


        CustomWindow customWindow = new CustomWindow(getPopulation().getPopulation().toString());


        ActionListener saveListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Population currentPopulation = getPopulation().getCopy();
                originator.setPopulation(currentPopulation);
                caretaker.addMemento(originator.storeInMemento());

                savedPops++;

                backButton.setEnabled(true);
            }
        };

        ActionListener backListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(savedPops>=1){
                    savedPops--;
                    setPopulation(originator.restoreFromMemento(caretaker.getMemento(savedPops)));
                }else{
                    backButton.setEnabled(false);
                }

            }
        };


        saveButton = new JButton("Zapisz");
        backButton = new JButton("Cofnij");

        saveButton.addActionListener(saveListener);
        backButton.addActionListener(backListener);
        backButton.setEnabled(false);

        JPanel panel = new JPanel();
        panel.add(saveButton);
        panel.add(backButton);


        this.add(customWindow, BorderLayout.NORTH);
        this.add(panel, BorderLayout.SOUTH);
        this.setVisible(true);

        prepareCoordinates(population);
        int stepsCounter = 1;

        for(;;){
            for(int i=0;i<stepsCounter;i++){
                population.getInfected().forEach(Individual::handle);
                customWindow.setString(population.getPopulation().toString());

                this.add(customWindow);
                this.revalidate();
                this.repaint();

                for (int j = 0; j < population.getInfected().size(); j++) {
                    Individual individual = population.getInfected().get(j);
                    individual.clearPosition(population);
                    individual.getDistances(population.getNoInfected());
                    individual.getTimes(population.getNoInfected());

                    Map<Integer, Integer> times = individual.getIndividualMoves().getTimes();

                    for(int key: times.keySet()){
                        if(times.get(key) >= 75){
                            population.getIndividualViaId(key).handle(individual);
                        }
                    }
                }

                population.getPopulation().forEach(single -> single.generateRandomPosition(area, random));
                population.deleteIfExited();
                if(stepsCounter % 3 ==0){
                    population.addIndividual(PopulationGenerator.getNoResistSingleIndividual(area));
                }
            }

            if(stepsCounter == 1000)
                break;
            if(population.getInfected().size() == 0)
                break;
            stepsCounter++;

        }

    }


    private void prepareCoordinates(Population population){
        for(int i=0;i< population.getInfected().size();i++){
            Individual individual = population.getInfected().get(i);
            List<Individual> comparedIndividuals = new LinkedList<>(population.getPossibleInfected());
            Map<Integer, Double> distances = individual.getDistances(comparedIndividuals);
            Map<Integer, Integer> times = individual.getTimes(comparedIndividuals);
            individual.setIndividualMoves(new IndividualMoves(distances, times));
        }
    }


}
