package com.example.bitacoras.servicios

object Validaciones {

    /* =========================================================
       👤 VALIDACIONES DE USUARIO
       ========================================================= */

    // 🧍 Nombre (mínimo 3 caracteres)
    fun nombreValido(nombre: String): Boolean {
        return nombre.trim().length >= 3
    }

    // 📧 Correo electrónico (formato estándar)
    fun correoValido(correo: String): Boolean {
        return Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
            .matches(correo.trim())
    }

    // 📱 Teléfono: solo números, 8 a 12 dígitos
    fun telefonoValido(telefono: String): Boolean {
        return telefono.all { it.isDigit() } &&
                telefono.length in 8..12
    }

    // 🔐 Contraseña:
    // - mínimo 6 caracteres
    // - al menos una letra
    // - al menos un número
    fun contrasenaValida(contrasena: String): Boolean {
        return contrasena.length >= 6 &&
                contrasena.any { it.isLetter() } &&
                contrasena.any { it.isDigit() }
    }

    /* =========================================================
       📅 VALIDACIONES DE FECHA
       ========================================================= */

    // Fecha en formato dd/mm/yyyy con rango de años
    fun esFechaValida(
        fecha: String,
        anioMin: Int = 2020,
        anioMax: Int = 2035
    ): Boolean {

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

        return dia in 1..diasMes
    }

    private fun esBisiesto(anio: Int): Boolean {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)
    }

    /* =========================================================
       ⏰ VALIDACIONES DE HORA
       ========================================================= */

    // Hora en formato HH:MM (24 horas)
    fun esHoraValida(hora: String): Boolean {
        val regex = Regex("""\d{2}:\d{2}""")
        if (!regex.matches(hora)) return false

        val partes = hora.split(":")
        val h = partes.getOrNull(0)?.toIntOrNull() ?: return false
        val m = partes.getOrNull(1)?.toIntOrNull() ?: return false

        return h in 0..23 && m in 0..59
    }
}
