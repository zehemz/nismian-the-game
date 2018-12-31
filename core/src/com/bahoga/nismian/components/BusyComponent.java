package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;

public class BusyComponent extends Component {

    public static final BusyComponent IDLE = new BusyComponent(0f);

    private float timebusy;

    public BusyComponent(float timebusy) {
        this.timebusy = timebusy;
    }

    public void update(float delta) {
        timebusy -= delta;
    }

    public boolean isBusy() {
        return timebusy > 0f;
    }

    public boolean isIdle() {
        return timebusy <= 0f;
    }
}
