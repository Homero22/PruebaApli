package com.example.accesoDatos.entidades

import com.example.accesoDatos.modelos.Persona
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass



object Personas: IntIdTable("personas") {
    val nombre = varchar("nombre", 50)
    val apellido = varchar("apellido", 50)
    val edad = integer("edad")
    val sexo = varchar("sexo", 1)
    val fechaNacimiento = varchar("fechaNacimiento", 10)
    val estado = varchar("estado", 1)
}

class PersonasDAO(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<PersonasDAO>(Personas)
    var nombre by Personas.nombre
    var apellido by Personas.apellido
    var edad by Personas.edad
    var sexo by Personas.sexo
    var fechaNacimiento by Personas.fechaNacimiento
    var estado by Personas.estado

    fun toPersonas():Persona{
        return Persona(
            id.value,
            nombre,
            apellido,
            edad,
            sexo,
            fechaNacimiento,
            estado
        )
    }

}