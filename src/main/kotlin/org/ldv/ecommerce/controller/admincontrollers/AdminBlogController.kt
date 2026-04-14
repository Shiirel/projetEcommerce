package org.ldv.ecommerce.controller.admincontrollers

import org.ldv.ecommerce.model.dao.BlogDAO
import org.ldv.ecommerce.model.dao.UtilisateurDAO
import org.ldv.ecommerce.model.entity.Blog
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@Controller
class AdminBlogController(
    private val blogDAO: BlogDAO,
    private val utilisateurDAO: UtilisateurDAO
) {

    /**
     * GetMapping : Consulter les articles du blog
     */
    @GetMapping("/ecommerce/blog")
    fun index(model: Model): String {
        model.addAttribute("articlesBlog", blogDAO.findAllByOrderByDatePublicationDesc())
        return "pagesVisiteur/blog"
    }

    /**
     * GetMapping : Afficher le formulaire de création
     */
    @GetMapping("/ecommerce/admin/blog/create")
    fun create(model: Model): String {
        model.addAttribute("nouveauBlog", Blog())
        return "pageAdmin/blog/create"
    }

    /**
     * PostMapping : Enregistrer le nouvel article
     */
    @PostMapping("/ecommerce/admin/blog/store")
    fun store(@ModelAttribute blog: Blog, authentication: Authentication): String {
        // Récupération automatique de l'auteur connecté via Spring Security
        val emailAuteur = authentication.name
        val utilisateur = utilisateurDAO.findByEmail(emailAuteur)

        blog.auteur = utilisateur
        blog.datePublication = LocalDate.now()

        blogDAO.save(blog)
        return "redirect:/ecommerce/blog"
    }
}