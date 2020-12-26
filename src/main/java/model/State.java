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
    private int emptySlots;
    private float slotModifier;
    private int pendingSlots;
    private int pendingInfrastructue;
    private int openInfrastructureLevel;

    public State(String name, int id, int infrastructureLevel, int baseSlots, int milAmount, int dockAmount, int civAmount, int synthAmount) {
        this.name = name;
        this.id = id;
        this.infrastructureLevel = infrastructureLevel;
        this.baseSlots = baseSlots;
        this.milAmount = milAmount;
        this.dockAmount = dockAmount;
        this.civAmount = civAmount;
        this.synthAmount = synthAmount;
        this.pendingSlots = 0;
        this.pendingInfrastructue = 0;
        this.openInfrastructureLevel = 0;
    }

    public void refreshData() {
        this.usedSlots = milAmount + dockAmount + civAmount + synthAmount;
        this.emptySlots = Math.round(baseSlots * (1 + slotModifier) - usedSlots - pendingSlots);
        this.openInfrastructureLevel = 10 - infrastructureLevel - pendingInfrastructue;
    }

    public void addInfrastructureLevel() {
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

    public void addPendingInfrastructureLevel() {
        this.pendingInfrastructue++;
    }

    public void addPendingSlot() {
        this.pendingSlots++;
    }

}
