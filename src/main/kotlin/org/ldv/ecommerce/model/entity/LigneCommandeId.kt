package org.ldv.ecommerce.model.entity

import jakarta.persistence.*
import java.io.Serializable

@Embeddable
class LigneCommandeId (
    var commandeId: Long,
    var articleId: Long
): Serializable {
}
