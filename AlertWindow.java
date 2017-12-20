/*
AlertWindow
version 2.1
© 2017 Dark Tornado, All rights reserved.
You can customize it as changing color, texts or add animation.
*/

package com.darktornado.alertwindowexample;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by DarkTornado on 2017-06-13.
 */

public class AlertWindow {
    private WindowManager mManager;
    private WindowManager.LayoutParams mParams;
    private Context ctx;
    private View view;
    private TextView title;
    private TextView msg;
    private boolean useExit;
    private LinearLayout layout;
    private TextView btn;
    private boolean drag;
    private boolean fold;

    public AlertWindow(Context ctx2) {
        try {
            ctx = ctx2;
            title = null;
            msg = null;
            useExit = true;
            btn = null;
            drag = true;
            fold = false;
            int x = ctx.getResources().getDisplayMetrics().widthPixels;
            int y = ctx.getResources().getDisplayMetrics().heightPixels;
            if(x<y)
                mParams = new WindowManager.LayoutParams(
                        x/2, ((x/2)*4/3),
                        WindowManager.LayoutParams.TYPE_PHONE,
                        WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                        PixelFormat.TRANSLUCENT);
            else
                mParams = new WindowManager.LayoutParams(
                        (y*3/4)*3/4, y*3/4,
                        WindowManager.LayoutParams.TYPE_PHONE,
                        WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                        PixelFormat.TRANSLUCENT);
        }
        catch(Exception e){
            toast(e.toString());
        }
    }

    public AlertWindow(Context ctx2, boolean hasEditText) {
        try {
            ctx = ctx2;
            title = null;
            msg = null;
            useExit = true;
            btn = null;
            drag = true;
            fold = false;
            int x = ctx.getResources().getDisplayMetrics().widthPixels;
            int y = ctx.getResources().getDisplayMetrics().heightPixels;
            if(x<y)
                mParams = new WindowManager.LayoutParams(
                        x/2, ((x/2)*4/3),
                        WindowManager.LayoutParams.TYPE_PHONE,
                        WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                        PixelFormat.TRANSLUCENT);
            else
                mParams = new WindowManager.LayoutParams(
                        (y*3/4)*3/4, y*3/4,
                        WindowManager.LayoutParams.TYPE_PHONE,
                        WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                        PixelFormat.TRANSLUCENT);
        }
        catch(Exception e){
            toast(e.toString());
        }
    }

    public void setTitle(String txt) {
        try {
            title = new TextView(ctx);
            title.setText(txt);
            title.setTextColor(Color.CYAN);
            title.setTextSize(22);
            title.setGravity(Gravity.CENTER);
            int pad = dip2px(3);
            title.setPadding(pad, pad, pad, pad);
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public void setMessage(String txt){
        try{
            msg = new TextView(ctx);
            msg.setText(txt);
            msg.setTextColor(Color.WHITE);
            msg.setTextSize(18);
        }
        catch(Exception e){
            toast(e.toString());
        }
    }

    public void setView(View view1){
        try{
            view = view1;
        }
        catch(Exception e){
            toast(e.toString());
        }
    }

    public void useCloseButton(boolean use){
        try{
            useExit = use;
        }
        catch(Exception e){
            toast(e.toString());
        }
    }

    public void setButton(String txt, View.OnClickListener listener){
        try{
            btn = new TextView(ctx);
            btn.setText(txt);
            btn.setTextSize(18);
            btn.setTextColor(Color.WHITE);
            btn.setOnClickListener(listener);
            int pad = dip2px(5);
            btn.setPadding(pad, pad, pad, pad);
            btn.setGravity(Gravity.CENTER);
            btn.setBackgroundColor(Color.argb(70, 0, 0, 0));
            ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(-2, -2);
            margin.setMargins(0, dip2px(5), 0, dip2px(3));
            btn.setLayoutParams(new android.widget.LinearLayout.LayoutParams(margin));
        }
        catch(Exception e){
            toast(e.toString());
        }
    }

    public void show(){
        try{
            layout = new LinearLayout(ctx);
            layout.setOrientation(1);
            LinearLayout layout2 = new LinearLayout(ctx);
            layout2.setOrientation(1);
            if(title!=null) {
                title.setBackgroundColor(Color.argb(90, 90, 90, 90));
                if(useExit) layout.addView(makeExit());
                else layout.addView(title);
                final boolean[] longClick = {false};
                if (drag) title.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent ev) {
                        if (longClick[0]) {
                            switch (ev.getAction()) {
                                case MotionEvent.ACTION_UP:
                                    longClick[0] = false;
                                    break;
                                case MotionEvent.ACTION_MOVE:
                                    mParams.x = (int) ev.getRawX() - mParams.width / 2;
                                    mParams.y = (int) ev.getRawY() - mParams.height / 2;
                                    mParams.gravity = Gravity.LEFT | Gravity.TOP;
                                    mManager.updateViewLayout(layout, mParams);
                                    break;
                            }
                        } else if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    if (!longClick[0]) longClick[0] = true;
                                }
                            }, 500);
                        }
                        return !fold;
                    }
                });
                if(fold){
                    final int height = mParams.height;
                    title.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                if (layout.getChildCount() == 1) {
                                    layout.addView(scroll);
                                    mParams.height = height;
                                    mManager.updateViewLayout(layout, mParams);
                                } else {
                                    layout.removeView(scroll);
                                    mParams.height = -2;
                                    mManager.updateViewLayout(layout, mParams);
                                }
                            } catch (Exception e) {
                                toast(e.toString());
                            }
                        }
                    });
                }
            }
            if(view!=null) layout2.addView(view);
            if(msg!=null) layout2.addView(msg);
            if(btn!=null) layout2.addView(btn);
            ScrollView scroll = new ScrollView(ctx);
            scroll.addView(layout2);
            int pad = dip2px(3);
            layout2.setPadding(pad, pad, pad, pad);
            layout2.setGravity(Gravity.CENTER);
            layout.addView(scroll);
            layout.setBackgroundColor(Color.argb(130, 50, 50, 50));
            mManager = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
            mManager.addView(layout, mParams);
        }
        catch(Exception e){
            toast(e.toString());
        }
    }

    private RelativeLayout makeExit(){
        try {
            RelativeLayout layout = new RelativeLayout(ctx);
            title.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            layout.addView(title);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(dip2px(30), dip2px(30));
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            TextView exit = new TextView(ctx);
            exit.setText("X");
            exit.setTextSize(14);
            exit.setTextColor(Color.WHITE);
            exit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    close();
                }
            });
            int pad = dip2px(1);
            exit.setPadding(pad, pad, pad, pad);
            exit.setGravity(Gravity.CENTER);
            exit.setBackgroundColor(Color.argb(20, 0, 0, 0));
            exit.setLayoutParams(params);
            layout.addView(exit);
            return layout;
        }
        catch(Exception e){
            toast(e.toString());
        }
        return null;
    }

    public void close(){
        try{
            mManager = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
            mManager.removeView(layout);
        }
        catch(Exception e){
            toast(e.toString());
        }
    }

    public void setDraggable(boolean canDrag){
        drag = canDrag;
    }

    public void setFoldable(boolean canFold){
        fold = canFold;
    }


    private void toast(final String msg) {
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
    }

    private int dip2px(int dips){
        return (int)Math.ceil(dips*ctx.getResources().getDisplayMetrics().density);
    }

}
