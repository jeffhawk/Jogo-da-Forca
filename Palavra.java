public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
		// verifica se o texto recebido é nulo ou então vazio,
		// ou seja, sem nenhum caractere, lançando exceção.
		// armazena o texto recebido em this.texto.
    	if(texto == null || texto.isBlank()) throw new Exception ("Por favor, entre com um texto válido!");
    	
    	this.texto = texto;
    	
    }

    public int getQuantidade (char letra)
    {
        // percorre o String this.texto, conta e retorna
        // quantas letras existem nele iguais a letra fornecida
    	int word = 0;
    	for(int i=0; i<this.getTamanho(); i++)
    	{
    		if (this.texto.charAt(i) == letra)
    			word++;
    	}
    	
    	return word;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        // se i==0, retorna a posicao em que ocorre a primeira
        // aparicao de letra fornecida em this.texto;
        // se i==1, retorna a posicao em que ocorre a segunda
        // aparicao de letra fornecida em this.texto;
        // se i==2, retorna a posicao em que ocorre a terceira
        // aparicao de letra fornecida em this.texto;
        // e assim por diante.
        // lan�ar excecao caso nao encontre em this.texto
        // a I�zima apari��o da letra fornecida.
    	int[] lis = new int[this.getTamanho()];
    	int k = 0, j = 0, ret=0;
    	
    	for(k=0; k < this.getTamanho(); k++)
		{
			if(this.texto.charAt(k) == letra)
			{
				
				lis[j] = k;
				j++;
				System.out.printf("Achou na posíção: %3d \n", k);
			}
			
			
		}
    	
    	if (j==0) throw new Exception("Letra não encontrada no texto");
    	else
    	{
    		for(k=0; k < j; k++)
    		{
    			if (k==i) ret = lis[k];
    		}	
    	}
		return ret;
    	  	
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    @Override
    public String toString ()
    {
        return this.texto;
    }

    @Override
    public boolean equals (Object obj)
    {
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo
    	if (this == obj) return true;
    	
    	if (obj == null) return false;
    	
    	if (this.getClass() != obj.getClass()) return false;
    	
    	Palavra pala = (Palavra) obj;
    	
    	if (this.texto != pala.texto) return false;
    	
    	if (this.getTamanho() != pala.getTamanho()) return false;
    	
    	for (int i=0; i< this.getTamanho(); i++)
    	{
    		if(this.texto.charAt(i) != pala.texto.charAt(i)) return false;
    	}
    	
    	return true;
    	
    	
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this
    	int ret = 1982;
    	
    	ret = 13*ret + this.getTamanho();
    	
    	ret = 13*ret + this.hashCode();
    	
    	return ret;
    }

    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
