package net.oop.gEditor.uicore.WorkPanel;

import net.oop.gEditor.uicore.ModuleLoader.ModuleLoader;
import net.oop.gEditor.uicore.Shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Panel extends JPanel {

    public ArrayList<Shape> shapes = new ArrayList<>();
    public ArrayList<Shape> removedShapes = new ArrayList<>();

    public Color currColor;
    public Color fillColor;
    public int weight;

    public Panel() {
        this.setBounds(30, 30, 1920, 1080);
        this.setBackground(Color.white);
        this.setOpaque(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (Shape shape : shapes) {
            shape.draw(g2);
        }
    }
}
