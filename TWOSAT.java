import com.example.tarjanalgorithm.GRAPH;

import java.io.*;
import java.util.*;

public class TWOSAT {
    public static void main(String[] args) {
        String path = args[0];
        try {
            // create graph from file
            GRAPH graph = new GRAPH();
            // run Tarjan's strongly connected components algorithm
            graph.Tarjan();
            // check for satisfiability
            if(graph.satisfiable()) {
                System.out.println("FORMULA SATISFIABLE");
                // solve
                Map<Integer, Boolean> solution = graph.solve();
                // print solution
                for(int i = 1; i <= solution.size(); i++) {
                    Boolean value = solution.get(i);
                    if(value) {
                        System.out.print('1');
                    } else {
                        System.out.print('0');
                    }
                    // print a space to separate values
                    if(i != solution.size()) {
                        System.out.print(' ');
                    }
                }
                System.out.println("");
            } else {
                System.out.println("FORMULA UNSATISFIABLE");
            }
        } catch(InvalidInputException e) {
        } catch(IOException e) {
            System.out.println("Unexpected IOException");
        }
    }
}
