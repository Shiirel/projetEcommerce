package org.ldv.ecommerce.controller
import org.ldv.ecommerce.model.dao.ArticleDAO
import org.ldv.ecommerce.model.dao.LivreDAO
import org.ldv.ecommerce.model.dao.PapeterieDAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.security.core.Authentication


@Controller
class MainController (
    private val livreDAO: LivreDAO,
    private val papeterieDAO: PapeterieDAO,
    private val articleDAO : ArticleDAO
){

    /**
     * Méthode permettant d'afficher la page d'accueil de l'application.
     * @return le chemin vers le template a partir du dossier ressources/templates (on ne marque pas le .html)
     */
    @GetMapping("/ecommerce")
    fun home(): String{
        return "index"
    }
    @GetMapping("/ecommerce/login")
    fun login(@RequestParam(required = false) error: Boolean?, model: Model): String {
        // Ajoute un attribut "error" au modèle si la requête contient une erreur
        model.addAttribute("error", error == true)
        return "pagesVisiteur/login"
    }

    @GetMapping("/ecommerce/logout")
    fun logout(@RequestParam(required = false) error: Boolean?, model: Model): String {
        // Ajoute un attribut "error" au modèle si la requête contient une erreur
        model.addAttribute("error", error == true)
        return "index"
    }





    @GetMapping("/ecommerce/profile")
    fun profile(authentication: Authentication): String {

        // Récupération des rôles (authorities) de l’utilisateur connecté
        val roles = authentication.authorities.map { it.authority }

        // Si l'utilisateur est admin → redirection
        if ("ROLE_ADMIN" in roles) {
            return "redirect:/ecommerce/admin/dashboard"
        }

        // Sinon → on affiche la page profile
        return "pagesClient/profile"
    }

    @GetMapping("/ecommerce/admin/dashboard")
    fun dashboard(): String {
        return "pageAdmin/dashboard"
    }


    @GetMapping("/ecommerce/recherche")
    fun recherche(
        @RequestParam(name = "q", required = false) query: String?,
        @RequestParam(name = "cat", required = false) cat: String?, // On le met en optionnel pour tester
        model: Model
    ): String {
        val recherche = query ?: ""

        // Debug : si vous lancez en mode local, regardez votre console
        println("Recherche: $recherche dans la catégorie: $cat")

        return if (cat == "papeterie") {
            model.addAttribute("papeteries", papeterieDAO.findByNomContainingIgnoreCase(recherche))
            "pagesVisiteur/papeterie"
        } else {
            model.addAttribute("livres", livreDAO.findByNomContainingIgnoreCase(recherche))
            "pagesVisiteur/livres"
        }
    }

}
