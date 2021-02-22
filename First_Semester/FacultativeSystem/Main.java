package FacultativeSystem;

public class Main {
    public static void main(String[] args) {
        Platform.createDataBase();
        Platform platform = new Platform();
        platform.welcome();
    }
}
