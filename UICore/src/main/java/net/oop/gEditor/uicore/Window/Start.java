package net.oop.gEditor.uicore.Window;

import net.oop.gEditor.uicore.Mouse.Mouse;
import net.oop.gEditor.uicore.UI.ColorBar;
import net.oop.gEditor.uicore.UI.MenuBar;
import net.oop.gEditor.uicore.UI.ToolBar;
import net.oop.gEditor.uicore.UndoRedo.UndoRedo;
import net.oop.gEditor.uicore.WorkPanel.Board;
import net.oop.gEditor.uicore.WorkPanel.Panel;

import javax.swing.*;

public class Start {
    private static Board myFrame;
    private static Panel myPanel;
    private static Mouse myMouse;


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                myFrame = new Board();
                myPanel = new Panel();
                myMouse = new Mouse(myPanel);
                myFrame.setVisible(true);
                myFrame.setJMenuBar(new MenuBar(myPanel));
                myFrame.add(new ColorBar(myFrame, myPanel));
                myFrame.add(myPanel);
                myFrame.add(new ToolBar(myMouse));
                new UndoRedo(myPanel, myMouse);
            }
        });
    }
}
