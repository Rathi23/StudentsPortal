package com.aspiresys.studentportal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AttendancePage extends JFrame {

    private JTable table;

    public AttendancePage() {
        super("Attendance Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create header panel
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel dateLabel = new JLabel("Date:10/03/2023");
        headerPanel.add(dateLabel);

        /*// Create date picker
        DatePicker datePicker = new DatePicker(LocalDate.now());
        headerPanel.add(datePicker);
*/
        // Create table
        String[] columnNames = {"Name", "Present"};
        Object[][] data = {
                {"Karthika", false},
                {"Rathi", false},
                {"Shathya", false}
        };
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 1) {
                    return Boolean.class;
                } else {
                    return super.getColumnClass(column);
                }
            }
        };
        table = new JTable(tableModel);

        // Create table panel
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScrollPane.setPreferredSize(new Dimension(400, 200));

        // Create form panel
        JPanel formPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel nameLabel = new JLabel("Name:");
        formPanel.add(nameLabel);

        JTextField nameField = new JTextField(20);
        formPanel.add(nameField);

        JButton presentButton = new JButton("Present");
        presentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int row = findRow(name);
                if (row >= 0) {
                    tableModel.setValueAt(true, row, 1);
                    nameField.setText("");
                }
            }
        });
        formPanel.add(presentButton);

        JButton absentButton = new JButton("Absent");
        absentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int row = findRow(name);
                if (row >= 0) {
                    tableModel.setValueAt(false, row, 1);
                    nameField.setText("");
                }
            }
        });
        formPanel.add(absentButton);
        
        JButton exitbutton = new JButton("Exit");
        exitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new StudentPortalHomePage();
            }
        });
        formPanel.add(exitbutton);

        // Create main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);
        mainPanel.add(formPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
        setSize(500, 300);
        setVisible(true);
    }

    private int findRow(String name) {
        for (int i = 0; i < table.getRowCount(); i++) {
            if (table.getValueAt(i, 0).equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new AttendancePage();
    }
}

