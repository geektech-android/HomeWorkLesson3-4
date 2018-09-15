package com.akai.geektech.homework34;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mName, mPhoneNumber, mEmail, mSkills;
    private EditText mSkillsEdit;
    private Button mSaveEditButton;
    private boolean isEditMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void switchModeClicked() {
        if (isEditMode) {
            showViewMode();
        } else {
            showEditMode();
        }
    }

    private void showViewMode() {
        String mEditedSkills = mSkillsEdit.getText().toString();
        mSkills.setText(mEditedSkills);
        mSkillsEdit.setVisibility(View.INVISIBLE);
        mSkills.setVisibility(View.VISIBLE);

        mSaveEditButton.setText(getString(R.string.edit));
        switchMode();
    }

    private void showEditMode() {
        mSkillsEdit.setText(mSkills.getText());
        mSkillsEdit.setVisibility(View.VISIBLE);
        mSkills.setVisibility(View.INVISIBLE);

        mSaveEditButton.setText(getString(R.string.save));
        switchMode();
    }

    private void switchMode() {
        isEditMode = !isEditMode;
    }

    private void switchModeListener(View view) {
        switch (view.getId()) {
            case R.id.switchMode: switchModeClicked(); break;
        }
    }

    private void init() {
        mName = findViewById(R.id.name);
        mPhoneNumber = findViewById(R.id.phone);
        mEmail = findViewById(R.id.email);
        mSkills = findViewById(R.id.skills);
        mSkillsEdit = findViewById(R.id.edit_skills);
        mSaveEditButton = findViewById(R.id.switchMode);


        Log.d("TAG", "visible " + mSkillsEdit.getVisibility());

        mSkills.setText(getSkills());
        mSaveEditButton.setOnClickListener(this::switchModeListener);
    }

    private String getSkills() {
        String[] skills = getResources().getStringArray(R.array.skills);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < skills.length; i++) {
            builder.append(skills[i]);
            if (i != skills.length-1) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }
}
