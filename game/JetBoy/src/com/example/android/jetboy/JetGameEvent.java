package com.example.android.jetboy;

/**
 * @author Administrator  on 2019/9/20.
 */

import android.media.JetPlayer;

/**
 * A GameEvent subclass for events from the JetPlayer.
 */
public class JetGameEvent extends GameEvent {
    /**
     * Simple constructor to make populating this event easier.
     */
    public JetGameEvent(JetPlayer player, short segment, byte track, byte channel,
                        byte controller, byte value) {
        this.player = player;
        this.segment = segment;
        this.track = track;
        this.channel = channel;
        this.controller = controller;
        this.value = value;
    }

    public JetPlayer player;
    public short segment;
    public byte track;
    public byte channel;
    public byte controller;
    public byte value;
}
