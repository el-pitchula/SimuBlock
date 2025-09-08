package com.el_pitchula.simublock.blocks;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Block {
    public final String id;
    // LinkedHashMap preserva ordem de inserção (útil no Sum)
    public final Map<String, Double> inputs = new LinkedHashMap<>();
    public final Map<String, Double> outputs = new LinkedHashMap<>();

    public Block(String id) {
        this.id = id;
    }

    public abstract void evaluate(double dt);
}
