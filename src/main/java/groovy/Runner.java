package groovy;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: mario
 * Date: 22/06/13
 * Time: 12.23
 * To change this template use File | Settings | File Templates.
 */
public class Runner {

    public static void main(String[] args) throws IOException {

        Claims claims=  new Claims();
        PreProcess preProcess= new PreProcess();
        Family family= new Family();

        String text= preProcess.read("src/main/resources/file.xml");
        claims.extractClaims(text);
        family.extract(text);

    }

}
