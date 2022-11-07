import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulatedAnnealing {
    //temperature and cooling rate
    private static double temperature = 1000;
    private static double coolingRate = 0.995;

    public static void main(String args[]) {
        List<City> cities = CityGenerator.generateCities(10);
        //Duplicate of the list to compare distance with NN algorithm
        List<City> citiesForNN = cities;

        Tour currentPath = new Tour(cities);
        Tour bestPath = currentPath.duplicate();

        for (double t = temperature; t > 1; t *= coolingRate)
        {
            // Neighbouring solution to "current" one
            Tour neighbourPath = currentPath.duplicate();

            //Get random index number of city
            int index1 = (int) (neighbourPath.numberOfCities() * Math.random());
            int index2 = (int) (neighbourPath.numberOfCities() * Math.random());

            Collections.swap(neighbourPath.getCities(), index1, index2);

            int currentPathLength = currentPath.getTourLength();
            int neighbourPathLength = neighbourPath.getTourLength();

            if (Math.random() < Util.probability(currentPathLength, neighbourPathLength, t)) {
                currentPath = neighbourPath.duplicate();
            }

            if (currentPath.getTourLength() < bestPath.getTourLength()) {
                bestPath = currentPath.duplicate();
            }
            // FOR TESTING UNCOMMENT TO SEE FULL PROCESS
            //System.out.println("Current tour: " + currentPath + "          Length: " + currentPathLength);
            //System.out.println("Neighbour tour: " + neighbourPath + "          Length: " + neighbourPathLength);
            //System.out.println("Best tour: " + bestPath + "          Length: " + bestPath.getTourLength());
        }
        //printing best result
        System.out.println("Final tour length: " + bestPath.getTourLength());
        System.out.println(bestPath);


        /*
        //List for testing
        private static List<City> testCities(){
        List<City> cities = new ArrayList<>();
        City city1 = new City("city1", 100, 100);
        cities.add(city1);

        City city2 = new City("city2", 200, 100);
        cities.add(city2);

        City city3 = new City("city3",100, 200);
        cities.add(city3);

        City city4 = new City("city4", 200, 200);
        cities.add(city4);
        return cities; }
         */
    }
}