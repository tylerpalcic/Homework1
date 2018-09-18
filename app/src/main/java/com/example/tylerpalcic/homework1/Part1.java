package com.example.tylerpalcic.homework1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import java.util.Random;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Part1 extends Fragment {

    // random number
    Random ran = new Random();

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_part1, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {


        // change color button
        Button colorButton = getView().findViewById(R.id.colorButton);


        // edit text field
        final EditText inputEditText = getView().findViewById(R.id.inputEditText);

        final TextView outputTextView = getView().findViewById(R.id.outputTextView);

        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputEditText.getText().length() == 0) {
                    Toast.makeText(getActivity(), "Text field empty!", Toast.LENGTH_SHORT).show();
                }
                // generate color
                int r =ran.nextInt(256);

                // set text color
                int g =ran.nextInt(256);
                int b =ran.nextInt(256);
                int color = Color.rgb(r, g, b);
                inputEditText.setTextColor(color);

                //generate HTML color code
                String colorCode = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);

                // set output
                String s = "COLOR: " + r + "r     " + g + "g     "  +  b + "b\n" + "HTML color code: " + colorCode;
                outputTextView.setText(s);
            }
        });
    }
}
