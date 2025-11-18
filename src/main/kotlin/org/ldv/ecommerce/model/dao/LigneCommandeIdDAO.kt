package org.ldv.ecommerce.model.dao
import org.ldv.ecommerce.model.entity.Commande
import org.ldv.ecommerce.model.entity.LigneCommandeId
import org.springframework.data.jpa.repository.JpaRepository

interface LigneCommandeIdDAO : JpaRepository<LigneCommandeId, Long> {
}