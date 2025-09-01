package com.example.simublock.blocks

abstract class Block(val id: String) {
    val inputs: MutableMap<String, Double> = mutableMapOf()
    val outputs: MutableMap<String, Double> = mutableMapOf()

    abstract fun evaluate(dt: Double)
}
