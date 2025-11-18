package org.ldv.ecommerce.model.entity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.*
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import java.util.Date


@Entity
class Utilisateur(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    var id: Long?,
    var nom: String,
    var dateModif : Date,
    @Column(unique = true)
    var email : String,
    var mdp : String,

    //Association Many to One avec Role
    @ManyToOne
    @JoinColumn(name = "role_id")
    var role: Role? = null,

    //Association One to Many avec Commentaire
    @OneToMany(mappedBy = "commentaire")
    var commentaires: MutableList<Commentaire> = mutableListOf(),

    //Association One to Many avec Commande
    @OneToMany(mappedBy = "commande")
    var commandes: MutableList<Commande> = mutableListOf(),
    ){
}