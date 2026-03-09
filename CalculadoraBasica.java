/*

Projeto Calculadora Ciêntifica em Java
09/03/2026
João Lucas de Lima Souza - RA:00360044
Pedro Chagas Neves de Farias Nascimento - RA:00359511    
   
*/
public class CalculadoraBasica {
    
    public void calcular(String operando1, String operador, String operando2){ 
        double result = 0;

        if(isNumeric(operando1) && isNumeric(operando2)){ // Verifica se eh numerico
            switch (operador){
                case "-":
                    result = Double.parseDouble(operando1) - Double.parseDouble(operando2);
                    break;
                case "+":
                    result = Double.parseDouble(operando1) + Double.parseDouble(operando2);
                    break;
                case "*":
                case "x": 
                    result = Double.parseDouble(operando1) * Double.parseDouble(operando2);
                    break;
                case "/":
                    double val2 = Double.parseDouble(operando2);
                    if (val2 != 0) {
                        result = Double.parseDouble(operando1) / val2;
                    } else {
                        System.out.println("Erro: Divisao por zero!");
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.println("Operador invalido!!");
                    System.exit(0);
            }    
            
            System.out.printf("Resultado = %.2f\n", result);
        } else {
            System.out.println("Operando invalido!!");
            System.exit(0);
        }
    }

    public boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        boolean foundDecimal = false;
        int start = 0;
        
        // Aceita numeros negativos
        if (str.charAt(0) == '-') {
            if (str.length() == 1) return false;
            start = 1;
        }
        
        for (int i = start; i < str.length(); i++) { // percorre a string
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