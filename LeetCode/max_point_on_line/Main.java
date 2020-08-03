package LeetCode.max_point_on_line;

public class Main {
    public static void main(String[] args) {
//        Point a = new Point(0,0);
//        Point b = new Point(94911151,94911150);
//        Point c = new Point(94911152,94911151);
        Point a = new Point(2,3);
        Point b = new Point(3,3);
        Point c = new Point(-5,3);
        Point[] points = new Point[3];
        points[0]= a;
        points[1]= b;
        points[2]= c;
        Solution s =new Solution();
        System.out.println(s.maxPoints(points));
    }
}
