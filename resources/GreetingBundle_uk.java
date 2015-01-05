import java.util.ListResourceBundle;

public class GreetingBundle_uk extends ListResourceBundle {
    public Object[][] getContents() {
        return contents;
    }
    private static final Object[][] contents = {
        { "Greeting", "Привіт!" }
    };
}
