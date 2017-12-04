package generics;

public class Camera extends Product<Camera>{

    int cost;

    public Camera(int seria, String nameOfSeria, int cost) {
        super(seria, nameOfSeria);
        this.cost = cost;
    }

    @Override
    public boolean personalCompare(Camera o) {
        return this.cost>o.cost;
    }
}
