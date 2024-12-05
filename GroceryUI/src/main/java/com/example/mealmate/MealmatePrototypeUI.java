package com.example.mealmate;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MealmatePrototypeUI extends Application {

    private static class Product {
        private String name;
        private double price;
        private int quantity;
        private String category;

        public Product(String name, double price, int quantity, String category) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.category = category;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
        public int getQuantity() { return quantity; }
        public String getCategory() { return category; }
    }


    private List<Product> productCatalog = new ArrayList<>();
    private List<Product> shoppingCart = new ArrayList<>();


    private static final double TOTAL_DELIVERY_FEE = 20.00;
    private static final int SHARED_STUDENTS = 5;
    private static final double INDIVIDUAL_DELIVERY_FEE = TOTAL_DELIVERY_FEE / SHARED_STUDENTS;

    @Override
    public void start(Stage primaryStage) {
        showLoginScreen(primaryStage);
    }

    private void showLoginScreen(Stage primaryStage) {
        VBox loginLayout = new VBox(20);
        loginLayout.setAlignment(Pos.CENTER);
        loginLayout.setPadding(new Insets(20));

        Label titleLabel = new Label("Welcome to MealMate, Login below");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField studentIdField = new TextField();
        studentIdField.setPromptText("Student ID");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");
        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        loginButton.setOnAction(e -> {
            if (authenticateUser(studentIdField.getText(), passwordField.getText())) {

                initialiseSampleData();

                showMainDashboard(primaryStage);
            } else {
                errorLabel.setText("Invalid Student ID or Password");
            }
        });

        loginLayout.getChildren().addAll(
                titleLabel,
                new Label("Student ID: (use 'admin' for username)"),
                studentIdField,
                new Label("Password: (use 'admin' for password)"),
                passwordField,
                loginButton,
                errorLabel
        );

        Scene loginScene = new Scene(loginLayout, 400, 500);
        primaryStage.setTitle("Student Grocery Store - Login");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private boolean authenticateUser(String studentId, String password) {

        return "admin".equals(studentId) && "admin".equals(password);
    }

    private void initialiseSampleData() {

        productCatalog.add(new Product("Milk", 2.50, 50, "Dairy"));
        productCatalog.add(new Product("Bread", 1.75, 30, "Bakery"));
        productCatalog.add(new Product("Eggs", 3.25, 40, "Dairy"));
        productCatalog.add(new Product("Cheese", 4.00, 25, "Dairy"));
        productCatalog.add(new Product("Yogurt", 1.50, 35, "Dairy"));


        productCatalog.add(new Product("Apples", 0.50, 100, "Fruits"));
        productCatalog.add(new Product("Bananas", 0.35, 80, "Fruits"));
        productCatalog.add(new Product("Oranges", 0.75, 60, "Fruits"));
        productCatalog.add(new Product("Chicken Breast", 5.99, 40, "Meat"));
        productCatalog.add(new Product("Minced Beef", 4.50, 35, "Meat"));
        productCatalog.add(new Product("Salmon", 8.99, 20, "Seafood"));
        productCatalog.add(new Product("Pasta", 1.25, 50, "Grains"));
        productCatalog.add(new Product("Rice", 2.25, 45, "Grains"));
        productCatalog.add(new Product("Cereal", 3.50, 40, "Breakfast"));
        productCatalog.add(new Product("Crisps", 2.00, 30, "Snacks"));
        productCatalog.add(new Product("Chocolate Bar", 1.25, 50, "Sweets"));
        productCatalog.add(new Product("Tomatoes", 0.80, 70, "Vegetables"));
        productCatalog.add(new Product("Lettuce", 1.50, 40, "Vegetables"));
        productCatalog.add(new Product("Cucumber", 0.75, 55, "Vegetables"));
        productCatalog.add(new Product("Peanut Butter", 3.25, 35, "Spreads"));
        productCatalog.add(new Product("Jam", 2.75, 40, "Spreads"));
        productCatalog.add(new Product("Olive Oil", 4.50, 25, "Cooking"));
        productCatalog.add(new Product("Salt", 1.00, 60, "Spices"));
        productCatalog.add(new Product("Pepper", 1.25, 50, "Spices"));
        productCatalog.add(new Product("Frozen Pizza", 4.99, 30, "Frozen"));
        productCatalog.add(new Product("Ice Cream", 3.75, 40, "Frozen"));
    }

    private void showMainDashboard(Stage primaryStage) {
        BorderPane mainLayout = new BorderPane();

        HBox navigationBar = new HBox(10);
        navigationBar.setAlignment(Pos.CENTER);
        navigationBar.setPadding(new Insets(10));
        navigationBar.setStyle("-fx-background-color: #f0f0f0;");

        Button searchButton = new Button("Search Products");
        Button cartButton = new Button("View Cart");
        Button infoButton = new Button("Store Information");
        Button recipeSuggestionsBtn = new Button("Recipe Suggestions");

        navigationBar.getChildren().addAll(searchButton, cartButton, infoButton, recipeSuggestionsBtn);
        mainLayout.setBottom(navigationBar);


        StackPane contentArea = new StackPane();
        mainLayout.setCenter(contentArea);


        VBox searchView = createSearchView(contentArea, primaryStage);
        VBox cartView = createCartView(contentArea);
        VBox infoView = createStoreInfoView(contentArea);
        VBox recipeSuggestionsView = createRecipeSuggestionsContent();


        contentArea.getChildren().add(searchView);


        searchButton.setOnAction(e -> {
            contentArea.getChildren().clear();
            contentArea.getChildren().add(searchView);
        });

        cartButton.setOnAction(e -> {
            contentArea.getChildren().clear();
            contentArea.getChildren().add(cartView);
            updateCartView(cartView);
        });

        infoButton.setOnAction(e -> {
            contentArea.getChildren().clear();
            contentArea.getChildren().add(infoView);
        });

        recipeSuggestionsBtn.setOnAction(e -> {
            contentArea.getChildren().clear();
            contentArea.getChildren().add(recipeSuggestionsView);
        });


        Scene mainScene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


    private VBox createRecipeSuggestionsContent() {
        VBox recipeLayout = new VBox(15);
        recipeLayout.setPadding(new Insets(20));
        recipeLayout.setStyle("-fx-background-color: #f8f9fa;");


        Label heading = new Label("Your AI Tailored Recipe Suggestions:");
        heading.setFont(Font.font("Arial", FontWeight.BOLD, 18));


        Label subheading = new Label("Based on your previous purchases, here is a selection of AMAZING recipes to try!!!");
        subheading.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        subheading.setTextFill(Color.GRAY);

        recipeLayout.getChildren().addAll(heading, subheading);

        recipeLayout.getChildren().addAll(
                createRecipeBox(
                        "Tikka Masala",
                        "Enjoy the spicy, rich flavours of tikka masala with this family-friendly lighter version that's both healthy and gluten-free. It's a guaranteed crowd-pleaser",
                        "1 hr 5 mins", "Easy", "Healthy", "Gluten-free"
                ),
                createRecipeBox(
                        "Healthy Salmon Pasta",
                        "Love salmon pasta and looking for healthy dinner inspo? Try our lighter recipe made with salmon, penne, veg and basil – it's fresh, tasty and packed with goodness",
                        "25 mins", "Easy", "Healthy"
                ),
                createRecipeBox(
                        "Healthy Pad Thai",
                        "Toss chicken with rice noodles and stir-fried veg to create a deliciously healthy dinner. There's a vegan option, too, which uses peanut butter (see tip, below)",
                        "32 mins", "Easy", "Healthy"
                ),
                createRecipeBox(
                        "Healthy Bolognese",
                        "This low-fat, low-calorie bolognese combines lean pork mince with fennel and cherry tomatoes to give a burst of fresh flavours and two of your five-a-day",
                        "25 mins", "Easy", "Healthy"
                ),
                createRecipeBox(
                        "Healthy Carrot Soup",
                        "Give yourself a boost and treat yourself to this low-fat, healthy carrot soup with a swirl of soured cream",
                        "10 mins", "Easy", "Healthy", "Vegetarian"
                )
        );

        return recipeLayout;
    }

    private VBox createRecipeBox(String title, String description, String time, String difficulty,
                                 String... tags) {
        VBox recipeBox = new VBox(5);
        recipeBox.setPadding(new Insets(10));
        recipeBox.setStyle("-fx-border-color: #ccc; -fx-border-width: 1; -fx-border-radius: 5; " +
                "-fx-background-color: #ffffff; -fx-background-radius: 5;");

        Label titleLabel = new Label(title);
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        Label descriptionLabel = new Label(description);
        descriptionLabel.setWrapText(true);

        String tagText = tags != null && tags.length > 0 ? String.join(", ", tags) : "No tags";
        Label detailsLabel = new Label(String.format("Time: %s  |  Difficulty: %s  |  Tags: %s",
                time, difficulty, tagText));
        detailsLabel.setFont(Font.font("Arial", FontPosture.ITALIC, 12));

        recipeBox.getChildren().addAll(titleLabel, descriptionLabel, detailsLabel);

        return recipeBox;
    }


    private VBox createSearchView(StackPane contentArea, Stage primaryStage) {
        VBox searchView = new VBox(10);
        searchView.setPadding(new Insets(20));

        TextField searchBar = new TextField();
        searchBar.setPromptText("Welcome to Meal Mate, Search products in the search bar !...");

        ListView<String> productListView = new ListView<>();
        updateProductList(productListView, "");

        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            updateProductList(productListView, newValue);
        });

        Button addToCartButton = new Button("Add to Cart");
        addToCartButton.setOnAction(e -> {
            int selectedIndex = productListView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                String selectedProductName = productListView.getSelectionModel().getSelectedItem().split(" - ")[0];

                Product selectedProduct = productCatalog.stream()
                        .filter(p -> p.getName().equals(selectedProductName))
                        .findFirst()
                        .orElse(null);

                if (selectedProduct != null) {
                    showQuantityDialog(selectedProduct, primaryStage);
                }
            }
        });

        searchView.getChildren().addAll(
                new Label("Mealmate, the Most affordable Student Grocery Shopping APP "),
                searchBar,
                productListView,
                addToCartButton
        );

        return searchView;
    }



    private void updateProductList(ListView<String> productListView, String searchTerm) {
        productListView.getItems().clear();
        productCatalog.stream()
                .filter(product -> product.getName().toLowerCase().contains(searchTerm.toLowerCase()))
                .forEach(product ->
                        productListView.getItems().add(product.getName() +
                                " - £" + String.format("%.2f", product.getPrice()) +
                                " (Stock: " + product.getQuantity() + ")")
                );
    }

    private void showQuantityDialog(Product product, Stage primaryStage) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        dialog.setTitle("Add to Cart");

        VBox dialogVBox = new VBox(20);
        dialogVBox.setPadding(new Insets(20));
        dialogVBox.setAlignment(Pos.CENTER);

        Label productLabel = new Label(product.getName());
        Label priceLabel = new Label(String.format("Price: £%.2f", product.getPrice()));
        Label availableLabel = new Label(String.format("Available: %d", product.getQuantity()));

        TextField quantityField = new TextField("1");
        quantityField.setPromptText("Quantity");

        Label totalPriceLabel = new Label();

        quantityField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                int quantity = Integer.parseInt(newValue);
                double totalPrice = product.getPrice() * quantity;
                totalPriceLabel.setText(String.format("Total: £%.2f", totalPrice));
            } catch (NumberFormatException e) {
                totalPriceLabel.setText("Invalid quantity");
            }
        });

        Button addButton = new Button("Add to Cart");
        addButton.setOnAction(e -> {
            try {
                int quantity = Integer.parseInt(quantityField.getText());
                if (quantity > 0 && quantity <= product.getQuantity()) {
                    Product cartItem = new Product(
                            product.getName(),
                            product.getPrice(),
                            quantity,
                            product.getCategory()
                    );
                    shoppingCart.add(cartItem);
                    showAlert("Added to Cart", quantity + " " + product.getName() + "(s) added successfully");
                    dialog.close();
                } else {
                    showAlert("Invalid Quantity", "Please enter a valid quantity");
                }
            } catch (NumberFormatException ex) {
                showAlert("Error", "Please enter a valid number");
            }
        });

        dialogVBox.getChildren().addAll(
                productLabel,
                priceLabel,
                availableLabel,
                new Label("Quantity:"),
                quantityField,
                totalPriceLabel,
                addButton
        );

        Scene dialogScene = new Scene(dialogVBox, 300, 400);
        dialog.setScene(dialogScene);
        dialog.show();
    }


    private VBox createCartView(StackPane contentArea) {
        VBox cartView = new VBox(10);
        cartView.setPadding(new Insets(20));

        VBox studentInfoBox = new VBox(5);
        studentInfoBox.setStyle("-fx-border-color: lightgray; -fx-border-width: 1; -fx-padding: 10;");

        Label studentNameLabel = new Label("Student: Lionel Messi");
        Label addressLabel = new Label("Address: 1 Birmingham Student Palace, B1 1AA");
        Label cardDetailsLabel = new Label("Saved Card details: **** **** **** 1234 (Visa)\n Exp date 01/28");

        studentInfoBox.getChildren().addAll(
                new Label("Student & Payment Details:"),
                studentNameLabel,
                addressLabel,
                cardDetailsLabel
        );

        ListView<String> cartListView = new ListView<>();
        Label totalLabel = new Label();

        Button removeFromCartButton = new Button("Remove from Cart");
        removeFromCartButton.setOnAction(e -> {
            int selectedIndex = cartListView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                shoppingCart.remove(selectedIndex);
                updateCartView(cartView);
            }
        });

        Label deliveryInfoLabel = new Label(String.format("Delivery Fee (Shared with 5 students): £%.2f", INDIVIDUAL_DELIVERY_FEE));
        deliveryInfoLabel.setStyle("-fx-font-style: italic;");

        Button checkoutButton = new Button("Checkout");
        checkoutButton.setOnAction(e -> {
            double subtotal = shoppingCart.stream()
                    .mapToDouble(p -> p.getPrice() * p.getQuantity())
                    .sum();

            double total = subtotal + INDIVIDUAL_DELIVERY_FEE;

            showAlert("Checkout", String.format(
                    "Subtotal: £%.2f\n" +
                            "Shared Delivery Fee: £%.2f\n" +
                            "Total: £%.2f\n\n" +
                            "Congrats! By ordering with us, we have saved your delivery fee by more than 200 percent!!\n" +
                            "Thank you for your purchase!\n" +
                            "Your order will arrive at an estimated 30 Minutes, please look for updates via the app notifications",
                    subtotal, INDIVIDUAL_DELIVERY_FEE, total
            ));
            shoppingCart.clear();
            updateCartView(cartView);
        });

        cartView.getChildren().addAll(
                new Label("Shopping Cart"),
                studentInfoBox,
                cartListView,
                totalLabel,
                deliveryInfoLabel,
                removeFromCartButton,
                checkoutButton
        );

        return cartView;
    }

    private void updateCartView(VBox cartView) {
        ListView<String> cartListView = (ListView<String>) cartView.getChildren().get(2);
        Label totalLabel = (Label) cartView.getChildren().get(3);

        cartListView.getItems().clear();
        shoppingCart.forEach(item ->
                cartListView.getItems().add(item.getName() +
                        " - £" + String.format("%.2f", item.getPrice()) +
                        " x " + item.getQuantity() +
                        " = £" + String.format("%.2f", item.getPrice() * item.getQuantity()))
        );

        double subtotal = shoppingCart.stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();

        totalLabel.setText(String.format("Subtotal: £%.2f\nTotal (with Delivery Fee): £%.2f",
                subtotal, subtotal + INDIVIDUAL_DELIVERY_FEE));
    }

    private VBox createStoreInfoView(StackPane contentArea) {
        VBox infoView = new VBox(30);
        infoView.setPadding(new Insets(60));

        Label titleLabel = new Label("Student Grocery Store");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextArea infoArea = new TextArea();
        infoArea.setEditable(false);
        infoArea.setText("Store Details:\n\n" +
                "- Operating Hours: 8:00 AM - 8:00 PM\n" +
                "- Location: Birmingham Student Palace\n" +
                "- Contact: 079342232322\n\n" +
                "Payment Methods:\n" +
                "- Student ID Card\n" +
                "- Mobile Payment\n\n" +
                "Special Discounts:\n" +
                "- 10% off for student groups\n"
        );

        infoView.getChildren().addAll(
                titleLabel,
                infoArea
        );

        return infoView;
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

