package com.example.tylerpalcic.homework1;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pes.androidmaterialcolorpickerdialog.ColorPicker;
import com.pes.androidmaterialcolorpickerdialog.ColorPickerCallback;
import android.support.annotation.ColorInt;
import android.graphics.Bitmap;
import android.widget.Toast;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;

public class Part2 extends Fragment {

    private CanvasView canvasView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_part2, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // clear canvas button
        final Button clearButton = getView().findViewById(R.id.clearButton);
        canvasView = getView().findViewById(R.id.canvas);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { clearCanvas(); }
        });

        // color change button
        final Button colorButton = getView().findViewById(R.id.colorButton);
        colorButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openColorPicker();
            }
        });

        // save image button
        final Button saveButton = getView().findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getActivity(), "Image Saved!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openColorPicker(){
        final ColorPicker cp = new ColorPicker(getActivity(), 0,0 , 0);
        cp.show();

        cp.enableAutoClose();

        cp.setCallback(new ColorPickerCallback() {
            @Override
            public void onColorChosen(@ColorInt int color) {
                canvasView.getmPaint().setColor(color);
//                canvasView.onDraw(Canvas.getmCanvas());
//                Path mPath = new Path();
//                Paint mPaint1 = new Paint();
//                mPaint1.setColor(color);
//                canvasView.mCanvas.drawPath(mPath,mPaint1);
            }
        });
    }

    public void clearCanvas(){
        canvasView.clearCanvas();
    }
}