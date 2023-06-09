package com.example.accesoDatos.repositorios

import com.example.accesoDatos.cBase
import com.example.accesoDatos.entidades.Personas
import com.example.accesoDatos.entidades.PersonasDAO
import com.example.accesoDatos.modelos.Persona
import org.jetbrains.exposed.sql.transactions.transaction

object Personas : cBase <Persona, Int>(){

    override fun insertar(entity: Persona)= transaction {
        entity.id = PersonasDAO.new {
            nombre = entity.nombre
            apellido = entity.apellido
            edad = entity.edad
            sexo = entity.sexo
            fechaNacimiento = entity.fechaNacimiento
            estado = entity.estado
        }.id.value
        return@transaction entity
    }

    override fun getById(id: Int)= transaction{
        return@transaction PersonasDAO.findById(id)?.toPersonas()
    }

    override fun listar() = transaction {
       val response = PersonasDAO.all()
        return@transaction response.map { it.toPersonas()}

    }



    override fun actualizar(entity: Persona, id: Int): Persona = transaction {
        val persona = PersonasDAO.findById(id)
        if (persona != null) {
            persona.nombre = entity.nombre
            persona.apellido = entity.apellido
            persona.edad = entity.edad
            persona.sexo = entity.sexo
            persona.fechaNacimiento = entity.fechaNacimiento
            persona.estado = entity.estado
        }
        return@transaction entity
    }

   fun consultar(entity: Persona, nombre:String): String{
      val apellido = PersonasDAO.find { Personas.nombre eq nombre }
        return apellido.toString()
    }

    override fun eliminar(id: Int): Boolean = transaction {
        return@transaction when (PersonasDAO.findById(id)) {
            null -> false
            else -> {
                PersonasDAO.findById(id)?.delete()
                true
            }

    }

    }



}