package templates;


public class JavaBrainfuckTranslator {

    public void execute() {
         int[] memory = new int[100];
         int pointer = 0;

    	memory[pointer]++;
	memory[pointer]++;
	memory[pointer]++;
	memory[pointer]++;
	memory[pointer]++;
	memory[pointer]++;
	memory[pointer]++;
	memory[pointer]++;
	while(memory[pointer] > 0) {
	pointer++;
	memory[pointer]++;
	memory[pointer]++;
	memory[pointer]++;
	memory[pointer]++;
	while(memory[pointer] > 0) {
	pointer++;
	memory[pointer]++;
	memory[pointer]++;
	pointer++;
	memory[pointer]++;
	memory[pointer]++;
	memory[pointer]++;
	pointer++;
	memory[pointer]++;
	memory[pointer]++;
	memory[pointer]++;
	pointer++;
	memory[pointer]++;
	pointer--;
	pointer--;
	pointer--;
	pointer--;
	memory[pointer]--;
}
	pointer++;
	memory[pointer]++;
	pointer++;
	memory[pointer]++;
	pointer++;
	memory[pointer]--;
	pointer++;
	pointer++;
	memory[pointer]++;
	while(memory[pointer] > 0) {
	pointer--;
}
	pointer--;
	memory[pointer]--;
}
	pointer++;
	pointer++;
	System.out.print((char) memory[pointer]);
	pointer++;
	memory[pointer]--;
	memory[pointer]--;
	memory[pointer]--;
	System.out.print((char) memory[pointer]);
	memory[pointer]++;
	memory[pointer]++;
	memory[pointer]++;
	memory[pointer]++;
	memory[pointer]++;
	memory[pointer]++;
	memory[pointer]++;
	System.out.print((char) memory[pointer]);
	System.out.print((char) memory[pointer]);
	memory[pointer]++;
	memory[pointer]++;
	memory[pointer]++;
	System.out.print((char) memory[pointer]);
	pointer++;
	pointer++;
	System.out.print((char) memory[pointer]);
	pointer--;
	memory[pointer]--;
	System.out.print((char) memory[pointer]);
	pointer--;
	System.out.print((char) memory[pointer]);
	memory[pointer]++;
	memory[pointer]++;
	memory[pointer]++;
	System.out.print((char) memory[pointer]);
	memory[pointer]--;
	memory[pointer]--;
	memory[pointer]--;
	memory[pointer]--;
	memory[pointer]--;
	memory[pointer]--;
	System.out.print((char) memory[pointer]);
	memory[pointer]--;
	memory[pointer]--;
	memory[pointer]--;
	memory[pointer]--;
	memory[pointer]--;
	memory[pointer]--;
	memory[pointer]--;
	memory[pointer]--;
	System.out.print((char) memory[pointer]);
	pointer++;
	pointer++;
	memory[pointer]++;
	System.out.print((char) memory[pointer]);
	pointer++;
	memory[pointer]++;
	memory[pointer]++;
	System.out.print((char) memory[pointer]);

    }

    public static void main(String[] args) {
        JavaBrainfuckGenerator javaBrainfuckGenerator = new JavaBrainfuckGenerator();
        javaBrainfuckGenerator.execute();
    }
}