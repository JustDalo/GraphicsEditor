import net.oop.gEditor.pluginCore.*;
import net.oop.gEditor.uicore.ShapeFactory.ShapeFactory;
import net.oop.gEditor.uicore.Shapes.Shape;

module Plugin1 {
    requires UICore;
    requires java.desktop;

    exports net.oop.gEditor.pluginCore;

    provides Shape with Trapeze;
    provides ShapeFactory with TrapezeFactory;
}
