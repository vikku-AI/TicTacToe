package ticktack;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class TickTacToe implements ActionListener{
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] button = new JButton[9];
    boolean player1_turn;

    JButton resetButton = new JButton();
    JButton closeButton = new JButton();
    JButton letButton = new JButton();
    boolean check_allbuttonfull = false;
    int j =0;
//    boolean draw_check = true;
    boolean x_owincall = true;
//    boolean isPlayer2_turn;

    TickTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);


        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(4,3));
        button_panel.setBackground(new Color(150, 150,150));
        for(int i =0; i<9; i++){
            button[i] = new JButton();
            button_panel.add(button[i]);
            button[i].setFont(new Font("MV-Boli", Font.BOLD, 120));
            button[i].setFocusable(false);
            button[i].addActionListener(this);
        }
        resetButton.setFont(new Font("MV-Boli", Font.BOLD, 20));
        resetButton.setFocusable(false);
        resetButton.setText("Reset");
        resetButton.addActionListener(this);

        closeButton.setFont(new Font("MV-Boli", Font.BOLD, 20));
        closeButton.setFocusable(false);
        closeButton.setText("Close");
        closeButton.addActionListener(this);

        letButton.setFont(new Font("MV-Boli", Font.BOLD, 20));
        letButton.setFocusable(false);
        letButton.setText("Play");
        letButton.addActionListener(this);

        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        button_panel.add(resetButton);
        button_panel.add(closeButton);
        button_panel.add(letButton);
        button_panel.add(closeButton);
        frame.add(button_panel);


        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resetButton){
            TickTacToe tiktactoe = new TickTacToe();
        }
        if(e.getSource() == closeButton){
            JFrame frame_new = new JFrame("EXIT");
            if(JOptionPane.showConfirmDialog(frame_new,"Confirm if you want Exit", "EXIT",
                    JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.YES_NO_OPTION)
                System.exit(0);

        }
        if(e.getSource() == letButton) {
            if (letButton.getText() == "Play") {
                letButton.setForeground(new Color(255, 0, 0));
                letButton.setText("Game On");
            }
        }
        if(letButton.getText() == "Game On"){
//            int j = 8;
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == button[i]) {
                    if (player1_turn) {
                        if (button[i].getText() == "") {
                            button[i].setForeground(new Color(255, 0, 0));
                            button[i].setText("X");
                            player1_turn = false;
                            textfield.setText("O turn");
                            check();
                            j++;
                        }
                    } else {
                        if (button[i].getText() == "") {
                            button[i].setForeground(new Color(0, 0, 255));
                            button[i].setText("O");
                            player1_turn = true;
                            textfield.setText("X turn");
                            check();
                            j++;
                        }
                    }
                }

//                if(j==i){
//                    check_allbuttonfull = true;
//                }
//                j++;
            }
        }
    }

    public void firstTurn(){
        if(letButton.getText()=="Game On") {
//            Thread.sleep(100);

            if (random.nextInt(2) == 0) {
                player1_turn = true;
                textfield.setText("X turn");
            } else {
                player1_turn = false;
                textfield.setText("O turn");
            }
        }
    }


    public void check(){

        if((button[0].getText()=="X") &&
                        (button[1].getText()=="X") &&
                        (button[2].getText()=="X")){
            xWins(0,1,2);
//            draw_check = false;
        }
        if((button[3].getText()=="X") &&
                (button[4].getText()=="X") &&
                (button[5].getText()=="X")){
            xWins(3,4,5);
//            draw_check = false;
        }
        if((button[6].getText()=="X") &&
                (button[7].getText()=="X") &&
                (button[8].getText()=="X")){
            xWins(6,7,8);
//            draw_check = false;
        }
        if((button[0].getText()=="X") &&
                (button[3].getText()=="X") &&
                (button[6].getText()=="X")){
            xWins(0,3,6);
//            draw_check = false;
        }
        if((button[1].getText()=="X") &&
                (button[4].getText()=="X") &&
                (button[7].getText()=="X")){
            xWins(1,4,7);
//            draw_check = false;
        }
        if((button[2].getText()=="X") &&
                (button[5].getText()=="X") &&
                (button[8].getText()=="X")){
            xWins(2,5,8);
//            draw_check = false;
        }
        if((button[0].getText()=="X") &&
                (button[4].getText()=="X") &&
                (button[8].getText()=="X")){
            xWins(0,4,8);
//            draw_check = false;
        }
        if((button[2].getText()=="X") &&
                (button[4].getText()=="X") &&
                (button[6].getText()=="X")){
            xWins(2,4,6);
//            draw_check = false;
        }

        //for o win
        if((button[0].getText()=="O") &&
                (button[1].getText()=="O") &&
                (button[2].getText()=="O")){
            oWins(0,1,2);
//            draw_check = false;
        }
        if((button[3].getText()=="O") &&
                (button[4].getText()=="O") &&
                (button[5].getText()=="O")){
            oWins(3,4,5);
//            draw_check = false;
        }
        if((button[6].getText()=="O") &&
                (button[7].getText()=="O") &&
                (button[8].getText()=="O")){
            oWins(6,7,8);
//            draw_check = false;
        }
        if((button[0].getText()=="O") &&
                (button[3].getText()=="O") &&
                (button[6].getText()=="O")){
            oWins(0,3,6);
//            draw_check = false;
        }
        if((button[1].getText()=="O") &&
                (button[4].getText()=="O") &&
                (button[7].getText()=="O")){
            oWins(1,4,7);
//            draw_check = false;
        }
        if((button[2].getText()=="O") &&
                (button[5].getText()=="O") &&
                (button[8].getText()=="O")){
            oWins(2,5,8);
//            draw_check = false;
        }
        if((button[0].getText()=="O") &&
                (button[4].getText()=="O") &&
                (button[8].getText()=="O")){
            oWins(0,4,8);
//            draw_check = false;
        }
        if((button[2].getText()=="O") &&
                (button[4].getText()=="O") &&
                (button[6].getText()=="O")){
            oWins(2,4,6);
//            draw_check = false;

        }
        if((j==8) && x_owincall){
            NoWins();
        }


    }

    public void xWins(int a, int b, int c){
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
        x_owincall = false;
        for(int i =0; i<9; i++){
            button[i].setEnabled(false);
        }

        textfield.setText("X Wins");
        letButton.setText("Game Over");

    }
    public void oWins(int a, int b, int c){
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
        x_owincall = false;
        for(int i =0; i<9; i++){
            button[i].setEnabled(false);
        }

        textfield.setText("O Wins");
        letButton.setText("Game Over");

    }

    public void NoWins(){

        for(int i =0; i<9; i++){
            button[i].setEnabled(false);
        }
        textfield.setText("Draw");
        letButton.setText("Game Over");

    }



}
