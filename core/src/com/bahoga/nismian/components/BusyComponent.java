package com.bahoga.nismian.components;

import com.badlogic.ashley.core.Component;

public class BusyComponent extends Component {

    private float timebusy;

    public BusyComponent(float timebusy) {
        this.timebusy = timebusy;
    }

    public void update(float delta) {
        timebusy -= delta;
    }

    public boolean isBusy(){
        return timebusy > 0;
    }
}
