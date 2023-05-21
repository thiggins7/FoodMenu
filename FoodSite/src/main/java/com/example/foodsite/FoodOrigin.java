package com.example.foodsite;

public class FoodOrigin<Type> extends Food{

    Type None = (Type) " ";
    Type foodType;
    Food food;

    //Construct FoodOrigin
    FoodOrigin(Food food, Type foodType)
    {
        this.food = food;
        this.foodType = foodType;
    }

    //Get FoodType
    public Type getFoodType()
    {
        if(this.food.foodStock > this.food.foodPurchased && this.food.foodPurchased != 0) {
            return this.foodType;
        }
        else
        {
            return None;
        }
    }
}
