package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Livre
import org.springframework.data.jpa.repository.JpaRepository

interface LivreDAO : JpaRepository<Livre, Long> {
}