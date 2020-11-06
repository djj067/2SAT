package com.example.tarjanalgorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class Tarjan {
    GRAPH graph = new GRAPH();
    private List< ArrayList<Integer> > result;
    private boolean[] inStack;
    private Stack<Integer> stack;
    private int[] dfn;
    private int[] low;
    private int time;

    public Tarjan(List< ArrayList<Integer> > graph, int numofnode){

        this.numofnode = numofnode;
        this.inStack = new boolean[numofnode];
        this.stack = new Stack<Integer>();
        dfn = new int[numofnode];
        low = new int[numofnode];
        Arrays.fill(dfn, -1);
        Arrays.fill(low, -1);
        result = new ArrayList<ArrayList<Integer>>();
    }

    public List< ArrayList<Integer> > run(){
        for(int i=0;i<numofnode;i++){
            if(dfn[i] == -1){
                tarjan(i);
            }
        }
        return result;
    }


    public void tarjan(int current){
        dfn[current] = low[current] = time++;
        inStack[current] = true;
        stack.push(current);

        for(int i=0; i<graph.get(current).size(); i++){
            int next = graph.get(current).get(i);
            if(dfn[next] == -1){
                tarjan(next);
                low[current]=Math.min(low[current], low[next]);
            }else if(inStack[next]){
                low[current]=Math.min(low[current], dfn[next]);
            }
        }

        if(low[current] == dfn[current]){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int j = -1;
            while(current!=j){
                j = stack.pop();
                inStack[j] = false;
                temp.add(j);
            }
            result.add(temp);
        }
    }




    public static void main(String[] args) {


        List< ArrayList<Integer> > graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<numofnode; i++){
            graph.add(new ArrayList<Integer>());
        }

        Tarjan t = new Tarjan(graph, numofnode);
        List< ArrayList<Integer> > result = t.run();


        for(int i=0; i<result.size(); i++){
            for(int j=0; j<result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}
