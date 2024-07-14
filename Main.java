package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(15);
		root.setVgap(15);
		Button b1 = new Button("Customer");
		Button b2 = new Button("Media");
		Button b3 = new Button("Rent");

		ImageView img = new ImageView("rent.jpg");
		img.setFitHeight(200);
		img.setFitWidth(200);

		root.addRow(1, b1);
		root.addRow(2, b2);
		root.addRow(3, b3);
		root.add(img, 3, 4);

		Scene scene = new Scene(root, 400, 400);

		GridPane info = new GridPane();
		info.setAlignment(Pos.CENTER);
		info.setHgap(15);
		info.setVgap(15);

		Button cust1 = new Button("Add new Customer");
		Button cust2 = new Button("Delete Customer");
		Button cust3 = new Button("Update Information about Customer");
		Button cust4 = new Button("Search a Customer by id");
		Button cust5 = new Button("Return to main page");

		info.add(cust1, 3, 0);
		info.add(cust2, 3, 1);
		info.add(cust3, 3, 2);
		info.add(cust4, 3, 3);
		info.add(cust5, 3, 4);

		cust5.setOnAction(e -> {
			primaryStage.setScene(scene);
		});

		Scene scene1 = new Scene(info, 400, 400);

		b1.setOnAction(e -> {
			primaryStage.setScene(scene1);
		});

		GridPane info1 = new GridPane();
		info1.setAlignment(Pos.CENTER);
		info1.setHgap(15);
		info1.setVgap(15);

		Button cust6 = new Button("Add new Media");
		Button cust7 = new Button("Delete Media");
		Button cust8 = new Button("Update Information about Media");
		Button cust9 = new Button("Search a Media by Code");
		Button cust10 = new Button("Print All Media Information");
		Button cust11 = new Button("Print All Media Information");

		info1.add(cust6, 3, 0);
		info1.add(cust7, 3, 1);
		info1.add(cust8, 3, 2);
		info1.add(cust9, 3, 3);
		info1.add(cust10, 3, 4);
		info1.add(cust11, 3, 5);

		Scene scene2 = new Scene(info1, 400, 400);

		b2.setOnAction(e -> {
			primaryStage.setScene(scene2);
		});

		addCustomer(primaryStage, cust1);
		deleteCustomer(primaryStage, cust2);
		updateInfo(primaryStage, cust3);
		searchCustomer(primaryStage, cust4);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

	private void addCustomer(Stage primaryStage, Button cust1) {

		GridPane root = new GridPane();
		root.setHgap(15);
		root.setVgap(15);
		root.setAlignment(Pos.CENTER);

		ImageView addIcon = new ImageView("https://img.icons8.com/fluency/344/add.png");
		addIcon.setFitHeight(20);
		addIcon.setFitWidth(20);
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

		TextField txf1 = new TextField("901211212");
		TextField txf2 = new TextField();
		TextField txf3 = new TextField();
		TextField txf4 = new TextField();
		txf2.setDisable(true);
		txf3.setDisable(true);
		txf4.setDisable(true);

		txf1.setOnKeyPressed(e -> {
			txf2.setDisable(false);
		});
		txf2.setOnKeyPressed(e -> {
			txf3.setDisable(false);
		});
		txf3.setOnKeyPressed(e -> {
			txf4.setDisable(false);
		});

		root.addRow(0, lb1, txf1);
		root.addRow(1, lb2, txf2);
		root.addRow(2, lb3, txf3);
		root.addRow(3, lb4, txf4);
		root.add(add, 1, 4);
		root.add(back, 2, 4);

		Scene scene = new Scene(root, 500, 500);
		cust1.setOnAction(e -> {
			primaryStage.setScene(scene);
		});
		back.setOnAction(e -> {
			primaryStage.setScene(cust1.getScene());
		});

	}

	private void deleteCustomer(Stage primaryStage, Button cust2) {

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

		TextField txf1 = new TextField("901211212");
		TextField txf2 = new TextField();
		TextField txf3 = new TextField();
		TextField txf4 = new TextField();
		txf2.setDisable(true);
		txf3.setDisable(true);
		txf4.setDisable(true);

		txf1.setOnKeyPressed(e -> {
			txf2.setDisable(false);
		});
		txf2.setOnKeyPressed(e -> {
			txf3.setDisable(false);
		});
		txf3.setOnKeyPressed(e -> {
			txf4.setDisable(false);
		});

		root.addRow(0, lb1, txf1);
		root.addRow(1, lb2, txf2);
		root.addRow(2, lb3, txf3);
		root.addRow(3, lb4, txf4);
		root.add(find, 0, 4);
		root.add(delete, 1, 4);
		root.add(back, 2, 4);

		Scene scene = new Scene(root, 500, 500);
		cust2.setOnAction(e -> {
			primaryStage.setScene(scene);
		});
		back.setOnAction(e -> {
			primaryStage.setScene(cust2.getScene());
		});

	}

	private void updateInfo(Stage primaryStage, Button cust3) {

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

		TextField txf1 = new TextField("901211212");
		TextField txf2 = new TextField();
		TextField txf3 = new TextField();
		TextField txf4 = new TextField();
		txf2.setDisable(true);
		txf3.setDisable(true);
		txf4.setDisable(true);

		txf1.setOnKeyPressed(e -> {
			txf2.setDisable(false);
		});
		txf2.setOnKeyPressed(e -> {
			txf3.setDisable(false);
		});
		txf3.setOnKeyPressed(e -> {
			txf4.setDisable(false);
		});

		root.addRow(0, lb1, txf1);
		root.addRow(1, lb2, txf2);
		root.addRow(2, lb3, txf3);
		root.addRow(3, lb4, txf4);
		root.add(find, 0, 4);
		root.add(update, 1, 4);
		root.add(back, 2, 4);

		Scene scene = new Scene(root, 500, 500);
		cust3.setOnAction(e -> {
			primaryStage.setScene(scene);

		});
		back.setOnAction(e -> {
			primaryStage.setScene(cust3.getScene());
		});

	}

	private void searchCustomer(Stage primaryStage, Button cust4) {

		GridPane root = new GridPane();
		root.setHgap(15);
		root.setVgap(15);
		root.setAlignment(Pos.CENTER);
		Label lb1 = new Label("Customer ID:");
		Label lb2 = new Label("Customer Name:");
		Label lb3 = new Label("Customer Address:");
		Label lb4 = new Label("Customer Mobile:");

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

		TextField txf1 = new TextField("901211212");
		TextField txf2 = new TextField();
		TextField txf3 = new TextField();
		TextField txf4 = new TextField();
		txf2.setDisable(true);
		txf3.setDisable(true);
		txf4.setDisable(true);

		txf1.setOnKeyPressed(e -> {
			txf2.setDisable(false);
		});
		txf2.setOnKeyPressed(e -> {
			txf3.setDisable(false);
		});
		txf3.setOnKeyPressed(e -> {
			txf4.setDisable(false);
		});

		root.addRow(0, lb1, txf1);
		root.addRow(1, lb2, txf2);
		root.addRow(2, lb3, txf3);
		root.addRow(3, lb4, txf4);
		root.add(find, 1, 4);
		root.add(back, 2, 4);

		Scene scene = new Scene(root, 500, 500);
		cust4.setOnAction(e -> {
			primaryStage.setScene(scene);

		});
		back.setOnAction(e -> {
			primaryStage.setScene(cust4.getScene());
		});

	}

	public static void main(String[] args) {
		launch(args);
	}
}
