public class Main
{
	public static void main(String[] args)
	{
		Vertex vert0 = new Vertex("a");
		Vertex vert1 = new Vertex("b");
		Vertex vert2 = new Vertex("c");
		Vertex vert3 = new Vertex("d");
		Vertex vert4 = new Vertex("e");
		Vertex vert5 = new Vertex("f");
		Vertex vert6 = new Vertex("g");
		Vertex vert7 = new Vertex("h");
		Vertex vert8 = new Vertex("i");
		Vertex vert9 = new Vertex("j");
		
		Edge edge7 = new Edge(vert8,vert0,3);
		Edge edge0 = new Edge(vert1,vert0,2);
		Edge edge1 = new Edge(vert2,vert1,4);
		Edge edge2 = new Edge(vert0,vert2,1);
		
		Edge edge11 = new Edge(vert1,vert3,1);
		
		Edge edge3 = new Edge(vert3,vert4,8);
		Edge edge4 = new Edge(vert4,vert5,-3);
		Edge edge5 = new Edge(vert3,vert5,7);
		
		Edge edge9 = new Edge(vert7,vert5,1);
		
		Edge edge6 = new Edge(vert6,vert7,6);
		Edge edge8 = new Edge(vert7,vert9,2);
		
		Edge edge10 = new Edge(vert1,vert6,5);
		
		String result = Graph.findCycleVertexDirected(vert8);
		System.out.println(result);
	}
}
