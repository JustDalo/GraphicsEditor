package net.oop.gEditor.uicore.ShapeFactory;

import net.oop.gEditor.uicore.Shapes.Line;
import net.oop.gEditor.uicore.Shapes.Shape;

public class LineFactory extends ShapeFactory {
    public Shape getShape() {
        return new Line();
    }
}

