package com.el_pitchula.simublock.core

import com.el_pitchula.simublock.blocks.Block

class Simulator(
    private val diagram: Diagram,
    private val dt: Double = 0.01,
    private val steps: Int = 1000
) {
    fun run() {
        repeat(steps) {
            // 1) cada bloco calcula sua saída
            for (b in diagram.blocks) b.evaluate(dt)
            // 2) os sinais são propagados pelas conexões
            diagram.propagateSignals()
        }
    }
}
