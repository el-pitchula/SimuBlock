package com.el_pitchula.simublock.blocks;

public class Integrator extends Block {
    private double state;

    public Integrator(String id) {
        this(id, 0.0);
    }

    public Integrator(String id, double initial) {
        super(id);
        this.state = initial;
        outputs.put("out1", state);
        inputs.put("in1", 0.0);
    }

    @Override
    public void evaluate(double dt) {
        double u = inputs.getOrDefault("in1", 0.0);
        state += u * dt;                 // integração simples (Euler)
        outputs.put("out1", state);
    }

    public double getState() { return state; }
}
