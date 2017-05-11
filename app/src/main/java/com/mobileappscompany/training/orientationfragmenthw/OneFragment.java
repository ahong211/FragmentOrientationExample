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


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {
    Button btn;
    EditText editText1;
    TextView textView1;


    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        textView1 = (TextView) view.findViewById(R.id.textView);
        editText1 = (EditText) view.findViewById(R.id.editText1);

        btn = (Button) view.findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MoveToFrag2 act = (MoveToFrag2) getActivity();

                String frag1Text = editText1.getText().toString();

                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    act.goToFrag2();
                }

                act.setTextFrag2(frag1Text);
            }
        });
        return view;
    }


    public interface MoveToFrag2 {
        public void goToFrag2();

        public void goToFrag1();

        public void setTextFrag2(String s);

        public void setTextFrag1(String s);

    }

}

