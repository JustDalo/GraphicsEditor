package net.oop.gEditor.uicore.Serialization;

//import com.fasterxml.jackson.databind.ObjectMapper;
import net.oop.gEditor.uicore.ModuleLoader.ModuleLoader;
import net.oop.gEditor.uicore.Shapes.Shape;
import net.oop.gEditor.uicore.WorkPanel.Panel;


import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class OpenFile {
    public OpenFile(JMenu fileMenu, Panel panel) {

        Action loadAction = new AbstractAction("Open") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JFileChooser jf = new JFileChooser();
                    jf.addChoosableFileFilter(new FileFilter() {
                        @Override
                        public boolean accept(File f) {
                            if (f.isDirectory()) {
                                return true;
                            }
                            if (f.getName().endsWith(".json")) {
                                return true;
                            }
                            return false;
                        }

                        @Override
                        public String getDescription() {
                            return "*.json";
                        }
                    });
                    int result = jf.showOpenDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        String fileName = jf.getSelectedFile().getAbsolutePath();

                        FileInputStream fis = new FileInputStream(fileName);
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        panel.removedShapes.clear();
                        panel.shapes = (ArrayList<Shape>) ois.readObject();
                        panel.repaint();

                        ois.close();
                        fis.close();
                    }
                } catch (Exception ex) {
                    System.out.println(ex);

                }
            }
        };
        JMenuItem loadMenu = new JMenuItem(loadAction);
        fileMenu.add(loadMenu);
    }

}
