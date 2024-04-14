package com.navarro.avengers.domain.avenger

interface AvengerRepository {

    fun getHeroes(): List<Avenger>
    fun getHero(id: Long): Avenger?
    fun createHero(avenger: Avenger): Avenger
    fun updateHero(avenger: Avenger): Avenger
    fun deleteHero(id: Long)
}