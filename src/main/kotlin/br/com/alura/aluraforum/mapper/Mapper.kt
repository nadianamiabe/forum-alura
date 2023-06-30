package br.com.alura.aluraforum.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}
