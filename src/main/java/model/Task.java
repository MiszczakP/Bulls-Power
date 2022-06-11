package model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {

    private String projectName;
    private String taskName;
    private LocalDateTime start;
    private LocalDateTime stop;

}
