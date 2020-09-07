/**
 * This class represents a simple picture. You can draw the picture using
 * the draw method. But wait, there's more: being an electronic picture, it
 * can be changed. You can set it to black-and-white display and back to
 * colors (only after it's been drawn, of course).
 *
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author  Craig Hussey
 * @version 2020.9.9
 */
import java.util.Random;
public class Picture
{
    private Square shipBody, window;
    private Triangle shipNose, shipLeftWing, shipRightWing;
    private Circle sun, earth, star1, star2, star3, star4, star5, star6, 
        star7, star8, land1, land2, land3, land4;
    private boolean drawn;
    private Person astronaut;
    private Canvas thisCanvas;
    private boolean insideShip;
    public boolean floatAround;
    /**
     * Constructor for objects of class Picture
     */
    public Picture()
    {
        star1 = new Circle(); star2 = new Circle(); star3 = new Circle();
        star4 = new Circle(); star5 = new Circle(); star6 = new Circle();
        star7 = new Circle(); star8 = new Circle(); 
        land1 = new Circle(); land2 = new Circle(); 
        land3 = new Circle(); land4 = new Circle(); 
        shipBody = new Square();
        shipNose = new Triangle();
        window = new Square();
        shipLeftWing = new Triangle();
        shipRightWing = new Triangle();
        sun = new Circle();
        earth = new Circle();
        astronaut = new Person();
        insideShip = false;
        floatAround = true;
        drawn = false;
        draw();
    }

    /**
     * Draw this picture. ~changed by Craig Hussey
     */
    public void draw()
    {
        if(!drawn) {
            thisCanvas = Canvas.getCanvas();
            thisCanvas.changeToBlack();
            
            star1.moveHorizontal(-120);
            star1.moveVertical(80);
            star1.changeSize(8);
            star1.changeColor("white");
            star1.makeVisible();
            
            star2.moveHorizontal(-200);
            star2.moveVertical(-40);
            star2.changeSize(4);
            star2.changeColor("white");
            star2.makeVisible();
            
            star3.moveHorizontal(-10);
            star3.moveVertical(-50);
            star3.changeSize(4);
            star3.changeColor("white");
            star3.makeVisible();
            
            star4.moveHorizontal(-60);
            star4.moveVertical(160);
            star4.changeSize(6);
            star4.changeColor("white");
            star4.makeVisible();
            
            star5.moveHorizontal(80);
            star5.moveVertical(80);
            star5.changeSize(4);
            star5.changeColor("white");
            star5.makeVisible();
            
            star6.moveHorizontal(80);
            star6.moveVertical(-60);
            star6.changeSize(8);
            star6.changeColor("white");
            star6.makeVisible();
         
            star7.moveHorizontal(160);
            star7.moveVertical(140);
            star7.changeSize(8);
            star7.changeColor("white");
            star7.makeVisible();
            
            star8.moveHorizontal(220);
            star8.moveVertical(20);
            star8.changeSize(4);
            star8.changeColor("white");
            star8.makeVisible();
            
            shipBody.changeColor("silver");
            shipBody.changeWidth(31);
            shipBody.changeHeight(100);
            shipBody.moveHorizontal(-265);
            shipBody.moveVertical(20);
            shipBody.makeVisible();
            
            window.changeSize(10);
            window.changeColor("black");
            window.moveHorizontal(-262);
            window.moveVertical(24);
            window.makeVisible();
            
            shipNose.changeColor("silver");
            shipNose.moveVertical(-40);
            shipNose.moveHorizontal(-150);
            shipNose.changeSize(40, 40);
            shipNose.makeVisible();
            
            shipLeftWing.changeColor("silver");
            shipLeftWing.changeSize(30, 30);
            shipLeftWing.moveHorizontal(-160);
            shipLeftWing.moveVertical(80);
            shipLeftWing.makeVisible();
            
            shipRightWing.changeColor("silver");
            shipRightWing.changeSize(30, 30);
            shipRightWing.moveHorizontal(-140);
            shipRightWing.moveVertical(80);
            shipRightWing.makeVisible();
            
            earth.moveHorizontal(-100);
            earth.moveVertical(-40);
            earth.changeSize(120);
            earth.changeColor("blue");
            earth.makeVisible();
            
            land1.changeSize(20);
            land1.moveVertical(-18);
            land1.moveHorizontal(-10);
            land1.changeColor("green");
            land1.makeVisible();
            
            land2.changeSize(60);
            land2.moveHorizontal(-80);
            land2.moveVertical(-20);
            land2.changeColor("green");
            land2.makeVisible();
            
            land3.changeSize(30);
            land3.moveHorizontal(-28);
            land3.changeColor("green");
            land3.makeVisible();
            
            land4.changeSize(30);
            land4.moveHorizontal(-72);
            land4.moveVertical(40);
            land4.changeColor("green");
            land4.makeVisible();
                          
            sun.changeColor("yellow");
            sun.moveHorizontal(140);
            sun.moveVertical(-30);
            sun.changeSize(20);
            sun.makeVisible();
            
            astronaut.moveHorizontal(-50);
            astronaut.moveVertical(-28);
            astronaut.changeColor("white");
            astronaut.makeVisible();
            
            drawn = true;
            TwinkleStars();
        }
    }
    /**
     * If astronaut outside ship, send him back, if he is inside ship
     * send him outside. ~added by Craig Hussey
     */
    public void InteractWithAstronaut()
    {
        if (!insideShip)
        CollectAstronaut();
        else if (insideShip)
        SendAstronaut();
    }
    
    public void ExploreSpace()
    {
        if (insideShip)
        {
            SendAstronaut();
            astronaut.FloatAround();
        }
        else if (!insideShip)
        astronaut.FloatAround();
    }
    
    /**
     * Sends astronaut to spaceship ~added by Craig Hussey
     */
    private void CollectAstronaut()
    {
        astronaut.slowMoveHorizontal(-144);
        astronaut.slowSize(-20);
        astronaut.makeInvisible();
        insideShip = true;
    }
    /**
     * Sends astronaut to view Earth ~added by Craig Hussey
     */
    private void SendAstronaut()
    {
        astronaut.makeVisible();
        astronaut.slowSize(20);
        astronaut.slowMoveHorizontal(144);
        insideShip = false;
    }
    /**
     * makes the stars "twinkle" ~added by Craig Hussey
     */
    public void TwinkleStars()
    {
        star1.slowMoveSize(5);
        star1.slowMoveSize(-5);
        star2.slowMoveSize(5);
        star2.slowMoveSize(-5);
        star3.slowMoveSize(5);
        star3.slowMoveSize(-5);
        star4.slowMoveSize(5);
        star4.slowMoveSize(-5);
        star5.slowMoveSize(5);
        star5.slowMoveSize(-5);
        star6.slowMoveSize(5);
        star6.slowMoveSize(-5);
        star7.slowMoveSize(5);
        star7.slowMoveSize(-5);
        star8.slowMoveSize(5);
        star8.slowMoveSize(-5);
    }
    /**
     * Change this picture to black/white display ~changed by Craig Hussey
     */
    public void setBlackAndWhite()
    {
        thisCanvas.changeToWhite();
        sun.changeColor("black");
        earth.changeColor("black");
        land1.changeColor("white");
        land2.changeColor("white");
        land3.changeColor("white");
        land4.changeColor("white");
        star1.changeColor("black");
        star2.changeColor("black");
        star3.changeColor("black");
        star4.changeColor("black");
        star5.changeColor("black");
        star6.changeColor("black");
        star7.changeColor("black");
        star8.changeColor("black");
        astronaut.changeColor("black");
        shipBody.changeColor("black");
        shipLeftWing.changeColor("black");
        shipRightWing.changeColor("black");
        shipNose.changeColor("black");
        window.changeColor("white");
    }
    /**
     * Sets back to original color ~changed by Craig Hussey
     */
    public void setColor()
    {
        thisCanvas.changeToBlack();
        sun.changeColor("yellow");
        earth.changeColor("blue");
        land1.changeColor("green");
        land2.changeColor("green");
        land3.changeColor("green");
        land4.changeColor("green");
        star1.changeColor("white");
        star2.changeColor("white");
        star3.changeColor("white");
        star4.changeColor("white");
        star5.changeColor("white");
        star6.changeColor("white");
        star7.changeColor("white");
        star8.changeColor("white");
        astronaut.changeColor("white");
        shipBody.changeColor("silver");
        shipLeftWing.changeColor("silver");
        shipRightWing.changeColor("silver");
        shipNose.changeColor("silver");
        window.changeColor("black");
    }
}
