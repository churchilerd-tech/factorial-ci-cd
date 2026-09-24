import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class Factorial {

    public static long calculate(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }

        long fact = 1;

        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }

        return fact;
    }

    public static void main(String[] args) throws IOException {

        int port = Integer.parseInt(
                System.getenv().getOrDefault("PORT", "8080")
        );

        HttpServer server = HttpServer.create(
                new InetSocketAddress("0.0.0.0", port),
                0
        );

        server.createContext("/", exchange -> {

            String response =
                    "Factorial CI/CD Application is Running!\n" +
                    "Factorial of 5 = " + calculate(5);

            exchange.sendResponseHeaders(
                    200,
                    response.getBytes().length
            );

            OutputStream output = exchange.getResponseBody();
            output.write(response.getBytes());
            output.close();
        });

        server.start();

        System.out.println(
                "Server started on port " + port
        );
    }
}