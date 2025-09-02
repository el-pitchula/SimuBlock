package com.el_pitchula.simublock.blocks

class Scope(id: String) : Block(id) {
    val timeSeries: MutableList<Pair<Double, Double>> = mutableListOf()

    override fun evaluate(dt: Double) {
        val y = inputs["in1"] ?: 0.0
        val t = (timeSeries.size) * dt
        timeSeries.add(Pair(t, y))
    }
}
