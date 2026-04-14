package org.ldv.ecommerce.controller.visiteurcontrollers
import jakarta.servlet.http.HttpSession
import org.ldv.ecommerce.model.dao.ArticleDAO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class PanierController(val articleDAO: ArticleDAO) {

    // Ajouter un article au panier
    @PostMapping("/ecommerce/panier/ajouter")
    fun ajouter(@RequestParam id: Long, session: HttpSession): String {
        // 1. Récupérer le panier en session (ou en créer un s'il n'existe pas)
        val panier = session.getAttribute("panier") as? MutableMap<Long, Int> ?: mutableMapOf()

        // 2. Ajouter +1 à la quantité
        panier[id] = (panier[id] ?: 0) + 1

        // 3. Remettre le panier à jour dans la session
        session.setAttribute("panier", panier)

        return "redirect:/ecommerce/panier"
    }

    // Afficher le contenu du panier
    @GetMapping("/ecommerce/panier")
    fun index(session: HttpSession, model: Model): String {
        val panier = session.getAttribute("panier") as? Map<Long, Int> ?: mapOf()

        // On transforme la Map d'IDs en une Map d'objets Article
        val detailPanier = panier.mapKeys { (id, _) ->
            articleDAO.findById(id).orElseThrow { Exception("Article non trouvé") }
        }

        // Calcul du total global
        val totalGeneral = detailPanier.entries.sumOf { it.key.prix * it.value }

        model.addAttribute("lignes", detailPanier) // Ici detailPanier est une Map<Article, Int>
        model.addAttribute("total", totalGeneral)

        return "pagesVisiteur/panier"
    }
}