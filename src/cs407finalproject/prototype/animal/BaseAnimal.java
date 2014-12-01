/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs407finalproject.prototype.animal;
/**
 *
 * @author Nick
 */
public class BaseAnimal implements Animal{
    private final int size;
    private final String type;
    private final MovementStrategy MS;
    private final Body body;
    
    public BaseAnimal(int size, String type, MovementStrategy MS, Body body){
        this.size = size;
        this.type = type;
        this.MS = MS;
        this.body = body;
    }   
    
    @Override
    public void move() {
        MS.move();
    }
    
    @Override
    public void takeTurn() {
        move();
        eat();
        mutate();
    }
    @Override
    public void eat() {
        System.out.println("eating");
    }
    @Override
    public void mutate() {
     System.out.println("mutating");
    }
    public BaseAnimal clone(){
        return new BaseAnimal(size,type,MS,(Body)body.clone());
    }
}