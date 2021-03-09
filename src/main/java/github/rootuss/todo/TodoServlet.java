package github.rootuss.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
class TodoServlet {
    private final Logger logger = LoggerFactory.getLogger(TodoServlet.class);
    private TodoService todoService;

    TodoServlet(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    ResponseEntity<List<Todo>> findAllTodos() {
        logger.info(" Obsłużono REQUEST");

        return ResponseEntity.ok(todoService.findAll());
    }

    // update data
    @PutMapping("/{id}")
    ResponseEntity<Todo> toggleTodo(@PathVariable Integer id) {
        var todo = todoService.updateById(id);

        return todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //add new data
    @PostMapping
    ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.save(todo));
    }
}