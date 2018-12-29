package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class MapComponent extends Component {


    public final OrthogonalTiledMapRenderer mapRenderer;

    public MapComponent(final TiledMap tiledMap) {
        mapRenderer = new OrthogonalTiledMapRenderer(tiledMap, 1);
    }
}
