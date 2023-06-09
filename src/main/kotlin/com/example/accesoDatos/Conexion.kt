package com.example.accesoDatos

import com.example.accesoDatos.entidades.Personas
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object Conexion {


    fun init() {

        val jdbcUrl = "jdbc:postgresql://localhost:5432/db_Prueba"
        val driverClassName = "org.postgresql.Driver"
        val username = "postgres"
        val password = "cmingruimr-8501"

        try {
            Database.connect(jdbcUrl,driverClassName,username,password)

            transaction {
                //Crear las tablas
                SchemaUtils.create(Personas);

            }
            println("Conexión Establecida")
        }catch (e: Throwable){
            println("No se ha podido establecer la conexion a la Base de datos")
        }

    }



}