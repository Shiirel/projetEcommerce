package org.ldv.ecommerce.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.*
import java.time.LocalDate
import java.util.Date

@Entity
@DiscriminatorValue("LIVRE")
class Livre (
    id:Long?=null,
    nom:String,
    prix:Double,
    dateModif: LocalDate,
    stock : Int,
    lienImage : String,


    var auteur : String,
    var genre : String,

    @Column(length = 1500)
    var description : String,
    var date : String
) : Article(id,nom,prix,dateModif,stock,lienImage){

    val type: String
        get() = "Livre"
}