package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Livre
import org.ldv.ecommerce.model.entity.Papeterie
import org.springframework.data.jpa.repository.JpaRepository

interface PapeterieDAO : JpaRepository<Papeterie, Long> {
    fun findByNomContainingIgnoreCase(nom: String): List<Papeterie>

    fun findByMarqueContainingIgnoreCase(auteur: String): List<Papeterie>
}