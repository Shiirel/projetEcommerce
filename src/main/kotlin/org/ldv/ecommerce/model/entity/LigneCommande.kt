package org.ldv.ecommerce.model.entity

import jakarta.persistence.*

@Entity
class LigneCommande (
    @EmbeddedId
    var LigneCommandeId: LigneCommandeId? = null,
    var quantite : Int,

    //Association Many to One avec Commande
    @MapsId("commandeId")
    @ManyToOne
    @JoinColumn(name = "commande_id")
    var commande: Commande? = null,


    @MapsId("articleId")
    @ManyToOne
    @JoinColumn(name = "article_id")
    var article: Article? = null,


    ){
}