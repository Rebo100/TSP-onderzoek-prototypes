import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    //Timer source: https://stackoverflow.com/questions/5204051/how-to-calculate-the-running-time-of-my-program
    static final long startTime = System.nanoTime();

    //Input voor algoritme genereren
    static Point[] input = new Point[4];
    static Point origin;
    static Point position;
    static Point[] finishedPoints = new Point[4];

    static Point[] visiting = new Point[4];

    public static double[] getDistances(Point[] points){
        System.out.println();
        System.out.println("Position: "+position);
        boolean inArray = false;
            System.out.println("Distances between cities: ");
        double[] distances = new double[4];
        int i=-1;
        for (Point p: points){
            inArray=false;
            i++;
//            System.out.println();
//            System.out.print("c: ");
            for(Point c: finishedPoints){
//                System.out.print(c+" ");
                if(c==p){inArray=true;}
            }
            System.out.println();
            if(p==position || p==origin || inArray){distances[i] = 0;}
            else {
                int x;
                int y;
                if (p.getX() >= position.getX()) {
                    x = p.getX() - position.getX();
                } else {
                    x = position.getX() - p.getX();
                }

                if (p.getY() >= position.getY()) {
                    y = p.getY() - position.getY();
                } else {
                    y = position.getY() - p.getY();
                }

                double distance = Math.sqrt(x + y);
                distance = Math.round(distance * 100);
                distance = distance/100;
                distances[i] = distance;
                System.out.print(distance+" ");
            }
        }
        return distances;
    }

    public static int getClosest(double[] distances){
        double oldDistance = 100000;
        int index=-1;
        int indexClosest = 0;
        System.out.println("Function input: ");
        for(double d: distances){
            System.out.print(d+" ");
            index++;
            if(d<oldDistance&&d!=0)
            {
                oldDistance=d;
                indexClosest=index;
            }
        }
        System.out.println("");
        position=input[indexClosest];
        System.out.println("City: "+indexClosest+" is closest ("+position+")");

        return indexClosest;
    }


    public static void main(String[] args) {
        Random random = new Random();
        input[0] = new Point(0, 0);
        for(int i = 1; i<=3; i++){
            input[i] = new Point(random.nextInt(1, 5), random.nextInt(1, 5));
        }

        boolean status = true;
        while(status){
            int counter = 0;
        for(int i2 = 1; i2<=3; i2++){
            if(counter>=4){status=false;}
            for(int i = 1; i<=3; i++){
                if(i==i2){}else{
                if (input[i2].getX()==input[i].getX()&&input[i2].getY()==input[i].getY()){
                    System.out.println(input[i2]+" Dezelfde! "+input[i]);
                    counter=0;
                    input[i]=new Point(random.nextInt(1, 5), random.nextInt(1, 5));
                }else{
                    counter++;
                    System.out.println("Niet dezelfde!");
                }
            }
        }
        }
        }
        System.out.println("Cities:");
        for (Point p: input
             ) {
            System.out.println(p);
        }

        origin = input[0];
        position = origin;


        //        v4

        visiting=input;
//        finishedPoints[0]=input[0];
        for(int i = 1; i<input.length; i++){
            finishedPoints[i]=input[getClosest(getDistances(visiting))];
        }
        //stop timer! programma is klaar
        final long duration = System.nanoTime() - startTime;

        System.out.println("Finished points: ");
        for(Point p: finishedPoints){
            System.out.print("  "+p);
        }



        System.out.println("\n");
        System.out.println("De locaties zijn: ");
        for(Point p: input){
            System.out.print("("+p+") ");
        }

        System.out.println("\nDe route is: ");
        for(int i=1; i<=3; i++){
            System.out.print("("+finishedPoints[i]+") ");
        }

        System.out.println("De tijd was: "+duration);






        //Adjecency list maken
//        Point origin = input[0];
//        Point position = origin;
//        for (Point p: input){
//            if(p==position){}
//            else {
//                int x;
//                int y;
//                if (p.getX() >= position.getX()) {
//                    x = p.getX() - position.getX();
//                } else {
//                    x = position.getX() - p.getX();
//                }
//
//                if (p.getY() >= position.getY()) {
//                    y = p.getY() - position.getY();
//                } else {
//                    y = position.getY() - p.getY();
//                }
//
//                double distance = Math.sqrt(x + y);
//                distance = Math.round(distance * 100);
//                distance = distance/100;
//                System.out.println(distance);
//            }
//        }
//
//
//        //v2
//        for(Point p2: input){
//            position=p2;
//            System.out.println("");
//            for (Point p: input){
//                int x;
//                int y;
//                if (p.getX() >= position.getX()) {
//                    x = p.getX() - position.getX();
//                } else {
//                    x = position.getX() - p.getX();
//                }
//
//                if (p.getY() >= position.getY()) {
//                    y = p.getY() - position.getY();
//                } else {
//                    y = position.getY() - p.getY();
//                }
//                double distance = Math.sqrt(x + y);
//                distance = Math.round(distance * 100);
//                int result = (int)distance;
//                System.out.print(result+" ");
//            }
//        }

        //v3
//        Point origin = input[0];
//        Point position = origin;

//        int i = 0;
//        double[] distances = new double[4];
//        for (Point p: input){
//            if(p==position || p==origin){}
//            else {
//                i++;
//                int x;
//                int y;
//                if (p.getX() >= position.getX()) {
//                    x = p.getX() - position.getX();
//                } else {
//                    x = position.getX() - p.getX();
//                }
//
//                if (p.getY() >= position.getY()) {
//                    y = p.getY() - position.getY();
//                } else {
//                    y = position.getY() - p.getY();
//                }
//
//                double distance = Math.sqrt(x + y);
//                distance = Math.round(distance * 100);
//                distance = distance/100;
//                distances[i] = distance;
//                System.out.print(distance+" ");
//            }
//        }
//        double oldDistance = 100000;
//        int index=0;
//        int indexClosest = 0;
//        for(double d: distances){
//            System.out.println(d);
//            index++;
//            if(d<oldDistance&&d!=0)
//            {
//                oldDistance=d;
//                indexClosest=index;
//            }
//        }
//        System.out.println(indexClosest+" is closest");







    }
}
