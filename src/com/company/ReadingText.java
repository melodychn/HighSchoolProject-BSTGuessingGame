package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ReadingText {

    public BTNode root;
    private ArrayList<String> words;
    private int k;

    public ReadingText() throws FileNotFoundException{
        words = new ArrayList<String>();
        k =1;
        createNode();
    }

    public BTNode getRoot()
    {
        return root;
    }

    private void createNode(){
        Scanner in = null;
        File file = new File("test.txt");
        try {
            in = new Scanner(file);
            while (in.hasNextLine()) {
                words.add(in.nextLine());
            }
            root = new BTNode(words.get(0), null, null);
            createN(root);
            in.close();
        } catch (FileNotFoundException ex) { //cannot find the file
            ex.printStackTrace();
        }
    }

    private void createN(BTNode node)
    {
        createLeft(node);
        createR(node.left);
        createRight(node);
        createR(node.right);
    }

    //RECURSION HELPER FUNCTION
    private void createR(BTNode node)
    {
        if(node == null){
            return;
        }
        createR(node.left);
        createRight(node);
        if(node.right!=null){
            createR(node.right);
        }
    }

    private void createLeft(BTNode node)
    {

        if(!((k>= 0)&&(k<words.size()))||words.get(k).equals("null")){
            k++;
            return;
        }
        node.left = new BTNode(words.get(k), null, null);
        k++;
        createLeft(node.left);


    }

    private void createRight(BTNode node)
    {
        if(!((k>= 0)&&(k<words.size()))||words.get(k).equals("null")){
            k++;
            return;
        }
        node.right = new BTNode(words.get(k), null, null);
        k++;
        createLeft(node.right);
    }

    //use for debugging
    public void printTree(BTNode node)
    {
        if(node == null){
            return;
        }
        printTree(node.left);
        printTree(node.right);
        node.print();
    }

}

