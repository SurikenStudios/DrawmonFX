package drawmon;

import igu.Login;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Drawmon {
    public static void main(String[] args) {
       
        // Todo esto es lo de la pantalla para dibujar
        
        JFrame frame = new JFrame("Dibujo libre");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        MyPanel panel = new MyPanel();
        frame.add(panel);

        JButton doneButton = new JButton("Hecho");
        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage image = panel.getImage();
                // Usa la imagen como un modelo 2D para la mascota del jugador

                // Guarda la imagen en un archivo
                File file = new File("mascota.png");
                try {
                    ImageIO.write(image, "png", file);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
                frame.dispose();
            }
        });
        
        frame.add(doneButton, BorderLayout.SOUTH);
        
        frame.setVisible(true);
        
        
    }
}



