package com.aspiresys.studentportal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class EventCertificateUpdatePage extends JFrame {
    private JLabel certificateNameLabel, certificateDescriptionLabel, certificateImageLabel;
    private JTextField certificateNameTextField, certificateDescriptionTextField;
    private JButton updateButton;
    private JFileChooser fileChooser;
    private File selectedFile;

    public EventCertificateUpdatePage() {
        // Set the frame size and layout
        setSize(400, 300);
        setLayout(new GridLayout(4, 2));

        // Create and add the labels and text fields
        certificateNameLabel = new JLabel("Certificate Name:");
        certificateNameTextField = new JTextField();
        certificateDescriptionLabel = new JLabel("Certificate Description:");
        certificateDescriptionTextField = new JTextField();
        certificateImageLabel = new JLabel("Certificate Image:");
        updateButton = new JButton("Update");

        add(certificateNameLabel);
        add(certificateNameTextField);
        add(certificateDescriptionLabel);
        add(certificateDescriptionTextField);
        add(certificateImageLabel);
        add(updateButton);

        // Add an ActionListener to the update button
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the text entered in the text fields
                String certificateName = certificateNameTextField.getText();
                String certificateDescription = certificateDescriptionTextField.getText();

                // Get the file selected by the user
                fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                }

                // Update the event certificate properties
                // Your code to update the event certificate properties goes here

                // Display a message to the user confirming the update
                JOptionPane.showMessageDialog(null, "Certificate updated successfully!");
            }
        });
    }

    public static void main(String[] args) {
        EventCertificateUpdatePage updatePage = new EventCertificateUpdatePage();
        updatePage.setVisible(true);
    }
}

