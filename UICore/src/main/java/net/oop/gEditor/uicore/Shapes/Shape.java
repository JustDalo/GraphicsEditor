package net.oop.gEditor.uicore.Shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import net.oop.gEditor.uicore.WorkPanel.Panel;

public abstract class Shape {
    public abstract void realTimeDraw(ArrayList<Integer> points, int lineWeight, Color currColor, Color fillColor, Panel board);

    public abstract void draw(Graphics2D g2);

    public static List<Shape> getServices(ModuleLayer layer) {
        return ServiceLoader
                .load(layer, Shape.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }
}
