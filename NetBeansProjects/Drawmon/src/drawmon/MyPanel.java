/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package drawmon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author jczr8
 */
class MyPanel extends JPanel {

    private static final int ROWS = 10;
    private static final int COLS = 10;

    private boolean[][] grid = new boolean[ROWS][COLS];
    private boolean drawMode = true;

    public MyPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = e.getY() / (getHeight() / ROWS);
                int col = e.getX() / (getWidth() / COLS);
                grid[row][col] = drawMode;
                repaint();
            }
        });

        getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "toggleDrawMode");
        getActionMap().put("toggleDrawMode", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawMode = !drawMode;
                setBackground(drawMode ? Color.WHITE : Color.LIGHT_GRAY);
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                requestFocusInWindow();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellWidth = getWidth() / COLS;
        int cellHeight = getHeight() / ROWS;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col]) {
                    g.fillRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
                }
            }
        }
    }

  public BufferedImage getImage() {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        paint(g);
        g.dispose();
        return image;
        
    }


}
