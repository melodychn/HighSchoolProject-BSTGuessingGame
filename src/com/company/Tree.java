package com.company;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
public class Tree
{
    private BTNode root;
    private String learn;
    private Scanner keyboard;

    public Tree() throws FileNotFoundException
    {
        keyboard = new Scanner(System.in);
        ReadingText node = new ReadingText();
        learn = "What makes it different?";
        root = node.getRoot();
    }

    private String oneTurn(BTNode node)
    {
        //prints out the question
        System.out.print("Is it ");
        node.print();
        System.out.println("?(y/n)");
        return keyboard.next();
    }

    private void learn(BTNode node)throws IOException
    {

        //set answer as replacement for node aka one piece
        System.out.println(learn);
        keyboard.nextLine();
        String response = keyboard.nextLine();
        node.right = new BTNode(node.data, null, null);
        node.replace(response);
        System.out.println("What are you thinking of?");
        String response2 = keyboard.nextLine();
        node.left = new BTNode(response2, null, null);
        FormattingText print = new FormattingText(root);
        print.format();
    }

    public void play() throws IOException
    {
        System.out.println("Think of a manga/anime!");

        play(root);
        System.out.println("Want to try again?(y/n)");
        String ans = keyboard.next();
        if(ans.equals("y"))play();
    }

    public void play(BTNode node) throws IOException
    {
        if(oneTurn(node).equals("y")){
            if(node.left ==null){ //end
                return;
            }
            play(node.left);
        }else{
            if(node.right ==null){
                learn(node);
                return;
            }
            play(node.right);
        }
    }

    private void printTree(BTNode node)
    {
        if(node == null){
            return;
        }
        printTree(node.left);
        printTree(node.right);
        node.print();
    }
}
