package com.company;

import java.util.Formatter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
public class FormattingText{

    BTNode updated;
    ArrayList<String> strings;

    public FormattingText(BTNode root)
    {
        updated = root;
        strings = new ArrayList<String>();
    }

    public void format() throws IOException{
        fill(updated);
        Formatter out = null;
        try {
            out = new Formatter("test.txt");
            String data = null;
            for(int k=0; k<strings.size();k++){
                data= strings.get(k);
                out.format("%s%n",data);
            }
            out.flush();
        } catch (IOException e ) {
            System.out.println ("Error with the file");
        } finally {
            if (out!= null) {
                out.close();
            }
        }
    }

    //put it in to arraylist in preorder
    public void fill(BTNode node)
    {
        if(node == null){
            strings.add("null");
            return;
        }
        strings.add(node.data);
        fill(node.left);
        fill(node.right);
    }

}
