package com.example.simublock.blocks

class Integrator(id: String, private var state: Double = 0.0) : Block(id) {
    override fun evaluate(dt: Double) {
        val u = inputs["in1"] ?: 0.0
        state += u * dt
        outputs["out1"] = state
    }
}
