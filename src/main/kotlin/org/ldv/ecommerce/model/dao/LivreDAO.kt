package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Livre
import org.springframework.data.jpa.repository.JpaRepository

interface LivreDAO : JpaRepository<Livre, Long> {
    // Cette méthode génère automatiquement :
    // SELECT * FROM livre WHERE LOWER(titre) LIKE LOWER(CONCAT('%', :query, '%'))
    fun findByNomContainingIgnoreCase(nom: String): List<Livre>

    fun findByAuteurContainingIgnoreCase(auteur: String): List<Livre>


}