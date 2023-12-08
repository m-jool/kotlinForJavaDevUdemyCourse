import org.jetbrains.annotations.Nullable;

public class Car {

    public static int x = 5;

    private String color;
    private String model;
    private int year;
    private Object obj;

    public Car(String color, String model, int year) {
        this.color = color;
        this.model = model;
        this.year = year;
    }

    public static String xString (){
        return "this is x: " + x++;
    }

    public void demoMethod() {
//        constructing a thread
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("i am in a thread");
//            }
//        }).start();

        // same as above but using a lambda
        new Thread( () -> System.out.println("i am in a thread")).start();
    }

    public static void demoMethod2(Runnable r) {
        new Thread(r).start();
    }

    public String getColor() {
        return color;
    }

    public void setColor(@Nullable String color) {
        this.color = color;
    }

    public @Nullable String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void variableMethod(int num, String... strings) {
        for (String str: strings){
            System.out.println(str);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
