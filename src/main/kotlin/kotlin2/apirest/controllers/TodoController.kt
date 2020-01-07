package kotlin2.apirest.controllers

import kotlin2.apirest.entities.Todo
import kotlin2.apirest.repositories.TodoRepository
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.EnableWebMvc


@RestController
@RequestMapping("/todo") @EnableWebMvc
class TodoResource(val todoRepo: TodoRepository) {

    @GetMapping("/")
    fun getExemplaAll() = todoRepo.findAll()

    @GetMapping("/{id}")
    fun getOne(@PathVariable id: Long) = todoRepo.findById(id)

    @PostMapping("/")
    fun new(@RequestBody text: String) = todoRepo.save(Todo(text = text))

    @DeleteMapping( "/{id}")
    fun delete(@PathVariable id: Long) = todoRepo.deleteById(id)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody todo: Todo): Todo {
        val toUpdate: Todo = todoRepo.findById(id).orElseThrow()
        toUpdate.text = todo.text
        toUpdate.done = todo.done
        return todoRepo.save(toUpdate)
    }
}


