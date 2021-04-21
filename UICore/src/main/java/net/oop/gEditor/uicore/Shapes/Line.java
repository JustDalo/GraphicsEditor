package net.oop.gEditor.uicore.Shapes;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

import net.oop.gEditor.uicore.WorkPanel.Panel;

public class Line extends Shape implements Serializable {
    private int x1;
    private int y1;
    private int x2;

    private int y2;
    private int lineWeight;
    private Color currColor;

    public Line() {
    }

    @Override
    public void realTimeDraw(ArrayList<Integer> points, int lineWeight, Color currColor, Color fillColor, Panel board) {
        this.x1 = points.get(points.size() - 4);
        this.y1 = points.get(points.size() - 3);
        this.x2 = points.get(points.size() - 2);
        this.y2 = points.get(points.size() - 1);
        this.lineWeight = lineWeight;
        this.currColor = currColor;

    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(currColor);
        g2.setStroke(new BasicStroke(lineWeight));
        g2.drawLine(x1, y1, x2, y2);

    }

}
