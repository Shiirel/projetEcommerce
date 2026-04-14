package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Article
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleDAO : JpaRepository<Article, Long> {

    // Pour trier par l'ID le plus élevé (les derniers créés en premier)
    fun findAllByOrderByIdDesc(): List<Article>

    // OU pour trier par date de modification (plus logique pour du "récent")
    fun findAllByOrderByDateModifDesc(): List<Article>
    fun findAllByOrderByDateModifAsc(): List<Article>
}