//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Pila pila = new Pila();
    //String cadena = "HOLA";

    //String resultado = pila.invierteCadena(cadena);
    //System.out.println(resultado);

    String cadena2 = "(([{{()}}]))"; // Es correcto
    String cadena3 = "{())}"; // Esta mal a proposito

    boolean resultado2 = pila.revisarSintaxis(cadena2);
    System.out.println("-- Ejercicio 4 --");
    System.out.println("Sintaxis correcta:");
    System.out.println("Cadena enviada:" + cadena2 + "\nResultado:" + resultado2);

    boolean resultado2_2 = pila.revisarSintaxis(cadena3);
    System.out.println("\nSintaxis INCORRECTA:");
    System.out.println("Cadena enviada:" + cadena3 + "\nResultado:" + resultado2_2);


    int[] numeros = new int[7];
    int[] numeros2 = new int [10];

    int c = 0;

    for (int i = 5 ; i > 0 ; i--) {

        numeros[c] = i;

        numeros2[c] = i - 2;

        c++;
    }

    numeros[5] = 2;
    numeros[6] = 4;


    numeros2[5] = 100;
    numeros2[6] = 64;
    numeros2[7] = 31;
    numeros2[8] = 3;
    numeros2[9] = 0;

    Pila<Integer> resultado3 = pila.ordenarVector(numeros);
    Pila<Integer> resultado4 = pila.ordenarVector(numeros2);

    System.out.println("\n-- Ejercicio 5 --");
    System.out.println("Ejemplo 1:");
    while (!resultado3.vacia()) {
        System.out.println(resultado3.pop());
    }

    System.out.println("\nEjemplo 2:");
    while (!resultado4.vacia()) {
        System.out.println(resultado4.pop());
    }

}