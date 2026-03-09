/*

Projeto Calculadora Ciêntifica em Java
09/03/2026
João Lucas de Lima Souza - RA:00360044
Pedro Chagas Neves de Farias Nascimento - RA:00359511    
   
*/
import java.util.Scanner; 

public class Entrada {
    // Cria a instância do Scanner para entrada de dados
    Scanner sc = new Scanner(System.in);

    public String lerString(String mensagem){
        System.out.print(mensagem);
        return sc.nextLine();
    }

    public void fechar() {
        //Fecha o Scanner
        sc.close();
    }
}