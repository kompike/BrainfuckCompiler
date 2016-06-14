${package}


class GroovyBrainfuckTranslator {

    void execute() {
         def memory = new int[100]
         int pointer = 0

    ${generatedCode}
    }

    static void main(String[] args) {
        def groovyBrainfuckGenerator = new GroovyBrainfuckTranslator()
        groovyBrainfuckGenerator.execute()
    }
}