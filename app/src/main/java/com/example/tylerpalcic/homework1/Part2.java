package com.example.tylerpalcic.homework1;


import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.pes.androidmaterialcolorpickerdialog.ColorPicker;
import com.pes.androidmaterialcolorpickerdialog.ColorPickerCallback;
import android.support.annotation.ColorInt;
import android.graphics.Bitmap;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Part2 extends Fragment {

    private CanvasView canvasView;
    private int spc = 1;
    private ArrayList<Path> paths = new ArrayList<Path>();


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
                if (ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        saveImage(canvasView.mBitmap);

                } else {
                    requestStoragePermission();
                }
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



            }
        });
    }

    public void clearCanvas(){
        canvasView.clearCanvas();
    }

    public void saveImage(Bitmap bitmap){

        File file = Environment.getExternalStorageDirectory();
        File newFile = new File(file, "test.PNG");

        try {
            FileOutputStream fos = new FileOutputStream(newFile);
            boolean compress = bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
            Toast.makeText(getContext(),
                            "Saved Image: " + fos.toString(),
                            Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        Toast.makeText(getContext(),
                            "Error1: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
            }
    }

    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
        Manifest.permission.READ_EXTERNAL_STORAGE)) {
        new AlertDialog.Builder(getActivity())
        .setTitle("Permission Needed").setMessage("Do you accept?")
        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
          }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            }
            }).create().show();
        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, spc);
         }


        }

    }

