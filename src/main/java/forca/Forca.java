package forca;

import java.io.IOException;

public class Forca
{
	final static String ANSI_RESET = "\u001B[0m";
	final String ANSI_YELLOW = "\u001B[33m";
	final static String ANSI_RED = "\u001B[31m";
	final static String ANSI_BLUE = "\u001B[34m";
	static String mess = "";
    public static void main (String args []) throws InterruptedException, IOException
    {
        char continuar = ' ';
		Forca f = new Forca();
		

        do
        {			
			f.Tela();
			Palavra palavra = BancoDePalavras.getPalavraSorteada();
			Tracinhos tracinhos = null;

			try
			{
			    tracinhos = new Tracinhos (palavra.getTamanho());
            }
            catch (Exception erro)
            {}
            
			ControladorDeLetrasJaDigitadas
			controladorDeLetrasJaDigitadas =
			new ControladorDeLetrasJaDigitadas ();
			
			ControladorDeErros controladorDeErros = null;
			try
			{
			    controladorDeErros = new ControladorDeErros ((int)(palavra.getTamanho()*0.6));
			}
			catch (Exception erro)
			{}

			while (tracinhos.isAindaComTracinhos() && 
				!controladorDeErros.isAtingidoMaximoDeErros())
			{
				f.Tela();
				System.out.println ("\t\t Palavra...: "+tracinhos);
				System.out.println ("\t\t Digitadas.: "+controladorDeLetrasJaDigitadas);
				System.out.println ("\t\t Erros.....: "+controladorDeErros);
				System.out.println (mess);
				mess = "";
				try
				{
					System.out.print   (ANSI_BLUE + "\t\t Qual letra? " + ANSI_RESET);
					char letra = Character.toUpperCase (Teclado.getUmChar());

					if (controladorDeLetrasJaDigitadas.isJaDigitada (letra))
					{
						mess = "\t\t Essa letra ja foi digitada!"; 
						//System.err.println ("\n\n\t\t Essa letra ja foi digitada!\n");
						System.err.println (mess);
						//System.in.read();
					}
					else
					{
						
						controladorDeLetrasJaDigitadas.registre (letra);

						int qtd = palavra.getQuantidade (letra);

						if (qtd==0)
						{
							//String teste = "";
							mess = "\t\t A palavra nao tem essa letra!";
							System.err.println (mess);
							controladorDeErros.registreUmErro ();
							//System.out.println ();
							//teste = ANSI_RED + letra;
							//letra = teste.charAt(10);
							
						}
						else
						{
							for (int i=0; i<qtd; i++)
							{
								int posicao = palavra.getPosicaoDaIezimaOcorrencia (i,letra);
								tracinhos.revele (posicao, letra);
							}
							System.out.println ();
						}
						//controladorDeLetrasJaDigitadas.registre (letra);
					}
				}
				catch (Exception erro)
				{
					System.err.println (erro.getMessage());
				}
			}

			if (controladorDeErros.isAtingidoMaximoDeErros ())
				System.out.println ("\t\t Que pena! Voce perdeu! A palavra era "+palavra+"\n");
			else // !tracinhos.isAindaComTracinhos()
				System.out.println ("\t\t Parabens! Voce ganhou! A palavra era mesmo "+palavra+"\n");

			for(;;)
			{
				try
				{
					System.out.print ("\t\t Deseja jogar de novo (S/N)? ");
					continuar = Character.toUpperCase (Teclado.getUmChar());
					if (continuar!='S' && continuar!='N')
						System.err.println ("\t\t Opcao invalida! Tente novamente...");
					else
						break;
				}
				catch (Exception erro)
				{
					System.err.println ("\t\t Opcao invalida! Tente novamente...");
					//System.in.read();
				}
			}
		}
        while (continuar=='S');
    }

	public void Tela() throws InterruptedException, IOException {

		


		if (System.getProperty("os.name").contains("Windows"))
            	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		else
			Runtime.getRuntime().exec("clear");
		
		System.out.println("\t\t" + ANSI_BLUE + "**************************************************************************************" + ANSI_RESET);
		System.out.println("\t\t" + ANSI_BLUE + "*****************************" + ANSI_RESET + ANSI_YELLOW + "BEM VINDO AO JOGO DA FORCA" + ANSI_BLUE + "*******************************" + ANSI_RESET);
		System.out.println("\t\t" + ANSI_BLUE + "**************************************************************************************" + ANSI_RESET);
		//System.err.println("Teste");
	}
}
