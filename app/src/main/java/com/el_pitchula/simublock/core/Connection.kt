package com.el_pitchula.simublock.blocks

import com.example.simublock.blocks.Block

data class Connection(
    val fromBlock: Block,
    val fromPort: String,
    val toBlock: Block,
    val toPort: String
)
