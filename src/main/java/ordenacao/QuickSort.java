package ordenacao;

import hash.NoListaEncadeadaDeputadoItem2;
import hash.NoListaEncadeadaPartidoItem2;
import java.util.Random;
import model.Gasto;
import model.Resultado;

/**
 * Uma das maiores classes do sistema, ela é responsável por implementar 3 cenários do Item 1 e a ordenação dos gastos dos deputados e dos partidos.
 * A forma como foi implementado o QuickSort será detalhado no relatório
 */

public class QuickSort {

//QuickSort utilizado para o cenário 1    
    private void quickSortObjeto(Gasto vetor[], Integer esquerda, Integer direita, Resultado resultado) {
        Gasto pivo;
        pivo = vetor[(esquerda + direita) / 2];
        Integer esq = esquerda;
        Integer dir = direita - 1;
        do {
            resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            Boolean auxiliar = true;
            Boolean auxiliar2 = true;
            while (auxiliar) {
                if (vetor[esq].getReceipt_value() < pivo.getReceipt_value() && esq < direita) {
                    esq++;
                } else {
                    auxiliar = false;
                }
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            }
            while (auxiliar2) {
                if (vetor[dir].getReceipt_value() > pivo.getReceipt_value() && dir > esquerda) {
                    dir--;
                } else {
                    auxiliar2 = false;
                }
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            }
            if (esq <= dir) {
                resultado.setNumTrocas(resultado.getNumTrocas() + 2);
                Gasto aux = vetor[esq];
                vetor[esq] = vetor[dir];
                vetor[dir] = aux;
                esq++;
                dir--;
            }
        } while (esq <= dir);
        if (esq < direita) {
            quickSortObjeto(vetor, esq, direita, resultado);
        }
        if (dir > esquerda) {
            quickSortObjeto(vetor, esquerda, dir + 1, resultado);
        }
    }

    public void ordenaObjeto(Gasto vetor[], Resultado resultado) {
        long tempoInicial = System.nanoTime();
        quickSortObjeto(vetor, 0, vetor.length, resultado);
        resultado.setTempoGasto(System.nanoTime() - tempoInicial);
    }

// QuickSort utilizado para o Cenário 1 e 2.    
    private void quickSortInteiro(Integer vetor[], Integer esquerda, Integer direita, Resultado resultado) {
        Integer pivo;
        pivo = vetor[(esquerda + direita) / 2];
        Integer esq = esquerda;
        Integer dir = direita - 1;
        do {
            resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            Boolean auxiliar = true;
            Boolean auxiliar2 = true;
            while (auxiliar) {
                if (vetor[esq] < pivo && esq < direita) {
                    esq++;
                } else {
                    auxiliar = false;
                }
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            }
            while (auxiliar2) {
                if (vetor[dir] > pivo && dir > esquerda) {
                    dir--;
                } else {
                    auxiliar2 = false;
                }
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            }
            if (esq <= dir) {
                resultado.setNumTrocas(resultado.getNumTrocas() + 2);
                Integer aux = vetor[esq];
                vetor[esq] = vetor[dir];
                vetor[dir] = aux;
                esq++;
                dir--;
            }
        } while (esq <= dir);
        if (esq < direita) {
            quickSortInteiro(vetor, esq, direita, resultado);
        }
        if (dir > esquerda) {
            quickSortInteiro(vetor, esquerda, dir + 1, resultado);
        }
    }

    public void ordenaInteiro(Integer vetor[], Resultado resultado) {
        long tempoInicial = System.nanoTime();
        quickSortInteiro(vetor, 0, vetor.length, resultado);
        resultado.setTempoGasto(System.nanoTime() - tempoInicial);
    }

//Cenário 2 - QuickSort com mediana
    private void quickSortInteiroMediana(Integer vetor[], Integer esquerda, Integer direita, Resultado resultado, Integer numParaMediana) {
        Integer[] indicesAleatorios = new Integer[numParaMediana];
        Integer esq = esquerda;
        Integer dir = direita - 1;
        Integer pivo;
        Random gerador = new Random();
        for (Integer i = 0; i < numParaMediana; i++) {
            indicesAleatorios[i] = vetor[gerador.nextInt(direita - esquerda) + esquerda];
        }
        auxOrdenaInteiroMediana(indicesAleatorios, resultado);
        pivo = indicesAleatorios[numParaMediana / 2];
        do {
            resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            Boolean auxiliar = true;
            Boolean auxiliar2 = true;
            while (auxiliar) {
                if (vetor[esq] < pivo && esq < direita) {
                    esq++;
                } else {
                    auxiliar = false;
                }
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            }
            while (auxiliar2) {
                if (vetor[dir] > pivo && dir > esquerda) {
                    dir--;
                } else {
                    auxiliar2 = false;
                }
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            }
            if (esq <= dir) {
                resultado.setNumTrocas(resultado.getNumTrocas() + 2);
                Integer aux = vetor[esq];
                vetor[esq] = vetor[dir];
                vetor[dir] = aux;
                esq++;
                dir--;
            }
        } while (esq <= dir);
        if (esq < direita) {
            quickSortInteiroMediana(vetor, esq, direita, resultado, numParaMediana);
        }
        if (dir > esquerda) {
            quickSortInteiroMediana(vetor, esquerda, dir + 1, resultado, numParaMediana);
        }
    }

    public void ordenaInteiroMediana(Integer vetor[], Resultado resultado, int numParaMediana) {
        long tempoInicial = System.nanoTime();
        quickSortInteiroMediana(vetor, 0, vetor.length, resultado, numParaMediana);
        resultado.setTempoGasto(System.nanoTime() - tempoInicial);
    }

    public void auxOrdenaInteiroMediana(Integer vetor[], Resultado resultado) {
        auxQuickSortInteiroMediana(vetor, 0, vetor.length, resultado);
    }

    private void auxQuickSortInteiroMediana(Integer vetor[], Integer esquerda, Integer direita, Resultado resultado) {
        Integer pivo;
        pivo = vetor[(esquerda + direita) / 2];
        Integer esq = esquerda;
        Integer dir = direita - 1;
        do {
            Boolean auxiliar = true;
            Boolean auxiliar2 = true;
            while (auxiliar) {
                if (vetor[esq] < pivo && esq < direita) {
                    esq++;
                } else {
                    auxiliar = false;
                }
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            }
            while (auxiliar2) {
                if (vetor[dir] > pivo && dir > esquerda) {
                    dir--;
                } else {
                    auxiliar2 = false;
                }
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
            }
            if (esq <= dir) {
                resultado.setNumTrocas(resultado.getNumTrocas() + 2);
                Integer aux = vetor[esq];
                vetor[esq] = vetor[dir];
                vetor[dir] = aux;
                esq++;
                dir--;
            }
        } while (esq <= dir);
        if (esq < direita) {
            auxQuickSortInteiroMediana(vetor, esq, direita, resultado);
        }
        if (dir > esquerda) {
            auxQuickSortInteiroMediana(vetor, esquerda, dir + 1, resultado);
        }
    }

// Cenário 2 - Responsável por utilizar o QuickSort + InsertionSort    
    private void quickSortInteiroInsertionSort(Integer vetor[], Integer esquerda, Integer direita, Resultado resultado, Integer numAtivarInsertion) {
        if ((direita - esquerda) >= numAtivarInsertion) {
            Integer pivo;
            pivo = vetor[(esquerda + direita) / 2];
            Integer esq = esquerda;
            Integer dir = direita - 1;
            do {
                Boolean auxiliar = true;
                Boolean auxiliar2 = true;
                while (auxiliar) {
                    if (vetor[esq] < pivo && esq < direita) {
                        esq++;
                    } else {
                        auxiliar = false;
                    }
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                }
                while (auxiliar2) {
                    if (vetor[dir] > pivo && dir > esquerda) {
                        dir--;
                    } else {
                        auxiliar2 = false;
                    }
                    resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                }

                if (esq <= dir) {
                    resultado.setNumTrocas(resultado.getNumTrocas() + 2);
                    Integer aux = vetor[esq];
                    vetor[esq] = vetor[dir];
                    vetor[dir] = aux;
                    esq++;
                    dir--;
                }
            } while (esq <= dir);
            if (esq < direita) {
                quickSortInteiroInsertionSort(vetor, esq, direita, resultado, numAtivarInsertion);
            }
            if (dir > esquerda) {
                quickSortInteiroInsertionSort(vetor, esquerda, dir + 1, resultado, numAtivarInsertion);
            }
        } else {
            int posicaoInicial;
            if (esquerda == (direita - 1)) {
                posicaoInicial = esquerda;
            } else {
                posicaoInicial = esquerda + 1;
            }
            do {
                resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                Boolean aux = true;
                Integer valorASerComparado = vetor[posicaoInicial];
                int posicaoAtual = posicaoInicial;
                while (aux) {
                    if (posicaoAtual > esquerda) {
                        if (vetor[posicaoAtual - 1] > valorASerComparado) {
                            vetor[posicaoAtual] = vetor[posicaoAtual - 1];
                            posicaoAtual--;
                            resultado.setNumTrocas(resultado.getNumTrocas() + 1);
                        } else {
                            aux = false;
                        }
                        resultado.setNumComparacoes(resultado.getNumComparacoes() + 1);
                    } else {
                        aux = false;
                    }
                }
                vetor[posicaoAtual] = valorASerComparado;
                resultado.setNumTrocas(resultado.getNumTrocas() + 1);
                posicaoInicial++;
            } while (posicaoInicial < direita);
        }

    }

//QuickSort para os Item 2
    public void ordenaInteiroQuickSortInsertion(Integer vetor[], Resultado resultado, int numAtivarInsertion) {
        long tempoInicial = System.nanoTime();
        quickSortInteiroInsertionSort(vetor, 0, vetor.length, resultado, numAtivarInsertion);
        resultado.setTempoGasto(System.nanoTime() - tempoInicial);
    }

    private void quickSortInteiroInsertionSortDeputadoItem2(NoListaEncadeadaDeputadoItem2 nos[], Integer esquerda, Integer direita, Integer numAtivarInsertion) {
        if ((direita - esquerda) >= numAtivarInsertion) {
            NoListaEncadeadaDeputadoItem2 pivo;
            pivo = nos[(esquerda + direita) / 2];
            Integer esq = esquerda;
            Integer dir = direita - 1;
            do {
                Boolean auxiliar = true;
                Boolean auxiliar2 = true;
                while (auxiliar) {
                    if (nos[esq].getValor() < pivo.getValor() && esq < direita) {
                        esq++;
                    } else {
                        auxiliar = false;
                    }
                }
                while (auxiliar2) {
                    if (nos[dir].getValor() > pivo.getValor() && dir > esquerda) {
                        dir--;
                    } else {
                        auxiliar2 = false;
                    }
                }

                if (esq <= dir) {
                    NoListaEncadeadaDeputadoItem2 aux = nos[esq];
                    nos[esq] = nos[dir];
                    nos[dir] = aux;
                    esq++;
                    dir--;
                }
            } while (esq <= dir);
            if (esq < direita) {
                quickSortInteiroInsertionSortDeputadoItem2(nos, esq, direita, numAtivarInsertion);
            }
            if (dir > esquerda) {
                quickSortInteiroInsertionSortDeputadoItem2(nos, esquerda, dir + 1, numAtivarInsertion);
            }
        } else {
            int posicaoInicial;
            if (esquerda == (direita - 1)) {
                posicaoInicial = esquerda;
            } else {
                posicaoInicial = esquerda + 1;
            }
            do {
                Boolean aux = true;
                NoListaEncadeadaDeputadoItem2 valorASerComparado = nos[posicaoInicial];
                int posicaoAtual = posicaoInicial;
                while (aux) {
                    if (posicaoAtual > esquerda) {
                        if (nos[posicaoAtual - 1].getValor() > valorASerComparado.getValor()) {
                            nos[posicaoAtual] = nos[posicaoAtual - 1];
                            posicaoAtual--;
                        } else {
                            aux = false;
                        }
                    } else {
                        aux = false;
                    }
                }
                nos[posicaoAtual] = valorASerComparado;
                posicaoInicial++;
            } while (posicaoInicial < direita);
        }

    }

    public void ordenaInteiroQuickSortInsertionItem2(NoListaEncadeadaDeputadoItem2[] nos, int numAtivarInsertion) {
        quickSortInteiroInsertionSortDeputadoItem2(nos, 0, nos.length, numAtivarInsertion);
    }

    private void quickSortInteiroInsertionSortPartidoItem2(NoListaEncadeadaPartidoItem2 nos[], Integer esquerda, Integer direita, Integer numAtivarInsertion) {
        if ((direita - esquerda) >= numAtivarInsertion) {
            NoListaEncadeadaPartidoItem2 pivo;
            pivo = nos[(esquerda + direita) / 2];
            Integer esq = esquerda;
            Integer dir = direita - 1;
            do {
                Boolean auxiliar = true;
                Boolean auxiliar2 = true;
                while (auxiliar) {
                    if (nos[esq].getValor() < pivo.getValor() && esq < direita) {
                        esq++;
                    } else {
                        auxiliar = false;
                    }
                }
                while (auxiliar2) {
                    if (nos[dir].getValor() > pivo.getValor() && dir > esquerda) {
                        dir--;
                    } else {
                        auxiliar2 = false;
                    }
                }

                if (esq <= dir) {
                    NoListaEncadeadaPartidoItem2 aux = nos[esq];
                    nos[esq] = nos[dir];
                    nos[dir] = aux;
                    esq++;
                    dir--;
                }
            } while (esq <= dir);
            if (esq < direita) {
                quickSortInteiroInsertionSortPartidoItem2(nos, esq, direita, numAtivarInsertion);
            }
            if (dir > esquerda) {
                quickSortInteiroInsertionSortPartidoItem2(nos, esquerda, dir + 1, numAtivarInsertion);
            }
        } else {
            int posicaoInicial;
            if (esquerda == (direita - 1)) {
                posicaoInicial = esquerda;
            } else {
                posicaoInicial = esquerda + 1;
            }
            do {
                Boolean aux = true;
                NoListaEncadeadaPartidoItem2 valorASerComparado = nos[posicaoInicial];
                int posicaoAtual = posicaoInicial;
                while (aux) {
                    if (posicaoAtual > esquerda) {
                        if (nos[posicaoAtual - 1].getValor() > valorASerComparado.getValor()) {
                            nos[posicaoAtual] = nos[posicaoAtual - 1];
                            posicaoAtual--;
                        } else {
                            aux = false;
                        }
                    } else {
                        aux = false;
                    }
                }
                nos[posicaoAtual] = valorASerComparado;
                posicaoInicial++;
            } while (posicaoInicial < direita);
        }

    }

    public void ordenaInteiroQuickSortInsertionPartidoItem2(NoListaEncadeadaPartidoItem2[] nos, int numAtivarInsertion) {
        quickSortInteiroInsertionSortPartidoItem2(nos, 0, nos.length, numAtivarInsertion);
    }
}
