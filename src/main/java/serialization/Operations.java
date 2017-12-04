package serialization;

import java.io.*;

public class Operations {
    public static void main(String[] args) {

        DataObject obj = new DataObject();
        obj.setMyData("NewMyData");


        File file = new File("store.bin");

        try (FileOutputStream fo = new FileOutputStream(file);
             ObjectOutputStream so = new ObjectOutputStream(fo)){

            so.writeObject(obj);
            System.out.println(obj);
            so.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fi = new FileInputStream(file);
             ObjectInputStream si = new ObjectInputStream(fi)){

            DataObject objNew = (DataObject) si.readObject();
            System.out.println(objNew.myData);

        } catch (IOException | ClassNotFoundException ei) {
            ei.printStackTrace();
        }


    }
}
