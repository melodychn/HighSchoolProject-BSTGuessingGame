package com.company;

public class BTNode
{
    public String data;
    public BTNode right, left;

    public BTNode(String alphabet, BTNode r, BTNode l){
        data = alphabet;
        right = r;
        left = l;
    }

    public void print(){
        System.out.print(data);
    }

    public void replace(String word)
    {
        data = word;

    }
}