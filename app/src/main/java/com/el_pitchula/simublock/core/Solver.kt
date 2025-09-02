package com.el_pitchula.simublock.core

enum class SolverType { EULER, RK4 }

class Solver(val type: SolverType = SolverType.EULER) {
    fun step(f: (Double) -> Double, y: Double, t: Double, dt: Double): Double {
        return when (type) {
            SolverType.EULER -> y + dt * f(y)
            SolverType.RK4 -> {
                val k1 = f(y)
                val k2 = f(y + 0.5 * dt * k1)
                val k3 = f(y + 0.5 * dt * k2)
                val k4 = f(y + dt * k3)
                y + (dt / 6.0) * (k1 + 2*k2 + 2*k3 + k4)
            }
        }
    }
}
