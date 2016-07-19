import io.bace.core.BaceApp;
import io.bace.core.BaceAppPackage;
import io.bace.core.BaceRegistry;

import java.util.List;

@BaceAppPackage("io.checkpost")
public class AppBace extends BaceApp {

    public static void main(String[] args) throws Exception {
        BaceApp.run(AppBace.class, args);

        List<Class> classes =  BaceRegistry.getClasses("io.checkpost");
        classes.forEach(System.out::println);
    }

}
