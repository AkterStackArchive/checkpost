import io.bace.core.BaceApp;
import io.bace.core.BaceRegistry;
import io.checkpost.http.AuthenticationRouter;

import java.lang.reflect.Field;
import java.util.List;

public class AppBace extends BaceApp {

    public static void main(String[] args) throws Exception {
        BaceApp.run(AppBace.class, args);
        Field f = ClassLoader.class.getDeclaredField("classes");
        f.setAccessible(true);

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        List<Class> classes =  (List<Class>) f.get(classLoader);
        classes.forEach(System.out::println);
    }

}
