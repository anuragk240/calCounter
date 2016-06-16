package model;

import java.io.Serializable;

/**
 * Created by Suhail on ०९-०६-२०१६.
 */
public class Food implements Serializable {

    private static  final long serialVersionUID=10L;
    private String FoodName;
    private int calories;
    private int foodId;
    private String recordDate;

    public Food(String food, int cal, int id, String date) {
        FoodName = food;
        calories = cal;
        foodId = id;
        recordDate = date;
    }

    public Food() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }
}
