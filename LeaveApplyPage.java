package com.aspiresys.studentportal;

import javax.swing.*;
import java.awt.*;

public class LeaveApplyPage extends JFrame {

    private JTextField nameField;
    private JComboBox<String> leaveTypeBox;
    private JTextArea reasonArea;

    public LeaveApplyPage() {
        super("Leave Apply Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Name field
        JLabel nameLabel = new JLabel("Name:");
        formPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        nameField = new JTextField(20);
        formPanel.add(nameField, gbc);

        // Leave type box
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel leaveTypeLabel = new JLabel("Leave Type:");
        formPanel.add(leaveTypeLabel, gbc);

        gbc.gridx = 1;
        String[] leaveTypes = {"Sick Leave", "Vacation Leave", "Personal Leave", "On-Duty", "External On-Duty"};
        leaveTypeBox = new JComboBox<>(leaveTypes);
        formPanel.add(leaveTypeBox, gbc);

        // Reason area
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel reasonLabel = new JLabel("Reason:");
        formPanel.add(reasonLabel, gbc);

        gbc.gridx = 1;
        gbc.gridheight = 3;
        reasonArea = new JTextArea(5, 20);
        reasonArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(reasonArea);
        formPanel.add(scrollPane, gbc);

        // Create submit button
        JButton submitButton = new JButton("Submit");

        // Create form panel wrapper
        JPanel formWrapper = new JPanel(new BorderLayout());
        formWrapper.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formWrapper.add(formPanel, BorderLayout.CENTER);
        formWrapper.add(submitButton, BorderLayout.SOUTH);

        getContentPane().add(formWrapper);
        setSize(400, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LeaveApplyPage();
    }
}

