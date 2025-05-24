package dev.oliveira.DevTask.Projetos;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // CREATE
    @PostMapping()
    public TaskModel createTask(@RequestBody TaskModel task) {
        log.info("POST /tasks - Body: {}", task);

        task.setPending(Boolean.FALSE);

        return taskRepository.save(task);
    }

    // READ ALL
    @GetMapping()
    public List<TaskModel> getAll() {
        log.info("GET /tasks");

        return taskRepository.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public TaskModel getById(@PathVariable Long id) {
        log.info("GET /tasks/{}", id);

        return taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "task not found"));
    }

    // UPDATE
    @PutMapping("/{id}")
    public TaskModel updateTask(@PathVariable Long id,@RequestBody TaskModel taskDetails) {
        log.info("PUT /tasks/{} - Body: {}", id, taskDetails);

        TaskModel task = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));

        task.setNome(taskDetails.getNome());

        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id) {
        log.info("DELETE /tasks/{}", id);

        TaskModel task = taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));

        taskRepository.deleteById(id);
    }

}
