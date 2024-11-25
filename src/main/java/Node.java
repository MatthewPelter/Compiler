import java.util.*;

public class Node {
    String data;
    Vector<Node> children;

    public Node(String data) {
        this.data = data;
        this.children = new Vector<Node>();
    }
}