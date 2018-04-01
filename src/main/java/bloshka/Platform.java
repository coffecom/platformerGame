package bloshka;

/**
 * Created by evelina on 16.04.2016.
 */
public class Platform {
    int x;
    int y;
    int weight; // ширина
    int length; // высота
    boolean deathOrAlive; // 0 - death, 1 - alive
    public Platform(int x, int y, int weight,int length, boolean deathOrAlive){
        this.x=x;
        this.y=y;
        this.length=length;
        this.weight=weight;
        this.deathOrAlive=deathOrAlive;
    }

}
