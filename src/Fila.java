import javax.swing.plaf.synth.SynthSeparatorUI;


/**
 * Classe referente a Fila usada no cálculo de expressões matemáticas.
 * */
public class Fila<X> {
	
		private Object[] vet;
		private int primero,ultimo,quant;
		/**
		 * Criando o objeto Fila.
		 * @param capacidade Recebe o valor referente a capacidade da Fila.
		 * */
		public Fila(int capacidade){
			this.primero = this.ultimo = 0;
			this.quant = 0;
			this.vet = new Object[capacidade];
		}
		/**
		 * Verifica se a Fila está vazia.
		 * @return Fila vazia.
		 * */
		public boolean isEmpty(){
			return this.quant == 0;
		}
		/**
		 * Verifica se a Fila está cheia.
		 * @return Tamanho da Fila.
		 * */
		public boolean isFull(){
			return this.quant == this.vet.length;
		}
		/**
		 * Verifica se a Fila está vazia, se não estiver, retira um elemento da mesma.
		 * @throws Exception Informa que a Pilha está vazia.
		 * @return sai Retorna o número ou operador que está na ultima posição da Fila. 
		 * */
		public X remover() throws Exception{
			X sai;
			if(this.isEmpty()){
				throw new Exception("Pilha vazia");
			}		
			sai = (X)this.vet[this.primero++];
			this.quant--;
			return sai;	
		}
		/**
		 * Insere um valor na Fila.
		 * @param valor Recebe um valor para inserir na fila.
		 * */
		public void inserir(X valor){
			try{
				this.vet[this.ultimo] = valor;
			}
			catch(ArrayIndexOutOfBoundsException e){
				reSize(getSize() * 2);
				this.vet[this.ultimo] = valor;
			}
			finally{
				this.ultimo++;
			    this.quant++;
			}
		}
		/**
		 * Verifica o tamanho da Fila.
		 * @return Tamanho da Fila.
		 * */
		public int getSize(){
			return this.vet.length;
		}
		/**
		 * Redimensiona o tamanho da Fila caso seja necessário.
		 * @param max Tamanho da nova Fila.
		 * */
		private void reSize(int max){
		      Object[] aux;
		      aux = new Object[max];
		      for (int i = this.primero; i < this.ultimo; i++)
		    	  aux[i] = vet[i];
		      this.vet = aux;  
		}   
}