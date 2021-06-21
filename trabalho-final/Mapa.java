public class Mapa {

    private char[][] mapa = {{' ', ' ', ' '}, 
                             {' ', ' ', ' '}, 
                             {' ', ' ', ' '}};

    public int sortear(int inicio, int fim){ 
        return (int) ((Math.random() * fim) - inicio);
    }

    public void limpar() {    
        for (int linha = 0; linha < mapa.length; linha++) {
            for (int coluna = 0; coluna < mapa.length; coluna++) {
                mapa[linha][coluna] = ' ';
            }
        }
    }

    public void desenhar(int jogada){
        System.out.println("------------- .. jogada: " + jogada);
        // desenha o tabuleiro
        System.out.println("| " + mapa[0][0] + " | " + mapa[0][1] + " | " + mapa[0][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + mapa[1][0] + " | " + mapa[1][1] + " | " + mapa[1][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + mapa[2][0] + " | " + mapa[2][1] + " | " + mapa[2][2] + " |");
        System.out.println("----------------------------");
    }

    public boolean jogar(int l, int c, char jogador){ 

        if ((mapa[l][c] == ' ') || (mapa[l][c] != 'O') && (mapa[l][c] != 'X')){
            mapa[l][c] = jogador;
            return true;

        } else {
            return false;
        }
    }
    public boolean verificarGanhador(char jogador){ 

        // se retornar true é pq ngm ganhou e false é pq alguem ganhou
        
        boolean vencedor = true;

        boolean condicaoDiagonalDireita = (mapa[0][0] == jogador) && (mapa[1][1] == jogador) && (mapa[2][2] == jogador);
        boolean condicaoDiagonalEsquerda = (mapa[0][2] == jogador) && (mapa[1][1] == jogador) && (mapa[2][0] == jogador);
        boolean linhaHorizontal0 = (mapa[0][0] == jogador) && (mapa[0][1] == jogador) && (mapa[0][2] == jogador);
        boolean linhaHorizontal1 = (mapa[1][0] == jogador) && (mapa[1][1] == jogador) && (mapa[1][2] == jogador);
        boolean linhaHorizontal2 = (mapa[2][0] == jogador) && (mapa[2][1] == jogador) && (mapa[2][2] == jogador);
        boolean linhaVertical0 = (mapa[0][0] == jogador) && (mapa[1][0] == jogador) && (mapa[2][0] == jogador);
        boolean linhaVertical1 = (mapa[0][1] == jogador) && (mapa[1][1] == jogador) && (mapa[2][1] == jogador);
        boolean linhaVertical2 = (mapa[0][2] == jogador) && (mapa[1][2] == jogador) && (mapa[2][2] == jogador);


        if (vencedor){

            // testar a diagonal direita
            if (condicaoDiagonalDireita){ return false; }

            // testa diagonal da esquerda
            if (condicaoDiagonalEsquerda){ return false; }

            // teste horizontal linha 0
            if (linhaHorizontal0){ return false; }

            // teste horizontal linha 1
            if (linhaHorizontal1){ return false; }

            // teste horizontal linha 2
            if (linhaHorizontal2){ return false; }

            // teste vertical coluna 0
            if (linhaVertical0){ return false; }

            // teste vertical coluna 1
            if (linhaVertical1){ return false; }

            // teste vertical coluna 2
            if (linhaVertical2){ return false; }
        }

        return true; // se retorna true, significa que ninguém venceu -- possivel condição empate
    }
}
