package model;

import lombok.Data;

@Data
public class Task {

    private String projectName;
    private String taskName;
    private LocalDatetime start;
    private LocalDatetime stop;

}
