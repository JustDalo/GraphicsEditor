package net.oop.gEditor.uicore.Shapes;

import net.oop.gEditor.uicore.WorkPanel.Panel;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Oval extends Shape implements Serializable {
    int x;
    int y;
    int width;
    int height;
    private int lineWeight;
    private Color currColor;
    private Color fillColor;

    public Oval() {

    }

    @Override
    public void realTimeDraw(ArrayList<Integer> points, int lineWeight, Color currColor, Color fillColor, Panel board) {
        this.lineWeight = lineWeight;
        this.currColor = currColor;
        this.fillColor = fillColor;
        this.x = points.get(points.size() - 4);
        this.y = points.get(points.size() - 3);
        this.width = points.get(points.size() - 2) - points.get(points.size() - 4);
        this.height = points.get(points.size() - 1) - points.get(points.size() - 3);
        if (width < 0) {
            x += width;
            width = -width;
        }
        if (height < 0) {
            y += height;
            height = -height;
        }
    }

    @Override
    public void draw(Graphics2D g2) {

        g2.setStroke(new BasicStroke(lineWeight));
        g2.setColor(fillColor);
        g2.fillOval(x, y, width, height);
        g2.setColor(currColor);
        g2.drawOval(x, y, width, height);
    }
}
