import java.util.*;

class Point{

	int id;
	String name;
	public Point(String name){
		this.name = name;
	}
}

class Edge{

	int value;
	Point[] points = new Point[2];
	int selected;
	public Edge(int v){
		value = v;
	}
}

public class Tree {

	private static boolean allInSelectPoint(Edge edge, Point[] hasSelectPoint){
		int flag1 = 0;
		int flag2 = 0;
		for (int i = 0; i < hasSelectPoint.length; i++) {
			if(edge.points[0] == hasSelectPoint[i]){
				flag1 = 1;
			}
			if(edge.points[1] == hasSelectPoint[i]){
				flag2 = 1;
			}
		}
		return flag1 == 1 && flag2 == 1;
	}

	private static void sort(Edge[] edge){
		Edge temp = null;
		for (int i = 0; i < edge.length; i++) {
			for (int j = i + 1; j < edge.length; j++) {
				if(edge[j].value < edge[i].value){
					temp = edge[i];
					edge[i] = edge[j];
					edge[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the number of the city: ");
		int n = sc.nextInt();
		int m = (n-1)*n/2;

		Point[] allPoints = new Point[n];
		Edge[] allEdges = new Edge[m];

		for (int i = 0; i < n; i++) {
			System.out.printf("Please enter the name of the city %d: ", i);
			allPoints[i] = new Point(sc.next());
			allPoints[i].id = i;
		}

		int count = 0;
		int inn = 0;
		for(int i = 0; i < n; i ++){
			for (int j = i + 1; j < n; j++) {
				if(i != j){
					System.out.printf("PLease enter the value between city %d and city %d: ", i, j);
					int v = sc.nextInt();
					allEdges[count] = new Edge(v);
					allEdges[count].points[0] = allPoints[i];
					allEdges[count].points[1] = allPoints[j];
					count ++;
				}
			}
		}

	    System.out.println();
		
		sort(allEdges);

		Point[] hasSelectPoint = new Point[2*m];
		for (int i = 0; i < hasSelectPoint.length; i++) {
			hasSelectPoint[i] = null;
		}

		int j = 0;
		int step = 1;
		for (int i = 0; i < n; i++) {
			if(step == m -1 && allInSelectPoint(allEdges[i], hasSelectPoint)) {
				allEdges[i].selected = 1;
				break;
			}else if(allEdges[i].selected == 0 && !allInSelectPoint(allEdges[i], hasSelectPoint)){
				allEdges[i].selected = 1;
				hasSelectPoint[j] = allEdges[i].points[0];
				j ++;
				hasSelectPoint[j] = allEdges[i].points[1];
				j ++;
				step ++;
			}
		}

		System.out.print("Select points: ");
		List<Point> points = getPoints(allEdges);
		for (Point point : points) {
			System.out.print(point.name + "--->");
		}
	}

	private static List<Point> getPoints(Edge[] edges){
		List<Point> rst = new ArrayList<>();
		for (Edge edge : edges) {
			if(edge.selected == 1){
				rst.addAll(Arrays.asList(edge.points));
			}
		}
		return rst;
	}
}
