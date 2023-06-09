package org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.neighbourhoodposition;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.LatticePointNeighbourhoodPosition;

import static org.junit.Assert.*;
import static org.woehlke.computer.kurzweil.simulated.evolution.model.neighbourhood.LatticePointNeighbourhoodPosition.CENTER;

public class OtherNeighbourhoodTest {

    @Test
    public void getNeighbourhoodPosition(){
        //given
        Neighbourhoods neighbourhoods = new OtherNeighbourhood();
        //when
        LatticePointNeighbourhoodPosition[] neighbourhoodPositions = neighbourhoods.getNeighbourhoodPositions();
        //then
        Assertions.assertSame(neighbourhoodPositions[0], CENTER);
     }
}
