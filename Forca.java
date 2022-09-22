import java.io.*;
import java.io.IOException;

public class Forca
{
    public static void main (String args []) throws InterruptedException, IOException
    {
        char continuar = ' ';
		Forca f = new Forca();

        do
        {			
			f.Tela();


			Palavra palavra =
			BancoDePalavras.getPalavraSorteada();
			
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
				
				System.out.println ("\t\t Palavra...: "+tracinhos);
				System.out.println ("\t\t Digitadas.: "+controladorDeLetrasJaDigitadas);
				System.out.println ("\t\t Erros.....: "+controladorDeErros);

				try
				{
					System.out.print   ("\t\t Qual letra? ");
					char letra = Character.toUpperCase (Teclado.getUmChar());

					if (controladorDeLetrasJaDigitadas.isJaDigitada (letra))
					{
						System.err.println ("\tEssa letra ja foi digitada!\n");
						//System.in.read();
					}
					else
					{
						controladorDeLetrasJaDigitadas.registre (letra);

						int qtd = palavra.getQuantidade (letra);

						if (qtd==0)
						{
							System.err.println ("\tA palavra nao tem essa letra!\n");
							controladorDeErros.registreUmErro ();
							//System.out.println ();
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
					}
				}
				catch (Exception erro)
				{
					System.err.println (erro.getMessage());
				}
			}

			if (controladorDeErros.isAtingidoMaximoDeErros ())
				System.out.println ("\tQue pena! Voce perdeu! A palavra era "+palavra+"\n");
			else // !tracinhos.isAindaComTracinhos()
				System.out.println ("\tParabens! Voce ganhou! A palavra era mesmo "+palavra+"\n");

			for(;;)
			{
				try
				{
					System.out.print ("\tDeseja jogar de novo (S/N)? ");
					continuar = Character.toUpperCase (Teclado.getUmChar());
					if (continuar!='S' && continuar!='N')
						System.err.println ("\tOpcao invalida! Tente novamente...");
					else
						break;
				}
				catch (Exception erro)
				{
					System.err.println ("\tOpcao invalida! Tente novamente...");
					//System.in.read();
				}
			}
		}
        while (continuar=='S');
    }

	public void Tela() throws InterruptedException, IOException {

		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_YELLOW = "\u001B[33m";


		if (System.getProperty("os.name").contains("Windows"))
            	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		else
			Runtime.getRuntime().exec("clear");
		
		System.out.println("\t\t**************************************************************************************");
		System.out.println("\t\t*****************************" + ANSI_YELLOW + "BEM VINDO AO JOGO DA FORCA" + ANSI_RESET + "*******************************");
		System.out.println("\t\t**************************************************************************************");
	}
}
