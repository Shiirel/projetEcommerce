package org.ldv.ecommerce.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.*
import java.util.Date

@Entity
@DiscriminatorValue("LIVRE")
class Livre (
    id:Long?,
    nom:String,
    prix:Double,
    estDisponible:Boolean,
    dateModif: Date,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var auteur : String,
    var genre : String,
    var description : String,
    var date : String
) : Article(id,nom,prix,estDisponible,dateModif,){
}