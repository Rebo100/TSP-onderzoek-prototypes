import java.util.Random;

public class Main {
    //Timer source: https://stackoverflow.com/questions/5204051/how-to-calculate-the-running-time-of-my-program
    static final long startTime = System.nanoTime();

    //Input voor algoritme genereren
    static Point[] input = new Point[4];
    static Point origin;


    public static void main(String[] args) {
        Random random = new Random();
        input[0] = new Point(0, 0);
        for (int i = 1; i <= 3; i++) {
            input[i] = new Point(random.nextInt(1, 5), random.nextInt(1, 5));
        }

        boolean status = true;
        while (status) {
            int counter = 0;
            for (int i2 = 1; i2 <= 3; i2++) {
                if (counter >= 4) {
                    status = false;
                }
                for (int i = 1; i <= 3; i++) {
                    if (i == i2) {
                    } else {
                        if (input[i2].getX() == input[i].getX() && input[i2].getY() == input[i].getY()) {
                            System.out.println(input[i2] + " Dezelfde! " + input[i]);
                            counter = 0;
                            input[i] = new Point(random.nextInt(1, 5), random.nextInt(1, 5));
                        } else {
                            counter++;
                            System.out.println("Niet dezelfde!");
                        }
                    }
                }
            }
        }
        System.out.println("Cities:");
        for (Point p : input
        ) {
            System.out.println(p);
        }


        Point position = input[0];
        Point[] visitedPosition = new Point[4];
        double oldDistance = 1000000000;
        double newDistance = 0;
        visitedPosition[0] = input[0];

        for(Point p: input){
            int i =0;
            boolean visitedPos = false;
            for (Point visited: visitedPosition){
                if(visited==p){visitedPos=true;}
            }
            if(!visitedPos){
                newDistance=newDistance+calcDistance(position, p);
                i++;
                visitedPosition[i] = p;
                }


            System.out.println("Visited positions: ");
            for (Point visited: visitedPosition){
                System.out.print("("+visited+") ");
            }

        }

    }





//        for (Point point: input){
//            i++;
//            boolean visited=true;
//            for (Point p: visitedPosition){if(p==point){visited=false;}}
//
//            if(point!=posision || visited){
//                visitedPosition[i] = point;
//                newDistance=newDistance+calcDistance(posision, point);
//            }
//        }
//        if(newDistance<oldDistance){
//            System.out.println("Route: ");
//            for(Point p: visitedPosition){
//                System.out.print("("+p+") ");
//            }
//        }


    public static double calcDistance(Point a, Point b) {
        int x;
        int y;
        if (a.getX() >= b.getX()) {
            x = a.getX() - b.getX();
        } else {
            x = b.getX() - a.getX();
        }

        if (a.getY() >= b.getY()) {
            y = a.getY() - b.getY();
        } else {
            y = b.getY() - a.getY();
        }

        double distance = Math.sqrt(x + y);
        distance = Math.round(distance * 100);
        distance = distance / 100;
        System.out.print(distance + " ");
        return distance;
    }
}

