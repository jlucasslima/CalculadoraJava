/*

Projeto Calculadora Ciêntifica em Java
09/03/2026
João Lucas de Lima Souza - RA:00360044
Pedro Chagas Neves de Farias Nascimento - RA:00359511    
   
*/
import java.util.Scanner; 

/**
 * Classe utilitaria para gerenciar a entrada de dados do usuario via console.
 */
public class Entrada {
    
    /** * Cria a instancia do Scanner para leitura de dados da entrada padrao (System.in). 
     */
    Scanner sc = new Scanner(System.in);

    /**
     * Exibe uma mensagem no console e le a linha digitada pelo usuario.
     * * @param mensagem Texto a ser exibido solicitando a entrada de dados.
     * @return A string digitada pelo usuario.
     */
    public String lerString(String mensagem){
        System.out.print(mensagem);
        return sc.nextLine();
    }

    /**
     * Fecha o recurso do Scanner, liberando o fluxo de entrada.
     */
    public void fechar() {
        sc.close();
    }
}