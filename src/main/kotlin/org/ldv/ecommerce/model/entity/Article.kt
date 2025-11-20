package org.ldv.ecommerce.model.entity


import jakarta.persistence.*
import java.time.LocalDate



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_article", discriminatorType = DiscriminatorType.STRING)
abstract class Article (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id : Long?=null,
    var nom : String,
    var prix : Double,
    var dateModif : LocalDate,
    var stock : Int,
    @Column(length = 1500)
    var lienImage : String,

    //Association One to Many avec Commande
    @OneToMany(mappedBy = "article")
    var commentaires: MutableList<Commentaire> = mutableListOf(),

    //Association One to Many avec LigneCommande
    @OneToMany(mappedBy = "article")
    var ligneCommandes: MutableList<LigneCommande> = mutableListOf()
){

}