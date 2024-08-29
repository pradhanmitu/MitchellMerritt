package Mitchelmeritt;

public class Node {
    int id, u, v;
    Node pre = null;
    Node post = null;

    public Node(int id, int u, int v) {
        this.id = id;
        this.u = u;
        this.v = v;
    }

    public String toString() {
        return "[Node " + id + ": " + u + " / " + v + "]";
    }
}

