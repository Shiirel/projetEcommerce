package org.ldv.ecommerce.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.Date


@Entity
class Commande (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id : Long?,
    var dateCommande : Date,
    var dateModif : Date,
    var statut : String
) {
}