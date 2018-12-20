import java.util.ArrayList;

public class Vertex
{
	public String label;
	public ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public Vertex(String label)
	{
		this.label = label;
	}
	
	public void addEdge(Edge edge)
	{
		edges.add(edge);
	}
}
