package com.example.rutas

import com.example.accesoDatos.modelos.Persona
import com.example.logicaNegocio.PersonaLogica
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlin.text.get

fun Route.personasRouting() {

    route("/personas") {
        get {
            //logica
            val res = PersonaLogica().listar()
            call.respond(HttpStatusCode(200,"OK"),res)
        }
        get ("/{id}"){
            val id = call.parameters["id"]?.toIntOrNull() ?: 0
            val res = PersonaLogica().consultarPorId(id)
            if(res == null)
                call.respond(HttpStatusCode(404,"No encontrado"), "No se encontro el registro")
            else
                call.respond(HttpStatusCode(200,"OK"), res )
        }
        post {
            val per = call.receive<Persona>()
            val res = PersonaLogica().insertar(per)
            call.respond(res)
        }
        put ("/{id}"){
            val id = call.parameters["id"]?.toIntOrNull() ?: 0
            val per = call.receive<Persona>()
            val res = PersonaLogica().actualizar(per, id)
            call.respond(res)
        }
        delete ("/{id}"){
           val id = call.parameters["id"]?.toIntOrNull() ?: 0
            val res = PersonaLogica().eliminar(id)
            call.respond(res)
        }

    }
}