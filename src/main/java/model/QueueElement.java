package model;

import lombok.Data;

@Data
public class QueueElement {
    private float goalPoints;
    private float progress;
    private BuildingType buildingType;
    int level;
    int stateId;
    GameState gameState;

    public void addProgress(int factories){
        switch(this.buildingType) {
            case CIVILIAN_FACTORY:
                calculateProgress(gameState.economyLaw.getCivilianFactoryConstructionSpeed()+gameState.civilianFactory.getConstructionSpeedModifier(), factories);
                break;
            case MILITARY_FACTORY:
                calculateProgress(gameState.economyLaw.getMilitaryFactoryConstructionSpeed()+gameState.militaryFactory.getConstructionSpeedModifier(), factories);
                break;
            case INFRASTRUCTURE:
                calculateProgressInfrastructure(gameState.infrastructure.getConstructionSpeedModifier(), factories);
                break;
            case CONVERT_MIL_TO_CIV:
                calculateProgress(gameState.civilianFactory.getConstructionSpeedModifier(), factories);
                break;
            case CONVERT_CIV_TO_MIL:
                calculateProgress(gameState.militaryFactory.getConstructionSpeedModifier(), factories);
                break;
        }
    }

    public boolean checkGoalReached(){
        if (progress >= goalPoints) {

            switch(this.buildingType) {
                case CIVILIAN_FACTORY:
                    gameState.integerStateMap.get(stateId).addCivilianFactory();
                    this.level = level-1;
                    this.progress = 0;
                    break;
                case MILITARY_FACTORY:
                    gameState.integerStateMap.get(stateId).addMilitaryFactory();
                    this.level = level-1;
                    this.progress = 0;
                    break;
                case INFRASTRUCTURE:
                    gameState.integerStateMap.get(stateId).addInfrastructureLevel();
                    this.level = level-1;
                    this.progress = 0;
                    break;
                case CONVERT_MIL_TO_CIV:
                    gameState.integerStateMap.get(stateId).addCivilianFactory();
                    this.level = level-1;
                    this.progress = 0;
                    gameState.integerStateMap.get(stateId).removeMilitaryFactory();
                    break;
                case CONVERT_CIV_TO_MIL:
                    gameState.integerStateMap.get(stateId).addMilitaryFactory();
                    this.level = level-1;
                    this.progress = 0;
                    gameState.integerStateMap.get(stateId).removeCivilianFactory();
                    break;
            }
            System.out.println("Finished a level of "+buildingType+ " in "+gameState.integerStateMap.get(stateId).getName());
            gameState.updateGameState();
            if(this.level <= 0){
                return true;
            }
        }
        return false;
    }

    public QueueElement(BuildingType buildingType,int level, int stateId, GameState gameState){
        this.buildingType = buildingType;
        this.stateId = stateId;
        this.gameState = gameState;
        this.level = level;


        switch(buildingType) {
            case CIVILIAN_FACTORY:
                this.goalPoints = gameState.civilianFactory.getConstructionCost();
                gameState.integerStateMap.get(stateId).addPendingSlot();
                break;
            case MILITARY_FACTORY:
                this.goalPoints = gameState.militaryFactory.getConstructionCost();
                gameState.integerStateMap.get(stateId).addPendingSlot();
                break;
            case INFRASTRUCTURE:
                this.goalPoints = gameState.infrastructure.getConstructionCost();
                gameState.integerStateMap.get(stateId).addPendingInfrastructureLevel();
                break;
            case CONVERT_MIL_TO_CIV:
                this.goalPoints = gameState.civilianFactory.getConversionCost()*(1.0f+gameState.economyLaw.getCivilianFactoryConversionCost()+gameState.civilianFactory.getConversionCostModifier());
                break;
            case CONVERT_CIV_TO_MIL:
                this.goalPoints = gameState.militaryFactory.getConversionCost()*(1.0f+gameState.economyLaw.getMilitaryFactoryConversionCost()+gameState.militaryFactory.getConversionCostModifier());
                break;
        }

        System.out.println("Start "+level+" level of "+buildingType.toString()+" in "+gameState.integerStateMap.get(stateId).getName() );

    }

    public void calculateProgress(float specificModifier, int factories){
        this.progress += factories*(5.0f*(1+gameState.getGeneralConstructionBonusFinal()+specificModifier))*(1+(gameState.getIntegerStateMap().get(stateId).getInfrastructureLevel()*0.1f));
    }
    public void calculateProgressInfrastructure(float specificModifier, int factories){
        this.progress += factories*(5.0f*(1+gameState.getGeneralConstructionBonusFinal()+specificModifier));
    }

    public void addLevel(int value){
        this.level += value;
    }
}
