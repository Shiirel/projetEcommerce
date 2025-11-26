package org.ldv.ecommerce.service


import org.ldv.ecommerce.model.dao.ArticleDAO
import org.ldv.ecommerce.model.dao.CommandeDAO
import org.ldv.ecommerce.model.dao.CommentaireDAO
import org.ldv.ecommerce.model.dao.LigneCommandeDAO

import org.ldv.ecommerce.model.dao.LivreDAO
import org.ldv.ecommerce.model.dao.PapeterieDAO
import org.ldv.ecommerce.model.dao.RoleDAO
import org.ldv.ecommerce.model.dao.UtilisateurDAO
import org.ldv.ecommerce.model.entity.Article
import org.ldv.ecommerce.model.entity.Commande
import org.ldv.ecommerce.model.entity.Commentaire
import org.ldv.ecommerce.model.entity.Livre
import org.ldv.ecommerce.model.entity.Papeterie
import org.ldv.ecommerce.model.entity.Role
import org.ldv.ecommerce.model.entity.Utilisateur
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.ComponentScan
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class DataInitializer(
    private val articleDAO: ArticleDAO,
    private val commandeDAO: CommandeDAO,
    private val commentaireDAO: CommentaireDAO,
    private val ligneCommandeDAO: LigneCommandeDAO,

    private val livreDAO: LivreDAO,
    private val papeterieDAO: PapeterieDAO,
    private val roleDAO: RoleDAO,
    private val utilisateurDAO: UtilisateurDAO,
    val passwordEncoder: PasswordEncoder
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        // Vérifie si la base contient déjà des données
        if (articleDAO.count() > 0 || commandeDAO.count() > 0 || commentaireDAO.count() > 0 || ligneCommandeDAO.count() > 0 || livreDAO.count() > 0 || papeterieDAO.count() > 0 || roleDAO.count() > 0 || utilisateurDAO.count() > 0) {
            println("ℹ️ Données déjà présentes, initialisation ignorée.")
            return
        } else {

            println("🚀 Initialisation des données...")


            // === Articles ===

            val articleLivre = Livre(
                nom = "Brida",
                prix = 8.50,
                dateModif = LocalDate.now(),
                stock = 15,
                lienImage = "https://m.media-amazon.com/images/I/81SM8DNE55L._SL1500_.jpg",
                auteur = "Paulo Coelho",
                genre = "roman",
                description = "Brida, une jeune Irlandaise à la recherche de la Connaissance, s’intéresse depuis toujours aux différents aspects de la magie, mais elle aspire à quelque chose de plus. Sa quête l’amène à rencontrer des personnes d’une grande sagesse, qui lui font découvrir le monde spirituel : un mage habitant la forêt lui apprend à vaincre ses peurs et à croire en la bonté de l’univers ; une magicienne lui explique comment danser au rythme du monde et invoquer la lune. Brida part alors à la rencontre de son destin. Parviendra-t-elle à réconcilier sa vie amoureuse et son désir de tout quitter pour devenir sorcière ? Ce roman enchanté renoue avec des thèmes chers aux lecteurs de Paulo Coelho : le conteur y tisse un récit qui mêle amour, passion, mystère et spiritualité.",
                date = "1990"
            )

            val articlePapeterie = Papeterie(
                nom = "Marque-page chinois - En bois sculpté avec pompons",
                prix = 2.90,
                dateModif = LocalDate.now(),
                stock = 15,
                lienImage = "https://m.media-amazon.com/images/I/81XkxldhrNL.jpg",
                marque = "Legami",
                categorie = "marque-page"
            )


            // === Sauvegarde des articles ===
            livreDAO.saveAll(listOf(articleLivre))
            papeterieDAO.saveAll(listOf(articlePapeterie))
            println("✅ Données initiales insérées : ${livreDAO.count()} livres.")
            println("✅ Données initiales insérées : ${papeterieDAO.count()} articles de papeterie.")


            // === Commandes ===
            val commande1 = Commande(
                dateCommande = LocalDate.now(),
                dateModif = LocalDate.now(),
                statut = "livré"
            )

            // === Sauvegarde des commandes ===
            commandeDAO.saveAll(listOf(commande1))
            println("✅ Données initiales insérées : ${commandeDAO.count()} commandes.")


            // === Commentaires ===
            val commentaire1 = Commentaire(
                texte = "Bon livre.",
                dateCommentaire = LocalDate.now(),
            )

            // === Sauvegarde des commentaires ===
            commentaireDAO.saveAll(listOf(commentaire1))
            println("✅ Données initiales insérées : ${commentaireDAO.count()} commentaires.")


            // === Roles ===
            val roleAdmin = Role(
                nom = "ADMIN"
            )
            val roleClient = Role(
                nom = "CLIENT"
            )

            // === Sauvegarde des roles ===
            roleDAO.saveAll(listOf(roleAdmin, roleClient))
            println("✅ Données initiales insérées : ${roleDAO.count()} rôles.")


            // === Utilisateurs ===
            val user1 = Utilisateur(
                nom = "Elena",
                dateModif = LocalDate.now(),
                email = "elena@gmail.com",
                mdp = passwordEncoder.encode("elena123"),
                role = roleClient
            )
            val userAdmin = Utilisateur(
                nom = "super admin",
                dateModif = LocalDate.now(),
                email = "admin@gmail.com",
                mdp = passwordEncoder.encode("admin123"),
                role = roleAdmin
            )

            // === Sauvegarde des commentaires ===
            utilisateurDAO.saveAll(listOf(user1, userAdmin))
            println("✅ Données initiales insérées : ${utilisateurDAO.count()} utilisateurs.")
        }
    }
}