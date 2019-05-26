package com.company;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Tree bob = new Tree(); //command line version
        //Tree_GUI bob = new Tree_GUI(); //GUI version, comment out to try
        bob.play();
    }
}
