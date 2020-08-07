package edu.usc.csci.boneapptheteeth;

//to be implemented
public class RecipeNotFoundException extends RuntimeException {
    RecipeNotFoundException(String query){
        super("Could not find recipe for " + query);
    }
}
