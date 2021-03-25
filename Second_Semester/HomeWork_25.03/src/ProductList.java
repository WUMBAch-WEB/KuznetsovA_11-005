import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProductList {

    File file;

    public ProductList(File file){

        this.file = file;
        List<Product> list = new ArrayList<>();
        Gson gson = new Gson();

        if (getList() == null){
            try {
                new FileWriter(file, false).close();
                FileWriter writer = new FileWriter(file);
                String str = gson.toJson(list);
                writer.append(str);
                writer.flush();
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ArrayList<Product> getList(){
        Gson gson = new Gson();
        ArrayList<Product> arrayList = null;
        Type type = new TypeToken<ArrayList<Product>>() {}.getType();
        try {
            arrayList = (ArrayList<Product>) gson.fromJson(new FileReader(file), type);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private void rewrite(ArrayList<Product> arrayList) {
        Gson gson = new Gson();
        try {
            new FileWriter(file, false).close();
            FileWriter writer = new FileWriter(file);
            String str = gson.toJson(arrayList);
            writer.append(str);
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Product product) {
        ArrayList<Product> arrayList = getList();
        if (arrayList == null) {
            System.out.println("List is null");
            return;
        }
        Boolean flag = false;
        for (Product i : arrayList) {
            if (i.equals(product)) {
                i.incCount(product.getCount());
                flag = true;
            }
        }
        if (!flag) {
            arrayList.add(product);
        }
        rewrite(arrayList);
    }

    public Boolean changeCount(String name, int count) {
        ArrayList<Product> arrayList = getList();
        if (arrayList == null) {
            System.out.println("Array list is null");
            return false;
        }
        Boolean flag = false;
        for (Product i : arrayList) {
            if (i.equals(name)) {
                i.incCount(count);
                flag = true;
            }
        }
        if (!flag)
            return flag;
        rewrite(arrayList);
        return flag;
    }

    public Boolean remove(String name) {
        ArrayList<Product> arrayList = getList();
        if (arrayList == null) {
            System.out.println("List is null");
            return false;
        }
        Boolean flag = false;
        for (Product i : arrayList) {
            if (i.equals(name)) {
                flag = true;
                arrayList.remove(i);
            }
        }
        if (!flag)
            return flag;
        rewrite(arrayList);
        return flag;
    }



    public String toString() {
        ArrayList<Product> arrayList = getList();
        String res = "";
        for (Product i : arrayList) {

            res += i + ", ";

        }
        return ('{' + res + '}').replace(", }", "}");
    }

}
