package com.example.isbatullah.tictactoe;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button restart;
    boolean player1 = true;
    boolean player2 = false;
    boolean playerTurn = player1;
    boolean gameOver = false;
    TextView turnText;
    boolean board = false;
    void WinnerCheckerFunction(Button a, Button b, Button c) {
        AlertDialog.Builder popup = new AlertDialog.Builder(MainActivity.this);
        popup.setTitle("Winner");
            if (a.getText().toString().equals("X") && b.getText().toString().equals("X") && c.getText().toString().equals("X")) {
                gameOver = true;
                board = true;
                String message = "Player 1 Wins!";
                popup.setMessage(message);
                popup.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        restartGame();
                    }
                });
                popup.show();
            }
            else if (a.getText().toString().equals("O") && b.getText().toString().equals("O") && c.getText().toString().equals("O")) {
                gameOver = true;
                board = true;
              String message = "Player Two wins!";
                popup.setMessage(message);
                popup.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        restartGame();
                    }
                });
                popup.show();
            }else if(!b1.getText().toString().equals("") &&
                    !b2.getText().toString().equals("") &&
                    !b3.getText().toString().equals("") &&
                    !b4.getText().toString().equals("") &&
                    !b5.getText().toString().equals("") &&
                    !b6.getText().toString().equals("") &&
                    !b7.getText().toString().equals("") &&
                    !b8.getText().toString().equals("") &&
                    !b9.getText().toString().equals("") && gameOver == false && board == false ){
                gameOver = true;
                String message = "It's a tie!";
                popup.setMessage(message);
                popup.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        restartGame();
                    }
                });
                popup.show();
            }

    }


    void WinnerChecker(){
        WinnerCheckerFunction(b1, b2, b3);
        WinnerCheckerFunction(b4, b5, b6);
        WinnerCheckerFunction(b7, b8, b9);
        WinnerCheckerFunction(b1, b4, b7);
        WinnerCheckerFunction(b2, b5, b8);
        WinnerCheckerFunction(b3, b6, b9);
        WinnerCheckerFunction(b1, b5, b9);
        WinnerCheckerFunction(b3, b5 ,b7);
    }

    void restartGame(){
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        turnText.setText("Time to play Tic Tac Toe! Player One's Turn");
        playerTurn = player1;
        gameOver = false;
        board = false;
    }

    void playerTurnFuncntion(Button x){
        if(gameOver==false) {
            if (playerTurn == player1) {
                if (x.getText().toString().equals("")) {
                    x.setText("X");
                    playerTurn = !playerTurn;

                }
            }
            if (playerTurn == player2) {
                if (x.getText().toString().equals("")) {
                    x.setText("O");
                    playerTurn = !playerTurn;

                }
            }
            WinnerChecker();
        }

        if(playerTurn) {
            turnText.setText("Player One's Turn");
        }else{
            turnText.setText("Player Two's Turn");

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        turnText = (TextView) findViewById(R.id.playerTurn);
        restart = (Button) findViewById(R.id.restart);

        if (gameOver == false) {
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playerTurnFuncntion(b1);
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playerTurnFuncntion(b2);
                }
            });
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playerTurnFuncntion(b3);
                }
            });
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playerTurnFuncntion(b4);
                }
            });
            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playerTurnFuncntion(b5);
                }
            });
            b6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playerTurnFuncntion(b6);
                }
            });
            b7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playerTurnFuncntion(b7);
                }
            });
            b8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playerTurnFuncntion(b8);
                }
            });
            b9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playerTurnFuncntion(b9);
                }
            });
            restart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  restartGame();
                }
            });

        }
    }
}
