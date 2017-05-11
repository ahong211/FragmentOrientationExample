package com.mobileappscompany.training.orientationfragmenthw;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class TwoFragment extends Fragment {
    EditText editText2;
    Button btn2;
    TextView textView2;


    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        textView2 = (TextView) view.findViewById(R.id.textView2);
        btn2 = (Button) view.findViewById(R.id.button2);
        editText2 = (EditText) view.findViewById(R.id.editText2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OneFragment.MoveToFrag2 act2 = (OneFragment.MoveToFrag2) getActivity();

                String frag2Text = editText2.getText().toString();

                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    act2.goToFrag1();
                }
                act2.setTextFrag1(frag2Text);
            }
        });

        return view;
    }



}
