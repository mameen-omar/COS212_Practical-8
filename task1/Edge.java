public class Edge
{
	public Vertex first;
	public Vertex second;
	public double distance;
	
	public Edge(Vertex first, Vertex second, double distance)
	{
		this.first = first;
		this.second = second;
		this.distance = distance;
		
		first.addEdge(this);
		second.addEdge(this);
	}
}
