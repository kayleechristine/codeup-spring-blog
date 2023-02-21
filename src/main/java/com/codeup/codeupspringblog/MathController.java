package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/{method}/{num1}/{and}/{num2}")
    @ResponseBody
    public String doMath(@PathVariable String method, @PathVariable int num1, @PathVariable String and, @PathVariable int num2) {
        String sign = "sign";
        int result = 0;
        switch (method) {
            case "add":
                sign = "+";
                result = num1 + num2;
                break;
            case "subtract":
                sign = "-";
                result = num1 - num2;
                break;
            case "divide":
                sign = "/";
                result = num1 / num2;
                break;
            case "multiply":
                sign = "*";
                result = num1 * num2;
                break;
        }
        return "<h1>" + num1 + " " + sign + " " + num2 + " = " + result + "</h1>";
    }

}
