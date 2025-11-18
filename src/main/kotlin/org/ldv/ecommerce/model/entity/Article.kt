package org.ldv.ecommerce.model.entity


import jakarta.persistence.*
import java.util.Date


@Entity
abstract class Article (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id : Long?,
    var nom : String,
    var prix : Double,
    var estDisponible : Boolean,
    var dateModif : Date
){
}