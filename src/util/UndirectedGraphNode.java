package util;

import java.util.ArrayList;

public class UndirectedGraphNode {
    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
