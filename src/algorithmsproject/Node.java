package algorithmsproject;

import java.util.ArrayList;

public class Node 
{
    private int x;
    private int y;
    private final int ID;
    private final ArrayList<Node> adjacentNodes;
    private final ArrayList<Double> adjacentDistances;
    private final ArrayList<Message> receivedMessages;
    private double Battery;
    
    public Node(int x, int y, int ID)
    {
        this.x = x;
        this.y = y;
        this.Battery = 50;
        this.ID = ID;
        adjacentNodes = new ArrayList();
        adjacentDistances = new ArrayList();
        receivedMessages = new ArrayList();
    }

    public int getX() {return x;}

    public void setX(int x) {this.x = x;}

    public int getY() {return y;}

    public void setY(int y){this.y = y;}

    public int getID(){return ID;}
    
    public ArrayList<Node> getAdjacentNodes(){return adjacentNodes;}

    public ArrayList<Double> getAdjacentDistances(){return adjacentDistances;}

    public ArrayList<Message> getReceivedMessages(){return receivedMessages;}
 
    public double getBattery(){return Battery;}

    public void setBattery(double Battery){this.Battery = Battery;}
    
    public double getDistance(Node n)
    {
        for(int i=0; i < adjacentNodes.size() ; i++)
            if(adjacentNodes.get(i).getID() == n.getID())
                return adjacentDistances.get(i);
        
        return 100000000;
    }
    
    public double getPower(Node n)
    {
        for(int i=0; i < adjacentNodes.size() ; i++)
            if(adjacentNodes.get(i).getID() == n.getID())
                return adjacentDistances.get(i)*0.05;
        
        return 0;
    }
    
    public Node copy()
    {
        Node n = new Node(this.x, this.y, this.ID);
        n.setBattery(Battery);
        return n;
    }
}
