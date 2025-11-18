package org.ldv.ecommerce.model.dto
import org.ldv.ecommerce.model.dao.ArticleDAO
import org.ldv.ecommerce.model.dao.CommandeDAO
import org.ldv.ecommerce.model.dao.CommentaireDAO
import org.ldv.ecommerce.model.dao.LigneCommandeDAO
import org.ldv.ecommerce.model.dao.LigneCommandeIdDAO
import org.ldv.ecommerce.model.dao.LivreDAO
import org.ldv.ecommerce.model.dao.PapeterieDAO
import org.ldv.ecommerce.model.dao.RoleDAO
import org.ldv.ecommerce.model.dao.UtilisateurDAO
import org.ldv.ecommerce.model.entity.LigneCommandeId
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component


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

        // === Article ===
        val livre = Article(nom = "Livres")
        val papeterie = Article(nom = "Papeterie")
        val catMaison = Categorie(nom = "Maison")

        categorieDAO.saveAll(listOf(catGadget, catJouet, catMaison))

        // === Articles ===

        val articleMontre = Article(
            nom = "Montre connectée",
            description = "Montre connectée avec capteur de fréquence cardiaque et suivi d’activité.",
            stock = 20,
            prix = 79.99,
            lienImage = "https://example.com/images/montre-connectee.jpg",
            categorie = catGadget
        )

        val articleDrone = Article(
            nom = "Mini drone",
            description = "Drone compact avec caméra HD et contrôle via smartphone.",
            stock = 15,
            prix = 149.99,
            lienImage = "https://example.com/images/mini-drone.jpg",
            categorie = catGadget
        )


        // === Sauvegarde des articles ===
        articleDAO.saveAll(
            listOf(
                articleMontre,
                articleDrone

            )
        )

        println("✅ Données initiales insérées : ${categorieDAO.count()} catégories, ${articleDAO.count()} articles.")
    }
}