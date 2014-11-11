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
public class Main {

    public static void main(String[] args) {
        Animal baloo;
        Animal dumbo;

        AnimalTypeFactory AF = AnimalTypeFactory.getInstance();

        baloo = AF.makeAnimal("b");
        System.out.println(baloo);
        baloo.takeTurn();
        baloo.takeTurn();
        dumbo = AF.makeAnimal("e");
        System.out.println(dumbo);
        dumbo.takeTurn();
    }

}
