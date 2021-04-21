package net.oop.gEditor.uicore.Serialization;

import net.oop.gEditor.uicore.WorkPanel.Panel;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveAsFile {
    public SaveAsFile(JMenu fileMenu, Panel panel) {
        Action saveAction = new AbstractAction("Save") {
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
                    int result = jf.showSaveDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION) {
                        String fileName = jf.getSelectedFile().getAbsolutePath();
                        FileOutputStream out = new FileOutputStream(fileName + ".json");
                        ObjectOutputStream oos = new ObjectOutputStream(out);
                        oos.writeObject(panel.shapes);
                        oos.flush();
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    System.out.println(ex);
                }
            }
        };
        JMenuItem saveMenu = new JMenuItem(saveAction);
        fileMenu.add(saveMenu);
    }
}
