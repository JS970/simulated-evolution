package org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.neighbourhoodposition.*;

import static org.junit.Assert.*;
import static org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.LatticePointNeighbourhoodPosition.*;
import static org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.LatticePointNeighbourhoodType.*;

public class LatticePointNeighbourhoodPositionTest {

    @Test
    public void getNeighbourhoodFor() {
        //given
        LatticePointNeighbourhoodPosition[] mooreNeighborhood;
        LatticePointNeighbourhoodPosition[] vonNeumannNeighbourhood;
        LatticePointNeighbourhoodPosition[] userDefineNeighbourhood;


        LatticePointNeighbourhoodPosition[] mooreExpect = {NORTH_WEST,NORTH, NORTH_EAST, EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, WEST};
        LatticePointNeighbourhoodPosition[] vonNeumannExpect = {NORTH, EAST, SOUTH, WEST};
        LatticePointNeighbourhoodPosition[] userDefineExpect = {NORTH_WEST, NORTH,NORTH_EAST,EAST,SOUTH_WEST, WEST};
        //when
        mooreNeighborhood = LatticePointNeighbourhoodPosition.getNeighbourhoodFor(MOORE_NEIGHBORHOOD);
        vonNeumannNeighbourhood = LatticePointNeighbourhoodPosition.getNeighbourhoodFor(VON_NEUMANN_NEIGHBORHOOD);
        userDefineNeighbourhood = LatticePointNeighbourhoodPosition.getNeighbourhoodFor(USER_DEFINE_NEIGHBORHOOD);

        //then
        assertTrue(checkPositionEquals(mooreNeighborhood, mooreExpect));
        assertTrue(checkPositionEquals(vonNeumannNeighbourhood, vonNeumannExpect));
        assertTrue(checkPositionEquals(userDefineNeighbourhood, userDefineExpect));
    }

    private boolean checkPositionEquals(LatticePointNeighbourhoodPosition[] target,LatticePointNeighbourhoodPosition[] expect){
        if(target.length != expect.length) return false;
        for(int i = 0; i < target.length; i++){
            if(target[i] != expect[i]) return false;
        }
        return true;
    }


}
