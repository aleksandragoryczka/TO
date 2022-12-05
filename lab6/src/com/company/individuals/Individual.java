package com.company.individuals;

import com.company.area.Area;
import com.company.population.Population;
import com.company.states.IState;
import com.company.states.NoSymptoms;
import com.company.vectors.IVector;
import com.company.vectors.Vector2D;

import java.util.*;

import static com.company.Constants.*;

public class Individual {


    private IState state;
    private final int ids;

    private IndividualMoves individualMoves;
    private final boolean isInArea;
    private double posX;
    private double posY;

    public Individual(IState state, int ids, IndividualMoves individualMoves, boolean isInArea, double posX, double posY) {
        this.state = state;
        this.ids = ids;
        this.individualMoves = individualMoves;
        this.isInArea = isInArea;
        this.posX = posX;
        this.posY = posY;
    }

    public int getId() {
        return ids;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public boolean getIsInArea() {
        return isInArea;
    }

    public IndividualMoves getIndividualMoves() {
        return individualMoves;
    }

    public void setIndividualMoves(IndividualMoves individualMoves) {
        this.individualMoves = individualMoves;
    }

    public void setIsInArea(boolean isInArea) {
        isInArea = isInArea;
    }

    public IState getState() {
        return state;
    }

    public void setState(IState state) {
        this.state = state;
    }

    public Individual getCopy(){
        return new Individual(state.getCopy(), ids, individualMoves, isInArea, posX, posY);
    }

    public void setPosition(IVector iVector){
        double[] components = iVector.getComponents();
        this.posX += components[0];
        this.posY += components[1];
    }

    public void generateRandomPosition(Area area, Random random){
        double x = random.nextDouble() * MAX_DISTANCE;
        double y = random.nextDouble() * (MAX_DISTANCE - x);

        if(random.nextInt(PROBABILITY_OF_NEGATIVE) < 2){
            x *= -1;
            y *= -1;
        }

        IVector iVector = new Vector2D(x,y);
        this.setPosition(iVector);


        // osobnik zawaraca na granicy lub nie
        if(getPosX() > area.getWidth()){
            if(random.nextInt(PROBABILITY_OF_RETURN_TO_AREA) == 0) {
                this.setPosX(getPosX() - 1);
            }else {
                this.setIsInArea(false);
            }
        }else if(getPosX() < 0){
            if(random.nextInt(PROBABILITY_OF_RETURN_TO_AREA) == 0){
                this.setPosX(getPosX()+1);
            }else{
                this.setIsInArea(false);
            }
        }else if(getPosY() > area.getHeight()){
            if(random.nextInt(PROBABILITY_OF_RETURN_TO_AREA) == 0) {
                this.setPosY(getPosY() - 1);
            }else {
                this.setIsInArea(false);
            }
        }else if(getPosY() < 0){
            if(random.nextInt(PROBABILITY_OF_RETURN_TO_AREA) == 0){
                this.setPosY(getPosY()+1);
            }else{
                this.setIsInArea(false);
            }
        }
    }


    public void handle(){
        this.state.handle(this);
    }

    public void handle(Individual individual){
        if(individual.getState().equals(new NoSymptoms())){ //bez objawów
            if(new Random().nextInt(PROBABILITY_OF_INFECT) == 0){
                this.handle(); //bez objawów, niezarażony
            }
        }else{
            this.handle(); //z objawami
        }
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        Individual second = (Individual) o;
        return Objects.equals(state, second.state);
    }

    @Override
    public String toString() {
        return state.getName() + "-" + posX + ";" + posY;
    }

    public double absIndividual(Individual vec){
        IVector iVector = new Vector2D(this.getPosX(),this.getPosY());
        return iVector.abs(vec.getPosX(), vec.getPosY());
    }

    public Map<Integer, Double> getDistances(List<Individual> individuals){
        Map<Integer, Double> distances = individualMoves.getDistances();
        for(Individual individual:individuals){
            distances.put(individual.getId(), this.absIndividual(individual));
        }
        return distances;
    }

    public Map<Integer, Integer> getTimes(List<Individual> individuals) {
        Map<Integer, Integer> times = individualMoves.getTimes();
        Map<Integer, Double> distances = individualMoves.getDistances();
        for(Individual individual: individuals){
            if(times.get(individual.getId()) == null){
                times.put(individual.getId(), 0);
            } else if(distances.get(individual.getId()) <= 2){
                int currentTime = times.get(individual.getId());
                times.put(individual.getId(), ++currentTime);
            } else{
                times.put(individual.getId(), 0);
            }
        }
        return times;
    }

    public void clearPosition(Population population){
        Map<Integer, Integer> times = getIndividualMoves().getTimes();
        Map<Integer, Double> distances = getIndividualMoves().getDistances();
        times.keySet().removeIf(key -> population.getIndividualViaId(key) == null);
        distances.keySet().removeIf(key -> population.getIndividualViaId(key) == null);
    }






}
