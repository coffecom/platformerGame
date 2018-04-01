package bloshka;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evelina on 28.05.2016.
 */
public class Levels {

    private static List<List<Platform>> platforms = new ArrayList<>();
    private static List<List<Monster>> monsters = new ArrayList<>();
    private static List<List<Door>> doors = new ArrayList<>();
    private static List<List<Bonus>> bonuses = new ArrayList<>();

    static {
        List<Platform> level0Platforms = new ArrayList<>();
        level0Platforms.add(new Platform(0, 0, 60, 600,true));
        level0Platforms.add(new Platform(0, 100-40, 440, 20,true));//x, y, ширина, высота
        level0Platforms.add(new Platform(560,100,140,20,true));
        level0Platforms.add(new Platform(500, 120, 160, 40,true));
        level0Platforms.add(new Platform(440,160,220,40,true));
        level0Platforms.add(new Platform(380, 200, 320, 40,true));
        level0Platforms.add(new Platform(0, 300, 180, 20,true));
        level0Platforms.add(new Platform(140, 260, 20, 40,true));
        level0Platforms.add(new Platform(160, 320, 40, 40,true));
        level0Platforms.add(new Platform(180, 360, 480, 40,true));
        level0Platforms.add(new Platform(660, 0, 60, 600 , true));
        level0Platforms.add(new Platform(360, 320, 20, 40 , true));
        level0Platforms.add(new Platform(460, 320 , 20, 40,true));
        level0Platforms.add(new Platform(380, 340, 80, 20, false));
        level0Platforms.add(new Platform(60,600, 680, 100, false));
        platforms.add(level0Platforms);


        List<Monster> level0Monsters = new ArrayList<>();
        level0Monsters.add(new BigY(120,140,80,80,3));
        level0Monsters.add(new MonsterSlime(100,20,40,40,2,1));
        monsters.add(level0Monsters);

        List<Door> level0Doors = new ArrayList<>();
        level0Doors.add(new Door(580,280));
        doors.add(level0Doors);



        List<Platform> level1Platforms = new ArrayList<>();
        level1Platforms.add(new Platform(0, 0, 40, 960,true));//x, y, ширина, высота
        level1Platforms.add(new Platform(1160, 0, 200, 40,true));
        level1Platforms.add(new Platform(40, 360, 120, 80,true));
        level1Platforms.add(new Platform(400, 200, 120, 20,true));
        level1Platforms.add(new Platform(40,0, 40, 200,true));
        level1Platforms.add(new Platform(120, 300, 160, 20,true));
        level1Platforms.add(new Platform(360, 320, 80, 20,true));
        level1Platforms.add(new Platform(840, 360, 40, 400,true));
        level1Platforms.add(new Platform(1240, 40, 120, 10,true));
        level1Platforms.add(new Platform(1280, 120, 80, 420,true));
        level1Platforms.add(new Platform(1320, 360,40, 600,true));
        level1Platforms.add(new Platform(160, 600, 40, 240,true));
        level1Platforms.add(new Platform(80, 0, 160, 20,true));
        level1Platforms.add(new Platform(80, 120, 120, 80,true));
        level1Platforms.add(new Platform(200, 160,80, 80,true));
        level1Platforms.add(new Platform(280, 200, 80, 40,true));
        level1Platforms.add(new Platform(360, 80, 240, 40,true));
        level1Platforms.add(new Platform(440, 40,80, 40,true));
        level1Platforms.add(new Platform(560, 120,560, 40,true));
        level1Platforms.add(new Platform(800, 80, 240, 40,true));
        level1Platforms.add(new Platform(840, 40, 120, 40,true));
        level1Platforms.add(new Platform(720, 160,400, 40,true));
        level1Platforms.add(new Platform(760, 200, 240, 40,true));
        level1Platforms.add(new Platform(840, 240,120, 40,true));
        level1Platforms.add(new Platform(840, 280, 80, 80,true));
        level1Platforms.add(new Platform(880, 480,80, 200,true));
        level1Platforms.add(new Platform(280, 880, 40, 40,true));
        level1Platforms.add(new Platform(960, 520,80, 80,true));
        level1Platforms.add(new Platform(1040, 560, 80, 40,true));
        level1Platforms.add(new Platform(1200, 200, 80, 80,true));
        level1Platforms.add(new Platform(1120, 280, 160, 80,true));
        level1Platforms.add(new Platform(1000, 360, 200, 40,true));
        level1Platforms.add(new Platform(1040, 400, 160, 40,true));
        level1Platforms.add(new Platform(1080, 440, 160, 40,true));
        level1Platforms.add(new Platform(1200, 480, 80, 40,true));
        level1Platforms.add(new Platform(1200, 600, 80, 20,true));
        level1Platforms.add(new Platform(840, 760, 120, 20,true));
        level1Platforms.add(new Platform(1120, 840, 120, 20,true));
        level1Platforms.add(new Platform(960, 880, 80, 20,true));
        level1Platforms.add(new Platform(760, 920, 80, 20,true));
        level1Platforms.add(new Platform(640, 440, 120, 20,true));
        level1Platforms.add(new Platform(560, 520, 160, 160,true));
        level1Platforms.add(new Platform(520, 520, 40, 40,true));
        level1Platforms.add(new Platform(520, 680, 120, 20,true));
        level1Platforms.add(new Platform(560, 720, 40, 80,true));
        level1Platforms.add(new Platform(440, 480, 80, 80,true));
        level1Platforms.add(new Platform(400, 440, 120, 40,true));
        level1Platforms.add(new Platform(320, 440, 40, 40,true));
        level1Platforms.add(new Platform(240, 400, 320, 40,true));
        level1Platforms.add(new Platform(480, 280, 160, 20,true));
        level1Platforms.add(new Platform(120, 440, 160, 20,true));
        level1Platforms.add(new Platform(120, 320, 40, 40,true));
        level1Platforms.add(new Platform(40, 600, 160, 20,true));
        level1Platforms.add(new Platform(40, 720, 40, 40,true));
        level1Platforms.add(new Platform(80, 800, 360, 40,true));
        level1Platforms.add(new Platform(160, 760, 240, 40,true));
        level1Platforms.add(new Platform(40, 920, 480, 40,true));
        level1Platforms.add(new Platform(520, 880, 40, 80,true));
        level1Platforms.add(new Platform(720, 640, 120, 80,true));
        level1Platforms.add(new Platform(800, 480, 40, 20,true));

        level1Platforms.add(new Platform(720, 620, 120, 40,false)); // dead
        level1Platforms.add(new Platform(520, 680, 180, 40,false));

        level1Platforms.add(new PlatformMoving(1000, 680, 120, 40, false, 1320, 920, 0, 0));//moving
        level1Platforms.add(new PlatformMoving(1000, 680, 120, 40, false, 0, 0, 760, 960));


        platforms.add(level1Platforms);


        List<Monster> level1Monsters = new ArrayList<>();
        level1Monsters.add(new MonsterSlime(100,20,40,40,2,1));
        monsters.add(level1Monsters);

        List<Door> level1Doors = new ArrayList<>();
        level1Doors.add(new Door(80,520));
        doors.add(level1Doors);




    }
    public static List<Platform> getPlatforms(int level){
        return platforms.get(level);
    }
    public static List<Monster> getMonsters(int level){
        return monsters.get(level);
    }
    public static List<Door> getDoors(int level){
        return doors.get(level);
    }
}

