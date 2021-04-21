package net.oop.gEditor.uicore.UndoRedo;

import net.oop.gEditor.uicore.Mouse.Mouse;
import net.oop.gEditor.uicore.Shapes.Shape;
import net.oop.gEditor.uicore.WorkPanel.Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UndoRedo {
    public UndoRedo(Panel board, Mouse mouse) {
        InputMap input = board.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        input.put(KeyStroke.getKeyStroke("ctrl pressed Z"), "undo");
        input.put(KeyStroke.getKeyStroke("ctrl pressed U"), "redo");

        board.getActionMap().put("undo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (board.shapes.size() != 0) {
                    Shape last = board.shapes.get(board.shapes.size() - 1);
                    mouse.points.clear();
                    board.shapes.remove(last);
                    board.removedShapes.add(last);
                    board.repaint();
                }
            }
        });

        board.getActionMap().put("redo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (board.removedShapes.size() != 0) {
                    Shape last = board.removedShapes.get(board.removedShapes.size() - 1);
                    board.shapes.add(last);
                    board.removedShapes.remove(last);
                    board.repaint();
                }
            }
        });
    }
}
