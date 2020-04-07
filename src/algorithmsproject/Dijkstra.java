package algorithmsproject;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class Dijkstra
{
    public static Graph shortestPath(Graph G, Node Source)
    {
        int NodeCount = G.getNodeCount();
        int[] predecessor =  new int[NodeCount];
        double[] distance = new double[NodeCount];
        Set<Node> unsettledNodes = new HashSet();
        
        for(int i=0 ; i < NodeCount ; i++)
        {
            unsettledNodes.add(G.getNodes().get(i));
            distance[i] = 100000000;
            predecessor[i] = -1;       
        }
        
        distance[Source.getID()] = 0;
        
        while(!unsettledNodes.isEmpty())
        {
            Node currentNode = getLowestDistanceNode(unsettledNodes, distance);
            for(Node n : currentNode.getAdjacentNodes())
            {
                if(distance[currentNode.getID()]+currentNode.getDistance(n) < distance[n.getID()])
                {
                    distance[n.getID()] = distance[currentNode.getID()]+currentNode.getDistance(n);
                    predecessor[n.getID()] = currentNode.getID();          
                }
            }

            unsettledNodes.remove(currentNode);      
        }
        
        printShortestPath(distance);
        Graph dijkstra = buildShortestPathGraph(G.getNodes(), Source.getID(), predecessor, distance);
        return dijkstra;
    }
    
    private static Node getLowestDistanceNode(Set<Node> unsettledNodes, double[] distance) 
    {
        
        Node lowestDistanceNode = null;
        double lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes)
        {
            double nodeDistance = distance[node.getID()];
            if (nodeDistance < lowestDistance) 
            {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }
    
    private static Graph buildShortestPathGraph(ArrayList<Node> Nodes,int SourceID, int[] predecessor, double[] distance)
    {
        ArrayList<Node> Path = new ArrayList();
        Graph G = new Graph(Path);
        int NodeCount = Nodes.size();
        
        
        Path.add(Nodes.get(SourceID).copy());
        
        for(int i=0 ; i < NodeCount ; i++)
            if(predecessor[i] != -1)
            {
                Node n = Nodes.get(i).copy();
                Path.add(n);
            }
                
        for(int i=0 ; i < NodeCount ; i++)
        {     
            if(predecessor[i] != -1)
            {
                int ParentID = predecessor[i];
                int ChildID = i;
                
                Node ParentNode = G.getNode(ParentID);
                Node ChildNode = G.getNode(ChildID);
                
                double Weight = distance[ChildNode.getID()]-distance[ParentNode.getID()];
                G.connect(ParentNode, ChildNode, Weight);
            }
        }  
        return G;
    }
    
    private static void printShortestPath(double[] distance)
    {
        System.out.println("Node        Distance from source");
        for(int i=0 ; i < distance.length ; i++)
            System.out.println(i+"                  "+distance[i]);
        
        System.out.println("--------------------------------");
    }
}
