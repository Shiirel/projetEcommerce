package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleDAO : JpaRepository<Article, Long> {
}