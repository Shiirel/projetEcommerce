package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Papeterie
import org.springframework.data.jpa.repository.JpaRepository

interface PapeterieDAO : JpaRepository<Papeterie, Long> {
}