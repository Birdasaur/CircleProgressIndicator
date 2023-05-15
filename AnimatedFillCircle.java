package edu.jhuapl.trinity.javafx.components.radial;

/*-
 * #%L
 * ******************************* UNCLASSIFIED *******************************
 * AnimatedFillCircle.java
 * trinity:trinity
 * %%
 * Copyright (C) 2021 - 2023 Johns Hopkins University Applied Physics Laboratory
 * %%
 * (c) Johns Hopkins University Applied Physics Laboratory. All Rights Reserved.
 * This material may only be used, modified, or reproduced by or for the
 * U.S. government pursuant to the license rights granted under FAR
 * clause 52.227-14 or DFARS clauses 252.227-7013/7014.
 * For any other permission, please contact the Legal Office at JHU/APL.
 * #L%
 */

import java.util.ArrayList;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;

/**
 *
 * @author phillsm1
 */
public class AnimatedFillCircle extends Circle {
    public Color fillStartColor = Color.CYAN;
    public Color fillEndColor = Color.CYAN;
    public LinearGradient lg;
    public Stop stop1, stop2, stop3;
    public SimpleDoubleProperty percentComplete = new SimpleDoubleProperty(0.0);

    public AnimatedFillCircle(double radius, double strokeWidth, Double... dashedArray) {
        updateComplete();
        setStroke(fillStartColor);
        setStrokeWidth(strokeWidth);
        setEffect(new Glow(0.9));
        setRadius(radius);
        getStrokeDashArray().setAll(dashedArray);
        percentComplete.addListener(l -> updateComplete());
    }
    public void setPercentComplete(double complete) {
        percentComplete.set(complete);
    }
    private void updateComplete() {
        stop1 = new Stop(0, fillStartColor);
        Color endColor = fillEndColor.deriveColor(
    1, 1, 1, percentComplete.get()/1.0);
//        stop2 = new Stop(percentComplete.get(), endColor);
        stop2 = new Stop(percentComplete.get(), Color.TRANSPARENT);


//        stop3 = new Stop(1, Color.TRANSPARENT);
        stop3 = new Stop(1, fillEndColor);
        ArrayList<Stop> stops = new ArrayList<>();
        stops.add(stop1);
        stops.add(stop2);
        stops.add(stop3);
        lg = new LinearGradient(
        0.5, 1.0, 0.5,0.0, true, CycleMethod.NO_CYCLE, stops);
        setFill(lg);
    }
}
