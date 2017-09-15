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
public class RegisterFragment extends Fragment {


    private EditText nameText;
    private EditText lastNameText;
    private EditText emailText;
    private EditText passText;
    private EditText conPassText;

    public static RegisterFragment mFragment;


    public RegisterFragment() {
        mFragment = this;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        nameText = (EditText) view.findViewById(R.id.name_txt);
        lastNameText = (EditText) view.findViewById(R.id.lname_txt);
        emailText = (EditText) view.findViewById(R.id.email_txt);
        passText = (EditText) view.findViewById(R.id.pass_txt);
        conPassText = (EditText) view.findViewById(R.id.conpass_txt);
        return view;
    }

    public void removeAll() {
        nameText.setText("");
        lastNameText.setText("");
        emailText.setText("");
        passText.setText("");
        conPassText.setText("");
    }

    public String getNameText() {
        return nameText.getText().toString();
    }

    public String  getLastNameText() {
        return lastNameText.getText().toString();
    }

    public String  getEmailText() {
        return emailText.getText().toString();
    }

    public String  getPassText() {
        return passText.getText().toString();
    }

    public String  getConPassText() {
        return conPassText.getText().toString();
    }

}
