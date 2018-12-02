/**Esta Classe implementa a tabela referente aos operadores que sao resgatados da expressao e diz se devem ou nao ser retirados da Pilha.
 * */

public class Tabela {
	private static char[] vetor = {'(','^','*','/','+','-',')'};
	private static boolean[][] matriz = {{false,false,false,false,false,false,true},
										{false,true,true,true,true,true,true},
										{false,false,true,true,true,true,true},
										{false,false,true,true,true,true,true},
										{false,false,false,false,true,true,true},
										{false,false,false,false,true,true,true},
										{false,false,false,false,false,false,false}};
	
	/**
	 * @param opr Recebe um operador. 
	 * @return Retorna a posicao do vetor.
	 * */
	private static int getPosicao(char opr){
		int ret = -1;
		for(int i = 0;i<Tabela.vetor.length;i++){
			if(Tabela.vetor[i] == opr){
				ret = i;
				break;
			}					
		}
		return ret;		
	}	
	
	/**
	 * Metodo utilizado para saber se devemos ou nao desempilhar um elemento da pilha.
	 * @param opr1 Representa o simbolo que esta no topo da Pilha.
	 * @param opr2 Representa o simbolo pego na sequencia da expressao.
	 * @return Retorna a posicao da tabela que se verdadeiro, desempilha, se nao, nao desempilha.
	 * @throws Exception Retorna operacao invalida.
	 */
	public static boolean devoDesempilhar(char opr1, char opr2) throws Exception{
		int pos1 = Tabela.getPosicao(opr1);
		int pos2 = Tabela.getPosicao(opr2);
		if(pos1 == -1){
			throw new Exception("Operação inválida");
		}
		if(pos2 == -1){
			throw new Exception("Operação inválida");
		}
		return Tabela.matriz[pos1][pos2];
	}
}