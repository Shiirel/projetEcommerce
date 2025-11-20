package org.ldv.ecommerce.model.entity


import jakarta.persistence.GenerationType
import jakarta.persistence.*

@Entity
class Role (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id : Long?=null,
    var nom : String,

    //Association One to Many avec Utilisateur
    @OneToMany(mappedBy = "role")
    var utilisateurs: MutableList<Utilisateur> = mutableListOf()

){
}