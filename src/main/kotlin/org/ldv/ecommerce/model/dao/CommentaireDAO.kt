package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Commentaire
import org.springframework.data.jpa.repository.JpaRepository

interface CommentaireDAO : JpaRepository<Commentaire, Long> {
}