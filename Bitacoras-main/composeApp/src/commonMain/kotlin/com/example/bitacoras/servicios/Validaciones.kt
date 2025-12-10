package com.example.bitacoras.servicios

object Validaciones {

    // fecha en formato dd/mm/yyyy y rango de años
    fun esFechaValida(
        fecha: String,
        anioMin: Int = 2020,
        anioMax: Int = 2035
    ): Boolean {
        // Formato básico
        val regex = Regex("""\d{2}/\d{2}/\d{4}""")
        if (!regex.matches(fecha)) return false

        val partes = fecha.split("/")
        val dia = partes.getOrNull(0)?.toIntOrNull() ?: return false
        val mes = partes.getOrNull(1)?.toIntOrNull() ?: return false
        val anio = partes.getOrNull(2)?.toIntOrNull() ?: return false

        if (anio !in anioMin..anioMax) return false
        if (mes !in 1..12) return false

        val diasMes = when (mes) {
            1, 3, 5, 7, 8, 10, 12 -> 31
            4, 6, 9, 11 -> 30
            2 -> if (esBisiesto(anio)) 29 else 28
            else -> return false
        }

        if (dia !in 1..diasMes) return false

        return true
    }

    private fun esBisiesto(anio: Int): Boolean {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)
    }

    // hora en formato HH:MM 24 hrs
    fun esHoraValida(hora: String): Boolean {
        val regex = Regex("""\d{2}:\d{2}""")
        if (!regex.matches(hora)) return false

        val partes = hora.split(":")
        val h = partes.getOrNull(0)?.toIntOrNull() ?: return false
        val m = partes.getOrNull(1)?.toIntOrNull() ?: return false

        if (h !in 0..23) return false
        if (m !in 0..59) return false

        return true
    }
}
