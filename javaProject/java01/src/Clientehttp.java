import java.io.IOException;
import java.net.URI;

public class Clientehttp {
    
    public String buscaDados(String url) {

        try {

            URI endereco = URI.create(url);
            var client = HttpClient.newHttpClient();
            var request = ((Object) HttpRequest.newBuilder(endereco)).GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String body = response.body();
            return body;

        } catch (IOException | InterruptedException ex) {
            throw new ClienteHttpException();
        }

    }

}