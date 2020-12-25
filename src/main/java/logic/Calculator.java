package logic;

import model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Calculator implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        main(args);
    }

    public static void main(String[] args) {

        GameState gameState = new GameState();

        List<State> stateList = new ArrayList<>();

        //initialize states
        stateList.add(new State("Brandenburg", 64, 8, 12, 5, 0, 4, 0));
        stateList.add(new State("Ermland-Masuren", 5, 6, 4, 0, 0, 0, 0));
        stateList.add(new State("Franken", 54, 7, 6, 0, 0, 2, 0));
        stateList.add(new State("Hannover", 59, 7, 8, 2, 2, 1, 0));
        stateList.add(new State("Hessen", 55, 7, 8, 1, 0, 2, 0));
        stateList.add(new State("Hinterpommern", 63, 6, 4, 0, 0, 1, 0));
        stateList.add(new State("Königsberg", 763, 6, 6, 0, 0, 2, 0));
        stateList.add(new State("Mecklenburg", 61, 6, 4, 3, 0, 0, 0));
        stateList.add(new State("Moselland", 42, 7, 10, 0, 0, 3, 0));
        stateList.add(new State("Niederbayern", 53, 6, 6, 0, 0, 0, 0));
        stateList.add(new State("Niederschlesien", 66, 6, 8, 0, 0, 1, 0));
        stateList.add(new State("Oberbayern", 52, 7, 6, 2, 0, 1, 0));
        stateList.add(new State("Oberschlesien", 67, 6, 6, 0, 0, 0, 0));
        stateList.add(new State("Ostmark", 68, 6, 6, 0, 0, 1, 0));
        stateList.add(new State("Rhineland", 51, 8, 10, 3, 0, 2, 0));
        stateList.add(new State("Sachsen", 65, 7, 10, 2, 0, 7, 0));
        stateList.add(new State("Schleswig-Holstein", 58, 6, 8, 2, 6, 0, 0));
        stateList.add(new State("Thüringen", 60, 6, 8, 0, 0, 1, 0));
        stateList.add(new State("Vorpommern", 62, 6, 4, 0, 0, 0, 0));
        stateList.add(new State("Weser-Ems", 56, 6, 6, 0, 2, 2, 0));
        stateList.add(new State("Westfalen", 57, 8, 8, 3, 0, 1, 0));
        stateList.add(new State("Württemberg", 50, 8, 8, 5, 0, 1, 0));

        Map<Integer, State> integerStateMap = new HashMap<>();

        stateList.stream().forEach(state -> integerStateMap.put(state.getId(), state));

        gameState.integerStateMap = integerStateMap;

        gameState.civilianFactory = new CivilianFactory();
        gameState.civilianFactory.setOffMapAmount(0);
        gameState.militaryFactory = new MilitaryFactory();
        gameState.syntheticRefinery = new SyntheticRefinery();
        gameState.dockyard = new Dockyard();
        gameState.infrastructure = new Infrastructure();

        //intitialize general
        gameState.generalConstructionBonus = 0.0f;
        gameState.stability = 0.00f;
        gameState.consumerGoodsModifiers = 0.0f;

        //country stats
        printTimeLog("Set start conditions", -1);
        gameState.tradeLaw = new TradeLaw(TradeLaws.LIMITED_EXPORTS);
        gameState.economyLaw = new EconomyLaw(EconomyLaws.PARTIAL_MOBILIZATION);
        gameState.stability = 0.84f;

        //country specific changes
        printTimeLog("Mefo bills", -1);
        gameState.consumerGoodsModifiers += -0.05;
        gameState.getMilitaryFactory().addConstructionSpeedModifier(0.25f);

        System.out.println(gameState.getCivilianFactory().getAmount());

        //initialize buildingQueue
        List<QueueElement> queueElementList = new ArrayList<>();


         queueElementList.add(new QueueElement(BuildingType.INFRASTRUCTURE,2, 51, gameState));
         queueElementList.add(new QueueElement(BuildingType.INFRASTRUCTURE, 3, 42, gameState));
         queueElementList.add(new QueueElement(BuildingType.CIVILIAN_FACTORY,5, 51, gameState));
         queueElementList.add(new QueueElement(BuildingType.CIVILIAN_FACTORY, 7, 42, gameState));
         queueElementList.add(new QueueElement(BuildingType.INFRASTRUCTURE,6, 66, gameState));
         queueElementList.add(new QueueElement(BuildingType.INFRASTRUCTURE, 6, 67, gameState));
         queueElementList.add(new QueueElement(BuildingType.CIVILIAN_FACTORY,7, 66, gameState));
         queueElementList.add(new QueueElement(BuildingType.CIVILIAN_FACTORY, 6, 67, gameState));

         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY,2, 51, gameState));
         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY, 2, 42, gameState));
         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY,1, 66, gameState));
         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY, 1, 67, gameState));

         queueElementList.add(new QueueElement(BuildingType.INFRASTRUCTURE,4, 53, gameState));
         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY, 7, 53, gameState));

         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY, 2, 51, gameState));
         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY, 2, 42, gameState));
         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY, 2, 66, gameState));
         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY, 1, 67, gameState));
         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY, 1, 53, gameState));

         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY, 7, 64, gameState));
         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY, 6, 59, gameState));
         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY, 10, 60, gameState));
         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY, 6, 54, gameState));

         queueElementList.add(new QueueElement(BuildingType.INFRASTRUCTURE,3, 55, gameState));
         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY, 8, 55, gameState));
         queueElementList.add(new QueueElement(BuildingType.INFRASTRUCTURE,2, 57, gameState));
         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY, 7, 57, gameState));
         queueElementList.add(new QueueElement(BuildingType.INFRASTRUCTURE,4, 68, gameState));
         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY, 7, 68, gameState));
         queueElementList.add(new QueueElement(BuildingType.INFRASTRUCTURE,2, 50, gameState));
         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY, 5, 50, gameState));
         queueElementList.add(new QueueElement(BuildingType.INFRASTRUCTURE,3, 52, gameState));
         queueElementList.add(new QueueElement(BuildingType.MILITARY_FACTORY, 5, 52, gameState));

        //finish gamestate calculations
        gameState.updateGameState();

        //stuff for the timeline calcs
        int accumulatedMilFactoryDays = 0;
        boolean queueEmptyFlag = false;

        //start timeline
        int timeCapInDays = 1000;
        int progressOffset = 0;
        for (int days = 0; days < timeCapInDays; days++) {
            // calculate how civ factories are distributed
            int filledBuildingProgressSlots = gameState.getCivilianFactoriesLeftForConstruction() / 15;
            int factoriesForUnfilledProgress = gameState.getCivilianFactoriesLeftForConstruction() % 15;

            while(queueElementList.size()<filledBuildingProgressSlots+1){
                //run add building task
            }
            // add progress
            for (int slots = 0; slots < filledBuildingProgressSlots; slots++) {
                queueElementList.get(slots).addProgress(15);
            }
            queueElementList.get(filledBuildingProgressSlots + progressOffset).addProgress(factoriesForUnfilledProgress);

            // purge empty entries from the list
            queueElementList = queueElementList.stream().filter(queueElement -> !queueElement.checkGoalReached()).collect(Collectors.toList());


            // make something like
            //System.out.println("Civilian factories first unused on day: " + days + "");

            //time based changes

             switch(days){
             case 70:
             printTimeLog("Schacht Ideas",days);
             gameState.getCivilianFactory().addConstructionSpeedModifier(0.1f);
             gameState.getInfrastructure().addConstructionSpeedModifier(0.1f);
             gameState.updateGameState();
             break;
             case 140:
             printTimeLog("Autarky",days);
             gameState.getCivilianFactory().addConstructionSpeedModifier(0.1f);
             gameState.getMilitaryFactory().addConstructionSpeedModifier(0.1f);
             gameState.updateGameState();
             break;
             case 155:
             printTimeLog("change to free trade",days);
             gameState.tradeLaw = new TradeLaw(TradeLaws.FREE_TRADE);
             gameState.updateGameState();
             break;
             case 166:
             printTimeLog("construction I",days);
             gameState.addGeneralConstructionBonus(0.1f);
             gameState.updateGameState();
             break;
             case 210:
             printTimeLog("Werke I",days);
             gameState.getCivilianFactory().addOffMapFactories(6);
             gameState.updateGameState();
             break;
             case 280:
             printTimeLog("Werke II",days);
             gameState.getCivilianFactory().addOffMapFactories(6);
             gameState.updateGameState();
             break;
             case 315:
             printTimeLog("construction II",days);
             gameState.addGeneralConstructionBonus(0.1f);
             gameState.updateGameState();
             break;
             case 420:
             printTimeLog("partial to full mobe",days);
             gameState.economyLaw = new EconomyLaw(EconomyLaws.WAR_ECONOMY);

             printTimeLog("walther Funk ideas",days);
             gameState.getMilitaryFactory().addConstructionSpeedModifier(0.1f);
             gameState.updateGameState();
             break;
             case 490:
             printTimeLog("Anschluss",days);
             gameState.getIntegerStateMap().put(153, new State("Tyrol", 153, 8, 4, 1, 0, 5, 0));
             gameState.getIntegerStateMap().put(152, new State("Upper Austria", 152, 6, 6, 1, 0, 4, 0));
             gameState.getIntegerStateMap().put(4, new State("Lower Austria", 4, 7, 8, 3, 0, 5, 0));
             gameState.updateGameState();
             break;
             case 560:
             printTimeLog("Sudetenland",days);
             gameState.stability = 0.94f;

             gameState.getIntegerStateMap().put(69, new State("Sudetenland", 69, 8, 4, 1, 0, 2, 0));
             gameState.getIntegerStateMap().put(152, new State("Eastern Sudetenland", 74, 6, 2, 1, 0, 0, 0));

             printTimeLog("remove Schacht Ideas",days);
             gameState.getCivilianFactory().addConstructionSpeedModifier(-0.1f);
             gameState.getInfrastructure().addConstructionSpeedModifier(-0.1f);
             gameState.updateGameState();
             break;
             case 630:
             printTimeLog("Reichsautobahn",days);
             gameState.getIntegerStateMap().get(64).setInfrastructureLevel(10);
             gameState.getIntegerStateMap().get(59).setInfrastructureLevel(10);
             gameState.getIntegerStateMap().get(60).setInfrastructureLevel(10);
             gameState.getIntegerStateMap().get(54).setInfrastructureLevel(10);
             gameState.updateGameState();
             break;
             case 770:
             printTimeLog("partition czechoslovakia with hungary",days);
             gameState.getIntegerStateMap().put(9, new State("Bohemia", 9, 7, 8, 6, 0, 1, 0));
             gameState.getIntegerStateMap().put(75, new State("Moravia", 75, 7, 6, 1, 0, 4, 0));
             gameState.updateGameState();
             break;
             case 840:
             printTimeLog("Memelland",days);
             gameState.getIntegerStateMap().put(188, new State("Memel", 188, 7, 2, 1, 0, 1, 0));
             gameState.updateGameState();
             break;
             case 910:
             printTimeLog("Slovenia",days);
             gameState.getIntegerStateMap().put(102, new State("Slovenia", 102, 6, 5, 0, 0, 1, 0));
             gameState.updateGameState();
             break;
             }


        }

        System.out.println("Civilian Factories : " + gameState.getCivilianFactory().getAmount() + "+" + gameState.getCivilianFactory().getOffMapAmount() + "");
        System.out.println("Military Factories : " + gameState.getMilitaryFactory().getAmount());
        System.out.println("Total days military factories were running: " + accumulatedMilFactoryDays);
    }

    public static void printTimeLog(String message, int days) {
        System.out.println("Day: " + days + " " + message);
    }

}