import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = new int[101]; //dimensione a 100 elementi
        int conta = 0;
        int scelta;

        do {
            //menu:
            System.out.println("Menu:");
            System.out.println("1.caricamento da tastiera.");
            System.out.println("2.caricamento random.");
            System.out.println("3.visualizzazione.");
            System.out.println("4.inserimento in posizione.");
            System.out.println("5.cancellazione di un elemento cercato.");
            System.out.println("6.cancellazione di tutte le occorrenze di un elemento cercato.");
            System.out.println("0.esci dal programma.");

            //vai a capo
            System.out.println(" ");

            System.out.print("Seleziona un'opzione: ");
            scelta = in.nextInt();

            switch (scelta) {


                case 1: //carica da tastiera
                    System.out.print("quanti elementi vuoi inserire (max 100)? ");
                    int num = in.nextInt();

                    num = Math.min(num, 100);

                    for (int i = 0; i < num; i++) {
                        System.out.print("Inserisci l'elemento " + (i + 1) + ": ");
                        array[i] = in.nextInt();
                        conta = i + 1;
                    }
                    break;

//----------------------------------------------------------------------------------------------------------------------

                case 2: //random
                    System.out.print("quanti elementi vuoi generare (max 100)? ");
                    int n = in.nextInt();

                    n = Math.min(n, 100);

                    Random random = new Random();
                    for (int i = 0; i < n; i++) {
                        //generatore numeri tra 0 e 99
                        array[i] = random.nextInt(100);
                        conta++;
                    }
                    break;

//----------------------------------------------------------------------------------------------------------------------

                case 3: //visualizza array
                    System.out.println("contenuto array: ");
                    for (int i = 0; i < conta; i++) {
                        System.out.println("elemento numero " + (i + 1) + ": " + array[i]);
                    }
                    break;

//----------------------------------------------------------------------------------------------------------------------

                case 4: //inserimento in posizione
                    if (conta >= 100) {
                        System.out.println("array pieno, impossibile inserire altri elementi.");
                        break;
                    }
                    System.out.print("inserisci elemento da aggiungere: ");
                    int NuovoElemento = in.nextInt();
                    System.out.print("inserisci posizione dove inserire elemento (1-" + (conta + 1) + "): ");
                    int posizione = in.nextInt() - 1;
                    for (int i = conta; i > posizione; i--) {
                        array[i] = array[i - 1];
                    }
                    array[posizione] = NuovoElemento;
                    conta++;
                    break;

//----------------------------------------------------------------------------------------------------------------------

                case 5: //cancellazione
                    System.out.print("Inserisci elemento da cancellare: ");
                    int CancElemento = in.nextInt();
                    boolean trovato = false;
                    for (int i = 0; i < conta; i++) {
                        if (array[i] == CancElemento) {
                            for (int j = i; j < conta - 1; j++) {
                                array[j] = array[j + 1];
                            }
                            conta--;
                            System.out.println("Elemento cancellato.");
                            trovato = true;
                            break;
                        }
                    }
                    if (!trovato) {
                        System.out.println("Elemento non trovato.");
                    }
                    break;

//----------------------------------------------------------------------------------------------------------------------

                case 6: //cancellazione di tutte le occorrenze
                    System.out.print("Inserisci l'elemento da cancellare: ");
                    int CancElemento_ = in.nextInt();
                    int i = 0;
                    boolean trova = false;
                    while (i < conta) {
                        if (array[i] == CancElemento_) {
                            for (int j = i; j < conta - 1; j++) {
                                array[j] = array[j + 1];
                            }
                            conta--;
                            trova = true;
                        } else {
                            i++;
                        }
                    }
                    if (trova) {
                        System.out.println("tutte le occorrenze dell'elemento sono state cancellate.");
                    } else {
                        System.out.println("elemento non trovato.");
                    }
                    break;

//----------------------------------------------------------------------------------------------------------------------

                case 0:
                    System.out.println("uscita.");
                    break;

                default:
                    System.out.println("scelta non valida.");

            }
        } while (scelta != 0);
    }
}
