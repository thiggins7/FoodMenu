package com.example.foodsite;

import static java.lang.Integer.parseInt;

public class Food{


    public String foodName;
    public double foodPrice;
    public int foodPurchased;
    public int foodStock;


    //Abstract Class
    public Food()
    {

    }

    //Construct Food Object
    public Food(String name, double price, int purchased, int stock)
    {
        this.foodName = name;
        this.foodPrice = price;
        this.foodPurchased = purchased;
        this.foodStock = stock;


    }



    //Get Name
    public String getName()
    {
        return this.foodName;
    }

    //Get Price
    public double getPrice()
    {
        return this.foodPrice;
    }

    //Get Items Purchased
    public int getPurchased()
    {
        return this.foodPurchased;
    }

    //Get how many items we have in stock
    public int getStock()
    {
        return this.foodStock;
    }


    //Set amount purchased
    public void setPurchased(int purchased)
    {
        this.foodPurchased = purchased;
    }

    //Set amount purchased(take in String)
    public void setPurchased(String purchased)
    {
        this.foodPurchased = parseInt(purchased);
    }

    //Print Cart Display for Food Item
    public String foodToCart()
    {
        if (this.foodPurchased > this.foodStock)
        {
            return "We only have " + this.foodStock + "of " + this.foodName + "available";
        }
        else if (this.foodPurchased > 0) {
            String FTC = "QTY: " + this.foodPurchased + "\tName: " + this.foodName + "  Price: $" + (this.foodPrice * this.foodPurchased) + " ";
            return FTC;
        }
        else
        {
            return " ";
        }

    }

    //Print Receipt for each Food Item
    public String foodToReceipt()
    {

        String FTR = this.foodName + "(" + this.foodPurchased + ")\t\t$" + (this.foodPrice * this.foodPurchased);
        return FTR;
    }

   //Calculate Total Price for each Food
    public double totalPrice()
    {
        return (this.foodPurchased * this.foodPrice);
    }

}
