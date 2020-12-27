package Fixtures.Countries;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.State;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Countries {


    public List<State> getStateListGermany1936(){
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

        return stateList;
    }

}
