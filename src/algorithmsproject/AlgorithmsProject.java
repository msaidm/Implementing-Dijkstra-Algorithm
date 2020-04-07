package algorithmsproject;
import java.util.ArrayList;

public class AlgorithmsProject
{
    public static void main(String[] args) 
    {
        ArrayList<Node> nodes = new ArrayList();
        Graph G = new Graph(nodes);
        for(int i=0 ; i < 9 ; i++)
        {
            Node n = new Node(0,0,i);
            nodes.add(n);
        }
        
        G.connect(G.getNode(0), G.getNode(1), 4);
        G.connect(G.getNode(0), G.getNode(7), 8);
        G.connect(G.getNode(1), G.getNode(7), 11);
        G.connect(G.getNode(7), G.getNode(8), 7);
        G.connect(G.getNode(1), G.getNode(2), 8);
        G.connect(G.getNode(2), G.getNode(8), 2);
        G.connect(G.getNode(6), G.getNode(8), 6);
        G.connect(G.getNode(6), G.getNode(7), 1);
        G.connect(G.getNode(2), G.getNode(5), 4);
        G.connect(G.getNode(2), G.getNode(3), 7);
        G.connect(G.getNode(6), G.getNode(5), 2);
        G.connect(G.getNode(3), G.getNode(5), 14);
        G.connect(G.getNode(4), G.getNode(5), 10);
        G.connect(G.getNode(3), G.getNode(4), 9);

        Graph shortestPath = Dijkstra.shortestPath(G, G.getNodes().get(0));
        shortestPath.print();
    }
}


