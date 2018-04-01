package bloshka;

/**
 * Created by astd52 on 16.04.2016.
 */
public class Hero {
    int sizeX = 40; //размер HERO
    int sizeY = 40;
    int x; //позиция относительно мапы
    int y;
    int positionY;
    int startX;
    int startY;
    int moving;
    boolean falling=true;
    int jumps = 2;
    int fullHP = 5;
    int hp = 5;
    boolean jumped;
    int currJumps = 2;
   // boolean dead=false; //0-alive; 1-dead
    public void jumpHero(Hero hero){
        jumped=true;
    }
    public Hero(int x, int y){
        this.x=x;
        this.y=y;
    }


}
