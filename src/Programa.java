import java.text.NumberFormat;
import java.util.*;
/**Programa utilizado para calcular expressoes matematicas a partir da notacao polonesa.
 * @author Guilherme, Marcelo, Thales.
 * @version 1.0.1
 * @since 03/05/2016
 * */
public class Programa {
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		Scanner leitor = new Scanner(System.in);
		Fila<String> fila = new Fila<String>(4);
		Pilha<String> pilha = new Pilha<String>(4);
		String expressao = new String();
		String elementoTopo = new String();
		System.out.println("Digite uma expressão: ");
		expressao = leitor.nextLine();
		expressao = expressao.replaceAll("\\s", "");
		StringTokenizer quebrador = new StringTokenizer(expressao,"+-*/^()",true);	
		
		while(quebrador.hasMoreTokens()){
			
			String proximoValor = quebrador.nextToken();
			try{
				double valor;
				valor = Double.parseDouble(proximoValor);
				fila.inserir(String.valueOf(valor));
			}
			catch(Exception e){
				if(Calculo.validarSimbolos(proximoValor)){
					boolean desempilhar = false;
					try{
						elementoTopo = pilha.exibirElementoTopo();
					}
					catch(Exception e1){
						pilha.push(proximoValor);
						continue;
					}
					do{
						try{
							desempilhar = Tabela.devoDesempilhar(elementoTopo.charAt(0),proximoValor.charAt(0));
						}
						catch(Exception e2){
							System.out.println("Expressão inválida");
							System.exit(1);
						}
						if(desempilhar){
							try{
								elementoTopo = pilha.pop();
								if(Calculo.validarOperador(elementoTopo)){
									fila.inserir(elementoTopo);	
								}
								try{
									elementoTopo = pilha.exibirElementoTopo();
								}
								catch(Exception e1){
									break;
								}
							}
							catch(Exception e3){
								break;
							}		
						}   
					}while(desempilhar == true);
					if(proximoValor.charAt(0)!= ')'){
						pilha.push(proximoValor);
					}
				}
				else{
					System.out.println("Expressão inválida");
					System.exit(1);
				}
			}		
		}
		while(pilha.getUltimo() != -1){
			try{
				elementoTopo = pilha.pop();
				if(Calculo.validarOperador(elementoTopo)){
					fila.inserir(elementoTopo);
				}
			}
			catch(Exception e){}			
		}
		while(!fila.isEmpty()){
			double valor1 = 0,valor2 = 0,result;
			String valorRetirado;
			try{
				valorRetirado = fila.remover();
			}
			catch(Exception e){
				break;
			}
			try{
				valor1 = Double.parseDouble(valorRetirado);
				pilha.push(String.valueOf(valor1));
			}
			catch(NumberFormatException e1){
				String opr = valorRetirado;
				try{
					valorRetirado = pilha.pop();
					valor1 = Double.parseDouble(valorRetirado);
				}
				catch(Exception e2){
					System.out.println("Expressão inválida");
					System.exit(1);
				}
				try{
					valorRetirado = pilha.pop();
					valor2 = Double.parseDouble(valorRetirado);
				}
				catch(Exception e2){
					System.out.println("Expressão inválida");
					System.exit(1);
				}
				try{
					result = Calculo.realizarOperacao(valor2,valor1,opr.charAt(0));
					pilha.push(String.valueOf(result));
				}
				catch(Exception e){
					System.out.println("Expressão inválida");
					System.exit(1);
				}
			}
		}
		try{
			Double resultFinal = Double.parseDouble(pilha.pop());
			System.out.format(" = "+NumberFormat.getInstance().format(resultFinal));
			}
		catch(Exception e){}
	}
}