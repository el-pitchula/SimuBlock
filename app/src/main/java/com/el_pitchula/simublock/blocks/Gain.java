package com.el_pitchula.simublock.blocks;

public class Gain extends Block {
    private final double k;

    public Gain(String id, double k) {
        super(id);
        this.k = k;
        outputs.put("out1", 0.0);
        inputs.put("in1", 0.0);
    }

    @Override
    public void evaluate(double dt) {
        double x = inputs.getOrDefault("in1", 0.0);
        outputs.put("out1", k * x);
    }
}
