package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MilitaryFactory implements Building{
    private int amount;

    private float constructionCost = 7200.0f;
    private float constructionSpeedModifier = 0.0f;
    private float conversionCost = 4000.0f;
    private float conversionCostModifier = 0.0f;

    public MilitaryFactory(int amount) {
        this.amount = amount;
    }

    @Override
    public double dailyProgressPerFactory() {
        return 0;
    }

    public void addConstructionSpeedModifier(float value){
        this.constructionSpeedModifier += value;
    }
}
