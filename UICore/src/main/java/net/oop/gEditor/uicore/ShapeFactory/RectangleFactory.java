package net.oop.gEditor.uicore.ShapeFactory;

import net.oop.gEditor.uicore.Shapes.Rectangle;
import net.oop.gEditor.uicore.Shapes.Shape;

public class RectangleFactory extends ShapeFactory {
    public Shape getShape() {
        return new Rectangle();
    }
}
