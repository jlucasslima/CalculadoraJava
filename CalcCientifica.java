/*

Projeto Calculadora Ciêntifica em Java
09/03/2026
João Lucas de Lima Souza - RA:00360044
Pedro Chagas Neves de Farias Nascimento - RA:00359511    
   
*/
public class CalcCientifica {
    
    public void calcular(String operando1, String operador) {
        
        if (isNumeric(operando1)) {
            double val = Double.parseDouble(operando1);
            double result = 0;

            switch (operador.toLowerCase()) {
                case "seno":
                    result = Math.sin(Math.toRadians(val));
                    System.out.printf("Resultado Seno = %.4f\n", result);
                    break;
                case "fatorial":
                    if (val < 0) {
                        System.out.println("Erro: Nao existe fatorial de numero negativo!");
                        System.exit(0);
                    } else {
                        System.out.println("Resultado Fatorial = " + calcularFatorial((int) val));
                    }
                    break;
                case "inverso":
                    if (val != 0) {
                        result = 1.0 / val;
                        System.out.printf("Resultado Inverso = %.4f\n", result);
                    } else {
                        System.out.println("Erro: Divisao por zero no inverso!");
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.println("Operador cientifico invalido!!");
                    System.exit(0);
            }
        } else {
            System.out.println("Operando invalido!!");
            System.exit(0);
        }
    }

    private long calcularFatorial(int n) {
        long fat = 1;
        for (int i = 2; i <= n; i++) {
            fat *= i;
        }
        return fat;
    }

    private boolean isNumeric(String str) {
        if (str == null || str.length() == 0) return false;

        boolean foundDecimal = false;
        int start = 0;
        
        if (str.charAt(0) == '-') {
            if (str.length() == 1) return false;
            start = 1;
        }
        
        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) { 
                if (c == '.' && !foundDecimal) { 
                    foundDecimal = true;
                } else {
                    return false;
                }
            }
        }            
        return true;
    }
}