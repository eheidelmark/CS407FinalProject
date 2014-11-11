/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject;

/**
 *
 * @author Eric
 */
public class AnimalTypeFactory implements AnimalFactory {

    private static AnimalTypeFactory instance;

    protected AnimalTypeFactory() {
        instance = null;
    } 
    
    public Animal makeAnimal(String type) {

        switch (type) {
            case ("b"):
                return makeBear();
            case ("e"):
                return makeElephant();
            default:
                return null;
        }
    } 
    public static final AnimalTypeFactory getInstance() {
        if (instance == null) {
            instance = new AnimalTypeFactory();
        }
        return instance;
    } 
    
    Bear makeBear() {
        Bear b = new Bear();
        b.MS = new RandomMove(); 
        b.body = makeBody(2,2);
        return b;
    }

    Elephant makeElephant() {
        Elephant e = new Elephant();
        e.MS = new FlightMove();
        e.body = makeBody(0,4);
        return e;
    }
    
    BodyComposite makeBody(int arms, int legs){
    /* The animal body should be customizable in so far as the user may add any number
       of arms and legs to the body
    */
        Body body = new Body();
        for (int a = 0; a < arms; a++){
            body.add(new Arms());
        }
        for (int l = 0; l < legs; l++){
            body.add(new Legs());
        }
        return body;
    }
}        
            
