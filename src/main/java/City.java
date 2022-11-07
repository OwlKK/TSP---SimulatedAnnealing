public class City {
    private String cityName;
    private int xCity;
    private int yCity;


    public City(String cityName, int xCity, int yCity)
    {
        this.cityName = cityName;
        this.xCity = xCity;
        this.yCity = yCity;
    }

    public int getX()
    {
        return xCity;
    }

    public int getY()
    {
        return yCity;
    }

    //In what way do I want to print the object City
    @Override
    public String toString()
    {
        return cityName + "(" + xCity+ ", " + yCity + ")";
    }
}
