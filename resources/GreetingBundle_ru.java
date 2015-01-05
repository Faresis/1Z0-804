import java.util.ListResourceBundle;

public class GreetingBundle_ru extends ListResourceBundle {
    public Object[][] getContents() {
        return contents;
    }
    private static final Object[][] contents = {
        { "Greeting", "Привет!" }
    };
}
