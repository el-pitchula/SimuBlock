package com.el_pitchula.simublock.blocks

import com.example.simublock.blocks.Block

class Diagram {
    val blocks = mutableListOf<Block>()
    val connections = mutableListOf<Connection>()

    fun addBlock(block: Block) {
        blocks.add(block)
    }

    fun connect(from: Block, fromPort: String, to: Block, toPort: String) {
        connections.add(Connection(from, fromPort, to, toPort))
    }

    fun propagateSignals() {
        for (conn in connections) {
            val value = conn.fromBlock.outputs[conn.fromPort] ?: 0.0
            conn.toBlock.inputs[conn.toPort] = value
        }
    }
}
