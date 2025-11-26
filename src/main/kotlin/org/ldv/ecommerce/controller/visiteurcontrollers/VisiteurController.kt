package org.ldv.ecommerce.controller.visiteurcontrollers

import org.ldv.ecommerce.model.dao.LivreDAO
import org.ldv.ecommerce.model.dao.PapeterieDAO
import org.ldv.ecommerce.model.entity.Livre
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class VisiteurController(
    val livreDAO: LivreDAO,
    val papeterieDAO: PapeterieDAO
) {

    @GetMapping("/livres")
    fun livres(model: Model): String {
        val livres = livreDAO.findAll()
        model.addAttribute("livres", livres)
        return "pagesVisiteur/livres" // le template Thymeleaf à créer
    }

    @GetMapping("/papeterie")
    fun papeterie(model: Model): String {
        val papeteries = papeterieDAO.findAll()
        model.addAttribute("papeteries", papeteries)
        return "pagesVisiteur/papeterie" // le template Thymeleaf à créer
    }

    @GetMapping("/livres/{id}")
    fun show(@PathVariable id:Long, model:Model):String {
        val unLivre = livreDAO.findById(id).orElseThrow()
        model.addAttribute("article",unLivre)

        return "pagesVisiteur/show"
    }

}
