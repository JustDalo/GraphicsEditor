package net.oop.gEditor.pluginCore;

import net.oop.gEditor.uicore.Shapes.Shape;
import net.oop.gEditor.uicore.WorkPanel.Panel;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Trapeze extends Shape implements Serializable {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int lineWeight;
    private Color currColor;
    private Color fillColor;

    private int[] x;
    private int[] y;

    @Override
    public void realTimeDraw(ArrayList<Integer> points, int lineWeight, Color currColor, Color fillColor, Panel board) {
        this.lineWeight = lineWeight;
        this.currColor = currColor;
        this.fillColor = fillColor;

        this.x1 = points.get(points.size() - 4);
        this.y1 = points.get(points.size() - 3);
        this.x2 = points.get(points.size() - 2);
        this.y2 = points.get(points.size() - 1);




        this.x[0] = points.get(points.size() - 4);
        this.x[1] = 0;
        this.x[2] = points.get(points.size() - 2);
        this.x[3] = 0;

        this.y[0] = points.get(points.size() - 3);
        this.y[1] = 0;
        this.y[2] = points.get(points.size() - 1);
        this.y[3] = 0;
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setStroke(new BasicStroke(lineWeight));
        g2.setColor(fillColor);
        g2.fillPolygon(x, y, x.length);
        g2.setColor(currColor);
        g2.drawPolygon(x, y, x.length);

    }
}
