/*

Projeto Calculadora Ciêntifica em Java
09/03/2026
João Lucas de Lima Souza - RA:00360044
Pedro Chagas Neves de Farias Nascimento - RA:00359511    
   
*/
public class AplicacaoCientifica {
    //Vetor de string para dados da linha de comando
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

    private static boolean isBasica(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.toLowerCase().equals("x");
    }

    private static boolean isCientifica(String op) {
        String o = op.toLowerCase();
        return o.equals("seno") || o.equals("fatorial") || o.equals("inverso");
    }

    public static void executar(String s1, String op, String s2) {
        if (isBasica(op)) {
            CalculadoraBasica cb = new CalculadoraBasica();
            cb.calcular(s1, op, s2);
        } else if (isCientifica(op)) {
            CalcCientifica cc = new CalcCientifica();
            cc.calcular(s1, op);
        } else {
            System.out.println("Operador invalido!!");
            System.exit(0);
        }
    }
}