package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Blog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BlogDAO : JpaRepository<Blog, Long> {
    // On trie par date pour avoir les derniers articles en haut
    fun findAllByOrderByDatePublicationDesc(): List<Blog>
}