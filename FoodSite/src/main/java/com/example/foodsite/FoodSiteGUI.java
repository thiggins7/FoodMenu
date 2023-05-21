package com.example.foodsite;

import javafx.scene.control.Tooltip;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class FoodSiteGUI extends Application{

    @Override
    public void start(Stage stage)
    {
        //Set Stage Title
        stage.setTitle("com.example.foodsite.Food-JavaFX");

        //Create Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Set Scene Title
        Text sceneTitle = new Text("The Food Market");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        //Label for Lao Gan Ma
        Label LGMLabel = new Label("Lao Gan Ma: $3.45");
        LGMLabel.setTooltip(new Tooltip("A chinese chili crisp - Simmered chili peppers, garlic, and seasonings in oil."));
        grid.add(LGMLabel,0, 1 );

        //Label for Dona Maria Mole
        Label DMMLabel = new Label("Dona Maria Mole: $2.50");
        DMMLabel.setTooltip(new Tooltip("An earthy mexican sauce - contains fruits, nuts, chili peppers, and spices"));
        grid.add(DMMLabel, 0, 3);

        //Label for Thai Chili Paste
        Label TCPLabel = new Label("Thai Kitchen Chili Paste: $3.50");
        TCPLabel.setTooltip(new Tooltip("A paste made up of dried chilis and roasted vegetables."));
        grid.add(TCPLabel, 0, 5);

       //Text Field for Amount of Lao Gan Ma Purchased
        TextField LGMAmount = new TextField();
        LGMAmount.setPrefWidth(1);
        grid.add(LGMAmount, 0, 2);

        //Text Field for Amount of Dona Maria Mole
        TextField DMMAmount = new TextField();
        DMMAmount.setPrefWidth(1);
        grid.add(DMMAmount, 0, 4);

        //Text Field for Amount of Thai Chili Paste
        TextField TCPAmount = new TextField();
        TCPAmount.setPrefWidth(1);
        grid.add(TCPAmount, 0, 6);


        //Construct Food Objects
        Food LaoGanMa = new Food("Lao Gan Ma", 3.45, 0, 20);
        Food ThaiChiliPaste = new Food("Thai Kitchen Chili Paste", 3.50, 0, 10);


        FoodOrigin LaoGanMaOrg = new FoodOrigin(LaoGanMa, "Asian Food");
        FoodOrigin ThaiChiliPasteOrg = new FoodOrigin(ThaiChiliPaste, "Asian Food");


        Food DonaMariaMole = new Food("Dona Maria Mole", 2.50, 0, 30);


        FoodOrigin DonaMariaMoleOrg = new FoodOrigin(DonaMariaMole, "Mexican Food");


        //Set Button to Purchase Items
        Button buyButton = new Button("Purchase");
        grid.add(buyButton, 7, 6 );

        //Set Button to view Shopping Cart
        Button cartButton = new Button( "Show Cart");
        grid.add(cartButton, 7, 0);




        //Set Scene
        Scene scene = new Scene(grid, 500, 275);



        //Move to Cart Page
        cartButton.setOnAction(actionEvent ->{
            GridPane cartGrid = new GridPane();
            cartGrid.setAlignment(Pos.CENTER);
            cartGrid.setHgap(10);
            cartGrid.setVgap(20);
            cartGrid.setPadding(new Insets(25, 25, 25, 25));

            //Set values to TextBox values
            LaoGanMa.setPurchased((LGMAmount.getText()));
            DonaMariaMole.setPurchased((DMMAmount.getText()));
            ThaiChiliPaste.setPurchased((TCPAmount.getText()));


            //add Labels
            Label LGMCartLabel = new Label(LaoGanMa.foodToCart() + "\t(" + LaoGanMaOrg.getFoodType() + ")");
            cartGrid.add(LGMCartLabel, 1, 1);

            Label DMMCartLabel = new Label(DonaMariaMole.foodToCart() + "\t(" + DonaMariaMoleOrg.getFoodType() + ")");
            cartGrid.add(DMMCartLabel, 1, 2);

            Label TCPCartLabel = new Label(ThaiChiliPaste.foodToCart() +"\t(" + ThaiChiliPasteOrg.getFoodType() + ")");
            cartGrid.add(TCPCartLabel, 1, 3);

            Label totalPrice = new Label(("Total Price:" + (LaoGanMa.totalPrice() + DonaMariaMole.totalPrice() + ThaiChiliPaste.totalPrice())));
            cartGrid.add(totalPrice, 1, 5);






            //Go back to Shopping Page
            Button backButton = new Button("Back");
            cartGrid.add(backButton, 5, 5);
            backButton.setOnAction((actionEvent1) -> stage.setScene(scene));



            //Set scene for Cart Page
            Scene cartScene = new Scene(cartGrid, 500, 275);
            stage.setScene(cartScene);

        });

        buyButton.setOnAction(actionEvent -> {
            double finalPrice = 0;

           //Set purchased values to textboxes
            LaoGanMa.setPurchased((LGMAmount.getText()));
            DonaMariaMole.setPurchased((DMMAmount.getText()));
            ThaiChiliPaste.setPurchased((TCPAmount.getText()));

            //Messages to receipt format
            String LGMReceiptMessage = LaoGanMa.foodToReceipt();
            String DMMReceiptMessage = DonaMariaMole.foodToReceipt();
            String TCPReceiptMessage = ThaiChiliPaste.foodToReceipt();

            //Print messages if not empty
            if(LaoGanMa.foodPurchased != 0)
            {
                System.out.println(LGMReceiptMessage + "\n");
                finalPrice += LaoGanMa.totalPrice();
            }
            if(DonaMariaMole.foodPurchased != 0)
            {
                System.out.println(DMMReceiptMessage + "\n");
                finalPrice += DonaMariaMole.totalPrice();
            }
            if(ThaiChiliPaste.foodPurchased != 0)
            {
                System.out.println(TCPReceiptMessage + "\n");
                finalPrice += ThaiChiliPaste.totalPrice();
            }



            //Print total price if valid, then thank customer
            if(finalPrice != 0)
            {
                System.out.println("Your final price is $" + finalPrice);
            }
            System.out.println("Thank you for shopping!");

        });



        //Set shopping scene
        stage.setScene(scene);


        stage.show();





    }

    public static void main(String[] args) {launch(args);}
}
