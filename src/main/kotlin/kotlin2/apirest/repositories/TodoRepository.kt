package kotlin2.apirest.repositories

import kotlin2.apirest.entities.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository: JpaRepository<Todo, Long>