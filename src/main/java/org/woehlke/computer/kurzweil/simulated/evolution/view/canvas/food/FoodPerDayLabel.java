package org.woehlke.computer.kurzweil.simulated.evolution.view.canvas.food;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.woehlke.computer.kurzweil.simulated.evolution.control.SimulatedEvolutionContext;

import javax.swing.*;

/**
 * &copy; 2006 - 2008 Thomas Woehlke.
 * http://java.woehlke.org/simulated-evolution/
 * @author Thomas Woehlke
 */
@Log4j2
@Getter
@ToString(callSuper = true)
public class FoodPerDayLabel extends JLabel {

    private static final long serialVersionUID = 242L;

    @ToString.Exclude
    private final SimulatedEvolutionContext tabCtx;
    private final String foodPerDayLabelString;

    public FoodPerDayLabel(SimulatedEvolutionContext tabCtx) {
        super(tabCtx.getCtx().getProperties().getSimulatedevolution().getFood().getFoodPerDayLabel());
        this.tabCtx = tabCtx;
        this.foodPerDayLabelString = this.tabCtx.getCtx().getProperties().getSimulatedevolution().getFood().getFoodPerDayLabel();
    }
}
