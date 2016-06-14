package templates;


class GroovyBrainfuckTranslator {

    void execute() {
         def memory = new int[100]
         int pointer = 0

    	memory[pointer]++
	memory[pointer]++
	memory[pointer]++
	memory[pointer]++
	memory[pointer]++
	memory[pointer]++
	memory[pointer]++
	memory[pointer]++
	while(memory[pointer] > 0) {
	pointer++
	memory[pointer]++
	memory[pointer]++
	memory[pointer]++
	memory[pointer]++
	while(memory[pointer] > 0) {
	pointer++
	memory[pointer]++
	memory[pointer]++
	pointer++
	memory[pointer]++
	memory[pointer]++
	memory[pointer]++
	pointer++
	memory[pointer]++
	memory[pointer]++
	memory[pointer]++
	pointer++
	memory[pointer]++
	pointer--
	pointer--
	pointer--
	pointer--
	memory[pointer]--
}
	pointer++
	memory[pointer]++
	pointer++
	memory[pointer]++
	pointer++
	memory[pointer]--
	pointer++
	pointer++
	memory[pointer]++
	while(memory[pointer] > 0) {
	pointer--
}
	pointer--
	memory[pointer]--
}
	pointer++
	pointer++
	print ((char) memory[pointer])
	pointer++
	memory[pointer]--
	memory[pointer]--
	memory[pointer]--
	print ((char) memory[pointer])
	memory[pointer]++
	memory[pointer]++
	memory[pointer]++
	memory[pointer]++
	memory[pointer]++
	memory[pointer]++
	memory[pointer]++
	print ((char) memory[pointer])
	print ((char) memory[pointer])
	memory[pointer]++
	memory[pointer]++
	memory[pointer]++
	print ((char) memory[pointer])
	pointer++
	pointer++
	print ((char) memory[pointer])
	pointer--
	memory[pointer]--
	print ((char) memory[pointer])
	pointer--
	print ((char) memory[pointer])
	memory[pointer]++
	memory[pointer]++
	memory[pointer]++
	print ((char) memory[pointer])
	memory[pointer]--
	memory[pointer]--
	memory[pointer]--
	memory[pointer]--
	memory[pointer]--
	memory[pointer]--
	print ((char) memory[pointer])
	memory[pointer]--
	memory[pointer]--
	memory[pointer]--
	memory[pointer]--
	memory[pointer]--
	memory[pointer]--
	memory[pointer]--
	memory[pointer]--
	print ((char) memory[pointer])
	pointer++
	pointer++
	memory[pointer]++
	print ((char) memory[pointer])
	pointer++
	memory[pointer]++
	memory[pointer]++
	print ((char) memory[pointer])

    }

    static void main(String[] args) {
        def groovyBrainfuckGenerator = new GroovyBrainfuckTranslator()
        groovyBrainfuckGenerator.execute()
    }
}