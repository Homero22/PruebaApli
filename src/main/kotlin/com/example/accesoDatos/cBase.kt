package com.example.accesoDatos

abstract class cBase <T, ID>{
    abstract fun insertar(entity:T):T
    abstract fun actualizar(entity: T, id: ID): T
    abstract fun eliminar(id: ID):Boolean
    abstract fun listar(): List<T>?
    abstract fun getById(id: ID):T?
}