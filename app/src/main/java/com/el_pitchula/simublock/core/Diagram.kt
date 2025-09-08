package com.el_pitchula.simublock.core

import com.el_pitchula.simublock.blocks.Block

class Diagram {
    val blocks = mutableListOf<Block>()
    val connections = mutableListOf<Connection>()

    fun addBlock(block: Block) = blocks.add(block)

    fun connect(from: Block, fromPort: String, to: Block, toPort: String) {
        connections.add(Connection(from, fromPort, to, toPort))
    }

    fun propagateSignals() {
        // copia simples de sinais (adequado para cadeias/ DAGs no MVP)
        for (c in connections) {
            val v = c.fromBlock.outputs[c.fromPort] ?: 0.0
            c.toBlock.inputs[c.toPort] = v
        }
    }
}
