package com.app.diceRoller.diceService;

import com.app.diceRoller.diceService.diceSimulator.DieType;

public interface DiceService {
    void resolveRoll(DieType dieType, int numOfDice);
    DieType stringToDieType(String dieType);
    String getResultMessage();
}
