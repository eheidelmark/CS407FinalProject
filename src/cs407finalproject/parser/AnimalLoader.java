/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs407finalproject.parser;


import cs407finalproject.prototype.animal.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
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
    private Boolean[] allElements = new Boolean[10];
    private List<String> animals;
    private AnimalFactory AF;
    //private AnimalFactory animalFactory1;
    
    
    public AnimalLoader(String filename) {              
        this.filename = filename;
        animals = new ArrayList<String>();
        AF = PrototypeAnimalFactory.getInstance();
        //animalFactory1 = PrototypeAnimalFactory.getInstance();
    }

    @Override
    public void run() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(ClassLoader.getSystemResourceAsStream(filename));
                        
            NodeList nodeList = document.getDocumentElement().getChildNodes();
            
            for(int i = 0; i < nodeList.getLength(); i++) {
                
                Node node = nodeList.item(i);
                if (node instanceof Element){
                    
                    String animalName = "";
                    AnimalType animalType = null;
                    MovementStrategy movementStrategy = null;
                    int movementRate = 0;
                    boolean cannibal = false;
                    int size = 0;
                    boolean eatLarger = false;
                    int arms = 0;
                    int legs = 0;
                    SkinType skinType = null;
                    
                    NodeList childNodes = node.getChildNodes();
                    
                    resetCheckForAllElements();
                    
                    for (int j = 0; j < childNodes.getLength(); j++){
                        Node cNode = childNodes.item(j);
                        
                        if(cNode instanceof Element) {
                            String content = cNode.getLastChild().getTextContent().trim();
                            //System.out.println(cNode.getNodeName());
                            switch (cNode.getNodeName()){
                                case "animalName" :
                                    animalName = content;
                                    allElements[0] = true;
                                    break;
                                case "animalType" :
                                    switch(content.toLowerCase().trim()) {
                                        case "carnivore":
                                            animalType = AnimalType.Carnivore;
                                            allElements[1] = true;
                                            break;
                                        case "omnivore":
                                            animalType = AnimalType.Omnivore;
                                            allElements[1] = true;
                                            break;
                                        case "herbivore":
                                            animalType = AnimalType.Herbivore;
                                            allElements[1] = true;
                                            break;
                                        default:
                                            throw new AnimalCreationException("Invalid animalType inside Animal");
                                    }
                                    break;
                                case "movementStrategy" :
                                    switch(content.toLowerCase().trim()) {
                                        case "random":
                                            movementStrategy = new RandomMove();
                                            allElements[2] = true;
                                            break;
                                        case "fight":
                                            movementStrategy = new FightMove();
                                            allElements[2] = true;
                                            break;
                                        case "flight":
                                            movementStrategy = new FlightMove();
                                            allElements[2] = true;
                                            break;
                                        default:
                                            throw new AnimalCreationException("Invalid movementStrategy inside Animal");
                                    }
                                    break;
                                case "movementRate" :
                                    movementRate = Integer.parseInt(content);
                                    allElements[3] = true;
                                    break;
                                case "cannibal" :
                                    cannibal = Boolean.parseBoolean(content);
                                    allElements[4] = true;                                   
                                    break;
                                case "size" :
                                    size = Integer.parseInt(content);
                                    allElements[5] = true;
                                    break;
                                case "eatLarger" :
                                    eatLarger = Boolean.parseBoolean(content);
                                    allElements[6] = true;
                                    break;
                                case "arms" :
                                    arms = Integer.parseInt(content);
                                    allElements[7] = true;
                                    break;
                                case "legs" :
                                    legs = Integer.parseInt(content);
                                    allElements[8] = true;
                                    break;
                                case "skinType" :
                                    switch(content.toLowerCase().trim()) {
                                        case "fur":
                                            skinType = SkinType.FUR;
                                            allElements[9] = true;
                                            break;
                                        case "feathers":
                                            skinType = SkinType.FEATHERS;
                                            allElements[9] = true;
                                            break;
                                        case "scales":
                                            skinType = SkinType.SCALES;
                                            allElements[9] = true;
                                            break;
                                        case "bare skin":
                                            skinType = SkinType.BARESKIN;
                                            allElements[9] = true;
                                            break;
                                        default:
                                            throw new AnimalCreationException("Invalid skinType inside Animal");
                                    }
                                    break;
                                
                                default:
                                    throw new AnimalCreationException("Invalid Element inside Animal");
                            }
                        }
                    }
                    if (checkForAllElements()) {
                        //catalog body
                        String bodyType = legs + " legs " + arms + " arms " + skinType;
                        if(!AF.bodyExists(bodyType)) {
                            AF.catalogBody(bodyType, AF.CreateBody(arms, legs, skinType));
                        }
                        //catalog animal
                        if(!AF.animalExists(animalName)) {
                            AF.catalogAnimal(animalName, new BaseAnimal(animalName, size, cannibal,eatLarger, animalType, movementStrategy, movementRate, AF.makeBody(bodyType)));
                            animals.add(animalName);
                        }                        
                    } else throw new AnimalCreationException("Missing Element inside Animal");
                }
            }  
            
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(parserMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AnimalCreationException ex) {
            Logger.getLogger(AnimalLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public LinkedList<Animal> getAnimals(int numberOf){
        LinkedList<Animal> randomAnimals = new LinkedList<>();
        Random random = new Random();
        for(int i = 0; i < numberOf; i++) {
            randomAnimals.add(AF.makeAnimal(animals.get(random.nextInt(animals.size()))));
        }
        return randomAnimals;
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
