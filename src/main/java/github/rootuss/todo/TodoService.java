package github.rootuss.todo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    List<Todo> findAll() {
        return todoRepository
                .findAll();
    }

    Optional<Todo> findById(Integer id) {
        return todoRepository.findById(id);
    }

    Optional<Todo> updateById(Integer id) {
        var todo = findById(id);
        todo.ifPresent(t -> {
                    t.setDone(!t.isDone());
                    todoRepository.save(t);
                }
        );
        return todo;
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }
}
