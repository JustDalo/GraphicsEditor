package net.oop.gEditor.uicore.Serialization;

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
                        File iF = new File(fileName);

                        FileInputStream fis = new FileInputStream(fileName);
                        ObjectInputStream ois = new ObjectInputStream(fis);

                        panel.shapes = (ArrayList) ois.readObject();
                        panel.repaint();

                        ois.close();
                        fis.close();
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    System.out.println(ex);
                }
            }
        };
        JMenuItem loadMenu = new JMenuItem(loadAction);
        fileMenu.add(loadMenu);
    }

}
