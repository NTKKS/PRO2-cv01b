package cz.uhk.fim.todolist.app.gui;

import cz.uhk.fim.todolist.app.model.TodoItem;
import cz.uhk.fim.todolist.app.model.TodoList;

import javax.swing.table.AbstractTableModel;

public class TodoTableModel extends AbstractTableModel {

    private TodoList todoList;

    public void setList(TodoList todoList) {
        this.todoList = todoList;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return todoList.getItemCount();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TodoItem item = todoList.getItemByIndex(rowIndex);
        switch (columnIndex) {
            case 0:
                return item.getTitle();
            case 1:
                return item.isComplete();
            case 2:
                return item.getDateTime();
            default:
                return "?";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        TodoItem item = todoList.getItemByIndex(rowIndex);
        switch (columnIndex) {
            case 0:
                item.setTitle((String) aValue);
                break;
            case 1:
                item.setComplete((Boolean) aValue);
                break;
            default:
                break;
        }
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nazev";
            case 1:
                return "Dokonceno?";
            case 2:
                return "Datum a cas";
            default:
                return "?";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Boolean.class;
            case 2:
                return String.class;
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
