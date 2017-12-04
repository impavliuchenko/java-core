package generics;

public abstract class Product <T extends Product> implements Comparable<T>{

    int  seria;
    String nameOfSeria;

    Product(int seria, String nameOfSeria) {
        this.seria = seria;
        this.nameOfSeria = nameOfSeria;
    }

    public abstract boolean personalCompare(T o);

    @Override
    public int compareTo(T o) {
        if (this.seria > o.seria){
            return 1;
        }else{
            return 0;
        }
    }

}
