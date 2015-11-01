package is.hgod.tictac;

import java.io.*;
import java.util.Scanner;


/**
 * @author Hermann Ingi Ragnarsson <hermannr14@ru.is>
 * @version 0.1
 * @since 2015-10-30
 */
public class UI {

    /**
     * Sole constructor.
     */
    UI() {
        getAsciiArt();
    }

    /**
     * An instance of the Engine Class
     */
    private static Engine game;
    /**
     * An array of all the lines of the assets text file.
     */
    private static String[] allLines = new String[385];

    /**
     * Prints 3 empty lines in between the different screens of the game.
     */
    private static void printEmptyLines() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

    /**
     * Prints the name of the game in Ascii art.
     */
    private static void printHeader() {
        int start = 308;
        int end = 339;
        printRow(start, end);
    }

    /**
     * Prints the game board with numbers indicating the squares of the board.
     */
    private static void printInitialBoard() {
        int start = 253;
        for (int i = 0; i < 3; i++) {
            printRow(start);
            start += 11;
        }
        printEmptyLines();
    }

    /**
     * Prints the current game board.
     */
    private static void printBoard() {
        String[] currentBoard = new String[3];
        for (int i = 0; i < 3; i++) {
            currentBoard[i] = "";
            for (int j = 0; j < game.getBoard()[i].length; j++) {
                if (game.getBoard()[i][j] == 0) {
                    currentBoard[i] += "0";
                } else {
                    currentBoard[i] += game.getBoard()[i][j];
                }
            }
            switch (currentBoard[i].toString()) {
                case "000":
                    printRow(220);
                    break;
                case "XOX":
                    printRow(0);
                    break;
                case "XXX":
                    printRow(11);
                    break;
                case "XXO":
                    printRow(22);
                    break;
                case "XOO":
                    printRow(33);
                    break;
                case "OOO":
                    printRow(44);
                    break;
                case "OOX":
                    printRow(55);
                    break;
                case "OXX":
                    printRow(66);
                    break;
                case "OXO":
                    printRow(77);
                    break;
                case "X00":
                    printRow(88);
                    break;
                case "XX0":
                    printRow(99);
                    break;
                case "0XX":
                    printRow(110);
                    break;
                case "00X":
                    printRow(121);
                    break;
                case "O00":
                    printRow(132);
                    break;
                case "OO0":
                    printRow(143);
                    break;
                case "0OO":
                    printRow(154);
                    break;
                case "00O":
                    printRow(165);
                    break;
                case "XO0":
                    printRow(176);
                    break;
                case "0XO":
                    printRow(187);
                    break;
                case "0OX":
                    printRow(198);
                    break;
                case "OX0":
                    printRow(209);
                    break;
                case "0X0":
                    printRow(231);
                    break;
                case "0O0":
                    printRow(242);
                    break;
                case "X0O":
                    printRow(340);
                    break;
                case "O0X":
                    printRow(351);
                    break;
                case "O0O":
                    printRow(362);
                    break;
                case "X0X":
                    printRow(373);
                    break;
                default:
                    System.out.println("Asset missing: " + currentBoard[i].toString());
                    break;
            }
        }
        printEmptyLines();
    }

    /**
     * Prints the menu for the game where the player can select either PvP or PvE.
     */
    private static void printMenu() {
        int start = 286;
        int end = 307;
        printRow(start, end);
    }

    /**
     * Prints the Ascii art assets for the game.
     * The assets were generated using http://http://patorjk.com/software/taag/.
     * The method will print the start line and the next 11 lines.
     *
     * @param start The line number of the first line to be printed.
     */
    private static void printRow(int start) {
        int end = start + 10;
        for (int j = start; j <= end; j++) {
            System.out.println(allLines[j]);
        }
    }

    /**
     * Prints the Ascii art assets for the game.
     * The assets were generated using http://http://patorjk.com/software/taag/.
     *
     * @param start The line number of the first line to be printed.
     * @param end   The line number of the last line to be printed.
     */
    private static void printRow(int start, int end) {
        for (int j = start; j <= end; j++) {
            System.out.println(allLines[j]);
        }
    }

    /**
     * Retrieve the Ascii art assets from a file.
     * The assets were generated using http://http://patorjk.com/software/taag/.
     *
     * @throws FileNotFoundException Thrown if no assets text file is found.
     * @throws IOException           Thrown if file is corrupted.
     */
    private void getAsciiArt() {
        String fileName = "/assets.txt";
        String line = null;
        try {
            InputStream in = getClass().getResourceAsStream(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                allLines[i] = line;
                i++;
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    /**
     * Starts the User Interface
     */
    public static void startUI() {
        Scanner in = new Scanner(System.in);

        printHeader();
        System.out.println("Press any key to continue");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printMenu();
        int gamemode = Integer.parseInt(in.next());
        game = new Engine(gamemode);
        printInitialBoard();

        boolean keepPlaying = true;
        while (keepPlaying) {

            while (game.getTurn() < 10) {
                int nextPlayer = game.nextPlayer();
                //To check for computer plays
                String input = "";
                if (nextPlayer != 3) {
                    System.out.println("Player" + nextPlayer + ": Select a number from 1 to 9");
                    input = in.next();
                }
                int winningPlay = game.humanPlay(input, nextPlayer);
                printBoard();
                while (winningPlay < -1) {
                    if (winningPlay == -2) {
                        System.out.println("Invalid input: " + input + "! Select a number from 1 to 9");
                    } else {
                        System.out.println("Square already taken: " + input + "! Select another number from 1 to 9");
                    }
                    input = in.next();
                    winningPlay = game.humanPlay(input, nextPlayer);
                }
                if (winningPlay == 1) {
                    printBoard();
                    if(nextPlayer == 3){
                        System.out.println("Computer won! Play another game?(y/n)");
                    }else {
                        System.out.println("Player" + nextPlayer + " is winner! Play another game?(y/n)");
                    }
                    if (in.next().charAt(0) == 'n') {
                        keepPlaying = false;
                        break;
                    } else {
                        break;
                    }
                }else if(winningPlay == 2){
                    printBoard();
                    System.out.println("Game tied! Play another game?(y/n)");
                    if (in.next().charAt(0) == 'n') {
                        keepPlaying = false;
                        break;
                    } else {
                        break;
                    }
                }
            }
            if (keepPlaying) {
                game.newGame();
                printInitialBoard();
            }
        }

    }

    public static void main(String[] args) {
        UI ui = new UI();
        ui.startUI();
    }
}
