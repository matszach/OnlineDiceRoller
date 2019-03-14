package com.app.diceRoller.controller;

import com.app.diceRoller.diceService.DiceService;
import com.app.diceRoller.diceService.diceSimulator.DiceSimulator;
import com.app.diceRoller.diceService.diceSimulator.DieType;
import com.app.diceRoller.util.AttributeNames;
import com.app.diceRoller.util.MappingNames;
import com.app.diceRoller.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DiceAppController {

    // fields
    private final DiceService diceService;

    // constructors
    @Autowired
    public DiceAppController(DiceService diceService) {
        this.diceService = diceService;
    }



    // Request Methods
    @GetMapping(MappingNames.MP_ROLL)
    public String roll(Model model){
        model.addAttribute(AttributeNames.MESSAGE,diceService.getResultMessage());
        return ViewNames.ROLL;
    }

    // Resolve Roll
    @PostMapping(MappingNames.MP_ROLL)
    public String resolveRoll(@RequestParam int numOfDice, @RequestParam String dieType){
        diceService.resolveRoll(diceService.stringToDieType(dieType), numOfDice);
        return MappingNames.MP_REDIR_ROLL;
    }




}
