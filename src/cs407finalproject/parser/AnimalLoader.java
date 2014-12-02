/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs407finalproject.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Jonathan
 */
public class AnimalLoader implements Runnable{
    
    
    private String filename;
    private Boolean[] allElements = new Boolean[6];
    
    public AnimalLoader(String filename) {              
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(ClassLoader.getSystemResourceAsStream(filename));
            
            
            
            List<TempAnimal> animals = new ArrayList<>();
            
            NodeList nodeList = document.getDocumentElement().getChildNodes();
            
            for(int i = 0; i < nodeList.getLength(); i++) {
                
                Node node = nodeList.item(i);
                if (node instanceof Element){
                    
                    String animalType = "";
                    String movementType = "";
                    int movementRate = 0;
                    boolean cannibal = false;
                    int size = 0;
                    boolean eatLarger = false;
                    
                    NodeList childNodes = node.getChildNodes();
                    
                    resetCheckForAllElements();
                    
                    for (int j = 0; j < childNodes.getLength(); j++){
                        Node cNode = childNodes.item(j);
                        
                        if(cNode instanceof Element) {
                            String content = cNode.getLastChild().getTextContent().trim();
                            //System.out.println(cNode.getNodeName());
                            switch (cNode.getNodeName()){
                                case "animalType" :
                                    animalType = content;
                                    allElements[0] = true;
                                    break;
                                case "movementType" :
                                    movementType = content;
                                    allElements[1] = true;
                                    break;
                                case "movementRate" :
                                    movementRate = Integer.parseInt(content);
                                    allElements[2] = true;
                                    break;
                                case "cannibal" :
                                    cannibal = Boolean.parseBoolean(content);
                                    allElements[3] = true;                                   
                                    break;
                                case "size" :
                                    size = Integer.parseInt(content);
                                    allElements[4] = true;
                                    break;
                                case "eatLarger" :
                                    eatLarger = Boolean.parseBoolean(content);
                                    allElements[5] = true;
                                    break;
                                default:
                                    throw new AnimalCreationException("Invalid Element inside Animal");
                            }
                        }
                    }
                    if (checkForAllElements()) {
                        animals.add(new TempAnimal(animalType, movementType, movementRate, cannibal, size, eatLarger));
                    } else throw new AnimalCreationException("Missing Element inside Animal");
                }
            }  
            
            System.out.println(animals.size() + " animal(s) loaded.");
            
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(parserMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AnimalCreationException ex) {
            Logger.getLogger(AnimalLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean checkForAllElements(){
        for(int i = 0; i < allElements.length; i++) {
            //System.out.println("checking " + i);
            if (!allElements[i]) return false;
        }
        return true;
    }
    
    private void resetCheckForAllElements(){
        for(int i = 0; i < allElements.length; i++) {
            allElements[i] = false;
        }
    }
    
    public class AnimalCreationException extends Exception {
            
            public AnimalCreationException(String message) {
                super(message);
            }
    }
}
