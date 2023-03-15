package com.aspiresys.studentportal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StudentPortalHomePage {

	static JFrame frame = new JFrame();

	StudentPortalHomePage() {

		JLabel label = new JLabel("Students portal");
		label.setBounds(200, 50, 100, 30);
		frame.add(label);

		JButton profile = new JButton("Profile");
		profile.setBounds(30, 150, 100, 30);
		profile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("aaa");

			}
		});

		frame.add(profile);

		JButton courses = new JButton("Courses");
		courses.setBounds(170, 150, 100, 30);
		courses.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("bbb");

			}
		});
		frame.add(courses);

		JButton eventupdate = new JButton("Event Update");
		eventupdate.setBounds(310, 150, 110, 30);
		courses.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("bbb");

			}
		});
		frame.add(eventupdate);

		JButton attendance = new JButton("Attendance");
		attendance.setBounds(450, 150, 100, 30);
		attendance.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new AttendancePage();

			}
		});

		frame.add(attendance);
		
		JButton leaveapply = new JButton("Leave Apply");
		leaveapply.setBounds(590, 150, 110, 30);
		leaveapply.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new LeaveApplyPage();

			}
		});

		frame.add(leaveapply);
		
		

		frame.setSize(500, 300);
		frame.setLayout(null);
		frame.setVisible(true);

	}

	public static void main(String[] args) {

		new StudentPortalHomePage();

	}
}
