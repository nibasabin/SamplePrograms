/*
 * Class: Resize
 * Method: imageToBufferedImage(Image)
 * Description: Allows user to resize the image into desired size and creates new JFrame
 */
package sidewalksketcher;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static sidewalksketcher.ImageFilter.Filter;

/**
 *
 * @author Sabin Raj Bajracharya, Pranil Maharjan
 */
public class Resize implements ActionListener {

    BufferedImage image = null;
    public static ImageIcon imageIcon;

    public static BufferedImage imageToBufferedImage(Image im) {
        BufferedImage bi = new BufferedImage(im.getWidth(null), 
                im.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics bg = bi.getGraphics();
        bg.drawImage(im, 0, 0, null);
        bg.dispose();
        return bi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        image = SidewalkSketcherGUI.imageDB[0];
        String Height = JOptionPane.showInputDialog("Enter Crop Height");
        int cropHeight = Integer.parseInt(Height);
        String Width = JOptionPane.showInputDialog("Enter Crop Width");
        int cropWidth = Integer.parseInt(Width);
        Image newimg = image.getScaledInstance(cropHeight, cropWidth, 
                java.awt.Image.SCALE_SMOOTH);
        BufferedImage convert = null;
        convert = imageToBufferedImage(newimg);
        SidewalkSketcherGUI.imageDB[0] = convert;
        ImageIcon imageIcon = new ImageIcon(newimg);
        JLabel label = new JLabel(imageIcon);
        SidewalkSketcherGUI.panel1.add(label);
        SidewalkSketcherGUI.panel1.removeAll();
        SidewalkSketcherGUI.panel1.add(label);
        SidewalkSketcherGUI.panel1.setSize(600, 600);
        SidewalkSketcherGUI.myframe.setSize(600, 600);
        SidewalkSketcherGUI.myframe.pack();
        SidewalkSketcherGUI.myframe.setResizable(false);
        SidewalkSketcherGUI.myframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
        SidewalkSketcherGUI.myframe.setVisible(true);
    }

}
