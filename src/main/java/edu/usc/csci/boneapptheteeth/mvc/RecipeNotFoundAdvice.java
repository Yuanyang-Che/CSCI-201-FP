package edu.usc.csci.boneapptheteeth.mvc;

import edu.usc.csci.boneapptheteeth.RecipeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//to be implemented
@ControllerAdvice
class RecipeNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(RecipeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String recipeNotFoundHandler(RecipeNotFoundException e){
        return e.getMessage();
    }
}
