public class Pila<T> {

    private T[] pila;
    private int tope;

    public Pila() {
        pila = (T[]) new Object[10];
        tope = -1;
    }

    public Pila(int capacidad) {
        pila = (T[]) new Object[capacidad];
        tope = -1;
    }

    public boolean push(T dato) {

        boolean seHizoPush = false;

        if(pila.length == tope) {
            System.out.println("Desbordamiento");
        } else {
            tope++;
            pila[tope] = dato;
            seHizoPush = true;
        }
        return seHizoPush;
    }

    public T pop() {
        if(tope == -1) {
            System.out.println("Pila vacia");
            return null;
        } else {
            T dato = pila[tope];
            tope--;
            return dato;
        }
    }

    public boolean vacia() {
        return (tope==-1);
    }

    public boolean llena() {
        return tope >= pila.length;
    }


    public String invierteCadena(String cadena) {

        Pila<Character> pila = new Pila<Character>(cadena.length());
        String combinar = "";

        for (int i = 0 ; i < cadena.length() ; i++) {
            pila.push(cadena.charAt(i));
        }
        while(!pila.vacia()) {
            combinar += pila.pop();
        }
        return combinar;
    }

    public boolean revisarSintaxis(String cadena) {

        Pila<Character> pila = new Pila<>(cadena.length());

        for (int i = 0; i < cadena.length(); i++) {
            char actual = cadena.charAt(i);

            switch (actual) {
                // Las aperturas se apilan directamente
                case '(':
                case '{':
                case '[':
                    pila.push(actual);
                    break;

                // En los cierres, sacamos con pop() y validamos si hace pareja
                case ')':
                    if (pila.vacia() || pila.pop() != '(') {
                        return false;
                    }
                    break;

                case '}':
                    if (pila.vacia() || pila.pop() != '{') {
                        return false;
                    }
                    break;

                case ']':
                    if (pila.vacia() || pila.pop() != '[') {
                        return false;
                    }
                    break;

                // Ignoramos cualquier otro caracter para que no aborte la ejecucion
                default:
                    break;
            }
        }

        return pila.vacia();
    }

    public Pila<Integer> ordenarVector(int[] vector) {
        Pila<Integer> pilaPrincipal = new Pila<>(vector.length);
        Pila<Integer> pilaAuxiliar = new Pila<>(vector.length);

        // Recorremos cada elemento del vector
        for (int i = 0; i < vector.length; i++) {
            int numeroActual = vector[i];

            // Desplazamos a la pila auxiliar los elementos menor o igual al numeroActual
            // Para consultar el tope sin desapilarlo, hacemos un pop() y luego lo devolvemos si es necesario
            while (!pilaPrincipal.vacia()) {
                int tope = pilaPrincipal.pop();

                if (tope <= numeroActual) {
                    // Si el tope es menor o igual, lo movemos a la auxiliar para hacer espacio
                    pilaAuxiliar.push(tope);
                } else {
                    // Si es mayor, lo regresamos a la principal y detenemos la busqueda
                    pilaPrincipal.push(tope);
                    break;
                }
            }

            // Colocamos el numero actual en su posicion correcta
            pilaPrincipal.push(numeroActual);

            // Regresamos todos los elementos de la pila auxiliar a la principal
            while (!pilaAuxiliar.vacia()) {
                pilaPrincipal.push(pilaAuxiliar.pop());
            }
        }

        // Regresa la pila con el mayor en el fondo y el menor en el tope para que se muestre de menor a mayor
        return pilaPrincipal;
    }
}
