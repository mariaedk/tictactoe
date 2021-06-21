public class PC {
    Mapa mapa;
    // atributo mapa para poder usar no metodo jogar
    private char letra = 'O';
    

    public PC (Mapa mapa) {
        // usou o this para usar o atributo da classe, é usado para poder usar o atributo da classe
        this.mapa = mapa;
    }

    public boolean jogar(){ 

        boolean jogadaPC;
        int linha = mapa.sortear(0, 3);
        int coluna = mapa.sortear(0, 3); 
        jogadaPC = mapa.jogar(linha, coluna, letra);

        // jogada PC repetiu
        while (jogadaPC == false){
            linha = mapa.sortear(0, 3);
            coluna = mapa.sortear(0, 3);
            jogadaPC = mapa.jogar(linha, coluna, letra);
        }

        System.out.println("PC["+linha+", "+coluna+"]");
        boolean naoVenceu = mapa.verificarGanhador('O');
        if (naoVenceu == false){
            System.out.println("... PC WON!");
            return false;
        }
        return true;
    }
}
