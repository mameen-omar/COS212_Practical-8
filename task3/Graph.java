//Mohamed Ameen Omar
//u16055323

import java.util.*;

public class Graph
{
	public static ArrayList<newVertex> myVertexes = new ArrayList<newVertex>();


	public static double shortestPathDirected(Vertex v1, Vertex v2)
	{

		populate(v1);
		makeInfinity();
		double distance = 0;
		makeDistance(v1,0);


		makeShortestDirectedPath(v1);

		distance = getEndDistance(v2);
		return distance;
	}

	public static void populate(Vertex v1)
	{
		//clear the arrayList since this is a new run
		if(!myVertexes.isEmpty())
		{
			myVertexes.clear();
		}

		Queue<Vertex> toBeChecked = new LinkedList<Vertex>();
		ArrayList<Vertex> visited = new ArrayList<Vertex>();
		Vertex temp;


		toBeChecked.add(v1);//add my first node
		visited.add(v1);//add my first node, since we are going to process it
		myVertexes.add(new newVertex(v1,null,0));//add first node to list of all my vertexes

		while(toBeChecked.peek() != null)
		{
			temp = toBeChecked.remove();

			for(int count = 0; count < temp.edges.size(); count++)
			{
				Vertex temp2 = temp.edges.get(count).second == temp ? temp.edges.get(count).first : temp.edges.get(count).second;

				if(visited.contains(temp2) == true)
				{
					continue;
				}

				toBeChecked.add(temp2);
				visited.add(temp2);
				myVertexes.add(new newVertex(temp2, null,0));
			}
		}
	}

	public static void makeInfinity()
	{
		int count = 0;
		while(count < myVertexes.size())
		{
			myVertexes.get(count).distance = Double.POSITIVE_INFINITY;
			count++;
		}

	}


	public static void makeShortestDirectedPath(Vertex v1)
	{
		Queue<Vertex> toBeChecked = new LinkedList<Vertex>();
		Vertex temp;

		toBeChecked.add(v1);

		for(;toBeChecked.isEmpty() == false;)
		{
			temp = toBeChecked.remove();

			for(int count = 0; count<temp.edges.size(); count++)
			{
				double tempDistance = temp.edges.get(count).distance + getVertexDistance(temp);

				Vertex newVertex = temp.edges.get(count).second;

				if(newVertex == temp)
				{
					continue;
				}

				if(tempDistance < getVertexDistance(newVertex))
				{
					 if(getPrevious(temp) == getVertex(newVertex))
					 {
						 continue;
					 }

					 makeDistance(newVertex, tempDistance);
					 makePrevious(newVertex,getVertex(temp));

					 if(toBeChecked.contains(newVertex)  == false)
					 {
						 toBeChecked.add(newVertex);
					 }
				}
			}
		}
	}

	public static void makeDistance(Vertex temp, double distance)
	{
		if(myVertexes.isEmpty() == false)
		{
			int count = 0;

			for(; count<myVertexes.size(); count++)
			{
				if(myVertexes.get(count).vertex == temp)
				{
					myVertexes.get(count).distance = distance;
				}
			}
		}

	}

	public static newVertex getVertex(Vertex temp)
	{
		if(myVertexes.isEmpty() == true)
		{
			return null;
		}

		for(int count = 0; count < myVertexes.size(); count++)
		{
			if(myVertexes.get(count).vertex == temp)
			{
				return myVertexes.get(count);
			}
		}

		return null;
	}

	public static double getVertexDistance(Vertex temp)
	{
		if(!myVertexes.isEmpty())
		{
			for(int x =0; x< myVertexes.size(); x++)
			{
				if(myVertexes.get(x).vertex == temp)
				{
					return myVertexes.get(x).distance;
				}
			}
		}


		return Double.POSITIVE_INFINITY;
	}

	public static newVertex getPrevious(Vertex temp)
	{
		if(!myVertexes.isEmpty())
		{
			for(int x =0; x< myVertexes.size(); x++)
			{
				if(myVertexes.get(x).vertex == temp)
				{
					return myVertexes.get(x).previous;
				}
			}
		}

		return null;
	}

	public static void makePrevious(Vertex temp, newVertex previous)
	{

		if(!myVertexes.isEmpty())
		{
			for(int x =0; x< myVertexes.size(); x++)
			{
				if(myVertexes.get(x).vertex == temp)
				{
					myVertexes.get(x).previous = previous;
				}
			}
		}


	}

	public static double getEndDistance(Vertex v2)
	{
		if(myVertexes.isEmpty() == false)
		{
			for(int x = 0; x< myVertexes.size(); x++)
			{
				if(myVertexes.get(x).vertex == v2)
				{
					return myVertexes.get(x).distance;
				}
			}
		}

		else
		{
			return Double.POSITIVE_INFINITY;
		}

		return Double.POSITIVE_INFINITY;
	}

}

//Mohamed Ameen Omar
//u16055323

class newVertex
{
	Vertex vertex;
	double distance;

	newVertex previous;

	public newVertex()
	{
		distance = 0;
		vertex = null;
		previous = null;
	}

	public newVertex(Vertex vertex, newVertex previous, double distance)
	{
		this.distance = distance;
		this.vertex = vertex;
		this.previous = previous;
	}


}
