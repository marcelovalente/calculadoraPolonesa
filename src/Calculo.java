
public class Calculo {
	/**
	 * Valida o símbolo para o tipo de operação.
	 * @param opr Tipo de símbolo passado por parâmetro.
	 * @return Verdadeiro, caso a comparação com o regex for bem sucedida, caso contrário, false.
	 * */
	public static boolean validarSimbolos(String opr){
		String regex = "[(/*--+^)]";
		return opr.matches(regex);	
	}
	/**
	 * Valida o operador para o tipo de operação.
	 * @param opr Tipo de operador passado por parâmetro.
	 * @return Verdadeiro, caso a comparação com o regex for bem sucedida, caso contrário, false.
	 * */
	public static boolean validarOperador(String opr){
		String regex = "[/*--+^]";
		return opr.matches(regex);	
	}
	/**
	 * Realiza as operações dos elementos retirados da pilha.
	 * @param num1 Recebe o segundo número retirado da pilha.
	 * @param num2 Recebe o primeiro número retirado da pilha.
	 * @param opr Recebe o operador retirado da pilha.
	 * @return Retorna o resultado ou Cálculo invalido.
	 * @throws Exception Informa que o Cálculo é invalido.
	 * */
	public static double realizarOperacao(double num1,double num2, char opr)throws Exception{
		double result;
		switch(opr){
			case '+': result = num1 + num2; return result;
			case '-': result = num1 - num2; return result;
			case '/': 
				if(num2 == 0){
					throw new Exception("Cálculo inválido");
				}
				result = num1 / num2; return result;
			case '*': result = num1 * num2; return result;
			case '^': result = Math.pow(num1, num2); return result;
			default: return 0;		
		}
	}
}