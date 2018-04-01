package bloshka;

import java.util.List;

/**
 * Created by evelina on 08.05.2016.
 */
public class MonsterSlime extends Monster{

    double speed;

    MonsterSlime(int x, int y, int sizeX, int sizeY, int damage,double speed) {
        super(x, y, sizeX, sizeY, damage);
        this.speed=speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
