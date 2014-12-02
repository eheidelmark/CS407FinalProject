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
                    int nodeCount = 0;
                    for (int j = 0; j < childNodes.getLength(); j++){
                        Node cNode = childNodes.item(j);
                        
                        if(cNode instanceof Element) {
                            String content = cNode.getLastChild().getTextContent().trim();
                            //System.out.println(cNode.getNodeName());
                            switch (cNode.getNodeName()){
                                case "animalType" :
                                    animalType = content;
                                    nodeCount++;
                                    break;
                                case "movementType" :
                                    movementType = content;
                                    nodeCount++;
                                    break;
                                case "movementRate" :
                                    movementRate = Integer.parseInt(content);
                                    nodeCount++;
                                    break;
                                case "cannibal" :
                                    cannibal = Boolean.parseBoolean(content);
                                    nodeCount++;                                    
                                    break;
                                case "size" :
                                    size = Integer.parseInt(content);
                                    nodeCount++;
                                    break;
                                case "eatLarger" :
                                    eatLarger = Boolean.parseBoolean(content);
                                    nodeCount++;
                                    break;
                                default:
                                    throw new AnimalCreationException("Invalid Element inside Animal");
                            }
                        }
                        //System.out.println(nodeCount);
                    }
                    if (nodeCount == 6) {
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
    
    public class AnimalCreationException extends Exception {
            
            public AnimalCreationException(String message) {
                super(message);
            }
    }
}
