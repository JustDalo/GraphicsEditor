package net.oop.gEditor.uicore.UI;

import net.oop.gEditor.uicore.WorkPanel.Board;
import net.oop.gEditor.uicore.WorkPanel.Panel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorBar extends JToolBar {
    private JColorChooser colorPanel;
    private JColorChooser colorFillPanel;
    private Color currColor;
    private Color fillColor;

    public ColorBar(Board f, Panel panel) {

        this.setName("Color bar");
        this.setBounds(0, 0, 350, 30);
        this.setRollover(false);
        currColor = Color.black;
        fillColor = Color.white;

        JButton colorBtn = new JButton();
        colorBtn.setBackground(currColor);
        colorBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ColorDialog colDi = new ColorDialog(f, "Color");
                colDi.setVisible(true);
            }
        });
        this.add(colorBtn);
        colorBtn.setBackground(currColor);


        JButton colorFillBtn = new JButton();
        colorFillBtn.setBackground(fillColor);
        colorFillBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ColorFillDialog colFillDi = new ColorFillDialog(f, "Color");
                colFillDi.setVisible(true);
            }
        });
        this.add(colorFillBtn);
        colorFillBtn.setBackground(fillColor);

        this.addSeparator();

        addColorBtn(Color.blue, colorBtn, panel);
        addColorBtn(Color.red, colorBtn, panel);
        addColorBtn(Color.green, colorBtn, panel);
        addColorBtn(Color.black, colorBtn, panel);
        addColorBtn(Color.white, colorBtn, panel);
        addColorBtn(Color.yellow, colorBtn, panel);
        addColorBtn(Color.orange, colorBtn, panel);

        colorPanel = new JColorChooser(currColor);
        colorPanel.getSelectionModel().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                currColor = colorPanel.getColor();
                panel.currColor = currColor;
                colorBtn.setBackground(currColor);
            }
        });

        colorFillPanel = new JColorChooser(fillColor);
        colorFillPanel.getSelectionModel().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                fillColor = colorFillPanel.getColor();
                panel.fillColor = fillColor;
                colorFillBtn.setBackground(fillColor);
            }
        });

        this.addSeparator();
        this.addSeparator();

        //SLIEDER
        JSlider lineWeight = new JSlider(1, 10);
        JLabel sliderlabel = new JLabel("Line weight", JLabel.CENTER);
        sliderlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        lineWeight.setPaintLabels(true);
        lineWeight.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int weight = lineWeight.getValue();
                panel.weight = weight;
            }
        });
        this.add(sliderlabel);
        this.add(lineWeight);

        panel.currColor = Color.black;
        panel.fillColor = Color.white;
    }

    private void addColorBtn(Color btnColor, JButton currCol, Panel panel) {
        JButton colorBtn = new JButton();
        colorBtn.setBackground(btnColor);
        colorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.currColor = btnColor;
                currColor = btnColor;
                currCol.setBackground(btnColor);
            }
        });
        this.add(colorBtn);
    }

    class ColorDialog extends JDialog {
        public ColorDialog(JFrame mainFrame, String title) {
            super(mainFrame, title, true);
            add(colorPanel);
            setSize(420, 300);
        }
    }

    class ColorFillDialog extends JDialog {
        public ColorFillDialog(JFrame mainFrame, String title) {
            super(mainFrame, title, true);
            add(colorFillPanel);
            setSize(420, 300);
        }
    }
}
