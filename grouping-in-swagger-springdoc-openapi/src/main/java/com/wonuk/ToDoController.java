package com.suraj;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RequestMapping("/todo")
@RestController
public class ToDoController {

  private final Map<Integer, String> todoMap = new HashMap<>(30);
  private final Random random = new Random();

  @Tag(name = "user tage name", description = "user tag description")
  @GetMapping(value = "/user")
  @Operation(summary = "Get All ToDo List")
  public Map<Integer, String> getAllTodoList() {
    return todoMap;
  }

  @GetMapping(value = "/user/{todo_id}")
  @Operation(summary = "Get ToDo item for todo id")
  public String getTodo(@PathVariable("todo_id") Integer todoId) {
    return todoMap.get(todoId);
  }

  @Tag(name = "admin tag name", description = "admin tag description")
  @PostMapping(value = "/admin")
  @Operation(summary = "Post new ToDo")
  public Integer postTodo(@RequestParam("todo") String todo) {
    int todoId = random.nextInt();
    todoMap.put(todoId, todo);
    return todoId;
  }

  @GetMapping(value = "/operation")
  @Operation(summary = "Get All ToDo List")
  public Map<Integer, String> getAllTodoListByOps() {
    return todoMap;
  }

  @GetMapping(value = "/operation/{todo_id}")
  @Operation(summary = "Get ToDo item for todo id")
  public String getTodoByOps(@PathVariable("todo_id") Integer todoId) {
    return todoMap.get(todoId);
  }

  @PostMapping(value = "/operation")
  @Operation(summary = "Post new ToDo")
  public Integer postTodoByOps(@RequestParam("todo") String todo) {
    int todoId = random.nextInt();
    todoMap.put(todoId, todo);
    return todoId;
  }
}
