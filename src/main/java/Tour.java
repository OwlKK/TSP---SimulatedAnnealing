import java.util.*;

public class Tour
{
    //Storing objects of class City in List
    private List<City> cities;
    private int distance;

    public Tour(List<City> cities)
    {
        this.cities = new ArrayList<>(cities);
    }


    public Tour duplicate()
    {
        return new Tour(new ArrayList<>(cities));
    }

    public int numberOfCities()
    {
        return cities.size();
    }

    public List<City> getCities() {
        return cities;
    }

    public int getTourLength()
    {
        int totalDistance = 0;

        if (distance != 0)
        {
            return distance;
        }


        for (int i = 0; i < numberOfCities(); i++)
        {
            City start = getCity(i);
            City end;
            if (i + 1 < numberOfCities())
            {
                end = getCity(i + 1 );
            }

            else
            {
                end = getCity(0);
            }

            totalDistance += Util.distance(start, end);
        }
        distance = totalDistance;
        return totalDistance;
    }

    @Override
    public String toString() {
        return  cities.toString();
    }

    public City getCity(int index)
    {
        return cities.get(index);
    }
}

