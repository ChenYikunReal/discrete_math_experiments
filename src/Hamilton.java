import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point{

    int selected;
    int id;
    String name;
    Point(String name){
        this.name = name;
    }
}

class Edge{

    Point[] points = new Point[2];
    int value;
    Edge(int value){
        this.value = value;
    }
}

public class Hamilton {

    private static Edge[] allEdges;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of the city: ");
        int n = sc.nextInt();
        int m = (n - 1) * n / 2;

        Point[] allPoints = new Point[n];
        allEdges = new Edge[m];

        for (int i = 0; i < n; i++) {
            System.out.printf("Please enter the name of the city %d: ", i+1);
            allPoints[i] = new Point(sc.next());
            allPoints[i].id = i;
        }

        int count = 0;
        for(int i = 0; i < n; i ++){
            for (int j = i + 1; j < n; j++) {
                if(i != j){
                    System.out.printf("PLease enter the value between %s and %s: ", allPoints[i].name, allPoints[j].name);
                    int v = sc.nextInt();
                    allEdges[count] = new Edge(v);
                    allEdges[count].points[0] = allPoints[i];
                    allEdges[count].points[1] = allPoints[j];
                    count ++;
                }
            }
        }

        System.out.println();
        
        List<Point> rst = new ArrayList<>();

        Point start = allPoints[0];
        rst.add(start);
        start.selected = 1;
        int c = 0;

        while(c < n -1){
            Point next = getMinPoint(start, allPoints);
            rst.add(next);
            next.selected = 1;
            start = next;
            c ++;
        }

        rst.add(allPoints[0]);

        for (int i = 0; i < rst.size(); i++) {
            if(i == rst.size()-1){
                System.out.print(rst.get(i).name);
            }else{
                System.out.print(rst.get(i).name + "--->");
            }
        }
    }

    private static int getValueOfPoints(Point p1, Point p2){
        for (Edge edge : allEdges) {
            if((edge.points[0] == p1 && edge.points[1] == p2) || (edge.points[1] == p1 && edge.points[0] == p2)){
                return edge.value;
            }
        }
        return 0;
    }

    private static Point getMinPoint(Point p1, Point[] ps){
        int[] values = new int[ps.length];
        for (int i = 0; i < ps.length; i++) {
            if(ps[i].selected == 0){
                values[i] = getValueOfPoints(p1, ps[i]);
            }else{
                values[i] = 99999;
            }
        }
        int min = values[0];
        int index = 0;
        for (int i = 0; i < values.length; i++) {
            if(values[i] <= min){
                min = values[i];
                index = i;
            }
        }
        return ps[index];
    }
}
