import java.util.ArrayList;
import java.util.Random;
//Code van stackoverflow https://stackoverflow.com/questions/11703827/brute-force-algorithm-for-the-traveling-salesman-problem-in-java
//Hier en daar zelf toevoegingen gedaan

public class Test {
    static final long startTime = System.nanoTime();
    static Point[] input = new Point[4];

    static double bestDistance = 1000000000;
    static ArrayList<Point> besteRoute = new ArrayList<Point>();
    private static ArrayList<Integer> bestRoute;

    public static void bruteForceFindBestRoute
            (ArrayList<Integer> r,
             ArrayList<Integer> citiesNotInRoute)
    {
        if(!citiesNotInRoute.isEmpty())
        {
            for(int i = 0; i<citiesNotInRoute.size(); i++)
            {
                Integer justRemoved =
                        (Integer) citiesNotInRoute.remove(0);
                ArrayList<Integer> newRoute =
                        (ArrayList<Integer>) r.clone();
                newRoute.add(justRemoved);

                bruteForceFindBestRoute(newRoute, citiesNotInRoute);
                citiesNotInRoute.add(justRemoved);
            }
        }
        else //if(citiesNotInRoute.isEmpty())
        {
            if(isBestRoute(r))
                bestRoute = r;
        }

    }

    private static boolean isBestRoute(ArrayList<Integer> r) {
        System.out.println(r.toString());
        double distance = calcDistance(input[r.get(0)], input[r.get(1)]);
        distance = distance+calcDistance(input[r.get(0)], input[r.get(1)]);


        System.out.println("Distance: "+distance);
        if(distance<bestDistance){
            if(!besteRoute.isEmpty()){
            besteRoute.clear();}
            for(int i: r){
                besteRoute.add(input[i]);
            }
            bestDistance = distance;
        }
        return false;
    }

    public static void main(String[] args) {
        //Create input:
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




        ArrayList<Integer> lst = new ArrayList<Integer>();
        for (int i = 1; i <=3; ++i)
            lst.add(i);
        ArrayList<Integer> route = new ArrayList<Integer>();
        bruteForceFindBestRoute(route, lst);



        final long duration = System.nanoTime() - startTime; //Stop timer!
        System.out.println("\n\nBest distance: "+bestDistance);
        System.out.println("Beste route: ");
        for(Point p: besteRoute){
            System.out.print("("+p+") ");
        }
        System.out.println("De tijd was: "+duration);
    }
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
//        System.out.print(distance + " ");
        return distance;
    }
}
