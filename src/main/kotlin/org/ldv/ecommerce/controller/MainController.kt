package org.ldv.ecommerce.controller
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.security.core.Authentication


@Controller
class MainController (){
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


}
