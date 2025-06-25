package main;

import java.util.*;

public class LogicaClasificacion {
    private Stack<Character> caracteres;
    private Stack<Character> simbolos;
    private Stack<Integer> auxliliar;

    public LogicaClasificacion() {
        this.caracteres = new Stack<>(); 
        this.simbolos = new Stack<>();
        this.auxliliar = new Stack<>();
    }
    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */


    public String invertirCadena(String texto) {

        int tam = texto.length();
        for(int i=0; i<tam; i++){
            caracteres.push(texto.charAt(i));
        }

        String invertida = "";
        while(!caracteres.isEmpty()) {
            invertida += caracteres.pop();
        }
        return invertida;
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {
        int tam = expresion.length();
        for(int i = 0; i<tam; i++){
            char c = expresion.charAt(i);

            if(c == '(' || c =='[' || c == '{'){
                simbolos.push(c);

            }else if (c == ')' || c ==']' || c == '}'){
                if(simbolos.isEmpty()){
                    return false;
                }

                char top = simbolos.pop();
                if(c== ')' && top != '('||c== ']' && top != '['||c== '}' && top != '{'){
                    return false;
                }


            }else{
                return false;
            }
        }

        return simbolos.isEmpty();
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        while(!pila.isEmpty()){
            int num = pila.pop();

            while(!auxliliar.isEmpty() && auxliliar.peek()<num){
                pila.push(auxliliar.pop());
            }

            auxliliar.push(num);    
        }

        List<Integer> resultado = new ArrayList<>();
        while(!auxliliar.isEmpty()){
            resultado.add(auxliliar.pop());
        }

        return resultado;
    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        List<Integer> listaPares = new LinkedList<>();
        List<Integer> listaImpares = new LinkedList<>();


        for(int num : original){
            if(num %2 == 0){
                listaPares.add(num);
            }else{
                listaImpares.add(num);
            }
        }

        listaPares.addAll(listaImpares);

        return listaPares;
    }
}
