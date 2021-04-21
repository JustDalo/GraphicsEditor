package net.oop.gEditor.uicore.UI;

import net.oop.gEditor.uicore.Mouse.Mouse;
import net.oop.gEditor.uicore.ShapeFactory.LineFactory;
import net.oop.gEditor.uicore.ShapeFactory.ShapeFactory;
import net.oop.gEditor.uicore.ModuleLoader.ModuleLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ToolBar extends JToolBar {

    public ShapeFactory shapeFactory;

    public ToolBar(Mouse mouse) {
        this.setOrientation(SwingConstants.VERTICAL);
        this.setFloatable(false);
        this.setBounds(0, 30, 30, 350);
        addToolBtn(mouse);
    }

    private void addToolBtn(Mouse mouse) {
        shapeFactory = new LineFactory();
        mouse.setShapeFactory(shapeFactory);

        List<ShapeFactory> factories = new ModuleLoader().getAllFactories();

        for (int i = 0; i <  factories.size(); i++) {
            ShapeFactory factory = factories.get(i);
            String className = factory.getClass().toString();
            Button btn = new Button(className.substring(className.lastIndexOf(".")+1, className.lastIndexOf("Factory")));

            btn.setBackground(Color.white);
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    mouse.setShapeFactory(factory);
                    mouse.points.clear();
                }
            });

            this.add(btn);
        }
    }
}
