import com.example.tarjanalgorithm.GRAPH;

import java.io.*;
import java.util.*;

public class TWOSAT {
    public static void main(String[] args) {
        String path = args[0];
        try {
            GRAPH graph = new GRAPH();
            graph.Tarjan();
            if(graph.satisfiable()) {
                System.out.println("FORMULA SATISFIABLE");
                Map<Integer, Boolean> solution = graph.solve();
                for(int i = 1; i <= solution.size(); i++) {
                    Boolean value = solution.get(i);
                    if(value) {
                        System.out.print('1');
                    } else {
                        System.out.print('0');
                    }

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
