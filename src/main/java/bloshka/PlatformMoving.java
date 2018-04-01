package bloshka;

/**
 * Created by evelina on 20.09.2016.
 */

public class PlatformMoving extends Platform {
    int leftX;
    int rightX;
    int topY;
    int botY;

    public PlatformMoving(int x, int y, int weight, int length, boolean deathOrAlive, int leftX, int rightX, int topY, int botY) {
        super(x, y, weight, length, deathOrAlive);
        this.leftX=leftX;
        this.rightX=rightX;
        this.botY=botY;
        this.topY=topY;
    }
}
