package com.example.android.codetribeconnect;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RP on 2017/09/02.
 */

public class UserProfileEditorActivity extends AppCompatActivity {
    public static final int DEFAULT_MSG_LENGTH_LIMIT  = 1000;
    public static final int RC_PHOTO_PICKER = 2;
    private EditText userNameEditText;
    private EditText userSurnameEditText;
    private EditText userCurrentOccupation;
    private EditText userPhoneNumber;
    private EditText userEmailEditText;
    private Button userUpdateButton;
    DatabaseReference mDatabaseReference;
    StorageReference mStoragereference;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("verified_users");
        mStoragereference = FirebaseStorage.getInstance().getReference()
                .child("verified_users_photos");
        userNameEditText = (EditText) findViewById(R.id.name_editView);
        userSurnameEditText = (EditText) findViewById(R.id.surnameEditText);
        userCurrentOccupation = (EditText) findViewById(R.id.occpateEditText);
        userPhoneNumber = (EditText) findViewById(R.id.cell_editTextView);
        userEmailEditText = (EditText) findViewById(R.id.emailEditText);
        userUpdateButton = (Button) findViewById(R.id.userUpdateButton);

        userUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ActiveUser items = new ActiveUser();
                items.setActiveUserName(userNameEditText.getText().toString());
                items.setActiveUserSurname(userSurnameEditText.getText().toString());
                items.setActiveUserOccupation(userCurrentOccupation.getText().toString());
                items.setActiveUserEmail(userEmailEditText.getText().toString());
                items.setActiveUserImageUrl(null);
                items.setActiveUserStatus(null);
                mDatabaseReference.push().setValue(items);
                userNameEditText.setText("");
                userSurnameEditText.setText("");
                userCurrentOccupation.setText("");
                userEmailEditText.setText("");
                userPhoneNumber.setText("");
                Toast.makeText(UserProfileEditorActivity.this, "Information saved...",Toast.LENGTH_SHORT).show();

            }
        });


        userNameEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(DEFAULT_MSG_LENGTH_LIMIT)});
        userSurnameEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(DEFAULT_MSG_LENGTH_LIMIT)});
        userCurrentOccupation.setFilters(new InputFilter[]{new InputFilter.LengthFilter(DEFAULT_MSG_LENGTH_LIMIT)});
        userPhoneNumber.setFilters(new InputFilter[]{new InputFilter.LengthFilter(DEFAULT_MSG_LENGTH_LIMIT)});
        userEmailEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(DEFAULT_MSG_LENGTH_LIMIT)});

    }
}

