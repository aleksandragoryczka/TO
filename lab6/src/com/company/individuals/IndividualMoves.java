package com.company.individuals;

import java.util.HashMap;
import java.util.Map;

public class IndividualMoves {

    private Map<Integer, Double> distances;
    private Map<Integer, Integer> times;

    public Map<Integer, Double> getDistances() {
        return distances;
    }

    public Map<Integer, Integer> getTimes() {
        return times;
    }

    public IndividualMoves(Map<Integer, Double> distances, Map<Integer, Integer> times) {
        this.distances = distances;
        this.times = times;
    }

}
