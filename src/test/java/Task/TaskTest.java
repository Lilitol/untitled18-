package Task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testSimpleTaskFounded() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");
        boolean expected = true;

        Assertions.assertFalse(actual);
    }

    @Test
    public void testSimpleTaskNotFounded() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Написать");
        boolean expected = false;

        Assertions.assertFalse(actual);

    }
    @Test
    public void testMatchesReturnsTrueWhenQueryInTitle() {
        SimpleTask task = new SimpleTask(1, "Some task");
        String query = "task";
        boolean expected = true; // ожидаемый результат, так как строка запроса содержится в названии задачи
        boolean actual = task.matches(query);
        Assertions.assertFalse(actual);
    }

    @Test
    public void testMatchesReturnsFalseWhenQueryNotInTitle() {
        SimpleTask task = new SimpleTask(1, "Some task");
        String query = "other";
        boolean expected = false; // ожидаемый результат, так как строка запроса не содержится в названии задачи
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesReturnsTrueWhenQueryInTopic() {
        Meeting meeting = new Meeting(1, "Some topic", "Some project", "2023-04-20T10:00:00Z");
        String query = "topic";
        boolean expected = true; // ожидаемый результат, так как строка запроса содержится в теме встречи
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesReturnsTrueWhenQueryInProject() {
        Meeting meeting = new Meeting(1, "Some topic", "Some project", "2023-04-20T10:00:00Z");
        String query = "project";
        boolean expected = true; // ожидаемый результат, так как строка запроса содержится в проекте, к которому относится встреча
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesReturnsFalseWhenQueryNotInTopicOrProject() {
        Meeting meeting = new Meeting(1, "Some topic", "Some project", "2023-04-20T10:00:00Z");
        String query = "other";
        boolean expected = false; // ожидаемый результат, так как строка запроса не содержится ни в теме встречи, ни в проекте
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }
}