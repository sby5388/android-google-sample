/*
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

// Android JET demonstration code:
// All inline comments related to the use of the JetPlayer class are preceded by "JET info:"

package com.example.android.jetboy;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JetBoyView extends SurfaceView implements SurfaceHolder.Callback, JetBoyThread.ViewCallback {

    // the number of asteroids that must be destroyed
    private static final int mSuccessThreshold = 50;

    // used to calculate level for mutes and trigger clip
    public int mHitStreak = 0;

    // total number asteroids you need to hit.
    public int mHitTotal = 0;

    // which music bed is currently playing?
    public int mCurrentBed = 0;

    // a lazy graphic fudge for the initial title splash
    private Bitmap mTitleBG;

    private Bitmap mTitleBG2;

    // JET info: the JetBoyThread receives all the events from the JET player
    // JET info: through the OnJetEventListener interface.

    public static final String TAG = "JetBoy";

    /**
     * The thread that actually draws the animation
     */
    private JetBoyThread thread;

    private TextView mTimerView;

    private Button mButtonRetry;

    // private Button mButtonRestart; 
    private TextView mTextView;

    /**
     * The constructor called from the main JetBoy activity
     *
     * @param context
     * @param attrs
     */
    public JetBoyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // register our interest in hearing about changes to our surface
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);

        // create thread only; it's started in surfaceCreated()
        // except if used in the layout editor.
        if (!isInEditMode()) {

            final Handler handler = new Handler() {

                @Override
                public void handleMessage(Message m) {

                    mTimerView.setText(m.getData().getString("text"));

                    if (m.getData().getString("STATE_LOSE") != null) {
                        //mButtonRestart.setVisibility(View.VISIBLE);
                        mButtonRetry.setVisibility(View.VISIBLE);

                        mTimerView.setVisibility(View.INVISIBLE);

                        mTextView.setVisibility(View.VISIBLE);

                        Log.d(TAG, "the total was " + mHitTotal);

                        if (mHitTotal >= mSuccessThreshold) {
                            mTextView.setText(R.string.winText);
                        } else {
                            mTextView.setText("Sorry, You Lose! You got " + mHitTotal
                                    + ". You need 50 to win.");
                        }

                        mTimerView.setText("1:12");
                        mTextView.setHeight(20);

                    }
                }//end handle msg
            };
            thread = new JetBoyThread(holder, context, handler, this);
        }

        setFocusable(true); // make sure we get key events

        Log.d(TAG, "@@@ done creating view!");
    }


    /**
     * Pass in a reference to the timer view widget so we can update it from here.
     *
     * @param tv
     */
    public void setTimerView(TextView tv) {
        mTimerView = tv;
    }


    /**
     * Standard window-focus override. Notice focus lost so we can pause on
     * focus lost. e.g. user switches to take a call.
     */
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        if (!hasWindowFocus) {
            if (thread != null)
                thread.pause();

        }
    }


    /**
     * Fetches the animation thread corresponding to this LunarView.
     *
     * @return the animation thread
     */
    public JetBoyThread getThread() {
        return thread;
    }


    /* Callback invoked when the surface dimensions change. */
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        thread.setSurfaceSize(width, height);
    }


    public void surfaceCreated(SurfaceHolder arg0) {
        // start the thread here so that we don't busy-wait in run()
        // waiting for the surface to be created
        thread.setRunning(true);
        thread.start();
    }


    public void surfaceDestroyed(SurfaceHolder arg0) {
        boolean retry = true;
        thread.setRunning(false);
        while (retry) {
            try {
                thread.join();
                retry = false;

            } catch (InterruptedException e) {
            }
        }
    }


    /**
     * A reference to the button to start game over.
     *
     * @param _buttonRetry
     */
    public void SetButtonView(Button _buttonRetry) {
        mButtonRetry = _buttonRetry;
        //  mButtonRestart = _buttonRestart;
    }


    //we reuse the help screen from the end game screen.
    public void SetTextView(TextView textView) {
        mTextView = textView;
    }

    @Override
    public void setTitleBG(Bitmap titleBG) {
        mTitleBG = titleBG;
    }

    @Override
    public Bitmap getTitleBG() {
        return mTitleBG;
    }

    @Override
    public void setCurrentBed(int currentBed) {
        mCurrentBed = currentBed;
    }

    @Override
    public Bitmap getTitleBG2() {
        return mTitleBG2;
    }

    @Override
    public void setTitleBG2(Bitmap titleBG2) {
        mTitleBG2 = titleBG2;
    }

    @Override
    public void initGameData() {
        mHitStreak = 0;
        mHitTotal = 0;
    }

    @Override
    public void addGameData() {
        mHitStreak++;
        mHitTotal++;
    }

    @Override
    public int getHitStreak() {
        return mHitStreak;
    }

    @Override
    public int getCurrentBed() {
        return mCurrentBed;
    }

    @Override
    public void setHitStreak(int hitStreak) {
        mHitStreak = hitStreak;
    }
}
