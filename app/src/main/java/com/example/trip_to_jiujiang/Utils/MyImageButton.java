package com.example.trip_to_jiujiang.Utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageButton;


public class MyImageButton extends ImageButton {
 private String text="";
 private int color;
 private float size;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public MyImageButton(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(color);
        paint.setTextSize(size);
        canvas.drawText(text, canvas.getWidth()/2, (canvas.getHeight()/2)+12, paint);
    }
}
