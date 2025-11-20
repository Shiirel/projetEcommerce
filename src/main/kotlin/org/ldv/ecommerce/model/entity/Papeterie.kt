package org.ldv.ecommerce.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.*
import java.time.LocalDate


@Entity
@DiscriminatorValue("PAPETERIE")
class Papeterie (
    id:Long?=null,
    nom:String,
    prix:Double,
    dateModif: LocalDate,
    stock : Int,
    lienImage : String,


    var marque : String,
    var categorie : String
) : Article(id,nom,prix,dateModif,stock,lienImage){
}