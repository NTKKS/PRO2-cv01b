package cz.uhk.fim.todolist.app.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItem {
    private String title;
    private boolean complete;
    private String dateTime;

    public TodoItem() {
    }

    public TodoItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
        if (complete){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            setDateTime(sdf.format(date));
        }
        else {
            setDateTime("");
        }
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;

    }
}
