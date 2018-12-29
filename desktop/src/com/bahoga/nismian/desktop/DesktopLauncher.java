package com.bahoga.nismian.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bahoga.nismian.Game;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        configureResolution(config);
        new LwjglApplication(new Game(), config);
    }

    private static void configureResolution(LwjglApplicationConfiguration config) {
        config.width = 1920;
        config.height = 1080;
    }
}
