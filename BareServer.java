import java.io.*;
import java.net.*;

public class BareServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9000);
        System.out.println("Server is alive...");

        while (true) {
            try (Socket client = server.accept()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                OutputStream output = client.getOutputStream();

                // 1. Read Request Line
                String requestLine = reader.readLine();
                if (requestLine == null)
                    continue;

                // 2. Parse Headers
                String headerLine;
                String userAgent = "Not Found";

                while ((headerLine = reader.readLine()) != null && !headerLine.isEmpty()) {
                    // Check for User-Agent (case-insensitive)
                    if (headerLine.toLowerCase().startsWith("user-agent:")) {
                        userAgent = headerLine.substring("user-agent:".length()).trim();
                    }
                }

                // 3. Send Response (Now we use the variable!)
                String body = "<html><body>" +
                        "<h1>Server Logic Check</h1>" +
                        "<p>Detected Browser: <b>" + userAgent + "</b></p>" +
                        "</body></html>";

                String response = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: " + body.length() + "\r\n" +
                        "Connection: close\r\n" +
                        "\r\n" +
                        body;

                output.write(response.getBytes());
                output.flush();

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}