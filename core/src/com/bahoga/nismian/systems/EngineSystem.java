package com.bahoga.nismian.systems;

import com.badlogic.ashley.core.*;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class EngineSystem extends EntitySystem {

    private Engine engine;

    @SafeVarargs
    final Stream<Entity> withComponents(final Class<? extends Component>... components) {
        Family all = Family.all(components).get();
        return StreamSupport.stream(engine.getEntitiesFor(all).spliterator(), false);
    }

    @Override
    public void addedToEngine(Engine engine) {
        this.engine = engine;
        super.addedToEngine(engine);
    }
}
