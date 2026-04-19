import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

public class Main {

    public static final String BASE_URI = "http://localhost:8080/api/v1/";

    public static HttpServer startServer() {

        ResourceConfig rc = new ResourceConfig()
                .packages("resource", "config", "exception", "filter");

        return GrizzlyHttpServerFactory.createHttpServer(
                URI.create(BASE_URI),
                rc
        );
    }

    public static void main(String[] args) throws Exception {

        startServer();

        System.out.println("Server running:");
        System.out.println("http://localhost:8080/api/v1");

        Thread.currentThread().join();
    }
}