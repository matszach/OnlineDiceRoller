package com.app.diceRoller.diceService;

import com.app.diceRoller.diceService.diceSimulator.DiceSimulator;
import com.app.diceRoller.diceService.diceSimulator.DieType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiceService_Implementation implements DiceService {

    // constants
    private final DiceSimulator diceSimulator;



    // fields
    private int[] resultSet;



    // constructors
    @Autowired
    public DiceService_Implementation(DiceSimulator diceSimulator) {
        this.diceSimulator = diceSimulator;
    }



    // private methods
    private String buildResultMessage(){
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for(int result : resultSet){
            if(isFirst){
               isFirst=false;
            }else {
                sb.append(", ");
            }
            sb.append(result);

        }
        return sb.toString();
    }



    // public methods
    @Override
    public DieType stringToDieType(String dieType) {
        switch (dieType){
            case "D2": return DieType.D2;
            case "D3": return DieType.D3;
            case "D4": return DieType.D4;
            case "D6": return DieType.D6;
            case "D8": return DieType.D8;
            case "D10": return DieType.D10;
            case "D12": return DieType.D12;
            case "D20": return DieType.D20;
            case "D100": return DieType.D100;
            default: return DieType.D100;
        }
    }

    @Override
    public void resolveRoll(DieType dieType, int numOfDice) {
        resultSet = new int[numOfDice];
        for(int i = 0; i < numOfDice; i++){
            resultSet[i] = diceSimulator.getRollOutcome(dieType);
        }
    }

    @Override
    public String getResultMessage() {
        if(resultSet==null || resultSet.length==0){
            return "Please roll some dice first";
        } else {
            return buildResultMessage();
        }
    }
}
