import java.util.ArrayList;
import java.util.List;

public class Generics {
    public void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.get(0).toUpperCase();

        // We do not have to provide the type by it is good practice to do so
        List list1 = new ArrayList<>();
        list.add("Good Bye");
    }
}
