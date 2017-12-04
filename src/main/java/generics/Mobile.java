package generics;

public class Mobile extends Product<Mobile> {

    int cost;

    Mobile(int seria, String nameOfSeria, int cost) {
        super(seria, nameOfSeria);
        this.cost = cost;
    }

    @Override
    public boolean personalCompare(Mobile o) {
        return this.cost>o.cost;
    }
}
