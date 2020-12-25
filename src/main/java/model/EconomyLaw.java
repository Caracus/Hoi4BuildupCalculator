package model;

import lombok.Data;

@Data
public class EconomyLaw {
    private float consumerGoods = 0.0f;
    private float civilianFactoryConstructionSpeed = 0.0f;
    private float militaryFactoryConstructionSpeed = 0.0f;
    private float dockyardConstructionSpeed = 0.0f;
    private float civilianFactoryConversionCost = 0.0f;
    private float militaryFactoryConversionCost = 0.0f;

    public EconomyLaw(EconomyLaws economyLaws){
        switch(economyLaws){
            case UNDISTURBED_ISOLATION:
                consumerGoods = 0.5f;
                civilianFactoryConstructionSpeed = -0.5f;
                militaryFactoryConstructionSpeed = -0.5f;
                dockyardConstructionSpeed = -0.5f;
                civilianFactoryConversionCost = 0.5f;
                militaryFactoryConversionCost = 0.5f;
                break;
            case ISOLATION:
                consumerGoods = 0.4f;
                civilianFactoryConstructionSpeed = -0.4f;
                militaryFactoryConstructionSpeed = -0.4f;
                dockyardConstructionSpeed = -0.4f;
                civilianFactoryConversionCost = 0.4f;
                militaryFactoryConversionCost = 0.4f;
                break;
            case CIVILIAN_ECONOMY:
                consumerGoods = 0.35f;
                civilianFactoryConstructionSpeed = -0.3f;
                militaryFactoryConstructionSpeed = -0.3f;
                dockyardConstructionSpeed = 0.0f;
                civilianFactoryConversionCost = 0.3f;
                militaryFactoryConversionCost = 0.3f;
                break;
            case EARLY_MOBILIZATION:
                consumerGoods = 0.3f;
                civilianFactoryConstructionSpeed = -0.1f;
                militaryFactoryConstructionSpeed = -0.1f;
                dockyardConstructionSpeed = 0.0f;
                civilianFactoryConversionCost = 0.0f;
                militaryFactoryConversionCost = 0.0f;
                break;
            case PARTIAL_MOBILIZATION:
                consumerGoods = 0.25f;
                civilianFactoryConstructionSpeed = 0.0f;
                militaryFactoryConstructionSpeed = 0.1f;
                dockyardConstructionSpeed = 0.0f;
                civilianFactoryConversionCost = -0.1f;
                militaryFactoryConversionCost = -0.1f;
                break;
            case WAR_ECONOMY:
                consumerGoods = 0.2f;
                civilianFactoryConstructionSpeed = 0.0f;
                militaryFactoryConstructionSpeed = 0.2f;
                dockyardConstructionSpeed = 0.0f;
                civilianFactoryConversionCost = -0.2f;
                militaryFactoryConversionCost = -0.2f;
                break;
            case TOTAL_MOBILIZATION:
                consumerGoods = 0.1f;
                civilianFactoryConstructionSpeed = 0.0f;
                militaryFactoryConstructionSpeed = 0.3f;
                dockyardConstructionSpeed = 0.0f;
                civilianFactoryConversionCost = -0.3f;
                militaryFactoryConversionCost = -0.3f;
                break;
        }
    }
}
