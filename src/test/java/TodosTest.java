import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void matchesSimpleTaskTest() {
        SimpleTask simpleTask = new SimpleTask(55, "Позвонить родителям");
        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить родителям");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void matchesEpicTest() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);
        boolean expected = true;
        boolean actual = epic.matches("Молоко");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void matchesMeetingTest() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void searchTest() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        SimpleTask[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);

        System.out.println(actual);
    }
}
