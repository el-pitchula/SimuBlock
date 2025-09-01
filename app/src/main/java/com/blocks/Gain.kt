package com.example.simublock.blocks

class Gain(id: String, private val k: Double) : Block(id) {
    override fun evaluate(dt: Double) {
        val x = inputs["in1"] ?: 0.0
        outputs["out1"] = k * x
    }
}
