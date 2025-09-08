package com.el_pitchula.simublock.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.el_pitchula.simublock.blocks.*
import com.el_pitchula.simublock.core.Diagram
import com.el_pitchula.simublock.core.Simulator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // sem layout ainda: usamos apenas Logcat como "scope" textual

        // Blocos (Java)
        val step = Step("step", 1.0)
        val gain = Gain("gain", 2.0)
        val integrator = Integrator("int", 0.0)
        val scope = Scope("scope")

        // Diagrama (Kotlin)
        val diagram = Diagram().apply {
            addBlock(step)
            addBlock(gain)
            addBlock(integrator)
            addBlock(scope)

            connect(step, "out1", gain, "in1")
            connect(gain, "out1", integrator, "in1")
            connect(integrator, "out1", scope, "in1")
        }

        // Simulador (Kotlin)
        val sim = Simulator(diagram, dt = 0.01, steps = 500)
        sim.run()

        // Inspeciona primeiras amostras no Logcat
        scope.timeSeries.take(20).forEach { s ->
            Log.d("SIM", "t=${s.t}, y=${s.y}")
        }
    }
}
