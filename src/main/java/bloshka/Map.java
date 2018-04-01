package bloshka;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evelina on 30.04.2016.
 */
public class Map {
    Hero hero;
    List<Platform> platforms= new ArrayList<>();
    List<Monster> monsters= new ArrayList<>();
    List<Door> doors = new ArrayList<>();
    int offsetX=0;
    int offsetY=0;

    public Map(Hero hero){
        this.hero=hero;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }
}
