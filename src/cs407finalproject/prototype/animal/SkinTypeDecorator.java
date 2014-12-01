/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs407finalproject.prototype.animal;

/**
 *  Adds a SkinType describing the skin type of the decorated body.
 * 
 * @author Jonathan
 */

public class SkinTypeDecorator extends Body{
    
    protected final BodyComponent decoratedBody;
    protected SkinType skinType;
    
    public SkinTypeDecorator(Body decoratedBody, SkinType skinType){
        this.decoratedBody = decoratedBody;
        this.skinType = skinType;
    }
    
    public SkinType skinType() {
        return skinType;
    }  
   
   public SkinTypeDecorator clone(){
       return new SkinTypeDecorator((Body)decoratedBody.clone(),skinType);
   }
}
