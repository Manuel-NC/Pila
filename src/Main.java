//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Pila pila = new Pila();
    String cadena = "HOLA";

    String resultado = pila.invierteCadena(cadena);
    System.out.println(resultado);

    String cadena2 = "(([{{()}}]))";
    boolean resultado2 = pila.revisarSintaxis(cadena2);
    System.out.println(resultado2);

    int[] numeros = new int[6];

    int c = 0;

    for (int i = 5 ; i > 0 ; i--) {
        numeros[c] = i;
        numeros[5] = 2;
        c++;
    }

    Pila<Integer> resultado3 = pila.ordenarVector(numeros);
    Pila<Integer> paraImprimir = new Pila<>(numeros.length);

// Al pasar de una pila a otra, los elementos invierten su orden
    while (!resultado3.vacia()) {
        paraImprimir.push(resultado3.pop());
    }

// Ahora el tope tiene el número menor
    System.out.println("Imprimiendo de menor a mayor:");
    while (!paraImprimir.vacia()) {
        System.out.println(paraImprimir.pop());
    }

}