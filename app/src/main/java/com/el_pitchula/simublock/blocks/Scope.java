package com.el_pitchula.simublock.blocks;

import java.util.ArrayList;
import java.util.List;

public class Scope extends Block {

    public static class Sample {
        public final double t;
        public final double y;
        public Sample(double t, double y) { this.t = t; this.y = y; }
    }

    private final List<Sample> timeSeries = new ArrayList<>();
    private double timeAccum = 0.0;

    public Scope(String id) {
        super(id);
        inputs.put("in1", 0.0);
    }

    @Override
    public void evaluate(double dt) {
        double y = inputs.getOrDefault("in1", 0.0);
        timeSeries.add(new Sample(timeAccum, y));
        timeAccum += dt;
    }

    public List<Sample> getTimeSeries() {
        return timeSeries;
    }
}

