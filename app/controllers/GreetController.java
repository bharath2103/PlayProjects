package controllers;

import play.mvc.*;

import static play.mvc.Results.ok;

public class GreetController {

    public Result greet(String respect, String firstName) {
        System.out.println(respect+","+firstName);
        return ok(respect+","+firstName);
    }

}
