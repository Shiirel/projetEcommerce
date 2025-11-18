package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Commande
import org.ldv.ecommerce.model.entity.LigneCommande
import org.springframework.data.jpa.repository.JpaRepository

interface LigneCommandeDAO : JpaRepository<LigneCommande, Long>{
}