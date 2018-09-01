package com.ka.paint.paint;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private DrawView mDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDraw = findViewById(R.id.drawView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.clear : {
                mDraw.clearCanvas();
                break;
            }

            case R.id.black : {
                mDraw.setColor(Color.BLACK);
                break;
            }

            case R.id.green : {
                mDraw.setColor(Color.GREEN);
                break;
            }

            case R.id.yellow : {
                mDraw.setColor(Color.YELLOW);
                break;
            }

            case R.id.blue : {
                mDraw.setColor(Color.BLUE);
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
