package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NextBuildQueueCheckDTO {
    private boolean maxedInfraFound;
    private boolean infrastructureBetter;
    private int stateId;

}
