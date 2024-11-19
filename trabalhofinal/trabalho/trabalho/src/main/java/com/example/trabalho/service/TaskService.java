package com.example.trabalho.service;

import com.example.trabalho.model.Priority;
import com.example.trabalho.model.Status;
import com.example.trabalho.model.Task;
import com.example.trabalho.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public String deleteTask(int id) {
        taskRepository.deleteById(id);
        return "Task deletada com sucesso!";
    }

    public Task editTask(Task task, int id) {
        Task newTask = taskRepository.findById(id).orElse(null);
        if (newTask != null) {
            if (task.getTitle() != null) {
                newTask.setTitle(task.getTitle());
            }
            if (task.getDescription() != null) {
                newTask.setDescription(task.getDescription());
            }
            if (task.getDueDate() != null) {
                newTask.setDueDate(task.getDueDate());
            }
            return taskRepository.save(newTask);
        } else {
            return null;
        }
    }

    public Task updateStatus(int id) {
        Task newTask = taskRepository.findById(id).orElse(null);
        if (newTask != null) {
            switch (newTask.getStatus()) {
                case A_FAZER -> newTask.setStatus(Status.EM_PROGRESSO);
                case EM_PROGRESSO -> newTask.setStatus(Status.CONCLUIDO);
                case CONCLUIDO -> newTask.setStatus(Status.A_FAZER);
            }
            return taskRepository.save(newTask);
        }
        return null;
    }

    public Task updatePriority(int id) {
        Task newTask = taskRepository.findById(id).orElse(null);
        if (newTask != null) {
            switch (newTask.getPriority()) {
                case BAIXA -> newTask.setPriority(Priority.MEDIA);
                case MEDIA -> newTask.setPriority(Priority.ALTA);
                case ALTA -> newTask.setPriority(Priority.BAIXA);
            }
            return taskRepository.save(newTask);
        }
        return null;
    }

    public List<Task> getTasksStatus(int status) {
        List<Task> tasks = taskRepository.findAll();
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks) {
            switch (status) {
                case 1 -> {
                    if (task.getStatus() == Status.A_FAZER) {
                        filteredTasks.add(task);
                    }
                }
                case 2 -> {
                    if (task.getStatus() == Status.EM_PROGRESSO) {
                        filteredTasks.add(task);
                    }
                }
                case 3 -> {
                    if (task.getStatus() == Status.CONCLUIDO) {
                        filteredTasks.add(task);
                    }
                }
            }
        }
        filteredTasks.sort((t1, t2) -> Priority.comparador.compare(t1.getPriority(), t2.getPriority()));
        return filteredTasks.isEmpty() ? null : filteredTasks;
    }

    public List<Task> getTasksPriority(int priority) {
        List<Task> tasks = taskRepository.findAll();
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks) {
            switch (priority) {
                case 1 -> {
                    if (task.getPriority() == Priority.BAIXA) {
                        filteredTasks.add(task);
                    }
                }
                case 2 -> {
                    if (task.getPriority() == Priority.MEDIA) {
                        filteredTasks.add(task);
                    }
                }
                case 3 -> {
                    if (task.getPriority() == Priority.ALTA) {
                        filteredTasks.add(task);
                    }
                }
            }
        }
        return filteredTasks.isEmpty() ? null : filteredTasks;
    }
}


