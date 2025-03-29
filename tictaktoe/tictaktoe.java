package tictaktoe;

import java.awt.*;
import java.awt.event.*;

public class tictaktoe extends Frame implements ActionListener {
    Button[] b =new Button[9];
    Button b1;
    int a=0;
    int z=0,z1=0,z2=0,z3=0,z4=0,z5=0,z6=0,z7=0,z8=0;
    int k=0,x=8,y=28;
    int l = 70;
    boolean gameOver = false;

    tictaktoe(){
        this.setVisible(true);
        this.setLayout(null);
        this.setSize(800,600);
        this.setLocation(350,100);
        this.setBackground(Color.white);
        this.setForeground(Color.BLACK);
        b1=new Button();
        b1.setLabel("New game");
        b1.setSize(250,50);
        b1.setLocation(30,350);
        b1.setBackground(new Color(97, 218, 16, 216));
        b1.addActionListener(this);
        this.add(b1);
        for(int i=1;i<=3;i++){
            for(int j=1;j<=3;j++){
                b[k]=new Button();
                b[k].setSize(100,100);
                b[k].setLocation(x,y);
                b[k].setFont(new Font("Consolas",Font.BOLD,40));
                b[k].setBackground(new Color(28, 255, 255, 255));
                b[k].setForeground(Color.BLACK);
                this.add(b[k]);
                b[k].addActionListener(this);
                k++;
                x=x+100;
            }
            x=8;
            y=y+100;
        }
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            for (int i = 0; i <= 8; i++) {
                b[i].setLabel("");
                z = 0;
                z1 = 0;
                z2 = 0;
                z3 = 0;
                z4 = 0;
                z5 = 0;
                z6 = 0;
                z7 = 0;
                z8 = 0;
                a = 0;
                gameOver = false;
            }
        }
        if(gameOver)
            return;
        if (e.getSource() == b[0] && z == 0) {
            if (a % 2 == 0) {
                b[0].setLabel("O");
                a++;
                z++;
            } else {
                b[0].setLabel("X");
                a++;
                z++;
            }
        }
        if (e.getSource() == b[1] && z1 == 0) {
            if (a % 2 == 0) {
                b[1].setLabel("O");
                a++;
                z1++;
            } else {
                b[1].setLabel("X");
                a++;
                z1++;
            }
        }
        if (e.getSource() == b[2] && z2 == 0) {
            if (a % 2 == 0) {
                b[2].setLabel("O");
                a++;
                z2++;
            } else {
                b[2].setLabel("X");
                a++;
                z2++;
            }
        }
        if (e.getSource() == b[3] && z3 == 0) {
            if (a % 2 == 0) {
                b[3].setLabel("O");
                a++;
                z3++;
            } else {
                b[3].setLabel("X");
                a++;
                z3++;
            }
        }
        if (e.getSource() == b[4] && z4 == 0) {
            if (a % 2 == 0) {
                b[4].setLabel("O");
                a++;
                z4++;
            } else {
                b[4].setLabel("X");
                a++;
                z4++;
            }
        }
        if (e.getSource() == b[5] && z5 == 0) {
            if (a % 2 == 0) {
                b[5].setLabel("O");
                a++;
                z5++;
            } else {
                b[5].setLabel("X");
                a++;
                z5++;
            }
        }
        if (e.getSource() == b[6] && z6 == 0) {
            if (a % 2 == 0) {
                b[6].setLabel("O");
                a++;
                z6++;
            } else {
                b[6].setLabel("X");
                a++;
                z6++;
            }
        }
        if (e.getSource() == b[7] && z7 == 0) {
            if (a % 2 == 0) {
                b[7].setLabel("O");
                a++;
                z7++;
            } else {
                b[7].setLabel("X");
                a++;
                z7++;
            }
        }
        if (e.getSource() == b[8] && z8 == 0) {
            if (a % 2 == 0) {
                b[8].setLabel("O");
                a++;
                z8++;
            } else {
                b[8].setLabel("X");
                a++;
                z8++;
            }
        }
        Font f = new Font("", Font.BOLD, 20);


           if (b[0].getLabel() == b[1].getLabel() && b[0].getLabel() == b[2].getLabel()) {

            if (b[0].getLabel() == "O") {

                Label p1 = new Label("Player 1 wins");
                p1.setSize(150, 50);
                p1.setLocation(320, l);
                p1.setFont(f);
                add(p1);
                l += 50;
                gameOver=true;
            }

            if (b[0].getLabel() == "X") {

                Label p1 = new Label("Player 2 wins");
                p1.setSize(150, 50);
                p1.setLocation(320, l);
                p1.setFont(f);
                add(p1);
                l += 50;
                gameOver=true;
            }
        }
         if (b[3].getLabel() == b[4].getLabel() && b[3].getLabel() == b[5].getLabel()) {

            if (b[3].getLabel() == "O") {

                Label p1 = new Label("Player 1 wins");
                p1.setSize(150, 50);
                p1.setLocation(320, l);
                p1.setFont(f);
                add(p1);
                l += 50;
                gameOver=true;
            }

            if (b[3].getLabel() == "X") {

                Label p1 = new Label("Player 2 wins");
                p1.setSize(150, 50);
                p1.setLocation(320, l);
                p1.setFont(f);
                add(p1);
                l += 50;
                gameOver=true;
            }
        }
         if (b[6].getLabel() == b[7].getLabel() && b[6].getLabel() == b[8].getLabel()) {

            if (b[6].getLabel() == "O") {

                Label p1 = new Label("Player 1 wins");
                p1.setSize(150, 50);
                p1.setLocation(320, l);
                p1.setFont(f);
                add(p1);
                l += 50;
                gameOver=true;
            }

            if (b[6].getLabel() == "X") {

                Label p1 = new Label("Player 2 wins");
                p1.setSize(150, 50);
                p1.setLocation(320, l);
                p1.setFont(f);
                add(p1);
                l += 50;
                gameOver=true;
            }
        }
         if (b[0].getLabel() == b[3].getLabel() && b[0].getLabel() == b[6].getLabel()) {

            if (b[0].getLabel() == "O") {

                Label p1 = new Label("Player 1 wins");
                p1.setSize(150, 50);
                p1.setLocation(320, l);
                p1.setFont(f);
                add(p1);
                l += 50;
                gameOver=true;
            }

            if (b[0].getLabel() == "X") {

                Label p1 = new Label("Player 2 wins");
                p1.setSize(150, 50);
                p1.setLocation(320, l);
                p1.setFont(f);
                add(p1);
                l += 50;
                gameOver=true;
            }
        }
        if (b[1].getLabel() == b[4].getLabel() && b[1].getLabel() == b[7].getLabel()) {

            if (b[1].getLabel() == "O") {

                Label p1 = new Label("Player 1 wins");
                p1.setSize(150, 50);
                p1.setLocation(320, l);
                p1.setFont(f);
                add(p1);
                l += 50;
                gameOver=true;
            }

            if (b[1].getLabel() == "X") {

                Label p1 = new Label("Player 2 wins");
                p1.setSize(150, 50);
                p1.setLocation(320, l);
                p1.setFont(f);
                add(p1);
                l += 50;
                gameOver=true;
            }
        }
        if (b[2].getLabel() == b[5].getLabel() && b[2].getLabel() == b[8].getLabel()) {

            if (b[2].getLabel() == "O") {

                Label p1 = new Label("Player 1 wins");
                p1.setSize(150, 50);
                p1.setLocation(320, l);
                p1.setFont(f);
                add(p1);
                l += 50;
                gameOver = true;
            }

            if (b[2].getLabel() == "X") {

                Label p1 = new Label("Player 2 wins");
                p1.setSize(150, 50);
                p1.setLocation(320, l);
                p1.setFont(f);
                add(p1);
                l += 50;
                gameOver = true;
            }
        }
          if (b[0].getLabel() == b[4].getLabel() && b[0].getLabel() == b[8].getLabel()) {

            if (b[0].getLabel() == "O") {

                Label p1 = new Label("Player 1 wins");
                p1.setSize(150, 50);
                p1.setLocation(320, l);
                p1.setFont(f);
                add(p1);
                l += 50;
                gameOver=true;
            }

            if (b[0].getLabel() == "X") {

                Label p1 = new Label("Player 2 wins");
                p1.setSize(150, 50);
                p1.setLocation(320, l);
                p1.setFont(f);
                add(p1);
                l += 50;
                gameOver=true;
            }
        }
         if (b[2].getLabel() == b[4].getLabel() && b[2].getLabel() == b[6].getLabel()) {

            if (b[2].getLabel() == "O") {

                Label p1 = new Label("Player 1 wins");
                p1.setSize(150, 50);
                p1.setLocation(320, l);
                p1.setFont(f);
                add(p1);
                l += 50;
                gameOver=true;
            }

            if (b[2].getLabel() == "X") {

                Label p1 = new Label("Player 2 wins");
                p1.setSize(150, 50);
                p1.setLocation(320, l);
                p1.setFont(f);
                add(p1);
                l += 50;
                gameOver=true;
            }



        }
    }



    public static void main(String[] args) {
        tictaktoe t= new tictaktoe();
    }
}
