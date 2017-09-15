package com.example.mahdihs76.flatiq.view.page.login;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.mahdihs76.flatiq.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment  {

    public static LoginFragment mFragment;
    private EditText emailText;
    private EditText passText;

    public LoginFragment() {
        mFragment = this;
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_login, container, false);
        emailText = (EditText) view.findViewById(R.id.email_text);
        passText = (EditText) view.findViewById(R.id.pass_text);
         return view;
    }

    public String getEmailPassString(){
        return emailText.getText().toString() + passText.getText().toString();
    }

    public String getEmail(){
        return emailText.getText().toString();
    }

    public String getPass(){
        return passText.getText().toString();
    }


}
