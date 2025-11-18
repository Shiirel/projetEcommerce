package org.ldv.ecommerce.service


import org.ldv.ecommerce.model.dao.ArticleDAO
import org.ldv.ecommerce.model.dao.CommandeDAO
import org.ldv.ecommerce.model.dao.CommentaireDAO
import org.ldv.ecommerce.model.dao.LigneCommandeDAO
import org.ldv.ecommerce.model.dao.LigneCommandeIdDAO
import org.ldv.ecommerce.model.dao.LivreDAO
import org.ldv.ecommerce.model.dao.PapeterieDAO
import org.ldv.ecommerce.model.dao.RoleDAO
import org.ldv.ecommerce.model.dao.UtilisateurDAO
import org.ldv.ecommerce.model.entity.Article
import org.ldv.ecommerce.model.entity.Commande
import org.ldv.ecommerce.model.entity.Livre
import org.ldv.ecommerce.model.entity.Papeterie
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class DataInitializer(
    private val articleDAO: ArticleDAO,
    private val commandeDAO: CommandeDAO,
    private val commentaireDAO: CommentaireDAO,
    private val ligneCommandeDAO: LigneCommandeDAO,
    private val ligneCommandeId: LigneCommandeIdDAO,
    private val livreDAO: LivreDAO,
    private val papeterieDAO: PapeterieDAO,
    private val roleDAO: RoleDAO,
    private val utilisateurDAO: UtilisateurDAO,
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        // Vérifie si la base contient déjà des données
        if (articleDAO.count() > 0 || commandeDAO.count() > 0 || commentaireDAO.count() > 0 || ligneCommandeDAO.count() > 0 || ligneCommandeId.count() > 0 || livreDAO.count() > 0 || papeterieDAO.count() > 0 || roleDAO.count() > 0 || utilisateurDAO.count() > 0) {
            println("ℹ️ Données déjà présentes, initialisation ignorée.")
            return
        }

        println("🚀 Initialisation des données...")


        // === Articles ===

        val articleLivre = Livre(
            id = 1,
            nom = "Brida",
            prix = 8.50,
            estDisponible = true,
            dateModif = LocalDate.now(),
            stock = 15,
            lienImage = "https://books.google.fr/books?id=LJSQAwAAQBAJ&printsec=frontcover&hl=fr&source=gbs_ge_summary_r&cad=0",
            auteur = "Paulo Coelho",
            genre = "roman",
            description = "Brida, une jeune Irlandaise à la recherche de la Connaissance, s’intéresse depuis toujours aux différents aspects de la magie, mais elle aspire à quelque chose de plus. Sa quête l’amène à rencontrer des personnes d’une grande sagesse, qui lui font découvrir le monde spirituel : un mage habitant la forêt lui apprend à vaincre ses peurs et à croire en la bonté de l’univers ; une magicienne lui explique comment danser au rythme du monde et invoquer la lune. Brida part alors à la rencontre de son destin. Parviendra-t-elle à réconcilier sa vie amoureuse et son désir de tout quitter pour devenir sorcière ? Ce roman enchanté renoue avec des thèmes chers aux lecteurs de Paulo Coelho : le conteur y tisse un récit qui mêle amour, passion, mystère et spiritualité.",
            date="1990"
        )

        val articlePapeterie = Papeterie(
            id = 1,
            nom = "Signet avec élastique",
            prix = 2.90,
            estDisponible = true,
            dateModif = LocalDate.now(),
            stock = 15,
            lienImage = "https://www.amazon.fr/Legami-%C3%A9lastique-certifi%C3%A9-Vintage-maintenir/dp/B0DMPGN7TT/ref=sr_1_8?c=ts&dib=eyJ2IjoiMSJ9.SNSyLhsLDXybGxYMXd0cRgXAagvYN21c7N4HGlQtd-ZgKtBP1xpULk5zdC48d1ulT43i65D2WemEgu5cmyxZBMPwcDZP7SPBAKpw3P9lJwwOyxknkZhtBG43OsPP0b2V_K0SzryKaEPqrYHiObXKSFi0wLpTTbd6YqyRZwJpz4AZxqpDRzwwReRYOEB6DA8w6ex8_moIkOlAV9QSgfZFDjXQrEvhrYCLGdSQTsDsSBCyFptRhBErepOHyoCEX2pjLF_B-RhF4FSaTc1_b5W6lKjbSdU3hFsx9YON4I_jSyY.-GFmryqZCYkMOikaZiOeoFj5P4rnZuawwyIy1u7o9Go&dib_tag=se&keywords=Marque-pages&qid=1763459353&s=officeproduct&sr=1-8&ts_id=205302031&th=1#:~:text=Signet%20avec%20%C3%A9lastique%2C%20papier%20certifi%C3%A9%20FSC%2C%20th%C3%A8me%20Vintage%20Book%2C%20permet%20de%20maintenir%20le%20sengo%20et%20le%20livre%20ferm%C3%A9s%2C%204%2C7%20x%2017%2C5%20cm",
            marque = "Legami",
            categorie = "marque-page"
        )


        // === Sauvegarde des articles ===
        articleDAO.saveAll(listOf(articleLivre, articlePapeterie))
        println("✅ Données initiales insérées : ${articleDAO.count()} commandes.")


        // === Commandes ===
        val commmande1 = Commande(
            id = 1,
            dateCommande = LocalDate.now(),
            dateModif = LocalDate.now(),
            statut = "livré"
        )

        // === Sauvegarde des commandes ===
        articleDAO.saveAll(listOf(commande1))
        println("✅ Données initiales insérées : ${commandeDAO.count()} commandes.")


        // === Commentaires ===
    }
}