package com.example.simublock.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.simublock.blocks.*
import com.example.simublock.core.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val step = Step("step", 1.0)
        val gain = Gain("gain", 2.0)
        val integrator = Integrator("int")
        val scope = Scope("scope")

        val diagram = Diagram()
        diagram.addBlock(step)
        diagram.addBlock(gain)
        diagram.addBlock(integrator)
        diagram.addBlock(scope)

        diagram.connect(step, "out1", gain, "in1")
        diagram.connect(gain, "out1", integrator, "in1")
        diagram.connect(integrator, "out1", scope, "in1")

        val sim = Simulator(diagram, dt = 0.01, steps = 500)
        sim.run()

        for ((t, y) in scope.timeSeries.take(20)) {
            Log.d("SIM", "t=$t, y=$y")
        }
    }
}
