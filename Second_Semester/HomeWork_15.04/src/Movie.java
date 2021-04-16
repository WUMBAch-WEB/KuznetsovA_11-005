public class Movie {
    public String name;
    public String rating;
    public String produce;

    public Movie(String name, String rating, String produce){
        this.name = name;
        this.rating = rating;
        this.produce = produce;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Название: " + name +
                ", Рейтинг: " + rating +
                ", Продюсер: " + produce;
    }
}
