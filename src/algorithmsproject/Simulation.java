package algorithmsproject;

import java.util.ArrayList;

public class Simulation 
{ 
    ArrayList<Node> Nodes;
    Graph G;
    
    public Simulation()
    {
        Nodes = new ArrayList();
        G = new Graph(Nodes);
    }
    public int randValue(int from, int to){return (int) (Math.random() * (to - from)) + from;}
    public double calculateDistance(Node n1, Node n2)
    {
        int x1 = n1.getX();
        int y1 = n1.getY();
        
        int x2 = n2.getX();
        int y2 = n2.getY();
        
        double distance = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1), 2));
        return distance;
    }
    
    public void generateNodes(int number)
    {
        for(int i=0 ; i < number ; i++)
        {
            int randX = randValue(0,100);
            int randY = randValue(0,100);
            Node n = new Node(randX,randY, i);
            Nodes.add(n);
        }     
    }
    
    public void generateGraph()
    { 
        for(int i=0; i < Nodes.size()-1 ; i++)
            for(int j=i+1 ; j < Nodes.size() ; j++)
            {
                double distance = calculateDistance(Nodes.get(i), Nodes.get(j));
                if(distance <= 20)
                   G.connect(Nodes.get(i), Nodes.get(j), distance);
            }
    }
}


