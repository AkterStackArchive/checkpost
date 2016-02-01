import io.bace.core.BaceApp;
import io.vertx.core.Launcher;

public class AppBace extends Launcher {

    public static void main(String[] args) {
        BaceApp.init(AppBace.class, args);
    }

}
