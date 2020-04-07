package algorithmsproject;
import java.util.ArrayList;

public class Graph 
{
    private final ArrayList<Node> Nodes;
    
    public Graph(ArrayList<Node> Nodes)
    {
        this.Nodes = Nodes;
    }
    
    public void connect(Node n1, Node n2, double weight)
    {
        n1.getAdjacentNodes().add(n2);
        n2.getAdjacentNodes().add(n1);
        n1.getAdjacentDistances().add(weight);
        n2.getAdjacentDistances().add(weight);
    }
    
    public ArrayList<Node> getNodes(){return Nodes;}
    
    public void print()
    {
        for(int i=0 ; i < Nodes.size() ; i++)
        {
            Node n = Nodes.get(i);
            ArrayList<Node> Adj = n.getAdjacentNodes();
            System.out.println("ID: "+n.getID()+" X: "+n.getX()+" Y: "+n.getY());
            for(int j=0 ; j < n.getAdjacentNodes().size() ; j++)
            {
                Node n2 = Adj.get(j);
                System.out.println("    ID: "+n2.getID()+" X: "+n2.getX()+" Y: "+n2.getY()+" Distance: "+n2.getDistance(n));
            }
            
            System.out.println("---------------------------------------------------");
        }
    }
        
    public int getNodeCount(){return Nodes.size();}
    public Node getNode(int ID)
    {
        for(int i=0; i < Nodes.size(); i++)
            if(Nodes.get(i).getID() == ID)
                return Nodes.get(i);
        
        return null;
    }
}
