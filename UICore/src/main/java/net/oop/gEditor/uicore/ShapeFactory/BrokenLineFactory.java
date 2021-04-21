package net.oop.gEditor.uicore.ShapeFactory;

import net.oop.gEditor.uicore.Shapes.BrokenLine;
import net.oop.gEditor.uicore.Shapes.Shape;

public class BrokenLineFactory extends ShapeFactory {
    public Shape getShape() {
        return new BrokenLine();
    }
}
