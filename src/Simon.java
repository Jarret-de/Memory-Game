import java.util.Random;
import java.util.Scanner;

public class Simon {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        int turn = 1;
        boolean lose = false;

        System.out.println("Let's play Simon!");

        do {
            ArrayList<String> Cpu = new ArrayList<>();
            ArrayList<String> Player = new ArrayList<>();
            for (int i=0; i < turn; i++) {
                int random = rnd.nextInt(4);
                switch(random) {
                    case 0:
                        Cpu.add("green");
                        break;
                    case 1:
                        Cpu.add("red");
                        break;
                    case 2:
                        Cpu.add("blue");
                        break;
                    case 3:
                        Cpu.add("yellow");
                        break;
                }
            }
            for (String move : Cpu) {
                System.out.println(move);
            }
            Thread.sleep(3000);
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            for (int i=0; i < turn; i++) {
                Player.add(scanner.next());
            }          
            if (!Player.equals(Cpu)) {
                System.out.println("Game over! Your score is " + turn);
                lose = true;
            }
            else {
                System.out.println("Correct! Your current score is " + turn);
            }
            turn++;
        } while(!lose);
    }
}
