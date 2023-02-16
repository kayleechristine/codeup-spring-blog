package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

record Message(String message){}

@Controller
public class HelloController {

    //### Controllers ###//
    // Method will listen for GET requests at /hello
    // Replaces URL patterns within a servlet
    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "<h1>Hello from Spring!</h1>";
    }

    // Method will listen for GET request at /json
    // Returns application/json as the Content-Type
    // Default Content-Type is text/HTML
    @GetMapping(path = "/json", produces = "application/json")
    @ResponseBody
    public Message returnMessage() {
        return new Message("Hello from Spring");
    }

    // RequestMapping is the parent of all other Mapping annotations
    // Can be further customized
    @RequestMapping(path = "/color", method = RequestMethod.GET)
    @ResponseBody
    public String color() {
        return "Royal Blue";
    }

    //### Path Variables ###//
    // Path values are given value by the URI mapping
    // The annotation must be included in the method parameters
    // Can be declared as different data types, but are usually Strings
    @GetMapping("/hello/{greeting}/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name, @PathVariable String greeting) {
        return "<h1>" + greeting + " " + name + "!</h1>";
    }

    @GetMapping("/boolean/{boo}")
    @ResponseBody
    public String testBoolean(@PathVariable boolean boo) {
        if (boo) {
            return "<h1>True!</h1>";
        } else {
            return "<h1>False!</h1>";
        }
    }

}
