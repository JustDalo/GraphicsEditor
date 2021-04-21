package net.oop.gEditor.uicore.Shapes;

import net.oop.gEditor.uicore.WorkPanel.Panel;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Polygon extends Shape implements Serializable {

    private int[] x;
    private int[] y;
    private int lineWeight;
    private Color currColor;
    private Color fillColor;
    private int count = 1;

    @Override
    public void realTimeDraw(ArrayList<Integer> points, int lineWeight, Color currColor, Color fillColor, Panel board) {
        this.currColor = currColor;
        this.lineWeight = lineWeight;
        this.fillColor = fillColor;

        this.x = new int[points.size() / 2];
        this.y = new int[points.size() / 2];
        for (int i = 0; i < (points.size() / 2); i++) {
            x[i] = points.get(i * 2);
            y[i] = points.get(i * 2 + 1);
        }
        if (points.size() > 4 && count == 1) {
            board.shapes.remove(board.shapes.get(board.shapes.size() - 1));
        }
        count++;
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
