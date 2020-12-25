package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Infrastructure
{
    private int amount;

    private float constructionCost = 3000.0f;
    private float constructionSpeedModifier = 0.0f;

    public void addConstructionSpeedModifier(float value){
        this.constructionSpeedModifier += value;
    }

}
