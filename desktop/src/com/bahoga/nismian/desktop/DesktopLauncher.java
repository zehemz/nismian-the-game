package com.bahoga.nismian.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bahoga.nismian.NismianGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        configureResolution(config);
        new LwjglApplication(new NismianGame(), config);
    }

    private static void configureResolution(LwjglApplicationConfiguration config) {
        config.width = 800;
        config.height = 600;
    }
}
