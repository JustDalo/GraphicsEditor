package net.oop.gEditor.uicore.ShapeFactory;

import net.oop.gEditor.uicore.Shapes.Polygon;
import net.oop.gEditor.uicore.Shapes.Shape;

public class PolygonFactory extends ShapeFactory {
    public Shape getShape() {
        return new Polygon();
    }
}
