import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.text.AbstractDocument.Content;

import org.omg.CORBA.Context;

public class ExtratorDeConteudoDoIMDB<Conteudo> implements ExtratorDeConteudo {
    
    public List<Content> extraiConteudos(String json) {
         // extrair só os dados que interessam (titulo, poster, classificação)
         JsonParser parser = new JsonParser();
         List<Map<String, String>> listaDeAtributos = parser.parse(json);

         return ((Object) listaDeAtributos.stream()
         .map(atributos -> new Context(atributos.get("title"), atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg"))))
         .toList();
 
    }

}