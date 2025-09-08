package com.el_pitchula.simublock.blocks;

public class Step extends Block {
    private final double amplitude;
    private double t = 0.0;

    public Step(String id, double amplitude) {
        super(id);
        this.amplitude = amplitude;
        outputs.put("out1", 0.0);
    }

    @Override
    public void evaluate(double dt) {
        t += dt;
        outputs.put("out1", t >= 0.0 ? amplitude : 0.0);
    }
}
