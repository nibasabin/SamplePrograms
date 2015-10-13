/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sidewalksketcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/**
 *
 * @author sabin raj bajracharya
 */
public class Pack implements ActionListener {
    
 GetPathFromSVG svgPath= new GetPathFromSVG();

    @Override
    public void actionPerformed(ActionEvent e)  {
        String currentDirectory = System.getProperty(("user.dir"));
        try {
            BufferedImage bi = SidewalkSketcherGUI.imageDB[0];
            File outputfile = new File(currentDirectory+"/potrace/nibasabin.bmp");
            ImageIO.write(bi, "bmp", outputfile);
            
        }  
        catch (Exception f )
        {
          
        }

      
  String path = "cd " + currentDirectory + "/potrace\n./potrace -s -o Image.svg nibasabin.bmp";
        try {
            Process p = Runtime.getRuntime().exec(new String[]{"bash", "-c", path});
             svgPath.path();
        } catch ( IOException | ParserConfigurationException | SAXException |
                XPathExpressionException f) {
           
        }
        
        
       
    
        
    }
}