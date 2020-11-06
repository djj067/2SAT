package com.example.graph

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.lang.Math;


public class GRAPH {
    LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();//the main list

    String encoding="UTF-8";
    private String filePath;
    File file=new File(filePath);

            if(file.isFile() && file.exists()) { //judge whether the file exist
        InputStreamReader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(file),encoding);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(reader);
        String lineText = null;
        LinkedList<Integer> sublist = new LinkedList<Integer>();
        while(true){
            try {
                if (!((lineText = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (lineText.charAt(0)=='c') {
                continue;
            } else if (lineText.charAt(0)=='p') {
                String[] lineTextArray = lineText.split(" ");
                Integer variables = Integer.valueOf(lineTextArray[2]);
                Integer clauses = Integer.valueOf(lineTextArray[3]);
            } else {
                String[] lineTextArray = lineText.split(" ");
                for (String s: lineTextArray) {
                    if (s.equals("0")) {
                        list.add(sublist);
                        sublist = new LinkedList<Integer>();
                    } else {
                        sublist.add(Integer.valueOf(s));
                    }
                }
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }
