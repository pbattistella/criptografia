package com.example.cripto2.feature.criptografia;

public class Criptografia {

    //Matriz Alfabeto
    private char[][]  matrizAlfabeto = {
            {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N' }, //Linha 1
            { 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X','Y', 'Z' , '.', '#'} //Linha 2
    };
    //Matriz de Números/Alfabeto
    private int [][] matrizNumeros = {
            { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, 					//Linha 1
            {15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28} //Linha 2
    };

    //Matríz chave
    private int [] [] matrizChave = {{5, -2}, {-7, 3}};

    //Matriz de Números  a serem criptografados
    private int [][] matrizNumerosMensagem;
    //Matriz de números criptografados
    private int [][] matrizNumerosCriptografados;

    //Número de linhas e colunas da Matriz
    private static final int NUM_LIN_MAX = 2; //Duas linhas
    private static final int NUM_COL_MAX = 14;//Quatorze colunas
    private int tamanhoVetMensagem; //tamanho dinâmico do vetor

    //Converter Mensagem em Matríz de Números
    public void converterMsgEmMatriz(String mensagem) {
        setTamanhoVetMensagem(mensagem.length());
        if (mensagem.length() % 2 == 1) {
            mensagem += "#";
        }
        //Criar a matriz de números
        int indiceAux = 0;
        int [] [] matrizAux =  new int [NUM_LIN_MAX][this.tamanhoVetMensagem];
        for (int i = 0; i < NUM_LIN_MAX; i++) {
            for (int j = 0; j < this.tamanhoVetMensagem; j++) {
                //trocar letra pelo número
                matrizAux[i][j] = buscarNumeroDaLetra( mensagem.charAt(indiceAux) );
                indiceAux++;
            }
        }
        this.matrizNumerosMensagem = matrizAux;
        this.matrizNumerosCriptografados = new int [NUM_LIN_MAX ][this.tamanhoVetMensagem];
    }

    //definir tamanho do vetor de mensagem
    private void setTamanhoVetMensagem(int numero) {
        //Define tamanho da matriz
        if (numero % 2 == 1) {
            numero++;
        }
        this.tamanhoVetMensagem =  numero / 2;
    }

    //método busca valor número da letra
    private int buscarNumeroDaLetra(char letra) {
        int numero = this.matrizNumeros[1][13];//inicializa com espaço
        //procurar número da letra
        for (int i = 0; i < NUM_LIN_MAX; i++) {
            for (int j = 0; j < NUM_COL_MAX; j++) {
                if (letra == this.matrizAlfabeto[i][j] ) {
                    numero = this.matrizNumeros[i][j];
                    break;
                }
            }
        }
        return numero;
    }

    //método para criptografar
    public void criptografar() {
        for (int i = 0; i < this.tamanhoVetMensagem; i++) {
            this.matrizNumerosCriptografados[0][i] = this.matrizNumerosMensagem[0][i] * this.matrizChave[0][0]
                    + this.matrizNumerosMensagem[1][i] * this.matrizChave[0][1];
            this.matrizNumerosCriptografados[1][i] = this.matrizNumerosMensagem[0][i] * this.matrizChave[1][0]
                    + this.matrizNumerosMensagem[1][i] * this.matrizChave[1][1];

        }
    }

    public String toString() {
        //matriz de números

        String texto = "*****Matriz de números*******";
        for (int i = 0; i< NUM_LIN_MAX; i++) {
            texto += "\n[";
            for (int j = 0; j < this.tamanhoVetMensagem; j++) {
                texto += " " + this.matrizNumerosMensagem[i][j] + ",";
            }
            texto += "]";
        }


        //matriz criptografada
        texto += "\n******Matríz criptografada*********";
        for (int i = 0; i< NUM_LIN_MAX; i++) {
            texto += "\n[";
            for (int j = 0; j < this.tamanhoVetMensagem; j++) {
                texto += " " + this.matrizNumerosCriptografados[i][j] + ",";
            }
            texto += "]";
        }
        return texto;
    }
}
