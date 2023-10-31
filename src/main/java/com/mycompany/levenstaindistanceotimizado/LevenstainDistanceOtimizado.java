/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.levenstaindistanceotimizado;

public class LevenstainDistanceOtimizado {
    //aqui criei um metodo para calcular a distância de 'm' que recebe a quantidades de caracteres da palavra1 e 'n' para os caracteres da palavra2
    public static int calcularDistancia(String palavra1, String palavra2) {
        int m = palavra1.length();
        int n = palavra2.length();
        int[][] dp = new int[m + 1][n + 1]; // para armazenar os resultados intermediários do cálculo da distância

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (palavra1.charAt(i - 1) == palavra2.charAt(j - 1)) {  //Se os caracteres atuais das duas strings forem iguais, a distância de Levenshtein na posição (i, j) é igual à distância na posição (i-1, j-1).
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]); //Se os caracteres atuais das duas strings forem diferentes, a distância de Levenshtein na posição 
                                                                                                       //(i, j) é calculada como 1 mais o mínimo entre a distância acima, a distância à esquerda e a 
                                                                                                       //distância diagonal acima à esquerda
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] strings = { "derradeiro", "cavalheiro", "companheiro", "sorrateiro", "galinheiro","lampeiro","zambujeiro","negreiro","enfermeiro" };//aqui ficam as palavras para se comparar com a palavra alvo
        String target = "corriqueiro";// aqui está a palavra alvo
        
        //utilizei o foreach para usar a String1(palavra1) para procurar dentro da String2(palavra2) para detectar a distância entre elas
        for (String str : strings) {
            int distancia = calcularDistancia(str, target);
            System.out.println("A distância de Levenshtein entre '" + str + "' e '" + target + "' é: " + distancia);
        }
    }
}

