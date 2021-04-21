package net.oop.gEditor.uicore.Mouse;

import net.oop.gEditor.uicore.ShapeFactory.ShapeFactory;
import net.oop.gEditor.uicore.Shapes.Shape;
import net.oop.gEditor.uicore.WorkPanel.Panel;


import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class Mouse {
    private boolean pressed = false;
    private ShapeFactory shapeFactory;
    public ArrayList<Integer> points = new ArrayList<>();

    public Shape shape;

    public void setShapeFactory(ShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }

    public Mouse(Panel board) {
        board.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent e) {
                if (pressed) {
                    points.set(points.size() - 2, e.getX());
                    points.set(points.size() - 1, e.getY());
                    shape.realTimeDraw(points, board.weight, board.currColor, board.fillColor, board);
                    board.repaint();
                }
            }
        });

        board.addMouseListener(new MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {
                board.removedShapes.clear();
                if (SwingUtilities.isLeftMouseButton(e)) {
                    if (!pressed) {
                        points.add(e.getX());
                        points.add(e.getY());
                        points.add(e.getX());
                        points.add(e.getY());


                        shape = shapeFactory.getShape();
                        shape.realTimeDraw(points, board.weight, board.currColor, board.fillColor, board);
                        board.shapes.add(shape);
                        board.repaint();
                        pressed = true;
                    } else {
                        points.add(e.getX());
                        points.add(e.getY());
                    }
                }

                if (SwingUtilities.isRightMouseButton(e)) {
                    points.clear();
                }
                board.repaint();
            }

            public void mouseReleased(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 1 && !e.isConsumed()) {
                    pressed = false;
                }
            }
        });
    }
}
