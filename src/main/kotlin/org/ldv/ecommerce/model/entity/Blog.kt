package org.ldv.ecommerce.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Blog(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var titre: String = "",

    @Column(columnDefinition = "TEXT") // Pour les contenus longs
    var contenu: String = "",

    var datePublication: LocalDate = LocalDate.now(),

    @ManyToOne
    @JoinColumn(name = "auteur_id") // Clé étrangère vers la table Utilisateur
    var auteur: Utilisateur? = null
)