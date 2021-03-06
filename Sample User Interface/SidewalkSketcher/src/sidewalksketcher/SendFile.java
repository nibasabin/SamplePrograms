/*
 *Class :SendFile
 * Description: Converts bmp image into svg image and sends instruction file for roomba via wifi;
 */
package sidewalksketcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/**
 *
 * @author sabin Raj Bajracharya
 */
public class SendFile implements ActionListener {
    GetPathFromSVG svgPath= new GetPathFromSVG();

    @Override
    public void actionPerformed(ActionEvent e) {
       String currentDirectory = System.getProperty(("user.dir")); 
        String path1 = "cd " + currentDirectory + "/potrace/\n python client.py";
        Process p = null;
        try {
            p = Runtime.getRuntime().exec(new String[]{"bash", "-c", path1});
        } catch (IOException ex) {
            Logger.getLogger(SendFile.class.getName()).log(Level.SEVERE, null, ex);
        }

        BufferedReader buf = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line = " ";
        try {
            while ((line = buf.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(SendFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(SidewalkSketcherGUI.myframe,
                "File Successfully Sent To Roomba.");

    }
    }
    
    

