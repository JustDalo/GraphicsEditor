package net.oop.gEditor.uicore.ShapeFactory;

import net.oop.gEditor.uicore.Shapes.Shape;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public abstract class ShapeFactory {
    public abstract Shape getShape();

    public static List<ShapeFactory> getServices(ModuleLayer layer) {
        return ServiceLoader
                .load(layer, ShapeFactory.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }
}
