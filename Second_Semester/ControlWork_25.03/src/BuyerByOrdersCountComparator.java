import java.util.Comparator;

public class BuyerByOrdersCountComparator implements Comparator<Buyer> {
    @Override
    public int compare(Buyer o1, Buyer o2) {
        Integer firstSize = 0;
        Integer secondSize = 0;
        for (City city : o1.cities){
            firstSize += city.orders.size();
        }
        for (City city : o2.cities){
            secondSize += city.orders.size();
        }
        return firstSize.compareTo(secondSize);
    }
}
