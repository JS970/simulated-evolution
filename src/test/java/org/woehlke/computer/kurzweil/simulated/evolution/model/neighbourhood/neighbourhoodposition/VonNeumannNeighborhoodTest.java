package org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.neighbourhoodposition;

import org.junit.Test;
import org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.LatticePointNeighbourhoodPosition;

import static org.junit.Assert.*;
import static org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.LatticePointNeighbourhoodPosition.*;

public class VonNeumannNeighborhoodTest {

    @Test
    public void getNeighbourhoodPosition() throws Exception{
        //given
        Neighbourhoods neighbourhoods = new VonNeumannNeighborhood();
        //when
        LatticePointNeighbourhoodPosition[] neighbourhoodPositions = neighbourhoods.getNeighbourhoodPositions();
        //then
        assertSame(neighbourhoodPositions[0], NORTH);
        assertSame(neighbourhoodPositions[1], EAST);
        assertSame(neighbourhoodPositions[2], SOUTH);
        assertSame(neighbourhoodPositions[3], WEST);
     }

}
