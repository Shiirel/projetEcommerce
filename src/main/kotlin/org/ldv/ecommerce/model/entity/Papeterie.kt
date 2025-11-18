package org.ldv.ecommerce.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.*
import java.time.LocalDate


@Entity
@DiscriminatorValue("PAPETERIE")
class Papeterie (
    id:Long?,
    nom:String,
    prix:Double,
    estDisponible:Boolean,
    dateModif: LocalDate,
    stock : Int,
    lienImage : String,

    @Column(nullable = false)
    var marque : String,
    var categorie : String
) : Article(id,nom,prix,estDisponible,dateModif,stock,lienImage){
}