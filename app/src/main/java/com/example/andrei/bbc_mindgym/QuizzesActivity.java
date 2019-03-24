package com.example.andrei.bbc_mindgym;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Question{
    private String quest;
    private String a;
    private String b;
    private String c;
    private String correct;

    public Question(String quest, String a, String b, String c, String correct) {
        this.quest = quest;
        this.a = a;
        this.b = b;
        this.c = c;
        this.correct = correct;
    }

    public String getQuest() {
        return quest;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getCorrect() {
        return correct;
    }
}

public class QuizzesActivity extends AppCompatActivity {

    List<Question> repo;
    TextView questionTextView;
    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button startButton;
    Question currentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizzes);

        questionTextView = findViewById(R.id.questionText);
        buttonA = findViewById(R.id.answerA);
        buttonB = findViewById(R.id.answerB);
        buttonC = findViewById(R.id.answerC);
        startButton = findViewById(R.id.startButton);

        repo = new ArrayList<>();
        repo.add(new Question("What is the bulgarian currency?", "Bulgarian dollar", "Franc", "Leva", "c"));
        repo.add(new Question("Who invented the light bulb?", "Thomas Edison", "Nicola Tesla", "Petrache Poenaru", "a"));
        repo.add(new Question("What river runs through Bucharest?", "Dunarea", "Siret", "Dambovita", "c"));
        repo.add(new Question("What's the capital of Iceland?", "Iceland", "Oslo", "Reyjavik", "c"));
        repo.add(new Question("How many states are in USA?", "55", "45", "50", "c"));
        repo.add(new Question("What's the capital of England?", "Rusia", "London", "Chisinau", "b"));
        repo.add(new Question("Where was Adolf Hitler Born?", "Austria", "Germania", "Polonia", "a"));
        repo.add(new Question("When did the second world (WWII) end?", "1944", "1945", "1946", "b"));
        repo.add(new Question("How long was the 100 years war?", "100 years", "96 years", "116 years", "c"));
        repo.add(new Question("How much is 2+2-1 ?", "3 quick maths", "5", "4", "a"));

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstGame();
            }
        });

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluateAnswer("a");
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluateAnswer("b");
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                evaluateAnswer("c");
            }
        });

    }

    public void evaluateAnswer(String ans){
        if (currentQuestion.getCorrect().equals(ans)){
            buttonA.setBackgroundResource(R.drawable.background_green);
            buttonB.setBackgroundResource(R.drawable.background_green);
            buttonC.setBackgroundResource(R.drawable.background_green);
        }
        else {
            buttonA.setBackgroundResource(R.drawable.background_red);
            buttonB.setBackgroundResource(R.drawable.background_red);
            buttonC.setBackgroundResource(R.drawable.background_red);
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                resetButtons();
                newGame();
            }
        }, 1000);
    }

    public void resetButtons(){
        buttonA.setBackgroundResource(0);
        buttonB.setBackgroundResource(0);
        buttonC.setBackgroundResource(0);
    }

    public void firstGame(){
        startButton.setAlpha(0);
        startButton.setEnabled(false);
        buttonA.setAlpha(1);
        buttonB.setAlpha(1);
        buttonC.setAlpha(1);
        resetButtons();
        newGame();
    }

    public void newGame(){
        currentQuestion = getRandomQuestion();
        questionTextView.setText(currentQuestion.getQuest());
        buttonA.setText(currentQuestion.getA());
        buttonB.setText(currentQuestion.getB());
        buttonC.setText(currentQuestion.getC());
    }

    public Question getRandomQuestion(){
        Random r = new Random();
        Integer integ = r.nextInt((10));
        return repo.get(integ);
    }
}
