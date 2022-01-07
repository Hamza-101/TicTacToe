package pk.edu.itu.lecture5fall2021;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int count=0;
    int [][] data;
    ImageButton[][] buttons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button reset=findViewById(R.id.btnResetGame);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
        buttons = new ImageButton[5][5];
        data= new int[5][5];

        buttons[0][0] = findViewById(R.id.img7);
        buttons[0][1] = findViewById(R.id.img2);
        buttons[0][2] = findViewById(R.id.img8);
        buttons[0][3] = findViewById(R.id.img15);
        buttons[0][4] = findViewById(R.id.img28);

        buttons[1][0] = findViewById(R.id.img4);
        buttons[1][1] = findViewById(R.id.img22);
        buttons[1][2] = findViewById(R.id.img16);
        buttons[1][3] = findViewById(R.id.img9);
        buttons[1][4] = findViewById(R.id.img10);

        buttons[2][0] = findViewById(R.id.img6);
        buttons[2][1] = findViewById(R.id.img23);
        buttons[2][2] = findViewById(R.id.img20);
        buttons[2][3] = findViewById(R.id.img12);
        buttons[2][4] = findViewById(R.id.img27);

        buttons[3][0] = findViewById(R.id.img3);
        buttons[3][1] = findViewById(R.id.img17);
        buttons[3][2] = findViewById(R.id.img21);
        buttons[3][3] = findViewById(R.id.img11);
        buttons[3][4] = findViewById(R.id.img26);

        buttons[4][0] = findViewById(R.id.img5);
        buttons[4][1] = findViewById(R.id.img18);
        buttons[4][2] = findViewById(R.id.img19);
        buttons[4][3] = findViewById(R.id.img24);
        buttons[4][4] = findViewById(R.id.img25);


        for(int i=0; i<5; i++)
        {
            for(int j=0; j<5; j++) {
                final int a = i;
                final int b= j;
                buttons[a][b].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(data[a][b]!=0)
                            return;
                        if (count % 2 == 0) {
                            buttons[a][b].setImageResource(R.drawable.sun);
                            data[a][b]=1;
                        }
                        else
                        {
                            buttons[a][b].setImageResource(R.drawable.snow);
                            data[a][b] = 2;
                        }
                        String output="";
                        for(int x =0; x<5; x++)
                            for(int y=0; y<5; y++)
                                output+= data[x][y]+",";
                        Log.d("TICTACTOE",output);


                        for(int row=0; row<5; row++)
                        {
                            if(data[row][0]==data[row][1] && data[row][1]==data[row][2] && data[row][2]==data[row][3]&& data[row][3]==data[row][4]&&data[row][0]!=0 ) {
                                if (count % 2 == 0)
                                    Toast.makeText(getApplicationContext(), "Sun wins", Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(getApplicationContext(), "Snowman wins", Toast.LENGTH_LONG).show();
                                resetGame();
                                return;
                            }
                        }

                        for(int row=0; row<5; row++)
                        {
                            if(data[0][row]==data[1][row] && data[2][row]==data[1][row] && data[2][row]==data[3][row]&& data[3][row]==data[4][row]&&data[row][0]!=0 ) {
                                if (count % 2 == 0)
                                    Toast.makeText(getApplicationContext(), "Sun wins", Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(getApplicationContext(), "Snowman wins", Toast.LENGTH_LONG).show();
                                resetGame();
                                return;
                            }
                        }
                        for(int row=0; row<5; row++)
                        {
                            if(data[0][0]==data[1][1] && data[1][1]==data[2][2] && data[2][2]==data[3][3]&&data[3][3]==data[4][4]&&data[0][0]!=0 ) {
                                if (count % 2 == 0)
                                    Toast.makeText(getApplicationContext(), "Sun wins", Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(getApplicationContext(), "Snowman wins", Toast.LENGTH_LONG).show();
                                resetGame();
                                return;
                            }
                        }
                        for(int row=0; row<5; row++)
                        {
                            if(data[0][4]==data[1][3] && data[1][3]==data[2][2] && data[3][1]==data[4][0]&&data[0][4]!=0 ) {
                                if (count % 2 == 0)
                                    Toast.makeText(getApplicationContext(), "Sun wins", Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(getApplicationContext(), "Snowman wins", Toast.LENGTH_LONG).show();
                                resetGame();
                                return;
                            }
                        }

                        count++;

                    }


                });
            }
        }




    }

    void resetGame()
    {
        count = 0;
        for(int i=0; i<5; i++)
        {
            for(int j=0; j<5; j++)
            {
                data[i][j] = 0;
                buttons[i][j].setImageResource(R.drawable.circle);
            }
        }
    }
}