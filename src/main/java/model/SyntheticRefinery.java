package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SyntheticRefinery implements Building{
    private int amount;

    private float constructionCost = 14500.0f;
    private float constructionSpeedModifier = 0.0f;
    private float conversionModifier = 0.0f;

    public SyntheticRefinery(int amount) {
        this.amount = amount;
    }

    @Override
    public double dailyProgressPerFactory() {
        return 0;
    }
}
