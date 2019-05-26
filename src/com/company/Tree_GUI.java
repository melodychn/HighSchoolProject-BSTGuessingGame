package com.company;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

//GUI VERSION OF GAME, better interface
public class Tree_GUI {
    private BTNode root;
    private String learn;

    public Tree_GUI() throws FileNotFoundException
    {
        ReadingText node = new ReadingText();
        learn = "What makes it different?";
        root = node.getRoot();
    }

    private int oneTurn(BTNode node)
    {
        int choice = JOptionPane.showConfirmDialog(null,"Is it "+node.data+"?","Anime/Manga",
                JOptionPane.YES_NO_OPTION);
        return choice;
    }

    private void learn(BTNode node)throws IOException
    {
        String response = JOptionPane.showInputDialog(null, learn);
        node.right = new BTNode(node.data, null, null);
        node.replace(response);
        String response2 = JOptionPane.showInputDialog(null, "What are you thinking of?");
        node.left = new BTNode(response2, null, null);
        FormattingText print = new FormattingText(root);
        print.format();
    }

    public void play() throws IOException
    {
        myShowMessage("Think of a manga/anime and I will guess it :)");
        play(root);
        int ans = JOptionPane.showConfirmDialog(null,"Want to try again?","Anime/Manga",
                JOptionPane.YES_NO_OPTION);
        if(ans==JOptionPane.YES_OPTION)play();
    }

    public void play(BTNode node) throws IOException
    {
        if(oneTurn(node)==JOptionPane.YES_OPTION){
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

    public void printTree(BTNode node)
    {
        if(node == null){
            return;
        }
        printTree(node.left);
        printTree(node.right);
        node.print();
    }

    public static void myShowMessage(String s) {
        if(s == null || "".equals(s)) {
            System.out.println("AHA!  gotcha ...");
        }
        JOptionPane.showMessageDialog(null, s);
    }
}
