package com.dragosholban.androiddrawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class DrawingView extends View {

    private ArrayList<Path> paths = new ArrayList<>();
    private ArrayList<Integer> colors = new ArrayList<>();
    private int currentColor = 0xFF000000;

    public DrawingView(Context context) {
        super(context);
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DrawingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void addPath(Path path) {
        paths.add(path);
        colors.add(currentColor);
    }

    public Path getLastPath() {
        if (paths.size() > 0) {
            return paths.get(paths.size() - 1);
        }

        return null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int i = 0;
        for (Path path : paths) {
            Paint paint = new Paint();
            paint.setColor(colors.get(i));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(3f);
            canvas.drawPath(path, paint);
            i++;
        }
    }

    public void setCurrentColor(int color) {
        currentColor = color;
    }
}
