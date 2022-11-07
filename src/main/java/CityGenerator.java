import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CityGenerator
{
    public static List<City> generateCities(int howManyToGenerate)
    {
        Random randI = new Random();
        List<City> cities = new ArrayList<>();
        for (int i = 0; i < howManyToGenerate; i++)
        {
            cities.add(new City("city" + i, randI.nextInt(100), randI.nextInt(100)));
        }
        return cities;
    }
}
