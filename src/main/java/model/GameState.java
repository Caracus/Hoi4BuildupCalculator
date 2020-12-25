package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class GameState {
    public float consumerGoodsModifiers;
    public float consumerGoodsModifierStability;
    public float consumerGoodsFinal;
    public float stability;
    public float generalConstructionBonus;
    public int civilianFactoriesLeftForConstruction;
    public CivilianFactory civilianFactory;
    public MilitaryFactory militaryFactory;
    public SyntheticRefinery syntheticRefinery;
    public Dockyard dockyard;
    public Infrastructure infrastructure;
    public Map<Integer, State> integerStateMap;
    public int totalFactoryCount;
    public TradeLaw tradeLaw;
    public EconomyLaw economyLaw;

    public void updateGameState() {
        integerStateMap.values().forEach(state -> state.refreshData());

        civilianFactory.setAmount(calculateNumberOfCivilianFactories(integerStateMap));
        militaryFactory.setAmount(calculateNumberOfMilitaryFactories(integerStateMap));
        dockyard.setAmount(calculateNumberOfDockyards(integerStateMap));
        syntheticRefinery.setAmount(calculateNumberOfSynthRefineries(integerStateMap));

        calculateStabilityInfluence();
        calculateConsumerGoodsFinal();
        calculateCivilianFactoriesLeftForConstruction();
    }

    public static Integer calculateNumberOfCivilianFactories(Map<Integer, State> integerStateMap) {
       return integerStateMap.values().stream().map(state -> state.getCivAmount()).collect(Collectors.summingInt(Integer::intValue));
    }

    public static Integer calculateNumberOfMilitaryFactories(Map<Integer, State> integerStateMap) {
        return integerStateMap.values().stream().map(state -> state.getMilAmount()).collect(Collectors.summingInt(Integer::intValue));
    }

    public static Integer calculateNumberOfSynthRefineries(Map<Integer, State> integerStateMap) {
        return integerStateMap.values().stream().map(state -> state.getSynthAmount()).collect(Collectors.summingInt(Integer::intValue));
    }

    public static Integer calculateNumberOfDockyards(Map<Integer, State> integerStateMap) {
        return integerStateMap.values().stream().map(state -> state.getDockAmount()).collect(Collectors.summingInt(Integer::intValue));
    }

    public static Integer calculateNumberOfTotalFactories(Map<Integer, State> integerStateMap) {
        return integerStateMap.values().stream().map(state -> state.getUsedSlots()).collect(Collectors.summingInt(Integer::intValue));
    }

    public void calculateStabilityInfluence() {
        if (this.stability > 0.5) {
            this.consumerGoodsModifierStability = -(this.stability - 0.5f) / 10;
        } else {
            this.consumerGoodsModifierStability = 0.0f;
        }
    }

    public void calculateConsumerGoodsFinal() {
        this.consumerGoodsFinal = economyLaw.getConsumerGoods() + consumerGoodsModifierStability + consumerGoodsModifiers;
    }

    public void calculateCivilianFactoriesLeftForConstruction() {
        this.civilianFactoriesLeftForConstruction = (int) Math.ceil(civilianFactory.getAmount()+civilianFactory.getOffMapAmount()-(civilianFactory.getAmount()+civilianFactory.getOffMapAmount()+militaryFactory.getAmount())*(consumerGoodsFinal));
    }

    public float getGeneralConstructionBonusFinal() {
        return tradeLaw.getConstructionSpeedBonus()+generalConstructionBonus;
    }

    public void addGeneralConstructionBonus(float value) {
        this.generalConstructionBonus += value;
    }

}

