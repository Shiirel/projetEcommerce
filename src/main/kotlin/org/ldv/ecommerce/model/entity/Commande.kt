package org.ldv.ecommerce.model.entity

import jakarta.persistence.*
import java.time.LocalDate


@Entity
class Commande (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id : Long?=null,
    var dateCommande : LocalDate,
    var dateModif : LocalDate,
    var statut : String,

    //Association Many to One avec Utilisateur
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    var utilisateur: Utilisateur? = null,

    //Association Many to One avec Article
    @ManyToOne
    @JoinColumn(name = "article_id")
    var article: Article? = null,

    //Association One to Many avec LigneCommande
    @OneToMany(mappedBy = "ligneCommande")
    var ligneCommandes: MutableList<LigneCommande> = mutableListOf()
) {
}