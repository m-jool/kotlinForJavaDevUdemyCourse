import java.util.ArrayList;
import java.util.List;

public class GenericsTypeErasure {
    public void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("hello");

        // We can not do the bellow, the JVM will not have this information
        // boolean b = strings instanceof List<String>;
        // But we can do:
        boolean b = strings instanceof List;
    }
}
