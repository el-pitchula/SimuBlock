package com.example.simublock.blocks

class Step(id: String, private val amplitude: Double = 1.0) : Block(id) {
    private var t = 0.0

    override fun evaluate(dt: Double) {
        t += dt
        outputs["out1"] = if (t >= 0.0) amplitude else 0.0
    }
}
