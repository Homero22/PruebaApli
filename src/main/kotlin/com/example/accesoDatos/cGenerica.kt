package com.example.accesoDatos

import com.example.accesoDatos.modelos.Persona
import com.example.accesoDatos.repositorios.Personas

class cGenerica <T>{

    fun gInsertar(obj: T, entity: Any): Any{
        return when(obj){
            is Personas ->{
                obj.insertar(entity as Persona)
            }
            else ->{
                println("No se puede insertar")
            }
        }
    }


    fun gActualizar(obj: T, id: Int, entity:Any):Any{
        return when(obj){
            is Personas ->{
                obj.actualizar(entity as Persona, id )
            }
            else ->{
                println("No se puede actualizar")
            }
        }
    }




    fun <T> gEliminar(obj: T , id: Int): Any{
        return when(obj){
            is Personas ->{
                obj.eliminar(id)
            }
            else ->{
                false
            }
        }
    }


    fun gConsultarPorId(obj: T, id: Int): Any?{

          return when(obj){
              is Personas ->{
                obj.getById(id)
            }
            else ->{
                println("No se puede consultar")
            }
          }

    }


    fun <T> gListar(obj:T): List<Any>{
        return when (obj){
            is Personas ->{
                obj.listar()
            }
            else ->{
                throw Exception("No se puede listar")
            }

        }
    }

}