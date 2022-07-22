package Week1;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import edu.duke.Point;
import edu.duke.Shape;

import java.io.File;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        double totalPerim = 0;
        Point prevPt = s.getLastPoint();
        for(Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim += currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }
    public int getNumPoints(Shape s) {
        int counter = 0;
        for (Point pt : s.getPoints()) {
            counter++;
        }
        return counter;
    }
    public double getAverageLength(Shape s) {
        double average;
        double perim = getPerimeter(s);
        double num_points = getNumPoints(s);
        average = perim / num_points;
        return average;
    }
    public double getLargestSide(Shape s) {
        double largestSide = 0;
        Point prevPt = s.getLastPoint();
        for(Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);

            if (currDist > largestSide) {
                largestSide = currDist;
            }
            prevPt = currPt;
        }

        return largestSide;
    }
    public double getLargestX(Shape s) {
        double largestX = 0;
        for(Point pt : s.getPoints()) {
            double x = pt.getX();
            if(x > largestX) {
                largestX = x;
            }
        }
        return largestX;
    }
    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);

        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);

        int numPoint = getNumPoints(s);
        System.out.println("number of points = " + numPoint);

        double getAverage = getAverageLength(s);
        System.out.println("average length = " + getAverage);

        double largestSide = getLargestSide(s);
        System.out.println("Largest side = " + largestSide);

        double largestX = getLargestX(s);
        System.out.println("Largest X = " + largestX);

    }


    // ---------------------------------------------------------------------



    public void testPerimeterMultipleFiles() {

        getLargestPerimeter obj1 = new getLargestPerimeter();
        double largestPerimeter = obj1.getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter = " + largestPerimeter);


        String largestPerimeterFile = obj1.getFileWithLargestPerimeter();
        System.out.println(largestPerimeterFile);

    }
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }





    public static void main(String[] args) {
        PerimeterRunner pr = new PerimeterRunner();

        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();



    }
}
class getLargestPerimeter {
    DirectoryResource dr = new DirectoryResource();
    PerimeterRunner main_class = new PerimeterRunner();
    Iterable<File> files = dr.selectedFiles();
    public double getLargestPerimeterMultipleFiles() {

        double largest_perimeter = 0;


        for(File f : files) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double perimeter = main_class.getPerimeter(s);
            if (perimeter > largest_perimeter) {
                largest_perimeter = perimeter;
            }
        }
        return largest_perimeter;
    }
    public String getFileWithLargestPerimeter() {
        File temp = null;
        double largest_perimeter = 0;

        for (File f : files) {
            FileResource fr_name = new FileResource(f);
            Shape s2 = new Shape(fr_name);
            double perimeter2 = main_class.getPerimeter(s2);
            if (perimeter2 > largest_perimeter) {
                largest_perimeter = perimeter2;
                temp = f;
            }
        }
        return String.valueOf(temp);
    }
}
