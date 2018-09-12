package HangmanUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Random;

public class Hangman {

    private String goal;
    private char[] subGoal;
    private ArrayList<String> goalMemo = new ArrayList<>();
    protected Vocab hang = new Vocab();
    protected String toShow = "";
    protected ArrayList <String> insertUnder = new ArrayList<>();
    private int countFalse = 1;
    private int countHint = 0;


    @FXML
    protected TextField input,textHint,errorScreen;
    @FXML
    protected Button enterInput,resetButton,hintButton;
    @FXML
    protected Label showOutput,head,body,leftHand,rightHand,leftLeg,rightLeg;



    public void initialize() {
        this.goal = hang.random();
        subGoal = goal.toCharArray();
        for (int i = 0; i < subGoal.length ; i++) {
            toShow += "_" +" ";
            goalMemo.add("_");
        }
        showOutput.setText(toShow);
        System.out.println(subGoal);
    }

    @FXML
    public void handleInput(ActionEvent e){
        enterInput = (Button) e.getSource();
        if (e.getSource().equals(enterInput)){
            if (input.getText().length() == 1 ){
                compareLetter(input.getText().charAt(0));
                errorScreen.setText("");
            }else{
                errorScreen.setText("Please input 1 character ");
                System.out.println("please input 1 character");
            }
            input.clear();
        }
        if (e.getSource().equals(resetButton)){
            restartGame();
        }
        if (e.getSource().equals(hintButton)) {
            hint();
        }
    }

    public void compareLetter(char input){
        boolean isCorrect = false;
        //check
        for (int i = 0; i < subGoal.length ; i++) {
            if (input == (subGoal[i])){
                goalMemo.set(i,String.valueOf(input));
                isCorrect = true;
            }
        }
        //print
        if(isCorrect){
            String showGoal = "";
            for (int i = 0; i < goalMemo.size(); i++) {
                System.out.println(goalMemo.get(i));
                showGoal += goalMemo.get(i) + " ";
            }
            showOutput.setText(showGoal);
        }else{
            //case false

            if (countFalse == 1) {
                head.setText("O");
            } if (countFalse == 2) {
                body.setText("|");
            } if (countFalse ==  3) {
                leftHand.setText("/");
            } if (countFalse == 4) {
                rightHand.setText("\\");
            } if (countFalse == 5) {
                leftLeg.setText("/");
            } if (countFalse == 6) {
                rightLeg.setText("\\");
            }


            System.out.println("fail");
            countFalse += 1;
            if (countFalse > 6){
                gameOver();
                enterInput.setDisable(true);


            }
        }

    }

    public void gameOver(){

        showOutput.setText("GAME OVER");

    }

    public void hint(){
        if (countHint < 2){
            ArrayList<String> avaliableHint = new ArrayList<>();
            for (int i = 0; i<= subGoal.length; i++){
                if (subGoal[i] != goalMemo.get(i).charAt(0)){

                    avaliableHint.add(String.valueOf(subGoal[i]));
                    textHint.setText(String.valueOf(avaliableHint));
                    errorScreen.setText("");
                }
            }
            countHint ++;
        }
    }

    public void restartGame() {
        enterInput.setDisable(false);
        showOutput.setText("");
        errorScreen.setText("");
        head.setText("");
        body.setText("");
        leftHand.setText("");
        rightHand.setText("");
        leftLeg.setText("");
        rightLeg.setText("");
        textHint.setText("");
        initialize();
    }







}
