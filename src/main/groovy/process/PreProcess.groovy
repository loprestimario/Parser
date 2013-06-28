package process


class PreProcess {

    public String read(String pathFile) {

        String body = new File(pathFile).text
        body.replaceAll('xmlns="http://www.tei-c.org/ns/1.0"', '')
    }
}
