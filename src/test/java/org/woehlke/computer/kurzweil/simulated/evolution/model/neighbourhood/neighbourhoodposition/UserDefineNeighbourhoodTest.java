package org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.neighbourhoodposition;

import org.junit.Test;
import org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.LatticePointNeighbourhoodPosition;

import static org.junit.Assert.*;
import static org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.LatticePointNeighbourhoodPosition.*;

public class UserDefineNeighbourhoodTest {

    @Test
    public void getNeighbourhoodPositions() {
        //given
        Neighbourhoods neighbourhoods = new UserDefineNeighbourhood();
        //when
        LatticePointNeighbourhoodPosition[] neighbourhoodPositions = neighbourhoods.getNeighbourhoodPositions();
        //then
        assertSame(neighbourhoodPositions[0], NORTH_WEST);
        assertSame(neighbourhoodPositions[1], NORTH);
        assertSame(neighbourhoodPositions[2],NORTH_EAST);
        assertSame(neighbourhoodPositions[3], EAST);
        assertSame(neighbourhoodPositions[4],SOUTH_WEST);
        assertSame(neighbourhoodPositions[5], WEST);
    }
}
