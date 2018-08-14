package my.edu.utem.randomnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    int txt, numberOfTries;
    boolean gameOn;
    int randNumber;
    Button Reset_Button, Click_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.hello_textView);
        Reset_Button = findViewById(R.id.Reset_button);
        Click_Button = findViewById(R.id.Click_button);
        initializeGame();
    }

    private void initializeGame() {
        randNumber = (int)Math.ceil(Math.random() * 100);
        numberOfTries = 3;
        gameOn = true;
        textView.setText("");
        Reset_Button.setVisibility(View.GONE);
        Click_Button.setVisibility(View.VISIBLE);
    }

    public void buttonPressed(View view) {


        txt = Integer.parseInt(textView.getText().toString());
        Log.d("debug", "Enter a number between 1-100");

        numberOfTries--;
        if (txt < randNumber) {
            Toast.makeText(MainActivity.this, "number too small", Toast.LENGTH_LONG).show();
        }else
        if (txt > randNumber) {
            Toast.makeText(MainActivity.this, "number too big", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "found", Toast.LENGTH_LONG).show();
            gameOn = false;
        }
        if(numberOfTries == 0 && gameOn)
        {
        textView.setText("Sorry you lose. The number is"+randNumber);
        }
    }

    public void resetButtonPressed(View view) {
        initializeGame();
    }
}