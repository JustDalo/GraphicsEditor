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

        int x1 = points.get(points.size() - 4);
        int y1 = points.get(points.size() - 3);
        int x2 = points.get(points.size() - 2);
        int y2 = points.get(points.size() - 1);
        int width = points.get(points.size() - 2) - points.get(points.size() - 4);
        int height = points.get(points.size() - 1) - points.get(points.size() - 3);
        this.x = new int[4];
        this.y = new int[4];

        this.x[0] = x1 + 50;
        this.x[1] = x1 + width - 50;
        this.x[2] = x2;
        this.x[3] = x2 - width;

        this.y[0] = y1;
        this.y[1] = y1;
        this.y[2] = y2;
        this.y[3] = y2;

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
