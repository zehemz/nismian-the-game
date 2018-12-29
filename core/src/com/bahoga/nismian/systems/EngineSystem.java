package com.bahoga.nismian.systems;

import com.badlogic.ashley.core.*;
import com.badlogic.ashley.utils.ImmutableArray;

import java.util.function.Consumer;

public class EngineSystem extends EntitySystem {

    private Engine engine;

    ImmutableArray<Entity> getAll(final Class<? extends Component>... components) {
        Family all = Family.all(components).get();
        return engine.getEntitiesFor(all);
    }

    void doApply(final Consumer<Entity> function, final Class<? extends Component>... components) {
        ImmutableArray<Entity> all = getAll(components);
        for (Entity en : all) {
            function.accept(en);
        }
    }

    @Override
    public void addedToEngine(Engine engine) {
        this.engine = engine;
        super.addedToEngine(engine);
    }
}
