	

	/**
	 * Pilha usada para armazenar os operadores e posteriosmente os numeros retirados da Fila para realizacao dos calculos.
	 * */
public class Pilha<X>{
	private Object[] vet;
	private int ultimo;
	
	/**Cria o objeto Pilha.
	 * @param capacidade Recebe o valor referente a capacidade que a Pilha deve ter.
	 * */
	public Pilha(int capacidade){
		this.ultimo = -1;
		this.vet = new Object[capacidade];
	}
	/**Verifica se a Pilha esta vazia.
	 * @return Caso esteja vazia, retorna ultimo = -1.
	 * */
	public boolean isEmpty(){
		return this.ultimo == -1;
	}
	/**Verifica se a Pilha esta cheia.
	 * @return Caso esteja cheia, ultimo = tamanho da Pilha - 1.
	 * */
	public boolean isFull(){
		return this.ultimo == this.vet.length - 1;
	}
	/**Retira um elemento da Pilha.
	 * @return Retira o ultimo elemento colocado na Pilha.
	 * @throws Exception Pilha vazia.
	 * */
	public X pop() throws Exception{
		if(this.isEmpty()){
			throw new Exception("Pilha vazia");
		}
		return (X)this.vet[this.ultimo--];
	}
	
	/**Insere um valor na Pilha.
	 * @param valor Valor a ser inserido na Pilha.
	 * */
	public void push(X valor){
		try{
			this.vet[++this.ultimo] = valor;
		}
		catch(ArrayIndexOutOfBoundsException e){
			reSize(getSize() * 2);
			this.vet[this.ultimo] = valor;
		}
	}
	/**Exibe o ultimo elemento introduzido na Pilha.
	 * @throws Exception Pilha vazia.
	 * @return Ultimo elemento introduzido na Pilha.
	 * */
	public X exibirElementoTopo() throws Exception{
		if(this.isEmpty()){
			throw new Exception("Pilha vazia");
		}
		return (X)this.vet[this.ultimo];
	}
	/**Verifica o tamanho da Pilha.
	 * @return Tamanho da Pilha.
	 * */
	public int getSize(){
		return this.vet.length;
	}
	/**Redimensiona a Pilha caso seja necessario.
	 * @param max Valor referente ao tamanho da Pilha redimensionada.
	 * */
	private void reSize(int max){
	      Object[] aux;
	      aux = new Object[max];
	      for (int i = 0; i < this.ultimo; i++)
	         aux[i] = vet[i];
	      this.vet = aux;
	} 
	/**Verifica o ultimo elemento da Pilha.
	 * @return Primeiro elemento introduzido na Pilha.
	 * */
	public int getUltimo(){
		return this.ultimo;
	}
}