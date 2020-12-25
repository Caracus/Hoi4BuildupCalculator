package model;

public enum StateCategory {
    WASTELAND(0),
    ENCLAVE(0),
    TINY_ISLAND(0),
    SMALL_ISLAND(1),
    PASTORAL(1),
    RURAL(2),
    TOWN(4),
    LARGE_TOWN(5),
    CITY(6),
    LARGE_CITY(8),
    METROPOLIS(10),
    MEGALOPOLIS(12);

    private int value;
    private StateCategory(int value) {
        this.value = value;
    }

    public int getValue(){
        return  value;
    }
}
