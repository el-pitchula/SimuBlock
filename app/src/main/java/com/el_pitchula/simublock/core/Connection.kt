package com.el_pitchula.simublock.core

import com.el_pitchula.simublock.blocks.Block

data class Connection(
    val fromBlock: Block,
    val fromPort: String,
    val toBlock: Block,
    val toPort: String
)
