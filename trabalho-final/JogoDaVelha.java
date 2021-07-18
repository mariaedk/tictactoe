import java.util.Scanner;

public class JogoDaVelha {
    //coloca as classes como atributos para poder usar em outros métodos
    Mapa jogoMapa;
    PC jogoPC;
    Jogador jogoJogador;

    private JogoDaVelha(){

        Scanner teclado = new Scanner(System.in);

        //instanciar objetos
        jogoMapa = new Mapa();
        jogoPC = new PC(jogoMapa);
        jogoJogador = new Jogador(jogoMapa);
        
        char desejaJogar;

        do {
            jogar(teclado);
            System.out.println("");
            System.out.println("________________________");
            System.out.println("Do you wish to play again ? (s for yes / n for no)");
            desejaJogar = teclado.next().charAt(0);
            desejaJogar = Character.toUpperCase(desejaJogar);
       } while (desejaJogar == 'S');

    }

        private void jogar(Scanner teclado){
            int jogada = 0;
            System.out.println("\033[H\033[2J");
    
            jogoMapa.limpar();
    
            int sorteio = jogoMapa.sortear(0, 2);

            jogoMapa.desenhar(jogada);

            boolean ganhadorJogador = true;
            boolean ganhadorPc = true;
            boolean jogar = true;

            while(jogar){
                
                if (sorteio == 0){ // JOGADOR COMEÇA

                    jogada++;
                    ganhadorJogador = jogoJogador.jogar(teclado); // se o jogador NAO vencer, retorna TRUE
                    if (ganhadorJogador) { 
                        jogoMapa.desenhar(jogada); 
                        if ((jogada == 9) && ((jogoMapa.verificarGanhador('X') && jogoMapa.verificarGanhador('O')))){
                            System.out.println("... DRAW!");
                            jogar = false;
                            break;
                        }
                        jogada++;
                        ganhadorPc = jogoPC.jogar(); // se retornar true, significa q o pc NAO ganhou
                    }
                    jogoMapa.desenhar(jogada);

                    if (ganhadorPc == false || ganhadorJogador == false){
                        jogar = false;
                        break;
                    } else if ((jogada == 9) && ((jogoMapa.verificarGanhador('X') && jogoMapa.verificarGanhador('O')))){
                        System.out.println("... DRAW!");
                        jogar = false;
                        break;
                    }

                } else if (sorteio == 1) { // PC COMEÇA

                    jogada++; 
                    ganhadorPc = jogoPC.jogar();
                    if (ganhadorPc) { 
                        jogoMapa.desenhar(jogada); 
                        if ((jogada == 9) && ((jogoMapa.verificarGanhador('X') && jogoMapa.verificarGanhador('O')))){
                            jogar = false;
                            System.out.println("... DRAW!");
                            break;
                        } 
                        jogada++;
                        ganhadorJogador = jogoJogador.jogar(teclado); 
                    }
                    jogoMapa.desenhar(jogada); 

                    if (ganhadorPc == false || ganhadorJogador == false) {
                        jogar = false;
                        break;
                    } else if ((jogada == 9) && ((jogoMapa.verificarGanhador('X') && jogoMapa.verificarGanhador('O')))){
                        jogar = false;
                        System.out.println("... DRAW!");
                        break;
                        }
                    }
                }
            }
    public static void main(String[] args) {
        new JogoDaVelha();
    }
}