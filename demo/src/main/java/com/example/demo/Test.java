package com.example.demo;
import com.spoonacular.DefaultApi;
import com.spoonacular.client.ApiClient;
import com.spoonacular.client.ApiException;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        DefaultApi apiInstance = new DefaultApi();
        Boolean limitLicense = true; // Boolean | Whether the recipes should have an open license that allows display with proper attribution.
        String tags = "vegetarian, dessert"; // String | The tags (can be diets, meal types, cuisines, or intolerances) that the recipe must have.
        BigDecimal number = BigDecimal.valueOf(1); // BigDecimal | The number of random recipes to be returned (between 1 and 100).
        try {
            Object result = apiInstance.getRandomRecipes(limitLicense, tags, number);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#getRandomRecipes");
            e.printStackTrace();
        }
    }
}
