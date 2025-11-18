package org.ldv.ecommerce.model.entity

import jakarta.persistence.*
import java.util.Date


@Entity
class Commande (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id : Long?,
    var dateCommande : Date,
    var dateModif : Date,
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