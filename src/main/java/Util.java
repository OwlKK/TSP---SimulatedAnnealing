public class Util
{
    //Equation for probability of accepting new solution
    //Source: https://towardsdatascience.com/optimization-techniques-simulated-annealing-d6a4785a1de7

    public static double probability(double f1, double f2, double temp)
    {
        // If new solution is worse do not change probability of change
        if(f2 < f1)
        {
            return 1;
        }

        else
        {
            //If solution is better change probability with equation from source above
            return Math.exp((f1 - f2) / temp);
        }
    }

    public static double distance(City city1, City city2)
    {
        int xDistance = Math.abs(city1.getX() - city2.getX());
        int yDistance = Math.abs(city1.getY() - city2.getY());

        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }
}
