package com.bahoga.nismian.systems;

import com.badlogic.ashley.core.*;

import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class EngineSystem extends EntitySystem {

    private Engine engine;

    Stream<Entity> searchWith(final Class<? extends Component>... components) {
        Family all = Family.all(components).get();
        return StreamSupport.stream(engine.getEntitiesFor(all).spliterator(), false);
    }

    void applyToAll(final Consumer<Entity> function, final Class<? extends Component>... components) {
        searchWith(components).forEach(function);
    }

    @Override
    public void addedToEngine(Engine engine) {
        this.engine = engine;
        super.addedToEngine(engine);
    }
}
