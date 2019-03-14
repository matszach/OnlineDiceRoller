package com.app.diceRoller.diceService.diceSimulator;

import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class DiceSimulator {

    // Constants
    private final Random random = new Random();

    // Constructors
    public DiceSimulator() {
    }

    // Private Methods
    private int getMaxRollValue(DieType dieType){
        switch (dieType){
            case D2: return 2;
            case D3: return 3;
            case D4: return 4;
            case D6: return 6;
            case D8: return 8;
            case D10: return 10;
            case D12: return 12;
            case D20: return 20;
            case D100: return 100;
            default: return 1;
        }
    }


    // Public Methods
    public int getRollOutcome(DieType dieType){
        return random.nextInt(getMaxRollValue(dieType))+1;
    }


}
