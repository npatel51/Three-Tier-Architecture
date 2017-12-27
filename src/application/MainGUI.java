package application;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Optional;

import businesslayer.AppData;
import businesslayer.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MainGUI extends Application {
	private static Stage mainDialog;
	private static Scene gridScene;
	private static Button homeButton;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		/** Layout of main frame : Login for database **/

		mainDialog = new Stage();
		primaryStage.setTitle("Welcome to the Database");
		GridPane gpane = new GridPane();
		gpane.setAlignment(Pos.CENTER);
		gpane.setHgap(10);
		gpane.setVgap(10);

		Scene scene = new Scene(gpane, 325, 275);
		primaryStage.setScene(scene);

		/** Nodes for the main frame **/

		Text gpaneTitle = new Text("Please login with your username and password.");

		gpaneTitle.setFont(Font.font("Timees New Roman", FontWeight.THIN, 12));
		gpane.add(gpaneTitle, 0, 0, 3, 1);

		Label userNameForLogin = new Label("User Name:");
		gpane.add(userNameForLogin, 0, 1);

		final TextField userNameInput = new TextField();
		gpane.add(userNameInput, 1, 1);

		final Label passWord = new Label("Password:");
		gpane.add(passWord, 0, 2);

		final PasswordField userPassInput = new PasswordField();
		gpane.add(userPassInput, 1, 2);

		final Text logInfail = new Text();
		gpane.add(logInfail, 1, 5);

		CheckBox cbox = new CheckBox("Remember me");

		cbox.setOnAction(e -> {

			if (cbox.isSelected()) {
				userNameInput.setText(userNameInput.getText());
			}
		});

		//Username =  'user'
		//Password =  'pass'
		userPassInput.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					if (userNameInput.getText().equals("user") && userPassInput.getText().equals("pass")) {
						mainDialog.setScene(gridScene);
						mainDialog.show();
					} else {
						logInfail.setFill(Color.FIREBRICK);
						logInfail.setText("Invalid Username or Password");
					}
				}
			}

		});

		Button loginButton = new Button("Log in");

		loginButton.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					if (userNameInput.getText().equals("user") && userPassInput.getText().equals("pass")) {
						mainDialog.setScene(gridScene);
						mainDialog.show();
					} else {
						logInfail.setFill(Color.FIREBRICK);
						logInfail.setText("Invalid Username or Password");
					}
				}
			}
		});

		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_CENTER);
		hbBtn.getChildren().addAll(cbox, loginButton);
		gpane.add(hbBtn, 1, 4);

		primaryStage.setScene(scene);
		primaryStage.show();

		/** End of primary stage **/

		/** Layout for main stage **/

		mainDialog.setTitle("Welcome to the Database");
		final BorderPane borderPane = new BorderPane();
		final GridPane gridPane = new GridPane();
		gridPane.setVgap(20);
		gridPane.setHgap(10);

		gridScene = new Scene(borderPane, 1200, 550);

		/** Sub-header for the main frame **/

		final VBox vboxForMenuBar = new VBox();
		borderPane.setTop(vboxForMenuBar);

		Menu fileMenu = new Menu("File");

		MenuItem newFile = new MenuItem("New");
		MenuItem openFile = new MenuItem("Open File..");
		MenuItem changedpItem = new MenuItem("Change Background");
		MenuItem exit = new MenuItem("Exit");

		fileMenu.getItems().addAll(newFile, openFile, new SeparatorMenuItem(), changedpItem, new SeparatorMenuItem(),
				exit);

		Menu editMenu = new Menu("Edit");
		MenuItem copy = new MenuItem("Copy");
		MenuItem delete = new MenuItem("Delete");

		editMenu.getItems().addAll(copy, delete);

		Menu viewMenu = new Menu("View");

		MenuItem database = new MenuItem("Database");
		MenuItem sortedData = new MenuItem("Sorted Database");
		viewMenu.getItems().addAll(database, sortedData);

		Menu helpMenu = new Menu("Help");

		MenuItem javaDoc = new MenuItem("JavaDoc");
		MenuItem helpCont = new MenuItem("Help Content");
		MenuItem about = new MenuItem("About");

		helpMenu.getItems().addAll(javaDoc, helpCont, about);

		MenuBar menuBar = new MenuBar();

		menuBar.getMenus().addAll(fileMenu, editMenu, viewMenu, helpMenu);
		vboxForMenuBar.getChildren().add(menuBar);

		/** Nodes for gridPane **/

		Label firstName = new Label("First Name*:");
		gridPane.add(firstName, 1, 2);

		final TextField firstNamefield = new TextField();
		gridPane.add(firstNamefield, 2, 2);

		Label lastName = new Label("Last Name*:");
		gridPane.add(lastName, 3, 2);

		final TextField lastNamefield = new TextField();
		gridPane.add(lastNamefield, 4, 2);

		Label dob = new Label("Date of birth*:");
		gridPane.add(dob, 1, 3);

		final DatePicker date = new DatePicker();
		gridPane.add(date, 2, 3);

		Label age = new Label("Age*:");
		gridPane.add(age, 3, 3);

		final TextField ageField = new TextField();
		gridPane.add(ageField, 4, 3);

		Label email = new Label("E-mail*:");
		gridPane.add(email, 1, 4);

		final TextField emailField = new TextField();
		gridPane.add(emailField, 2, 4);

		Label phone = new Label("Phone Number*:");
		gridPane.add(phone, 3, 4);

		final TextField phoneField = new TextField();
		gridPane.add(phoneField, 4, 4);

		Label address1 = new Label("Address Line 1*:");
		gridPane.add(address1, 1, 5);

		final TextField address1Field = new TextField();
		gridPane.add(address1Field, 2, 5);

		Label address2 = new Label("Address Line 2:");
		gridPane.add(address2, 1, 6);

		final TextField address2Field = new TextField();
		gridPane.add(address2Field, 2, 6);

		Label city = new Label("City*:");
		gridPane.add(city, 1, 7);

		final TextField cityField = new TextField();
		gridPane.add(cityField, 2, 7);

		Label state = new Label("State/Province/Region*:");
		gridPane.add(state, 3, 7);

		final TextField stateField = new TextField();
		gridPane.add(stateField, 4, 7);

		Label zip = new Label("Zip/Postal Code*:");
		gridPane.add(zip, 1, 8);

		final TextField zipField = new TextField();
		gridPane.add(zipField, 2, 8);

		Label country = new Label("Country:");
		gridPane.add(country, 1, 9);

		homeButton = new Button("Home");

		ArrayList<String> countries = new ArrayList<>();
		String[] locales = Locale.getISOCountries(); // countries
		for (String countryCode : locales) {

			Locale obj = new Locale("", countryCode);
			countries.add(obj.getDisplayCountry());

		}

		ObservableList<String> options = FXCollections.observableArrayList(countries);
		final ComboBox<String> cBox = new ComboBox<String>(options);
		cBox.setValue("United States");
		gridPane.add(cBox, 2, 9);

		final CheckBox agreementBox = new CheckBox("I agree to the Term and Conditions");
		gridPane.add(agreementBox, 1, 10);

		final Text agreementCheck = new Text();
		gridPane.add(agreementCheck, 1, 11);

		Button saveButton = new Button("Save");
		Button CancelButton = new Button("Cancel");
		Button ClearButton = new Button("Clear");
		final HBox hbButtons = new HBox(10);
		hbButtons.setAlignment(Pos.CENTER);
		hbButtons.getChildren().addAll(saveButton, CancelButton, ClearButton);

		mainDialog.initOwner(primaryStage);

		/** Validates the login info using Enter key and login button **/

		loginButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (userNameInput.getText().equals("Niraj") && userPassInput.getText().equals("pass123")) {
					mainDialog.setScene(gridScene);
					mainDialog.show();
				} else {
					logInfail.setFill(Color.FIREBRICK);
					logInfail.setText("Invalid Username or Password");
				}
			}
		});

		// return to the main menu
		homeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainDialog.setScene(gridScene);
				mainDialog.show();
			}
		});

		newFile.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				Text mainDialogTitle = new Text("Please fill in the required feilds:");
				mainDialogTitle.setFont(Font.font("Times New Roman", FontWeight.THIN, 14));
				vboxForMenuBar.getChildren().add(mainDialogTitle);
				borderPane.setCenter(gridPane);
				borderPane.setBottom(hbButtons);
			}
		});

		// Search the person in the data base.
		openFile.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				searchDialogScene();

			}
		});

		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Exit Confirmation");
				alert.setHeaderText("");
				alert.setContentText("Are you sure you wan to exit?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					AppData.getAppData().closeConnection(); //close connection
					System.exit(0);
				}

			}
		});

		delete.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				deletePerson();
			}
		});

		database.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ArrayList<Person> datafromDatabase = new ArrayList<Person>();
				try {
					datafromDatabase.addAll(AppData.getAppData().findAllPeople());
					createTableAndView(datafromDatabase);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});

		sortedData.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ArrayList<Person> datafromDatabase = new ArrayList<Person>();
				try {
					datafromDatabase.addAll(AppData.getAppData().findAllPeople());
					Collections.sort(datafromDatabase);
					createTableAndView(datafromDatabase);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});

		// Adds entry to the SQL database if all entries are valid
		saveButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				if (emailField.getText().isEmpty() || firstNamefield.getText().isEmpty()
						|| lastNamefield.getText().isEmpty() || ageField.getText().isEmpty()
						|| cityField.getText().isEmpty() || address1Field.getText().isEmpty()
						|| zipField.getText().isEmpty()) {

					agreementCheck.setFill(Color.RED);
					agreementCheck.setText("One or more fields are empty.");
				} else if (!(ageField.getText().matches("^[0-9]+"))) {
					agreementCheck.setFill(Color.RED);
					agreementCheck.setText("Please check the age feild.");

				} else if (!(emailField.getText().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))) {
					/**
					 * Email Pattern: https://examples.javacodegeeks.com/core-java/util/regex/
					 * matcher/validate-email-address-with-java-regular-expression- example/
					 **/
					agreementCheck.setFill(Color.RED);
					agreementCheck.setText("Please enter a valid email.");

				} else if (!(phoneField.getText().matches("\\d{10}"))) {
					agreementCheck.setFill(Color.RED);
					agreementCheck.setText("Please enter a valid 10 digit phone number in this format:1234567890");
				} else if (!(zipField.getText().matches("^[0-9]{5}(?:-[0-9]{4})?$"))) {
					agreementCheck.setFill(Color.RED);
					agreementCheck.setText("Invalid zip code");
				} else if (agreementBox.isSelected()) {
					String dateString = date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
					Person person = new Person(firstNamefield.getText(), lastNamefield.getText(), dateString,
							ageField.getText(), emailField.getText(), phoneField.getText(), address1Field.getText(),
							address2Field.getText(), cityField.getText(), zipField.getText(), stateField.getText(),
							cBox.getValue().toString());
					try {
						AppData.getAppData().addPerson(person);
					} catch (SQLException e) {
						System.err.println(e.getClass().getName() + ": " + e.getMessage());
					}
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Confirmation Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Your record has been saved succesfully!");
					alert.showAndWait();
				} else {
					agreementCheck.setFill(Color.RED);
					agreementCheck.setText("You must agree the terms and conditions.");
				}

			}

		});

		// Exit the GUI
		CancelButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Exit Confirmation");
				alert.setHeaderText("");
				alert.setContentText("Are you sure you wan to exit?");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					AppData.getAppData().closeConnection(); //close connection
					System.exit(0);
				}

			}
		});

		// Clear all fields
		ClearButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				firstNamefield.clear();
				lastNamefield.clear();
				emailField.clear();
				ageField.clear();
				phoneField.clear();
				address1Field.clear();
				address2Field.clear();
				cityField.clear();
				zipField.clear();

			}
		});
		
		
		mainDialog.setOnCloseRequest(event -> {
			AppData.getAppData().closeConnection(); //close connection
			System.exit(0);
		});
		
		
	}

	/** Methods for table,delete, and search scene **/

	@SuppressWarnings("unchecked")
	public static void createTableAndView(ArrayList<Person> listofPeople) throws SQLException {
		/** Table view mainDialog box layout **/

		final Label label = new Label("Database");
		label.setFont(new Font("Georgia", 20));
		final ObservableList<Person> data = FXCollections.observableArrayList(listofPeople);

		TableView<Person> table = new TableView<Person>();
		table.setItems(data);

		table.setEditable(true);

		TableColumn<Person, String> firstNameCol = new TableColumn<Person, String>("First Name");
		firstNameCol.setPrefWidth(70);
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));

		TableColumn<Person, String> lastNameCol = new TableColumn<Person, String>("Last Name");
		lastNameCol.setPrefWidth(70);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));

		TableColumn<Person, String>dobCol = new TableColumn<Person, String>("DOB");
		dobCol.setPrefWidth(100);
		dobCol.setCellValueFactory(new PropertyValueFactory<Person, String>("dateOfBirth"));

		TableColumn <Person, String> ageCol = new TableColumn<Person, String>("Age");
		ageCol.setPrefWidth(40);
		ageCol.setCellValueFactory(new PropertyValueFactory<Person, String>("age"));

		TableColumn<Person, String> emailCol = new TableColumn<Person, String>("Email");
		emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
		
		TableColumn<Person, String> phoneCol = new TableColumn<Person, String>("Phone");
		phoneCol.setCellValueFactory(new PropertyValueFactory<Person, String>("phoneNumber"));
		phoneCol.setPrefWidth(80);
		
		TableColumn<Person, String> address1Col = new TableColumn<Person, String>("Address1");
		address1Col.setCellValueFactory(new PropertyValueFactory<Person, String>("address1"));
		
		TableColumn<Person, String> address2Col = new TableColumn<Person, String>("Address2");
		address2Col.setCellValueFactory(new PropertyValueFactory<Person, String>("address2"));
		
		TableColumn<Person, String> cityCol = new TableColumn<Person, String>("City");
		cityCol.setCellValueFactory(new PropertyValueFactory<Person, String>("city"));
		
		TableColumn<Person, String> zipCol = new TableColumn<Person, String>("ZIP");
		zipCol.setPrefWidth(50);
		zipCol.setCellValueFactory(new PropertyValueFactory<Person, String>("zipCode"));
		
		TableColumn<Person, String> stateCol = new TableColumn<Person, String>("State");
		stateCol.setPrefWidth(60);
		stateCol.setCellValueFactory(new PropertyValueFactory<Person, String>("state"));
		
		TableColumn<Person, String> countryCol = new TableColumn<Person, String>("Country");
		countryCol.setCellValueFactory(new PropertyValueFactory<Person, String>("country"));

		table.getColumns().addAll(firstNameCol, lastNameCol, emailCol, dobCol, ageCol, phoneCol, address1Col,
				address2Col, cityCol, zipCol, stateCol, countryCol);

		final VBox vboxforTable = new VBox();

		vboxforTable.setSpacing(5);
		vboxforTable.setPadding(new Insets(10, 0, 0, 10));
		vboxforTable.getChildren().addAll(homeButton, label, table);

		Scene tableScene = new Scene(vboxforTable, 1200, 650);
		mainDialog.setScene(tableScene);
		mainDialog.show();

	}

	public static void deletePerson() {

		GridPane gpane = new GridPane();

		Label firstName = new Label("First Name*:");
		firstName.setMaxSize(80, 80);
		final TextField firstNamefield = new TextField();
		firstNamefield.setPrefSize(100, 10);
		Label lastName = new Label("Last Name*:");
		final TextField lastNamefield = new TextField();

		final Text searchConfirmation = new Text();
		gpane.add(searchConfirmation, 2, 2);

		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					AppData.getAppData().deletePerson(firstNamefield.getText(), lastNamefield.getText());
					searchConfirmation.setFill(Color.FIREBRICK);
					searchConfirmation.setText(firstNamefield.getText() + " information has been deleted from the database.");

				} catch (SQLException e) {
					searchConfirmation.setFill(Color.FIREBRICK);
					searchConfirmation.setText("Person you entered does not exist.");
				}

			}
		});
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(deleteButton, homeButton);
		VBox vbox = new VBox();
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(firstName, firstNamefield, lastName, lastNamefield, hbox);

		gpane.add(vbox, 1, 1);
		Scene deleteScene = new Scene(gpane, 1200, 550);
		mainDialog.setScene(deleteScene);
		mainDialog.show();
	}

	public static void searchDialogScene() {
		GridPane gpane = new GridPane();

		Label firstName = new Label("First Name*:");
		firstName.setMaxSize(80, 80);
		final TextField firstNamefield = new TextField();
		firstNamefield.setPrefSize(100, 10);
		Label lastName = new Label("Last Name*:");
		final TextField lastNamefield = new TextField();

		final Text deleteConfirmation = new Text();
		gpane.add(deleteConfirmation, 2, 2);

		Button searchButton = new Button("Search");
		searchButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					String output = AppData.getAppData().getPerson(firstNamefield.getText(), lastNamefield.getText())
							.toString();
					if (output != null) {
						deleteConfirmation.setFill(Color.FIREBRICK);
						deleteConfirmation.setText(output);
					}

				} catch (Exception e) {
					deleteConfirmation.setFill(Color.FIREBRICK);
					deleteConfirmation.setText(firstNamefield.getText() + " " + lastNamefield.getText()
							+ " does not exist in the database.");
				}

			}
		});
		HBox hbox = new HBox(10);
		hbox.setAlignment(Pos.CENTER);
		hbox.getChildren().addAll(searchButton, homeButton);
		VBox vbox = new VBox();
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(firstName, firstNamefield, lastName, lastNamefield, hbox);

		gpane.add(vbox, 1, 1);

		Scene deleteScene = new Scene(gpane, 1200, 550);
		mainDialog.setScene(deleteScene);
		mainDialog.show();

	}

}
