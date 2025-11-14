package org.ldv.ecommerce.model.dao

import org.ldv.ecommerce.model.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleDAO : JpaRepository<Role, Long> {
}