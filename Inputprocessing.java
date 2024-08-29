package Mitchelmeritt;

import java.io.*;
import java.util.*;

public class Inputprocessing {
    public static int Nodes;

    public static List<Node> input() {
        List<Node> array = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Adnan\\eclipse-workspace\\Assignment6\\src\\Input.txt"))) {
            String line = br.readLine();
            if (line != null) {
                Nodes = Integer.parseInt(line);
                for (int i = 0; i < Nodes; i++) {
                    Node node = new Node(i, i + 1, i + 1);
                    array.add(node);
                    System.out.println(node.toString() + " added successfully!");
                }
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\\s+");
                    if (parts.length < 2) break;
                    int id1 = Integer.parseInt(parts[0]);
                    int id2 = Integer.parseInt(parts[1]);
                    try {
                        array.get(id1).post = array.get(id2);
                        array.get(id2).pre = array.get(id1);
                        System.out.println("\n\nNode " + id1 + " is requesting to Node " + id2);
                        afterRequest(array.get(id1));
                        for (Node node : array) {
                            System.out.println(node.toString());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static void afterRequest(Node n) {
        // Request has been generated, block transmit detection check will occur here
        if (n.post != null) {
            n.u = Math.max(n.u, n.post.u) + 1;
            n.v = n.u;
        }

        Node m = n;
        while (true) {
            if (m.pre != null) {
                if (m.u > m.pre.u) {
                    m.pre.u = m.u;
                    m = m.pre;
                } else if (m.u < m.pre.u) {
                    break;
                } else if (m.u == m.pre.u && m.u == m.pre.v) {
                    System.out.println("Deadlock detected!");
                    break;
                }
            } else {
                break;
            }
        }
    }
}
