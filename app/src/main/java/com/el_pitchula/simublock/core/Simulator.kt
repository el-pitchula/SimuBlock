package com.el_pitchula.simublock.blocks

import com.example.simublock.blocks.Block

class Simulator(private val diagram: Diagram, private val dt: Double = 0.01, private val steps: Int = 1000) {
    fun run() {
        repeat(steps) {
            for (block in diagram.blocks) {
                block.evaluate(dt)
            }
            diagram.propagateSignals()
        }
    }
}
