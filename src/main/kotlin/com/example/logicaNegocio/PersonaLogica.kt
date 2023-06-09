package com.example.logicaNegocio

import com.example.accesoDatos.cGenerica
import com.example.accesoDatos.modelos.Persona
import com.example.accesoDatos.repositorios.Personas

class PersonaLogica {

    val obj = cGenerica<Personas>()

    fun insertar(entity: Persona): Any{
        //consultar si existe el registro
        //si existe, devolver mensaje
        //si no existe, insertar
        obj.gConsultarPorId(Personas, entity.id)

        if (obj.gConsultarPorId(Personas, entity.id) != null)
            return "El registro ya existe"
        else
            return obj.gInsertar(Personas, entity)

    }

    fun actualizar(entity: Persona, id: Int): Any{
        return obj.gActualizar(Personas, id, entity)
    }

    fun eliminar(id: Int): Boolean{
        return obj.gEliminar(Personas, id) as Boolean
    }

    fun consultarPorId(id: Int): Any?{
        return obj.gConsultarPorId(Personas, id)
    }

    fun listar(): List<Persona>{
        return obj.gListar(Personas) as List<Persona>
    }


}