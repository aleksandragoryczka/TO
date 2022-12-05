package com.company.vectors;

import com.company.vectors.IVector;

public class Vector2D implements IVector {
    private double x, y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double[] getComponents() {
        double[] components = new double[2];
        components[0] = x;
        components[1] = y;
        return components;
    }

    @Override
    public double abs(double x2, double y2) {
        return Math.sqrt((x2 - this.x) * (x2 - this.x) +  (y2 - this.y) * (y2 - this.y));
    }
}
