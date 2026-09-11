import tasks.Task19;
import tasks.Task7;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;

//        out.print("Task 7\n");
//        Task7.run(in, out);
        out.print("Task 19\n");
        Task19.run(in, out);

        in.close();
    }
}
