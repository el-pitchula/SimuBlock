package com.example.simublock.blocks

class Sum(id: String, private val signs: List<Int>) : Block(id) {
    override fun evaluate(dt: Double) {
        var sum = 0.0
        var i = 0
        for ((_, value) in inputs) {
            sum += signs[i] * value
            i++
        }
        outputs["out1"] = sum
    }
}
