package model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

import static model.MyData.emptyMyData;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    private String projectName;
    private String taskName;
    private MyData start;
    private MyData stop;
    private Long duration;

    public Task(String projectName, String taskName) {
        this.projectName = projectName;
        this.taskName = taskName;
        this.duration = 0L;
        this.start = new MyData();
        this.stop = emptyMyData();
    }

    public void finishTask() {
        this.stop = new MyData();
        duration = MyData.minuteBetween(stop, start);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskName.equals(task.taskName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskName);
    }


}
