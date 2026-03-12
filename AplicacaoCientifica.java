/*

Projeto Calculadora Ciêntifica em Java
09/03/2026
João Lucas de Lima Souza - RA:00360044
Pedro Chagas Neves de Farias Nascimento - RA:00359511    
   
*/

/**
 * Classe principal que gerencia a execucao da Calculadora Cientifica.
 * Permite a entrada de dados tanto via argumentos de linha de comando quanto via interacao com o usuario.
 */
public class AplicacaoCientifica {
    
    /**
     * Metodo principal (ponto de entrada) da aplicacao.
     * * @param args Vetor de strings para receber dados diretamente da linha de comando.
     */
    public static void main(String args[]) {
        String operando1 = "", operador = "", operando2 = "0"; 

        if (args.length == 0) { 
            Entrada ent = new Entrada();
            operando1 = ent.lerString("Forneca o valor 1: ");
            operador = ent.lerString("Forneca operacao (seno, fatorial, inverso ou +,-,*,/,x): ");
            
            if (isBasica(operador)) {
                operando2 = ent.lerString("Forneca o valor 2: ");
            }
            
            ent.fechar(); 
            executar(operando1, operador, operando2);

        } else if (args.length >= 2) { 
            operando1 = args[0];
            operador = args[1];
            if (args.length == 3) {
                operando2 = args[2];
            }
            executar(operando1, operador, operando2);
            
        } else {
            System.out.println("Numero de parametros invalido!");
            System.exit(0);
        }
    }

    /**
     * Verifica se o operador fornecido corresponde a uma operacao matematica basica.
     * * @param op String contendo o operador a ser verificado.
     * @return true se for um operador basico (+, -, *, /, x), false caso contrario.
     */
    public static boolean isBasica(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.toLowerCase().equals("x");
    }

    /**
     * Verifica se o operador fornecido corresponde a uma operacao matematica cientifica.
     * * @param op String contendo o operador a ser verificado.
     * @return true se for um operador cientifico (seno, fatorial, inverso), false caso contrario.
     */
    public static boolean isCientifica(String op) {
        String o = op.toLowerCase();
        return o.equals("seno") || o.equals("fatorial") || o.equals("inverso");
    }

    /**
     * Encaminha os operandos e o operador para a classe de calculo apropriada (Basica ou Cientifica).
     * * @param s1 Primeiro operando em formato de String.
     * @param op Operador matematico em formato de String.
     * @param s2 Segundo operando em formato de String (pode ser "0" em operacoes unarias).
     */
    public static void executar(String s1, String op, String s2) {
        CalcCientifica calc = new CalcCientifica();

        if (isBasica(op)) {
            calc.calcular(s1, op, s2);
        } else if (isCientifica(op)) {
            calc.calcular(s1, op);
        } else {
            System.out.println("Operador invalido!!");
            System.exit(0);
        }
    }
}