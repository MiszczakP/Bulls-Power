package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Task {

    private String projectName;
    private String taskName;
    private LocalDateTime start;
    private LocalDateTime stop;

    public Task(String projectName, String taskName) {
        this.projectName = projectName;
        this.taskName = taskName;
        this.start = LocalDateTime.now();
    }



}
