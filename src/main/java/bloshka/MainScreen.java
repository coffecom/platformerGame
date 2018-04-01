package bloshka;

import android.graphics.Color;
import android.media.session.PlaybackState;
import android.util.Log;

import com.badlogic.androidgames.framework.Game;
import com.badlogic.androidgames.framework.Graphics;
import com.badlogic.androidgames.framework.Input;
import com.badlogic.androidgames.framework.Pixmap;
import com.badlogic.androidgames.framework.Screen;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

public class MainScreen extends Screen {

    private int level=0;

    Hero hero1=new Hero(200,20);




    Map firstMap=new Map (hero1);

    Pixmap pictFloor;
    Pixmap pictSpike;
    Pixmap pictSpikeBlood;
    Pixmap pictDoor;
    Pixmap pictEmptyPill;
    Pixmap pictFullPill;
    Pixmap pictHeal;
    Pixmap pictHp;
    Pixmap pictHPBarRight;
    Pixmap pictHPBarLeft;
    Pixmap pictHPBarMid;




    boolean XColl = true;
    boolean YColl;

    int jumped=0;


    public void checkSideOfMovingSlimes(List<Platform> platforms,MonsterSlime monsterSlime){
        for(Platform platform: platforms){
            if (monsterSlime.x+(monsterSlime.sizeX/2)>=platform.x && monsterSlime.x+(monsterSlime.sizeX/2)<=platform.x+platform.weight){
                if (monsterSlime.x<=platform.x){
                    monsterSlime.speed=monsterSlime.speed*-1;
                }
                if (monsterSlime.x+monsterSlime.sizeX>=platform.x+platform.weight){
                    monsterSlime.speed=monsterSlime.speed*-1;

                }

            }
        }
    }
//    public void moving(Hero hero1, Map firstMap ) {
//        for (Platform platform : firstMap.getPlatforms()) {
//            for (int i = hero1.x; i < hero1.x + hero1.sizeX; i++) {
//                if (i > platform.x && i < platform.weight + platform.x) {//проверка пересечения с платформой X
//
//
//                    int Ystart = hero1.y;
//
//
//                    if ((hero1.y <= (platform.y + platform.length)) && (hero1.y > platform.y)) { //потолок
//                        hero1.moving = 4;
//                        hero1.falling = false;
//                    }
//
//
//                    if ((platform.y - (hero1.y + hero1.sizeY)) <= 0 && (platform.y - (hero1.y + hero1.sizeY)) > -1) {
//
//                        hero1.falling = false;
//                        hero1.moving = 0;
//                        hero1.jumped = false;
//                        hero1.y = Ystart;
//                        hero1.jumps = hero1.currJumps;
//                        if (!platform.deathOrAlive) {  //смертность
//                            hero1.hp -= 3;
//                            hero1.y = platform.y - (hero1.sizeY / 2);
//                            hero1.jumps = hero1.currJumps;
//                        }
//                    }
//                }
//                for (int j = hero1.y; j < hero1.y + hero1.sizeY; j++) {
//                    if (j > platform.y && j < platform.y + platform.length) {//проверка пересечения с платформой
//
//                        if (((hero1.x + hero1.sizeX) >= platform.x) && (hero1.x <= (platform.weight + platform.x))) {
//                            if (hero1.x >= (int) ((platform.x + (platform.weight / 2)))) {
//                                hero1.x = platform.x + platform.weight;
//                            } else {
//                                hero1.x = platform.x - hero1.sizeX;
//                            }
//                        }
//
//                    }
//                }
//
//            }
//        }
//    }

    public void moving(Hero hero1, Map firstMap ) {
        for (Platform platform : firstMap.getPlatforms()) {

//            for (Platform platform2 : firstMap.getPlatforms()) {
//
//                if ((hero1.x + hero1.sizeX >= platform2.x)  && hero1.y + hero1.sizeY <= platform2.y + platform2.length) {
//                    hero1.x=platform2.x-hero1.sizeX;
//
//                }
//                if((hero1.x <= (platform2.x + platform2.weight)) && hero1.y + hero1.sizeY <= platform2.y + platform2.length){
//                    hero1.x=platform2.weight+hero1.sizeX;
//
//                }
//            }

//            if ((hero1.y <= (platform.y + platform.length)) && (hero1.y > platform.y)) { //потолок
//                        hero1.moving = 5;
//                        hero1.falling = false;
//            }

            if ((hero1.y+hero1.sizeY)==platform.y) {
                if ((hero1.x+hero1.sizeX >= platform.x) && (hero1.x <= (platform.x + platform.weight))) {
                    hero1.falling = false;
                    hero1.moving = 0;
                    hero1.jumped = false;
                    hero1.y = platform.y-hero1.sizeY;
                    hero1.jumps = hero1.currJumps;
                    if (!platform.deathOrAlive) {  //смертность
                        hero1.hp -= 3;
                        hero1.y = platform.y - (hero1.sizeY / 2);
                        hero1.jumps = hero1.currJumps;

                    }
                }
            }//пересечения с горизанталями (сделать вертикали???)



        }
    }

    private void checkConnection(Hero hero, Monster monster){
        if ((hero.y < (monster.sizeY+monster.y)) && ((hero.y+hero.sizeY) > monster.y) && (hero.x < (monster.sizeX+monster.x)) && ((hero.x+hero.sizeX) > monster.x)) {
            hero.hp-=monster.damage;
            if(hero.x> monster.x+(monster.sizeX/2)){
                hero.x=monster.x+monster.sizeX+(hero.sizeX/2);
            }else{
                hero.x=monster.x-hero.sizeX-(hero.sizeX/2);
            }
            if(hero.y>(monster.y+(monster.sizeY/2))){
                hero.y=monster.y+monster.sizeY+(hero.sizeX/2);
            }else{
                hero.y=monster.y-(hero.sizeX/2);
            }
        }
    }
    private void checkOffset(){
        int left=160-firstMap.getOffsetX();
        int right=360-firstMap.getOffsetX();
        int top=120-firstMap.getOffsetY();
        int bottom=240-firstMap.getOffsetY();
        if ((hero1.y+hero1.sizeY)>bottom){
            firstMap.offsetY+=bottom-(hero1.y+hero1.sizeY);
        }
        if (hero1.y<top){
            firstMap.offsetY+=top-hero1.y;
        }
        if (hero1.x<left){
            firstMap.offsetX+=left-hero1.x;
        }
        if ((hero1.x+hero1.sizeX)>right){
            firstMap.offsetX+=right-(hero1.x+hero1.sizeX);
        }
    }
    private void checkDoorConnection(Door door, Hero hero){ // чет сделать надо
        if((hero.x<(door.sizeX+door.x))&&((hero.x+hero.sizeX)>door.x)){
            if(((hero.y+hero.sizeY)>door.y) && (hero.y<(door.y+door.sizeY))){
                level++;
                checkStartPosition(hero,level);
                hero.x=hero.startX;
                hero.y=hero.startY;
                firstMap.platforms= Levels.getPlatforms(level);
                firstMap.monsters=Levels.getMonsters(level);
                firstMap.doors=Levels.getDoors(level);

            }
        }
    }
//    private void checkMovingPlatforms(Map map){
//        for(Platform platform:map.getPlatforms()){
//            PlatformMoving
//        }
//    }


    public void  checkStartPosition(Hero hero, int level){
        if (level==0){
            hero.startX=200;
            hero.startY=20;
        }

        if (level==1){
            hero.startX= 640;
            hero.startY= 360;
        }

    }



//    private  void  newMonsters(){
//        monstersOfFirstMap.add(firstSlimeEVER);
//        monstersOfFirstMap.add(new BigY(90,140,80,80,3));
//
//    }







    public MainScreen (Game game, int level){
        super(game);
        this.level = level;
        Log.d("mrnom", "ver4;1");

        Graphics graphics=game.getGraphics();
        pictFloor=graphics.newPixmap("floorTexture.png", Graphics.PixmapFormat.ARGB4444);
        pictSpike=graphics.newPixmap("a spile without blood.png", Graphics.PixmapFormat.ARGB4444);
        pictSpikeBlood=graphics.newPixmap("a spike with blood.png", Graphics.PixmapFormat.ARGB4444);
        pictDoor=graphics.newPixmap("open door.png", Graphics.PixmapFormat.ARGB4444);
        pictEmptyPill=graphics.newPixmap("empty pill.png", Graphics.PixmapFormat.ARGB4444);
        pictFullPill=graphics.newPixmap("full pill.png", Graphics.PixmapFormat.ARGB4444);
        pictHeal=graphics.newPixmap("hp-bottle.png", Graphics.PixmapFormat.ARGB4444);
        pictHp=graphics.newPixmap("hp.png", Graphics.PixmapFormat.ARGB4444);
        pictHPBarLeft=graphics.newPixmap("hp bar left side.png", Graphics.PixmapFormat.ARGB4444);
        pictHPBarRight=graphics.newPixmap("hp bar right side.png", Graphics.PixmapFormat.ARGB4444);
        pictHPBarMid=graphics.newPixmap("hp bar middle side.png", Graphics.PixmapFormat.ARGB4444);

        firstMap.platforms= Levels.getPlatforms(level);
        firstMap.monsters=Levels.getMonsters(level);
        firstMap.doors=Levels.getDoors(level);

    }









    @Override
    public void update(float deltaTime) {

        int death=0;

        List<Input.TouchEvent> touchEvents=game.getInput().getTouchEvents();

        hero1.falling=true;

        for (Input.TouchEvent touchEvent : touchEvents){
            if (touchEvent.type == Input.TouchEvent.TOUCH_DOWN) {
                if(touchEvent.x>180) {
                    hero1.jumped = true;
                    if (hero1.jumps > 0) { //сет на прыжки вкорость вверх
                        hero1.positionY = hero1.y;
                        hero1.moving = -5;
                        hero1.jumps -= 1;
                    }
                }else{ //сет на атаку

                }
            }
        }



        if (hero1.y<=hero1.positionY-60 && hero1.jumped){ //скороть вниз
            hero1.moving=4;
            hero1.falling=false;
        }



        hero1.y+=hero1.moving; //движение

        moving(hero1,firstMap); //движени куба



        for (Monster monster: firstMap.monsters){ //функции монстров
            if(monster instanceof MonsterSlime ){
                MonsterSlime monsterSlime = (MonsterSlime) monster;
                monster.x+=(monsterSlime).getSpeed();
                checkSideOfMovingSlimes(firstMap.getPlatforms(), monsterSlime);
            }

        }







        if(hero1.falling==true && hero1.jumped!=true){
            hero1.positionY=hero1.y;
            hero1.moving=4;
        }


        Input input=game.getInput();

        hero1.x+=(int)((1*input.getAccelY())*deltaTime*50);

        for(Monster monster: firstMap.monsters){
            checkConnection(hero1, monster);
        }

        for (Door door: firstMap.getDoors()){
            checkDoorConnection(door,hero1);
        }

        if(hero1.hp<=0) {
            checkStartPosition(hero1,level);
            hero1.x=hero1.startX;
            hero1.y=hero1.startY;
            firstMap.setOffsetX(0);
            firstMap.setOffsetY(0);
            //hero1.dead=false;
            hero1.hp=hero1.fullHP;
            death++; //смерть и ее счетчик
        }


        checkOffset();
    }

    @Override
    public void present(float deltaTime) {
        Graphics g=game.getGraphics();
        g.setBackground(Color.WHITE);

        for(Monster monster:firstMap.getMonsters()){
            g.drawRect(monster.x + firstMap.offsetX, monster.y + firstMap.offsetY, monster.sizeX, monster.sizeY, true, Color.CYAN);
        }

        for (Platform platform : firstMap.getPlatforms()){
            if (platform.deathOrAlive==false){
                //g.drawRect(platform.x + firstMap.offsetX, platform.y + firstMap.offsetY, platform.weight+1, platform.length+1, true, Color.RED);
                for(int i=0; i<platform.weight; i+=10) {
                    g.drawPixmap(pictSpike, (platform.x + i) + firstMap.offsetX, (platform.y) + firstMap.getOffsetY());
                }
            }else {
                g.drawRect(platform.x + firstMap.offsetX, platform.y + firstMap.offsetY, platform.weight + 1, platform.length + 1, true, Color.BLACK);

            }
        }
        for (Door door : firstMap.getDoors()){
           g.drawPixmap(pictDoor,door.x-18+firstMap.getOffsetX(),door.y+firstMap.getOffsetY());
           // g.drawRect(door.x + firstMap.offsetX, door.y + firstMap.offsetY, door.sizeX, door.sizeY, true, Color.YELLOW);
        }

        g.drawRect(hero1.x + firstMap.offsetX, hero1.y + firstMap.offsetY + 1, hero1.sizeX, hero1.sizeY, true, Color.GREEN);


        for (int i=0;i<hero1.hp;i++){
            g.drawPixmap(pictHp,i*40,0);
        }
        for (int j=0;j<hero1.fullHP;j++){//HP BAR
            if (j==0){
                g.drawPixmap(pictHPBarLeft,0,0);
            }else {
                if (j == (hero1.fullHP - 1)) {
                    g.drawPixmap(pictHPBarRight, j * 40, 0);
                }else{
                    g.drawPixmap(pictHPBarMid,j*40,0);
                }
            }


        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}

