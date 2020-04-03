package com.example.android.jetboy;

/**
 * @author Administrator  on 2019/9/20.
 */

import android.view.KeyEvent;

/**
 * A GameEvent subclass for key based user input. Values are those used by
 * the standard onKey
 */
public class KeyGameEvent extends GameEvent {
    /**
     * Simple constructor to make populating this event easier.
     */
    public KeyGameEvent(int keyCode, boolean up, KeyEvent msg) {
        this.keyCode = keyCode;
        this.msg = msg;
        this.up = up;
    }

    public int keyCode;
    public KeyEvent msg;
    public boolean up;
}
