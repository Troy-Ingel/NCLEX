import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentTableScreen extends Application {
	Stage window;
	TableView<Student> table;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("NCLEX Student List");

		// Name column
		TableColumn<Student, String> firstNameColumn = new TableColumn<Student, String>("First Name");
		firstNameColumn.setMinWidth(200);
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

		TableColumn<Student, String> lastNameColumn = new TableColumn<Student, String>("Last Name");
		lastNameColumn.setMinWidth(200);
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

		TableColumn<Student, Integer> studentIdColumn = new TableColumn<Student, Integer>("Student Id");
		studentIdColumn.setMinWidth(200);
		studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));

		table = new TableView<>();
		table.setItems(getStudents());
		table.getColumns().addAll(firstNameColumn, lastNameColumn, studentIdColumn);
		table.setRowFactory(tv -> {
			TableRow<Student> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					Student rowData = row.getItem();
					System.out.println("First Name: " + rowData.getFirstName());
					System.out.println("Last Name: " + rowData.getLastName());
					System.out.println("Student Id: " + rowData.getStudentId());
				}
			});
			return row;
		});

		VBox vBox = new VBox();
		vBox.getChildren().addAll(table);

		Scene scene = new Scene(vBox);
		window.setScene(scene);
		window.show();

	}

	public ObservableList<Student> getStudents() {
		ObservableList<Student> students = FXCollections.observableArrayList();
		students.add(new Student("Troy", "Ingel", 100));
		students.add(new Student("Jake", "Jinhle", 200));
		students.add(new Student("Tom", "Mahr", 300));
		students.add(new Student("Jim", "Jakin", 400));
		students.add(new Student("Bob", "Fusta", 500));
		return students;
	}

}
