package com.el_pitchula.simublock.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Sum extends Block {
    // +1 para soma, -1 para subtração. Ordem segue a inserção das portas.
    private final List<Integer> signs = new ArrayList<>();

    public Sum(String id, List<Integer> signs) {
        super(id);
        this.signs.addAll(signs);
        outputs.put("out1", 0.0);
        // cria portas conforme signs (in1, in2, ...)
        for (int i = 0; i < signs.size(); i++) {
            inputs.put("in" + (i + 1), 0.0);
        }
    }

    @Override
    public void evaluate(double dt) {
        double acc = 0.0;
        int i = 0;
        for (Map.Entry<String, Double> e : inputs.entrySet()) {
            int s = (i < signs.size()) ? signs.get(i) : 1;
            acc += s * (e.getValue() != null ? e.getValue() : 0.0);
            i++;
        }
        outputs.put("out1", acc);
    }
}
