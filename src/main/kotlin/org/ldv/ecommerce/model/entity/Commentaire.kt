package org.ldv.ecommerce.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Commentaire (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id : Long?,
    var texte : String,
    var dateCommentaire : LocalDate,

    //Association Many to One avec Utilisateur
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    var utilisateur: Utilisateur? = null,

    //Association Many to One avec Article
    @ManyToOne
    @JoinColumn(name = "article_id")
    var article: Article? = null,
){
}