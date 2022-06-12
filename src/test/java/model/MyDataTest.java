package model;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


public class MyDataTest {

    @Test
    @DisplayName("should create empty data object")
    public void shouldCreateEmptyDataWithDayZero() {
        MyData eg1 = MyData.emptyMyData();
        assertEquals(0, eg1.getDay());
    }

    @Test
    @DisplayName("should create data object with correct year")
    public void shouldCreateDataWithCorrectYear() {
        MyData eg1 = new MyData();
        assertEquals(LocalDateTime.now().getYear(), eg1.getYear());
    }

}