import net.oop.gEditor.uicore.Shapes.*;
import net.oop.gEditor.uicore.ShapeFactory.*;


module UICore {
    requires java.desktop;

    exports net.oop.gEditor.uicore.ShapeFactory;
    exports net.oop.gEditor.uicore.Shapes;
    exports net.oop.gEditor.uicore.WorkPanel;

    uses Shape;
    uses ShapeFactory;

    provides Shape with Line, Oval, Rectangle, Polygon, BrokenLine;
    provides ShapeFactory with LineFactory, OvalFactory, RectangleFactory, PolygonFactory, BrokenLineFactory;
}
