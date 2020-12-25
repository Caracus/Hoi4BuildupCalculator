package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Dockyard implements Building{
    private int amount;

    private float constructionCost = 6400.0f;
    private float constructionSpeedModifier = 0.0f;
    private float conversionModifier = 0.0f;

    public Dockyard(int amount) {
        this.amount = amount;
    }

    @Override
    public double dailyProgressPerFactory() {
        return 0;
    }
}
