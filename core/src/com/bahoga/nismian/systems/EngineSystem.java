package com.bahoga.nismian.systems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;

public class EngineSystem extends EntitySystem {

    protected final Engine engine;

    public EngineSystem(final Engine engine) {
        this.engine = engine;
    }

    protected ImmutableArray<Entity> getAll(Class<? extends Component>... components) {
        Family all = Family.all(components).get();
        return engine.getEntitiesFor(all);
    }
}
