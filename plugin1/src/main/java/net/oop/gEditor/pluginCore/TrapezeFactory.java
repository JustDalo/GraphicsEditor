package net.oop.gEditor.pluginCore;

import net.oop.gEditor.uicore.ShapeFactory.ShapeFactory;
import net.oop.gEditor.uicore.Shapes.Shape;

public class TrapezeFactory extends ShapeFactory {
    public Shape getShape() {
        return new Trapeze();
    }
}
