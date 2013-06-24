package groovy

/**
 * Created with IntelliJ IDEA.
 * User: mario
 * Date: 23/06/13
 * Time: 14.27
 * To change this template use File | Settings | File Templates.
 */
class PreProcess {

    public String read(String pathFile){

        String body= new File(pathFile).text
        def g= body.replaceAll('xmlns="http://www.tei-c.org/ns/1.0"','')
        return g

    }

}
