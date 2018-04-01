package bloshka;

import com.badlogic.androidgames.framework.Screen;
import com.badlogic.androidgames.framework.impl.AndroidGame;

public class MyGame extends AndroidGame{
    public Screen getStartScreen (){
        return new MainScreen(this,0);
    }
}
