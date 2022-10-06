package forca;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ForcaTest {

        /*
         * void ControladorDeErros() {
         * ControladorDeErros c = new ControladorDeErros();
         * 
         * }
         * 
         * void controladorDeLetrasJaDigitadas() {
         * ControladorDeLetrasJaDigitadas cl = new ControladorDeLetrasJaDigitadas();
         * 
         * }
         * 
         * void Forca() {
         * Forca f = new Forca();
         * }
         * 
         * void Teclado() {
         * Teclado t = new Teclado();
         * }
         */
        @Test

        void Palavra() throws Exception {
                try {
                        Palavra p = new Palavra(null);
                        System.out.println("Deu certo em contruir palavra null!");
                } catch (Exception err) {
                        System.err.println("Deu erro construir palavra null");
                }

                try {
                        Palavra p1 = new Palavra("");
                        System.out.println("Deu certo em contruir palavra!");
                } catch (Exception err) {
                        System.out.println("Deu erro construir palavra");
                }
                Palavra p2 = null;
                try {
                        p2 = new Palavra("CLASSE");
                        System.out.println("Deu certo construir palavra \"CLASSE\"");
                } catch (Exception err) {
                        System.err.println("Deu erro construir palavra \"CLASSE\"");
                }

                Palavra p3 = null;
                try {
                        p3 = new Palavra("CLASSE");
                        System.out.println("Deu certo construir palavra \"CLASSE\"");
                } catch (Exception err) {
                        System.err.println("Deu erro construir palavra \"CLASSE\"");
                }

                Palavra p4 = null;
                try {
                        p4 = new Palavra("CLASSE");
                        System.out.println("Deu certo construir palavra \"CLASSE\"");
                } catch (Exception err) {
                        System.err.println("Deu erro construir palavra \"CLASSE\"");
                }

                try {
                        System.out.println("A 0a letra 'C' de \"CLASSE\" fica na posicao " +
                                        p2.getPosicaoDaIezimaOcorrencia(-1, 'C'));
                        System.err.println("Achamos a 0a aparicao da letra 'C' em \"CLASSE\" E NAO ERA PARA ACHARMOS");
                } catch (Exception erro) {
                        System.out.println(
                                        "Deu erro ao achar a 0a aparicao da letra 'W' em \"CLASSE\" E ERA PARA DAR ERRO MESMO");
                }

                try {
                        System.out.println("A 1a letra 'L' de \"CLASSE\" fica na posicao " +
                                        p2.getPosicaoDaIezimaOcorrencia(0, 'L'));
                        System.out.println("Achamos a 1a aparicao da letra 'L' em \"CLASSE\"");
                } catch (Exception erro) {
                        System.err.println("Deu erro ao achar a 1a aparicao da letra 'W' em \"CLASSE\"");
                }

                try {
                        System.out.println("A 1a letra 'A' de \"CLASSE\" fica na posicao " +
                                        p2.getPosicaoDaIezimaOcorrencia(0, 'A'));
                        System.out.println("Achamos a 1a aparicao da letra 'A' em \"CLASSE\"");
                } catch (Exception erro) {
                        System.err.println("Deu erro ao achar a 1a aparicao da letra 'W' em \"CLASSE\"");
                }

                System.out.println("\"CLASSE\" tem " + p2.getTamanho() + " letras");
                System.out.println(p2 + " eh a palavra que estamos testando");
                System.out.println("Eh " + p2.equals(null) +
                                " que \"CLASSE\" eh igual (pelo equals) a null");
                System.out.println("Eh " + p2.equals(p2) +
                                " que \"CLASSE\" eh igual (pelo equals) a si mesmo");
                System.out.println("Eh " + p2.equals("CLASSE") +
                                " que \"CLASSE\" eh igual (pelo equals) ao String \"CLASSE\"");
                System.out.println("Eh " + p2.equals(p3) +
                                " que \"CLASSE\" eh igual (pelo equals) a \"CLASSE\"");
                System.out.println("Eh " + p2.equals(p4) +
                                " que \"CLASSE\" eh igual (pelo equals) a \"OBJETO\"");
                System.out.println("Eh " + (p2.hashCode() == p3.hashCode())
                                +
                                " que o hashCode de um \"CLASSE\" eh igual ao hashCode de outro \"CLASSE\"");
                System.out.println("Eh " + (p2.hashCode() == p4.hashCode())
                                + " que o hashCode de \"CLASSE\" eh igual ao hashCode de \"OBJETO\"");
                System.out.println("Um \"CLASSE\" comparado (com compareTo) com outro \"CLASSE\" deu " +
                                p2.compareTo(p4));
                System.out.println("\"CLASSE\" comparado (com compareTo) com \"OBJETO\" deu "
                                + p2.compareTo(p4));
                System.out.println("\"\" comparado (com compareTo) com \"OBJETO\" deu " +
                                p4.compareTo(p2));

        }

}
