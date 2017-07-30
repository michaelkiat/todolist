package todolist;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Task {

    private LocalDate date;
    private static final Path TASK_FILE = Paths.get("Task.txt");

    public Task() {
    }
    //String Category;
    private String Description;

    public Task(LocalDate date, String Description, boolean Status) {
        this.date = date;
        this.Description = Description;
        this.Status = Status;
    }
    private boolean Status;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public boolean getStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public static void updateTaskList(LinkedList<Task> LinkedList) throws IOException {
        try (PrintWriter outputFile = new PrintWriter(TASK_FILE.toFile(), StandardCharsets.UTF_8.name())) {
            ListIterator<Task> listItr = LinkedList.listIterator();
            Task tempTask;
            while (listItr.hasNext()) {
                tempTask = listItr.next();
                outputFile.println(tempTask.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
                outputFile.println(tempTask.Description);
                outputFile.println(tempTask.Status);
            }
        }
    }

    public static LinkedList<Task> loadTaskList() throws IOException {
        LinkedList<Task> taskList = new LinkedList<>();

        if (Files.notExists(TASK_FILE)) {
            return taskList;
        } else {
            try (Scanner taskListScanner = new Scanner(TASK_FILE, StandardCharsets.UTF_8.name())) {
                while (taskListScanner.hasNextLine()) {
                    taskList.add(new Task(LocalDate.parse(taskListScanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE), taskListScanner.nextLine(), Boolean.parseBoolean(taskListScanner.nextLine())));
                }
                return taskList;
            }
        }
    }

}
