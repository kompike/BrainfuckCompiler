${package}


public class JavaBrainfuckTranslator {

    public void execute() {
         int[] memory = new int[100];
         int pointer = 0;

    ${generatedCode}
    }

    public static void main(String[] args) {
        JavaBrainfuckGenerator javaBrainfuckGenerator = new JavaBrainfuckGenerator();
        javaBrainfuckGenerator.execute();
    }
}