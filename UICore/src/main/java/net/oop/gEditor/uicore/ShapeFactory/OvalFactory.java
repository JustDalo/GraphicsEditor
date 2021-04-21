package net.oop.gEditor.uicore.ShapeFactory;

import net.oop.gEditor.uicore.Shapes.Oval;
import net.oop.gEditor.uicore.Shapes.Shape;

public class OvalFactory extends ShapeFactory {
    public Shape getShape() {
        return new Oval();
    }
}
