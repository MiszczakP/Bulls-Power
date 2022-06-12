package model;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    @DisplayName("should create empty task object and set projectName")
    public void shouldCreateEmptyTaskObjectAndSetProjectName() {
        Task eg1 = new Task();
        eg1.setProjectName("ABC");
        assertEquals("ABC", eg1.getProjectName());
    }
    @Test
    @DisplayName("should create empty task object and set taskName")
    public void shouldCreateEmptyTaskObjectAndSetTaskName() {
        Task eg1 = new Task();
        eg1.setTaskName("ABC");
        assertEquals("ABC", eg1.getTaskName());
    }
    @Test
    @DisplayName("should create empty task object and set start")
    public void shouldCreateEmptyTaskObjectAndSetStartData() {
        Task eg1 = new Task();
        eg1.setStart(new MyData());
        assertEquals((System.currentTimeMillis() / 1000), eg1.getStart().getTimeStamp());
    }
    @Test
    @DisplayName("should create empty task object and set projectName")
    public void shouldCreateEmptyTaskObjectAndSetStopData() {
        Task eg1 = new Task();
        eg1.setStop(new MyData());
        assertEquals((System.currentTimeMillis() / 1000), eg1.getStop().getTimeStamp());
    }

}