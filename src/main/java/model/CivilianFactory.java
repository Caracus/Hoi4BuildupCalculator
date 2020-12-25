package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CivilianFactory implements Building{
    private int amount;
    private int offMapAmount;

    private float constructionCost = 10800.0f;
    private float constructionSpeedModifier = 0.0f;
    private float conversionCost = 9000.0f;
    private float conversionCostModifier = 0.0f;

    public CivilianFactory(int amount, int offMapAmount) {
        this.amount = amount;
        this.amount = offMapAmount;
    }

    @Override
    public double dailyProgressPerFactory() {
        return 0;
    }

    public void addConstructionSpeedModifier(float value){
        this.constructionSpeedModifier += value;
    }

    public void addOffMapFactories(int value){
        this.offMapAmount += value;
    }
}
