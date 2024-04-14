package com.navarro.avengers.resource.avenger

import com.navarro.avengers.domain.avenger.Avenger
import com.navarro.avengers.domain.avenger.AvengerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class AvengerRepositoryImpl(
        @Autowired private val repository: AvengerEntityRepository
) : AvengerRepository {
    override fun getHeroes(): List<Avenger> =
       repository.findAll().map { it.toAvenger() }

    override fun getHero(id: Long): Avenger? =
        repository.findByIdOrNull(id)?.toAvenger()

    override fun createHero(avenger: Avenger): Avenger =
        repository.save(AvengerEntity.from(avenger)).toAvenger()

    override fun updateHero(avenger: Avenger): Avenger =
        repository.save(AvengerEntity.from(avenger)).toAvenger()

    override fun deleteHero(id: Long) = repository.deleteById(id)
}