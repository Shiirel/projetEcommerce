package org.ldv.ecommerce.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.*
import java.util.Date


@Entity
@DiscriminatorValue("PAPETERIE")
class Papeterie (
    id:Long?,
    nom:String,
    prix:Double,
    estDisponible:Boolean,
    dateModif: Date,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var marque : String,
    var categorie : String
) : Article(id,nom,prix,estDisponible,dateModif){
}