package model;

import lombok.Data;

@Data
public class State {
    private String name;
    private int id;
    private int infrastructureLevel;
    private int baseSlots;
    private int milAmount;
    private int dockAmount;
    private int civAmount;
    private int synthAmount;
    private int usedSlots;
    private float emptySlots;
    private float slotModifier;

    public State(String name, int id, int infrastructureLevel, int baseSlots, int milAmount, int dockAmount, int civAmount, int synthAmount){
        this.name = name;
        this.id = id;
        this.infrastructureLevel = infrastructureLevel;
        this.baseSlots = baseSlots;
        this.milAmount = milAmount;
        this.dockAmount = dockAmount;
        this.civAmount = civAmount;
        this.synthAmount = synthAmount;
    }

    public void refreshData() {
        this.usedSlots = milAmount + dockAmount + civAmount + synthAmount;
        this.emptySlots = baseSlots * (1 + slotModifier) - usedSlots;
    }

    public void addInfrastrucureLevel() {
        this.infrastructureLevel++;
    }

    public void addCivilianFactory() {
        this.civAmount++;
    }

    public void removeCivilianFactory() {
        this.civAmount--;
    }

    public void addMilitaryFactory() {
        this.milAmount++;
    }

    public void removeMilitaryFactory() {
        this.milAmount--;
    }

    public void addSyntheticRefinery() {
        this.synthAmount++;
    }

    public void addDockyard() {
        this.dockAmount++;
    }

}
