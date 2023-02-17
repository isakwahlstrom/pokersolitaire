package psmodel;
import java.util.Scanner;
import cardutils.Card;
public class PsUserInterface {
    private final PsLogic ps;
    private Scanner scan;

    public PsUserInterface() {
        ps = new PsLogic();
        scan = new Scanner(System.in);
    }
        public void run() {
            char choice = ' ';
            String answer;
            do {
                    printMenu();
                    answer = scan.next();
                    choice = answer.charAt(0);
                    switch (choice) {
                        case 'N':
                            play();
                            break;
                        case 'X':
                            System.out.println("Game done!");
                            break;
                        default:
                            System.out.println("Unknown command");
                    }
            } while(choice != 'X');
        }
        public void play() {
            ps.initNewGame();
            Card card;
            int answer;
            while(!ps.isGameOver()) {
                card = ps.pickNextCard();
                System.out.print("Next card: ");
                System.out.println(card.toString());
                System.out.println("Select a pile [0...4]: ");
                answer = scan.nextInt();
                ps.addCardToPile(answer);

                System.out.println(ps.getPiles());
            }
            System.out.println("You got: " + ps.getPoints() + " points");
        }
        public void printMenu() {
            System.out.println("---Menu---");
            System.out.println("N Start game");
            System.out.println("X Exit");
            System.out.println("----------");
        }
    }

