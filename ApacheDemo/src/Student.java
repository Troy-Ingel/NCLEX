import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Student {
	private String firstName, lastName;
	private String studentId;
	private ArrayList<PracticeAssessment> practiceList;
	private ArrayList<ProctoredAssessment> proctoredList;

	public Student() {
		this.firstName = "";
		this.lastName = "";
		this.studentId = "";
	}

	public Student(String firstName, String lastName, String studentId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentId = studentId;
		practiceList = new ArrayList<PracticeAssessment>();
		proctoredList = new ArrayList<ProctoredAssessment>();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public ArrayList<ProctoredAssessment> getProctoredAssessment() {
		return proctoredList;
	}

	public void setProctoredAssessment(ProctoredAssessment proctoredAssessment) {
		proctoredList.add(proctoredAssessment);
	}

	public ArrayList<PracticeAssessment> getPracticeAssessment() {
		return practiceList;
	}

	public void setPracticeAssessment(PracticeAssessment practiceAssessment) {
		practiceList.add(practiceAssessment);
	}

}