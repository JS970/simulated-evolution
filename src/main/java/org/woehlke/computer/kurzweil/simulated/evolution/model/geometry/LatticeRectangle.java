package org.woehlke.computer.kurzweil.simulated.evolution.model.geometry;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

@Log4j2
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LatticeRectangle implements Serializable {

    static final long serialVersionUID = 242L;

    private LatticePoint start;

    private LatticeDimension dimension;

    public static LatticeRectangle of(LatticePoint start, LatticeDimension dimension){
        return new LatticeRectangle(start, dimension);
    }

    public static LatticeRectangle of(int startX, int  startY, int width, int height){
        LatticePoint start = new LatticePoint(startX, startY);
        LatticeDimension dimension = new LatticeDimension(width, height);
        return new LatticeRectangle(start, dimension);
    }
}
