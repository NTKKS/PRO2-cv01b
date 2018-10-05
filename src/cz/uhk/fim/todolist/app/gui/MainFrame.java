package cz.uhk.fim.todolist.app.gui;

import cz.uhk.fim.todolist.app.model.TodoItem;
import cz.uhk.fim.todolist.app.model.TodoList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JTable table;
    private TodoTableModel model;
    private TodoList todoList;

    public MainFrame() {init();
    }

    private void init() {
        setTitle("TODO List App");
        setSize(640,480);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new TodoTableModel();
        todoList = new TodoList();
        //todoList.addItem(new TodoItem("zkusebni_item"));
        model.setList(todoList);

        initControlPanel();
        initContentPanel();
        }

        private void initContentPanel() {
        table = new JTable();
        table.setModel(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        }

        private void initControlPanel() {
        JPanel controlPanel = new JPanel(new BorderLayout());

        JLabel lblAddTodo = new JLabel("Zadej todo:");
        JTextField txtAddTodo = new JTextField();
        JButton btnAddTodo = new JButton("přidat");

        btnAddTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                todoList.addItem(new TodoItem(txtAddTodo.getText()));
                txtAddTodo.setText("");
                model.setList(todoList);
            }
        });

        controlPanel.add(lblAddTodo, BorderLayout.WEST);
        controlPanel.add(txtAddTodo, BorderLayout.CENTER);
        controlPanel.add(btnAddTodo, BorderLayout.EAST);

        add(controlPanel, BorderLayout.NORTH);
    }
}
