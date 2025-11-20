package org.ldv.ecommerce.controller.admincontrollers

import org.ldv.ecommerce.model.dao.ArticleDAO
import org.ldv.ecommerce.model.dao.LivreDAO
import org.ldv.ecommerce.model.dao.PapeterieDAO
import org.ldv.ecommerce.model.entity.Livre
import org.ldv.ecommerce.model.entity.Papeterie
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.time.LocalDate

@Controller
class AdminArticleController(
    val livreDAO: LivreDAO,
    val papeterieDAO: PapeterieDAO,
    val articleDAO: ArticleDAO
) {

    @GetMapping("/ecommerce/admin/articles")
    fun index(model: Model): String {
        val livres = livreDAO.findAll()
        val papeteries = papeterieDAO.findAll()
        val articles = livres + papeteries
        model.addAttribute("articles", articles)

        return "pageAdmin/article/index"
    }

    @GetMapping("/ecommerce/admin/articles/{id}")
    fun show(@PathVariable id:Long, model:Model):String {
        val unArticle = articleDAO.findById(id).orElseThrow()
        model.addAttribute("article",unArticle)

        return "pageAdmin/article/show"
    }

    @GetMapping("/ecommerce/admin/articles/choisirType")
    fun choisirType(model: Model): String {
        return "pageAdmin/article/choisirType"
    }


    @GetMapping("/ecommerce/admin/articles/createLivre")
    fun createLivre(model: Model): String {
        val livre = Livre(
            nom = "",
            prix = 0.0,
            dateModif = LocalDate.now(),
            stock = 0,
            lienImage = "",
            auteur = "",
            genre = "",
            description = "",
            date = ""
        )
        model.addAttribute("livre", livre)
        return "pageAdmin/article/createLivre"
    }

    @GetMapping("/ecommerce/admin/articles/createPapeterie")
    fun createPapeterie(model: Model): String {
        val papeterie = Papeterie(
            nom = "",
            prix = 0.0,
            dateModif = LocalDate.now(),
            stock = 0,
            lienImage = "",
            marque = "",
            categorie = ""
        )
        model.addAttribute("papeterie", papeterie)
        return "pageAdmin/article/createPapeterie"
    }

    @GetMapping("/ecommerce/admin/articles/edit/{id}")
    fun edit(@PathVariable id: Long, model: Model): String {
        val article = articleDAO.findById(id).orElseThrow()
        when (article) {
            is Livre -> model.addAttribute("livre", article)
            is Papeterie -> model.addAttribute("papeterie", article)
        }
        return "pageAdmin/article/edit"
    }

    @PostMapping("/ecommerce/admin/articles/updateLivre")
    fun updateLivre(@ModelAttribute livre: Livre, redirectAttributes: RedirectAttributes): String {
        livreDAO.save(livre)
        redirectAttributes.addFlashAttribute("msg", "Le livre a bien été mis à jour")
        return "redirect:/ecommerce/admin/articles"
    }

    @PostMapping("/ecommerce/admin/articles/updatePapeterie")
    fun updatePapeterie(@ModelAttribute papeterie: Papeterie, redirectAttributes: RedirectAttributes): String {
        papeterieDAO.save(papeterie)
        redirectAttributes.addFlashAttribute("msg", "La papeterie a bien été mise à jour")
        return "redirect:/ecommerce/admin/articles"
    }

    @PostMapping("/ecommerce/admin/articles/delete")
    fun delete(@RequestParam id: Long, redirectAttributes : RedirectAttributes):String {
        articleDAO.deleteById(id)
        redirectAttributes.addFlashAttribute("msg", "L'article est supprimé.")
        return "redirect:/ecommerce/admin/articles"
    }




    /*
    @GetMapping("/ecommerce/admin/articles/create")
    fun create(model:Model):String {
        var nouvelArticle = Article(nom = "", description = "", stock = 1, prix = 1.0)
        model.addAttribute("article", nouvelArticle)
        return "pageAdmin/article/create"
    }
     */
}
