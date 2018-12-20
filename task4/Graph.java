//Mohamed Ameen Omar
//u16055323

import java.util.*;

public class Graph
{
	public static ArrayList<newVertex> myVertexes = new ArrayList<newVertex>();

	public static int counter;


	public static String findCycleVertexDirected(Vertex v1)
	{
		counter = 0;

		populate(v1);
		makeZero();

		String output = "";

		output = DFSCycleDetection(v1);

		return output;
	}

	public static String DFSCycleDetection(Vertex v1)
	{
		String output = "";

		counter = 1;


		while(true)
		{
			boolean again = false;

			for(int x = 0; x<myVertexes.size();x++)
			{
				if(getVertexDistance(myVertexes.get(x).vertex) == 0)
				{
					again = true;
					output = cycleDetectionDFS(myVertexes.get(x));


				}

				if(output != "")
				{
					break;
				}
			}

			if(again == false)
			{
				return output;
			}
		}
	}

	public static String cycleDetectionDFS(newVertex v1)
	{
		String output = "";

		Vertex temp = v1.vertex;

		makeDistance(temp, counter++);

		for(int y=0; y<temp.edges.size();y++)
		{
			Vertex temp2 = temp.edges.get(y).second ;

			if(temp2 == temp)
			{
				continue;
			}

			if(getVertexDistance(temp2) == 0.0)
			{
				makePrevious(temp2, v1);
				return cycleDetectionDFS(getVertex(temp2));
			}

			else if(getVertexDistance(temp2) != Double.POSITIVE_INFINITY)
			{

				makePrevious(temp2,v1);
				output = temp2.label;
				return output;
			}


		}

		makeDistance(temp, Double.POSITIVE_INFINITY);

		return output;

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

		for(;toBeChecked.peek() != null;)
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

	public static void makeZero()
	{
		int count = 0;
		for(;count < myVertexes.size();)
		{
			myVertexes.get(count).distance = 0;
			count++;
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
		int count = 0;
		while(count < myVertexes.size())
		{
			if(myVertexes.get(count).vertex == temp)
			{
				return myVertexes.get(count);
			}

			count++;
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


		return 0;
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
			return 0;
		}

		return 0;
	}

}

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

	public newVertex(Vertex vertex, newVertex previous, int distance)
	{
		this.distance = distance;
		this.vertex = vertex;
		this.previous = previous;
	}


}
