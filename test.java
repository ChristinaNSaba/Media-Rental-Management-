package application;

import java.util.ArrayList;
import java.util.Date;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class test extends Application {
	@Override
	public void start(Stage primaryStage) {

		MediaRentalManager m = new MediaRentalManager(); // creating an object of media rental manager
		ArrayList<Media> med = m.getMediaDatabase(); // creating an array list of media to save the data and pass it
														// to the methods
		ArrayList<Customer> c = m.getCustomerDatabase(); // creating an array of customers to save the data and pass it
															// to the methods

		GridPane root = new GridPane(); // a grid pane which contains two vertical boxes. the first has three buttons
										// and the second has an image and a label
		root.setAlignment(Pos.CENTER);
		root.setHgap(15);
		root.setVgap(15);
		VBox root1 = new VBox(15);
		root1.setAlignment(Pos.CENTER);
		VBox root2 = new VBox(15);
		root2.setAlignment(Pos.CENTER);

		Button b1 = new Button("Customer"); // three buttons which lead to different scenes
		b1.setMaxSize(100, 100);
		Button b2 = new Button("Media");
		b2.setMaxSize(100, 100);
		Button b3 = new Button("Rent");
		b3.setMaxSize(100, 100);

		ImageView img = new ImageView("rent.jpg");
		img.setFitHeight(200);
		img.setFitWidth(200);

		Label lb = new Label("Rental Media System");

		root1.getChildren().addAll(b1, b2, b3);
		root2.getChildren().addAll(img, lb);
		root.add(root1, 0, 0);
		root.add(root2, 1, 0);

		Scene scene = new Scene(root, 600, 600);

		GridPane info = new GridPane(); // a grid pane which has the scene of options related to the customers after the
										// customer button is pressed
		info.setAlignment(Pos.CENTER);
		info.setHgap(15);
		info.setVgap(15);

		Button cust1 = new Button("Add new Customer");
		Button cust2 = new Button("Delete Customer");
		Button cust3 = new Button("Update Information about Customer");
		Button cust4 = new Button("Search a Customer by Id");
		Button cust5 = new Button("Return to main page");

		info.add(cust1, 3, 0);
		info.add(cust2, 3, 1);
		info.add(cust3, 3, 2);
		info.add(cust4, 3, 3);
		info.add(cust5, 3, 4);

		cust5.setOnAction(e -> {
			primaryStage.setScene(scene);
		});

		Scene scene1 = new Scene(info, 600, 600);

		b1.setOnAction(e -> {
			primaryStage.setScene(scene1);
		});

		GridPane info1 = new GridPane(); // a grid pane which has the scene of options related to the media after the
											// media button is pressed
		info1.setAlignment(Pos.CENTER);
		info1.setHgap(15);
		info1.setVgap(15);

		Button media1 = new Button("Add new Media");
		Button media2 = new Button("Delete Media");
		Button media3 = new Button("Update Information about Media");
		Button media4 = new Button("Search a Media by Code");
		Button media5 = new Button("Print All Media Information");
		Button media6 = new Button("Return to Main Page");

		info1.add(media1, 3, 0);
		info1.add(media2, 3, 1);
		info1.add(media3, 3, 2);
		info1.add(media4, 3, 3);
		info1.add(media5, 3, 4);
		info1.add(media6, 3, 5);

		media6.setOnAction(e -> {
			primaryStage.setScene(scene);
		});
		Scene scene2 = new Scene(info1, 600, 600);

		b2.setOnAction(e -> {
			primaryStage.setScene(scene2);
		});

		GridPane r = new GridPane(); // a grid pane to add the customer to the customer database by pressing the add
										// button
		r.setHgap(15);
		r.setVgap(15);
		r.setAlignment(Pos.CENTER);

		ImageView addIcon = new ImageView("https://img.icons8.com/fluency/344/add.png");
		addIcon.setFitHeight(10);
		addIcon.setFitWidth(10);
		ImageView backIcon = new ImageView(
				"https://img.icons8.com/external-dreamstale-lineal-dreamstale/344/external-back-left-arrows-dreamstale-lineal-dreamstale.png");
		backIcon.setFitHeight(20);
		backIcon.setFitWidth(20);
		Button add = new Button("Add", addIcon);
		Button back = new Button("Back", backIcon);

		Label lb1 = new Label("Customer ID:");
		Label lb2 = new Label("Customer Name:");
		Label lb3 = new Label("Customer Address:");
		Label lb4 = new Label("Customer Mobile:");
		Label lb5 = new Label("Customer Plan");

		TextField txf1 = new TextField("901211212");
		TextField txf2 = new TextField();
		TextField txf3 = new TextField();
		TextField txf4 = new TextField();
		TextField txf5 = new TextField();

		// setting the text fields to be disabled
		txf2.setDisable(true);
		txf3.setDisable(true);
		txf4.setDisable(true);
		txf5.setDisable(true);

		// the text fields will always be disabled unless the previous one is typed on
		txf1.setOnKeyPressed(e -> {
			txf2.setDisable(false);
		});
		txf2.setOnKeyPressed(e -> {
			txf3.setDisable(false);
		});
		txf3.setOnKeyPressed(e -> {
			txf4.setDisable(false);
		});
		txf4.setOnKeyTyped(e -> {
			txf5.setDisable(false);
		});

		r.addRow(0, lb1, txf1);
		r.addRow(1, lb2, txf2);
		r.addRow(2, lb3, txf3);
		r.addRow(3, lb4, txf4);
		r.addRow(4, lb5, txf5);
		r.add(add, 1, 5);
		r.add(back, 2, 5);

		add.setOnAction(e -> { // setting the add button to add a specific customer when pressed
			String id = txf1.getText();
			String name = txf2.getText();
			String address = txf3.getText();
			String mobile = txf4.getText();
			String plan = txf5.getText();
			if (idRepeated(id, c)) { // if the id is repeated then another id value should be entered
				System.out.println("This id already exists try again!");
				txf1.clear();
			}
			id = txf1.getText();
			m.addCustomer(name, address, plan, id, mobile); // calling the adding method from the media rental manager
															// class
			System.out.println(m.getAllCustomersInfo());
		});

		Scene scene3 = new Scene(r, 600, 600);
		cust1.setOnAction(e -> {
			primaryStage.setScene(scene3);
		});
		back.setOnAction(e -> { // setting the back button to go to the previous scene
			primaryStage.setScene(scene1);
		});

		GridPane r1 = new GridPane(); // a grid pane to add the media (movie, album, or game) to the database by
										// pressing the add button
		r1.setHgap(15);
		r1.setVgap(15);
		r1.setAlignment(Pos.CENTER);

		ImageView addIcon1 = new ImageView("https://img.icons8.com/fluency/344/add.png");
		addIcon1.setFitHeight(20);
		addIcon1.setFitWidth(20);
		ImageView backIcon1 = new ImageView(
				"https://img.icons8.com/external-dreamstale-lineal-dreamstale/344/external-back-left-arrows-dreamstale-lineal-dreamstale.png");
		backIcon1.setFitHeight(20);
		backIcon1.setFitWidth(20);
		Button add1 = new Button("Add", addIcon1);
		Button back1 = new Button("Back", backIcon1);

		Label lb6 = new Label("Media Title:");
		Label lb7 = new Label("Media Number of Copies:");
		Label lb8 = new Label("Media Rating:");
		Label lb9 = new Label("Weight:");
		Label lb10 = new Label("Media Artist:");
		Label lb11 = new Label("Media Song:");
		Label lb12 = new Label("Code:");

		TextField txf6 = new TextField();
		TextField txf7 = new TextField();
		TextField txf8 = new TextField();
		TextField txf9 = new TextField();
		TextField txf10 = new TextField();
		TextField txf11 = new TextField();
		TextField txf12 = new TextField();

		ComboBox<String> comboBox = new ComboBox<>(); // a combo box related to each kind of the media
		comboBox.setPromptText("Media Types");
		comboBox.getItems().addAll("Album", "Movie", "Game");

		r1.addRow(0, lb6, txf6);
		r1.addRow(1, lb7, txf7);
		r1.addRow(2, lb8, txf8);
		r1.addRow(3, lb9, txf9);
		r1.addRow(4, lb10, txf10);
		r1.addRow(5, lb11, txf11);
		r1.addRow(6, lb12, txf12);
		r1.add(add1, 1, 7);
		r1.add(back1, 2, 7);
		r1.add(comboBox, 2, 0);

		add1.setOnAction(e -> { // setting the button to add the media to the database and using the combo box
								// to determine what kind of media is being added
			try {
				if (comboBox.getValue().equalsIgnoreCase("movie")) {
					String title = txf6.getText();
					int numOfCopies = Integer.parseInt(txf7.getText());
					String rating = txf8.getText();
					String code = txf12.getText();
					m.addMovie(title, numOfCopies, rating, code);
					System.out.println(m.getAllMediaInfo());

				} else if (comboBox.getValue().equalsIgnoreCase("album")) {
					String title = txf6.getText();
					int numOfCopies = Integer.parseInt(txf7.getText());
					String artist = txf10.getText();
					String song = txf11.getText();
					String code = txf12.getText();
					m.addAlbum(title, numOfCopies, artist, song, code);
					System.out.println(m.getAllMediaInfo());

				} else if (comboBox.getValue().equalsIgnoreCase("game")) {
					String title = txf6.getText();
					int numOfCopies = Integer.parseInt(txf7.getText());
					Double weight = Double.parseDouble(txf9.getText());
					String code = txf12.getText();
					m.addGame(title, numOfCopies, weight, code);
					System.out.println(m.getAllMediaInfo());
				}
			} catch (NullPointerException k) { // if the user doesn't enter a type in the combo box then this sentence
												// is displayed until a type is chosen
				System.out.println("Media type is not known please select a type");
			}
		});

		Scene scene4 = new Scene(r1, 600, 600);
		media1.setOnAction(e -> {
			primaryStage.setScene(scene4);
		});
		back1.setOnAction(e -> {
			primaryStage.setScene(scene2);
		});
		// calling the methods made related to each button that was made
		deleteCustomer(primaryStage, cust2, c);
		updateInfo(primaryStage, cust3, c);
		searchCustomer(primaryStage, cust4, c);
		deleteMedia(primaryStage, media2, med);
		updateMedia(primaryStage, media3, med);
		searchMedia(primaryStage, media4, med);
		printMediaInfo(primaryStage, media5, med);
		rent(primaryStage, b3, c, med);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

	private void deleteCustomer(Stage primaryStage, Button cust2, ArrayList<Customer> c) { // a method to delete a
																							// customer from the
																							// customer
		// database by pressing the button

		MediaRentalManager m = new MediaRentalManager();
		GridPane root = new GridPane();
		root.setHgap(15);
		root.setVgap(15);
		root.setAlignment(Pos.CENTER);

		ImageView deleteIcon = new ImageView("https://img.icons8.com/carbon-copy/344/filled-trash.png");
		deleteIcon.setFitHeight(20);
		deleteIcon.setFitWidth(20);
		ImageView findIcon = new ImageView(
				"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-find-hotel-kiranshastry-gradient-kiranshastry.png");
		findIcon.setFitHeight(20);
		findIcon.setFitWidth(20);
		ImageView backIcon = new ImageView(
				"https://img.icons8.com/external-dreamstale-lineal-dreamstale/344/external-back-left-arrows-dreamstale-lineal-dreamstale.png");
		backIcon.setFitHeight(20);
		backIcon.setFitWidth(20);
		Button back = new Button("Back", backIcon);
		Button find = new Button("Find", findIcon);
		Button delete = new Button("Delete", deleteIcon);

		Label lb1 = new Label("Customer ID:");
		Label lb2 = new Label("Customer Name:");
		Label lb3 = new Label("Customer Address:");
		Label lb4 = new Label("Customer Mobile:");
		Label lb5 = new Label("Customer Plan:");

		TextField txf1 = new TextField("901211212");
		TextField txf2 = new TextField();
		TextField txf3 = new TextField();
		TextField txf4 = new TextField();
		TextField txf5 = new TextField();

		txf2.setDisable(true);
		txf3.setDisable(true);
		txf4.setDisable(true);
		txf5.setDisable(true);

		txf1.setOnKeyPressed(e -> {
			txf2.setDisable(false);
		});
		txf2.setOnKeyPressed(e -> {
			txf3.setDisable(false);
		});
		txf3.setOnKeyPressed(e -> {
			txf4.setDisable(false);
		});
		txf4.setOnKeyTyped(e -> {
			txf5.setDisable(false);
		});

		root.addRow(0, lb1, txf1);
		root.addRow(1, lb2, txf2);
		root.addRow(2, lb3, txf3);
		root.addRow(3, lb4, txf4);
		root.addRow(4, lb5, txf5);
		root.add(find, 0, 5);
		root.add(delete, 1, 5);
		root.add(back, 2, 5);

		Scene scene = new Scene(root, 600, 600);
		cust2.setOnAction(e -> {
			primaryStage.setScene(scene);
		});
		find.setOnAction(e -> { // setting the button to search for a specific student based on the id and
								// printing the information
			String id = txf1.getText();
			Customer cust = m.findCustomer(id, c);
			if (cust != null) {
				System.out.println(cust.toString());
			} else
				System.out.println("Customer does not exist in the database");
		});
		delete.setOnAction(e -> { // setting the button to delete a customer based on the information applied

			String id = txf1.getText();
			if (m.deleteCustomer(id, c)) {
				System.out.println("Customer is removed successfully");
			} else
				System.out.println("Customer id not found");
		});
		back.setOnAction(e -> {
			primaryStage.setScene(cust2.getScene());
		});
	}

	private void updateInfo(Stage primaryStage, Button cust3, ArrayList<Customer> c) {// a method to update the
																						// information of a specific
		// customer

		MediaRentalManager m = new MediaRentalManager();
		GridPane root = new GridPane();
		root.setHgap(15);
		root.setVgap(15);
		root.setAlignment(Pos.CENTER);

		ImageView findIcon = new ImageView(
				"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-find-hotel-kiranshastry-gradient-kiranshastry.png");
		findIcon.setFitHeight(20);
		findIcon.setFitWidth(20);
		ImageView backIcon = new ImageView(
				"https://img.icons8.com/external-dreamstale-lineal-dreamstale/344/external-back-left-arrows-dreamstale-lineal-dreamstale.png");
		backIcon.setFitHeight(20);
		backIcon.setFitWidth(20);
		ImageView updateIcon = new ImageView("https://img.icons8.com/ios/344/approve-and-update.png");
		updateIcon.setFitHeight(20);
		updateIcon.setFitWidth(20);
		Button back = new Button("Back", backIcon);
		Button find = new Button("Find", findIcon);
		Button update = new Button("Update", updateIcon);

		Label lb1 = new Label("Customer ID:");
		Label lb2 = new Label("Customer Name:");
		Label lb3 = new Label("Customer Address:");
		Label lb4 = new Label("Customer Mobile:");
		Label lb5 = new Label("Customer Plan:");

		TextField txf1 = new TextField("901211212");
		TextField txf2 = new TextField();
		TextField txf3 = new TextField();
		TextField txf4 = new TextField();
		TextField txf5 = new TextField();

		txf2.setDisable(true);
		txf3.setDisable(true);
		txf4.setDisable(true);
		txf5.setDisable(true);

		txf1.setOnKeyPressed(e -> {
			txf2.setDisable(false);
		});
		txf2.setOnKeyPressed(e -> {
			txf3.setDisable(false);
		});
		txf3.setOnKeyPressed(e -> {
			txf4.setDisable(false);
		});
		txf4.setOnKeyTyped(e -> {
			txf5.setDisable(false);
		});

		root.addRow(0, lb1, txf1);
		root.addRow(1, lb2, txf2);
		root.addRow(2, lb3, txf3);
		root.addRow(3, lb4, txf4);
		root.addRow(4, lb5, txf5);
		root.add(find, 0, 5);
		root.add(update, 1, 5);
		root.add(back, 2, 5);

		Scene scene = new Scene(root, 600, 600);
		cust3.setOnAction(e -> {
			primaryStage.setScene(scene);

		});
		find.setOnAction(e -> {
			String id = txf1.getText();
			Customer cust = m.findCustomer(id, c);
			if (cust != null)
				System.out.println(cust.toString());
			else
				System.out.println("Customer does not exist in the database");
		});
		update.setOnAction(e -> { // setting the button to update the whole information of a customer by declaring
									// the update method from media rental manager
			String id = txf1.getText();
			String name = txf2.getText();
			String address = txf3.getText();
			String mobile = txf4.getText();
			String plan = txf5.getText();
			System.out.println(m.updateCustomer(name, address, plan, id, mobile, c));
		});
		back.setOnAction(e -> {
			primaryStage.setScene(cust3.getScene());
		});

	}

	private void searchCustomer(Stage primaryStage, Button cust4, ArrayList<Customer> c) {// a method to search for a
																							// specific customer based
		// on the id by pressing a button

		MediaRentalManager m = new MediaRentalManager();
		GridPane root = new GridPane();
		root.setHgap(15);
		root.setVgap(15);
		root.setAlignment(Pos.CENTER);
		Label lb1 = new Label("Customer ID:");

		ImageView backIcon = new ImageView(
				"https://img.icons8.com/external-dreamstale-lineal-dreamstale/344/external-back-left-arrows-dreamstale-lineal-dreamstale.png");
		backIcon.setFitHeight(20);
		backIcon.setFitWidth(20);
		ImageView findIcon = new ImageView(
				"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-find-hotel-kiranshastry-gradient-kiranshastry.png");
		findIcon.setFitHeight(20);
		findIcon.setFitWidth(20);
		Button back = new Button("Back", backIcon);
		Button find = new Button("Find", findIcon);

		TextField txf1 = new TextField();

		root.addRow(0, lb1, txf1);
		root.add(find, 1, 3);
		root.add(back, 2, 3);

		Scene scene = new Scene(root, 600, 600);
		cust4.setOnAction(e -> {
			primaryStage.setScene(scene);
		});
		find.setOnAction(e -> { // setting a button to search for a customer based on the id given in the text
								// and display the information
			String id = txf1.getText();
			Customer cust = m.findCustomer(id, c);
			if (cust != null)
				System.out.println(cust.toString());
			else
				System.out.println("Customer does not exist in the database");
		});
		back.setOnAction(e -> {
			primaryStage.setScene(cust4.getScene());
		});

	}

	private void deleteMedia(Stage primaryStage, Button media2, ArrayList<Media> med) { // a method to delete a certain
																						// media type from the
		// media database

		MediaRentalManager m = new MediaRentalManager();
		GridPane root = new GridPane();
		root.setHgap(15);
		root.setVgap(15);
		root.setAlignment(Pos.CENTER);

		ImageView deleteIcon = new ImageView("https://img.icons8.com/carbon-copy/344/filled-trash.png");
		deleteIcon.setFitHeight(20);
		deleteIcon.setFitWidth(20);
		ImageView backIcon = new ImageView(
				"https://img.icons8.com/external-dreamstale-lineal-dreamstale/344/external-back-left-arrows-dreamstale-lineal-dreamstale.png");
		backIcon.setFitHeight(20);
		backIcon.setFitWidth(20);
		Button delete = new Button("Delete", deleteIcon);
		Button back = new Button("Back", backIcon);

		Label lb1 = new Label("Media Title:");
		Label lb2 = new Label("Media Number of Copies");
		Label lb3 = new Label("Media Rating");
		Label lb4 = new Label("Weight");
		Label lb5 = new Label("Media Artist");
		Label lb6 = new Label("Media Song");
		Label lb7 = new Label("Media Code");

		TextField txf1 = new TextField();
		TextField txf2 = new TextField();
		TextField txf3 = new TextField();
		TextField txf4 = new TextField();
		TextField txf5 = new TextField();
		TextField txf6 = new TextField();
		TextField txf7 = new TextField();

		ComboBox<String> comboBox = new ComboBox<>(); // a combo box to chose which type of media to delete from the
														// database
		comboBox.setPromptText("Media Types");
		comboBox.getItems().addAll("Album", "Movie", "Game");

		root.addRow(0, lb1, txf1);
		root.addRow(1, lb2, txf2);
		root.addRow(2, lb3, txf3);
		root.addRow(3, lb4, txf4);
		root.addRow(4, lb5, txf5);
		root.addRow(5, lb6, txf6);
		root.addRow(6, lb7, txf7);
		root.add(delete, 1, 8);
		root.add(back, 2, 8);
		root.add(comboBox, 2, 0);

		delete.setOnAction(e -> { // setting the button to delete the media based on each type using the combo box
									// to determine which kind is being deleted

			try {
				if (comboBox.getValue().equalsIgnoreCase("movie")) {
					String code = txf7.getText();
					if (m.removeMovie(code, med)) {
						System.out.println("Movie is removed successfully");
					} else
						System.out.println("Movie not found");

				} else if (comboBox.getValue().equalsIgnoreCase("album")) {
					String code = txf7.getText();
					if (m.removeAlbum(code, med)) {
						System.out.println("Album is removed successfully");
					} else
						System.out.println("Album not found");

				} else if (comboBox.getValue().equalsIgnoreCase("game")) {
					String code = txf7.getText();
					if (m.removeGame(code, med)) {
						System.out.println("Game is removed successfully");
					} else
						System.out.println("Game not found");

				}
			} catch (NullPointerException r) {
				System.out.println("Media type is not known please select a type");
			}
		});
		Scene scene = new Scene(root, 600, 600);
		media2.setOnAction(e -> {
			primaryStage.setScene(scene);
		});
		back.setOnAction(e -> {
			primaryStage.setScene(media2.getScene());
		});
	}

	private void updateMedia(Stage primaryStage, Button media3, ArrayList<Media> med) { // a method to update the
																						// information of a certain
		// media by pressing a button

		MediaRentalManager m = new MediaRentalManager();
		GridPane root = new GridPane();
		root.setHgap(15);
		root.setVgap(15);
		root.setAlignment(Pos.CENTER);

		ImageView findIcon = new ImageView(
				"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-find-hotel-kiranshastry-gradient-kiranshastry.png");
		findIcon.setFitHeight(20);
		findIcon.setFitWidth(20);
		ImageView backIcon = new ImageView(
				"https://img.icons8.com/external-dreamstale-lineal-dreamstale/344/external-back-left-arrows-dreamstale-lineal-dreamstale.png");
		backIcon.setFitHeight(20);
		backIcon.setFitWidth(20);
		ImageView updateIcon = new ImageView("https://img.icons8.com/ios/344/approve-and-update.png");
		updateIcon.setFitHeight(20);
		updateIcon.setFitWidth(20);
		Button find = new Button("Find", findIcon);
		Button update = new Button("Update", updateIcon);
		Button back = new Button("Back", backIcon);

		Label lb1 = new Label("Media Title:");
		Label lb2 = new Label("Media Number of Copies");
		Label lb3 = new Label("Media Rating");
		Label lb4 = new Label("Weight");
		Label lb5 = new Label("Media Artist");
		Label lb6 = new Label("Media Song");
		Label lb7 = new Label("Media Code");

		TextField txf1 = new TextField();
		TextField txf2 = new TextField();
		TextField txf3 = new TextField();
		TextField txf4 = new TextField();
		TextField txf5 = new TextField();
		TextField txf6 = new TextField();
		TextField txf7 = new TextField();

		ComboBox<String> comboBox = new ComboBox<>();
		comboBox.setPromptText("Media Types");
		comboBox.getItems().addAll("Album", "Movie", "Game");

		root.addRow(0, lb1, txf1);
		root.addRow(1, lb2, txf2);
		root.addRow(2, lb3, txf3);
		root.addRow(3, lb4, txf4);
		root.addRow(4, lb5, txf5);
		root.addRow(5, lb6, txf6);
		root.addRow(6, lb7, txf7);
		root.add(find, 1, 7);
		root.add(update, 2, 7);
		root.add(back, 3, 7);
		root.add(comboBox, 2, 0);

		update.setOnAction(e -> { // setting the button to update the information of the media by determining the
									// type using the combo box
			try {
				if (comboBox.getValue().equalsIgnoreCase("movie")) {
					String title = txf1.getText();
					int numOfCopies = Integer.parseInt(txf2.getText());
					String rating = txf3.getText();
					String code = txf7.getText();
					Media media = m.findMedia(code, med);
					if (media != null && media instanceof Movie) {
						Movie mov = new Movie();
						mov.setCode(code);
						mov.setNumberOfCopies(numOfCopies);
						mov.setRating(rating);
						mov.setTitle(title);
						System.out.println(mov.toString());
					}
				}
				if (comboBox.getValue().equalsIgnoreCase("album")) {
					String title = txf1.getText();
					int numOfCopies = Integer.parseInt(txf2.getText());
					String song = txf6.getText();
					String artist = txf5.getText();
					String code = txf7.getText();
					Media media = m.findMedia(code, med);
					if (media != null && media instanceof Album) {
						Album alb = new Album();
						alb.setArtistName(artist);
						alb.setCode(code);
						alb.setNumberOfCopies(numOfCopies);
						alb.setSongs(song);
						alb.setTitle(title);
						System.out.println(alb.toString());
					}
				}
				if (comboBox.getValue().equalsIgnoreCase("game")) {
					String title = txf1.getText();
					int numOfCopies = Integer.parseInt(txf2.getText());
					String code = txf7.getText();
					double weight = Double.parseDouble(txf4.getText());
					Media media = m.findMedia(code, med);
					if (media != null && media instanceof Game) {
						Game gm = new Game();
						gm.setCode(code);
						gm.setNumberOfCopies(numOfCopies);
						gm.setTitle(title);
						gm.setWeight(weight);
						System.out.println(gm.toString());
					}
				}
			} catch (NullPointerException r) {
				System.out.println("Media type is not known please select a type");
			}
		});
		Scene scene = new Scene(root, 600, 600);
		media3.setOnAction(e -> {
			primaryStage.setScene(scene);
		});
		find.setOnAction(e -> { // setting the button to search for a specific media type depending on the code

			try {
				if (comboBox.getValue().equalsIgnoreCase("movie")) {
					String code = txf7.getText();
					Media media = m.findMedia(code, med);
					if (media instanceof Movie && media != null) {
						System.out.println(media.toString());
					} else
						System.out.println("Media not found");
				} else if (comboBox.getValue().equalsIgnoreCase("album")) {
					String code = txf7.getText();
					Media media = m.findMedia(code, med);
					if (media instanceof Album && media != null) {
						System.out.println(media.toString());
					} else
						System.out.println("Media not found");
				} else if (comboBox.getValue().equalsIgnoreCase("game")) {
					String code = txf7.getText();
					Media media = m.findMedia(code, med);
					if (media instanceof Game && media != null) {
						System.out.println(media.toString());
					}
				}
			} catch (NullPointerException r) {
				System.out.println("Media type is not known please select a type");
			}
		});
		back.setOnAction(e -> {
			primaryStage.setScene(media3.getScene());
		});
	}

	private void searchMedia(Stage primaryStage, Button media4, ArrayList<Media> med) { // a method to search for a
																						// specific media using the
		// code given from the text field by pressing the
		// button

		MediaRentalManager m = new MediaRentalManager();
		GridPane root = new GridPane();
		root.setHgap(15);
		root.setVgap(15);
		root.setAlignment(Pos.CENTER);

		ImageView findIcon = new ImageView(
				"https://img.icons8.com/external-kiranshastry-gradient-kiranshastry/344/external-find-hotel-kiranshastry-gradient-kiranshastry.png");
		findIcon.setFitHeight(20);
		findIcon.setFitWidth(20);
		ImageView backIcon = new ImageView(
				"https://img.icons8.com/external-dreamstale-lineal-dreamstale/344/external-back-left-arrows-dreamstale-lineal-dreamstale.png");
		backIcon.setFitHeight(20);
		backIcon.setFitWidth(20);
		Button find = new Button("Find", findIcon);
		Button back = new Button("Back", backIcon);

		Label lb1 = new Label("Media Code");

		TextField txf1 = new TextField();

		ComboBox<String> comboBox = new ComboBox<>();
		comboBox.setPromptText("Media Types");
		comboBox.getItems().addAll("Album", "Movie", "Game");

		root.addRow(0, lb1, txf1);

		root.add(find, 1, 5);
		root.add(back, 2, 5);
		root.add(comboBox, 2, 0);

		Scene scene = new Scene(root, 600, 600);
		media4.setOnAction(e -> {
			primaryStage.setScene(scene);
		});
		find.setOnAction(e -> { // the find button to display the information of a certain media found by the
								// code
			try {
				if (comboBox.getValue().equalsIgnoreCase("movie")) {
					String code = txf1.getText();
					Media media = m.findMedia(code, med);
					if (media instanceof Movie && media != null) {
						System.out.println(media.toString());
					} else
						System.out.println("Media not found");
				} else if (comboBox.getValue().equalsIgnoreCase("album")) {
					String code = txf1.getText();
					Media media = m.findMedia(code, med);
					if (media instanceof Album && media != null) {
						System.out.println(media.toString());
					} else
						System.out.println("Media not found");
				} else if (comboBox.getValue().equalsIgnoreCase("game")) {
					String code = txf1.getText();
					Media media = m.findMedia(code, med);
					if (media instanceof Game && media != null) {
						System.out.println(media.toString());
					}
				}
			} catch (NullPointerException r) {
				System.out.println("Media type is not known please select a type");
			}
		});

		back.setOnAction(e -> {
			primaryStage.setScene(media4.getScene());
		});

	}

	private void printMediaInfo(Stage primaryStage, Button media5, ArrayList<Media> med) { // a method to display all
																							// the media information by
																							// pressing the button
		media5.setOnAction(e -> {
			String d = "Media Information: " + "\n";
			for (int i = 0; i < med.size(); i++) {
				d = d + med.get(i).toString() + "\n";
			}
			System.out.println(d);
		});

	}

	private void rent(Stage primaryStage, Button b3, ArrayList<Customer> c, ArrayList<Media> med) { // a method to rent
																									// the media added
																									// to the cart for a
																									// certain customer
																									// and processing
																									// the requests
																									// based on their
																									// plans and by
																									// pressing certain
																									// buttons

		MediaRentalManager m = new MediaRentalManager();
		GridPane root = new GridPane();
		root.setHgap(15);
		root.setVgap(15);
		root.setAlignment(Pos.CENTER);

		ImageView backIcon = new ImageView(
				"https://img.icons8.com/external-dreamstale-lineal-dreamstale/344/external-back-left-arrows-dreamstale-lineal-dreamstale.png");
		backIcon.setFitHeight(20);
		backIcon.setFitWidth(20);
		Button rent = new Button("Process Cart");
		Button back = new Button("Back", backIcon);
		Button addToCart = new Button("Add to Cart");

		Label lb1 = new Label("Customer ID:");
		Label lb2 = new Label("Media Code:");
		Label lb3 = new Label("Rented Date:");

		TextField txf1 = new TextField();
		TextField txf2 = new TextField();
		TextField txf3 = new TextField();

		GridPane r = new GridPane();
		r.addRow(0, lb1, txf1);
		r.setHgap(20);
		GridPane r1 = new GridPane();
		r1.addRow(0, lb2, txf2);
		r1.setHgap(20);
		GridPane r2 = new GridPane();
		r2.addRow(0, lb3, txf3);
		r2.setHgap(20);

		TextArea ta1 = new TextArea();
		TextArea ta2 = new TextArea();
		TextArea ta3 = new TextArea();

		root.add(r, 0, 0);
		root.add(r1, 0, 3);
		root.addRow(2, ta1);
		root.addRow(4, ta2);
		root.addRow(5, r2);
		root.addRow(6, ta3);
		root.add(addToCart, 0, 7);
		root.add(rent, 1, 7);
		root.add(back, 4, 7);

		Scene scene = new Scene(root, 600, 600);
		b3.setOnAction(e -> {
			primaryStage.setScene(scene);
		});

		addToCart.setOnAction(e -> { // setting the button to add a media to the requests database of each customer
			String id = txf1.getText();
			String code = txf2.getText();
			if (m.addToCart(id, code, c, med)) {
				for (int i = 0; i < c.size(); i++) {
					if (c.get(i).getId().equals(id)) {
						ta1.setText(c.get(i).toString());
					}
				}
				for (int i = 0; i < med.size(); i++) {
					if (med.get(i).getCode().equals(code)) {
						ta2.setText(med.get(i).toString());
					}
				}
			}

		});

		rent.setOnAction(e -> { // setting the button to process the requests of each customer and displaying
								// their requests

			Date date = new Date(Integer.parseInt(txf3.getText()));
			ta3.setText(m.processRequestsOne(c, med) + " at " + date.toString());
		});

		back.setOnAction(e -> {
			primaryStage.setScene(b3.getScene());
		});
	}

	public boolean idRepeated(String id, ArrayList<Customer> cust) { // a method to make the id of each customer unique

		if (cust == null)
			return false;
		else {
			for (int i = 0; i < cust.size(); i++) {
				Customer c = cust.get(i);
				if (c.getId().toLowerCase().equals(id.toLowerCase()))
					return true;
			}
			return false;

		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}