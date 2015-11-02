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
    private Engine game;
    /**
     * An array of all the lines of the assets text file.
     */
    private String[] allLines = new String[497];

    /**
     * Prints 3 empty lines in between the different screens of the game.
     */
    private void printEmptyLines() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

    /**
     * Prints the name of the game in Ascii art.
     */
    private void printHeader() {
        int start = 308;
        int end = 339;
        printRow(start, end);
    }

    /**
     * Prints the game board with numbers indicating the squares of the board.
     */
    private void printInitialBoard() {
        int start = 253;
        for (int i = 0; i < 3; i++) {
            printRow(start);
            start += 11;
        }
        printEmptyLines();
        printScoreBoard();
    }

    /**
    * Prints the games score with the number of games won for each player currently playing
    */
    private void printScoreBoard(){
        int gamemode = game.getGameMode();
        String score1, score2;
        score1 = Integer.toString(game.getHumanWins(1));
        int numStart = 400;
        if(gamemode == 1){
            score2 = Integer.toString(game.getComputerWins());
            for(int i = 0; i < 8; i++){
                System.out.print(allLines[384 + i]);
                for(int j = 0; j < score1.length(); j++){
                    System.out.print(allLines[numStart + (8 * (score1.charAt(j) - 48) + i)]);
                }
                System.out.println();
            }
            for(int i = 0; i < 8; i++){
                System.out.print(allLines[392 + i]);
                for(int j = 0; j < score2.length(); j++){
                    System.out.print(allLines[numStart + (8 * (score2.charAt(j) - 48) + i)]);
                }
                System.out.println();  
            }
        }
        else if(gamemode == 2){
            score2 = Integer.toString(game.getHumanWins(2));
            for(int i = 0; i < 8; i++){
                System.out.print(allLines[480 + i]);
                for(int j = 0; j < score1.length(); j++){
                    System.out.print(allLines[numStart + (8 * (score1.charAt(j) - 48) + i)]);
                }
                System.out.println();
            }
            for(int i = 0; i < 8; i++){
                System.out.print(allLines[488 + i]);
                for(int j = 0; j < score2.length(); j++){
                    System.out.print(allLines[numStart + (8 * (score2.charAt(j) - 48) + i)]);
                }
                System.out.println();  
            }
        }
    }

    /**
     * Prints the current game board.
     */
    private void printBoard() {
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
    private void printMenu() {
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
    private void printRow(int start) {
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
    private void printRow(int start, int end) {
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
    public void startUI() {
        Scanner in = new Scanner(System.in);

        printHeader();
        System.out.println("Press enter to continue");
        in.nextLine();
        printMenu();
        int gamemode;
        while(true){
            String input = in.next();
            if(input.length() < 2 && (input.charAt(0) == 49 || input.charAt(0) == 50)){
                gamemode = Integer.parseInt(input);
                break;
            }
        }
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
                int winningPlay = game.getPlay(input, nextPlayer);
                while (winningPlay < -1) {
                    if (winningPlay == -2) {
                        System.out.println("Invalid input: " + input + "! Select a number from 1 to 9");
                    } else {
                        System.out.println("Square already taken: " + input + "! Select another number from 1 to 9");
                    }
                    input = in.next();
                    winningPlay = game.getPlay(input, nextPlayer);
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
                }else{
                    printBoard();
                }
            }
            if (keepPlaying) {
                game.newGame();
                printInitialBoard();
            }
        }

    }
}
