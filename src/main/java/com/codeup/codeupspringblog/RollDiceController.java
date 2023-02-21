package com.codeup.codeupspringblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @PostMapping("/roll-dice")
    public String rollDice(@RequestParam(name = "guess") String guess, Model model) {
        model.addAttribute("guess", "Your guess was: " + guess);
        return "roll-dice/" + guess;
    }

    @GetMapping("/roll-dice/{guess}")
    public String testBoolean(@PathVariable String guess, Model model) {
        Random rand = new Random();
        int randomNum = rand.nextInt((6 - 1) + 1) + 1;
        model.addAttribute("answer", "The number was: " + randomNum);
        if (guess.equals(String.valueOf(randomNum))) {
            model.addAttribute("result", "You were correct!");
        } else {
            model.addAttribute("result", "Nope, try again!");
        }
        model.addAttribute("guess", "Your guess was: " + guess);
        return "roll-dice";
    }

}
