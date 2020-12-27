package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class WishListItem {
    private BuildingType buildingType;
    private int amount;
}
