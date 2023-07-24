package com.pjff.androidejercicio1.componentesgraficos.animallist
//03, 6/junio/2023,ponemos los atributos de nuestra clase

/*Adaptamos la interfaz serializable a data class con dos puntos y
el nombre de la interfaz
para
* */
class Animal(
    val name: String,
    val color: String,
    val url: String
): java.io.Serializable{
}