package com.choisroyalfamily.massivcode.finalcallback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    private EditText mTitleEditText, mContentsEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        mTitleEditText = (EditText) findViewById(R.id.title_et);
        mContentsEditText = (EditText) findViewById(R.id.contents_et);

        findViewById(R.id.add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = mTitleEditText.getText().toString().trim();

                if (TextUtils.isEmpty(title)) {
                    Toast.makeText(AddActivity.this, "제목을 입력해주세요!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String contents = mContentsEditText.getText().toString().trim();

                if (TextUtils.isEmpty(contents)) {
                    Toast.makeText(AddActivity.this, "내용을 입력해주세요!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent();
                intent.putExtra("memo", new Memo(title, contents));
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
