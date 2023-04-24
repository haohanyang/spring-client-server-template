package com.example.server;

import com.example.common.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok().body("hello");
    }

    @GetMapping("/todo")
    public List<Todo> todoList() {
        var calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        var yesterday = calendar.getTime();
        calendar.add(Calendar.DATE, -1);
        var dayBeforeYesterday = calendar.getTime();
        return List.of(
                new Todo("Apply for job", new Date(), false),
                new Todo("Do the laundry", new Date(), false),
                new Todo("Work on thesis", yesterday, true),
                new Todo("Learn .NET", dayBeforeYesterday, false));
    }
}
