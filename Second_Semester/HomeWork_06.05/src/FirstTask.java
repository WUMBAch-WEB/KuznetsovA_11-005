import java.util.TreeSet;

public class FirstTask {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>((x, y) -> x.length() - y.length());
        treeSet.add("ssss");
        treeSet.add("ssssss");
        treeSet.add("ss");
        treeSet.remove("smth");
        System.out.println(treeSet);
    }
}
