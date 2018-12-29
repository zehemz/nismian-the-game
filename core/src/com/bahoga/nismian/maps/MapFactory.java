package com.bahoga.nismian.maps;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class MapFactory {

    public enum GameMap {
        MAIN_MAP("maps/map_2.tmx");
        public final String value;

        GameMap(String value) {
            this.value = value;
        }
    }

    public static TiledMap create(final GameMap gameMap) {
        return new TmxMapLoader().load(gameMap.value);
    }
}
