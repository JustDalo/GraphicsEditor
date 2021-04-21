package net.oop.gEditor.uicore.UI;

import net.oop.gEditor.uicore.Shapes.Shape;
import net.oop.gEditor.uicore.WorkPanel.Panel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuBar extends JMenuBar {

    public MenuBar(Panel panel) {

        JMenu fileMenu = new JMenu("File");
        this.add(fileMenu);
        JMenu editMenu = new JMenu("Editing");
        this.add(editMenu);

       // new OpenFile(fileMenu, panel);
       // new SaveAsFile(fileMenu, panel);

        editBtn(editMenu, panel);

    }

    private void editBtn(JMenu editMenu, Panel board) {
        Action undoAction = new AbstractAction("Undo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (board.shapes.size() != 0) {
                    Shape last = board.shapes.get(board.shapes.size() - 1);
                    board.shapes.remove(last);
                    board.removedShapes.add(last);
                    board.repaint();
                }
            }
        };
        JMenuItem undoMenu = new JMenuItem(undoAction);
        editMenu.add(undoMenu);

        Action redoAction = new AbstractAction("Redo") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (board.removedShapes.size() != 0) {
                    Shape last = board.removedShapes.get(board.removedShapes.size() - 1);
                    board.shapes.add(last);
                    board.removedShapes.remove(last);
                    board.repaint();
                }
            }
        };
        JMenuItem redoMenu = new JMenuItem(redoAction);
        editMenu.add(redoMenu);
    }
}
