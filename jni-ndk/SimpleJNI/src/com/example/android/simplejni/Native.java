package com.example.android.simplejni;

/**
 * @author Administrator  on 2020/3/25.
 */
public class Native {
    static {
        // The runtime will add "lib" on the front and ".o" on the end of
        // the name supplied to loadLibrary.
        System.loadLibrary("simplejni");
    }

    static native int add(int a, int b);
}
