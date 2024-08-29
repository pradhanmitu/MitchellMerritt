package Mitchelmeritt;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> nodes = Inputprocessing.input();
        for (Node node : nodes) {
            // Node deletion is handled by garbage collector in Java
        }
    }
}
