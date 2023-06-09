package com.example.accesoDatos.modelos

import kotlinx.serialization.Serializable

@Serializable
data class Persona(
    var id: Int,
    val nombre: String,
    val apellido: String,
    val edad: Int,
    val sexo: String,
    val fechaNacimiento: String,
    val estado: String
)