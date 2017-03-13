package com.choisroyalfamily.massivcode.finalcallback;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentToActivityListener {

    private MemoFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragment = (MemoFragment) getSupportFragmentManager().findFragmentById(R.id.memo_fragment);
    }

    @Override
    public void onAddButtonClicked() {
        startActivityForResult(new Intent(MainActivity.this, AddActivity.class), 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1000 && resultCode == RESULT_OK && data != null) {
            mFragment.onMemoAdded((Memo) data.getSerializableExtra("memo"));
        }
    }
}
