package org.ldv.ecommerce.model.entity


import jakarta.persistence.*
import java.util.Date


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_article", discriminatorType = DiscriminatorType.STRING)
abstract class Article (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id : Long?,
    var nom : String,
    var prix : Double,
    var estDisponible : Boolean,
    var dateModif : Date,

    //Association One to Many avec Commande
    @OneToMany(mappedBy = "commentaire")
    var commentaires: MutableList<Commentaire> = mutableListOf(),

    //Association One to Many avec LigneCommande
    @OneToMany(mappedBy = "ligneCommande")
    var ligneCommandes: MutableList<LigneCommande> = mutableListOf()
){
}