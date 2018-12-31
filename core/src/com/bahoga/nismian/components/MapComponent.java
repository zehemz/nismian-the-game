package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.bahoga.nismian.Constants;

public class MapComponent extends Component {

    public final OrthogonalTiledMapRenderer mapRenderer;

    public MapComponent(final TiledMap tiledMap) {

        mapRenderer = new OrthogonalTiledMapRenderer(tiledMap, 1/Constants.TILE_SIZE);
    }
}
