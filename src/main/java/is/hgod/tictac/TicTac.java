package is.hgod.tictac;

import static spark.Spark.*;

public class TicTac {
    private static Engine game = new Engine(1);
    
    public static void main(String[] args) {
        
        post("/newplay", (request, response) -> {
            String input = request.queryParams("square");
            if(game.getPlay(input, game.nextPlayer()) == 1){
                response.redirect("/newgame");
                return response;    
            }
            if(game.getGameMode() == 1 && game.computerPlay() == 1){
                response.redirect("/computerwon");
                return response;
            }
            response.redirect("/");
            return response;
        
        });


        post("/changeMode", (request, response) -> {
            String input = request.queryParams("mode");
            int mode = Integer.parseInt(input);
            if(mode == 1){
                game = new Engine(1);     
            }
            else if(mode == 2){
                game = new Engine(2);
            }
            response.redirect("/");
            return response;
        });

        get("/", (request, response) -> {
            StringBuilder buildBoard = new StringBuilder();
            char[][] board = game.getBoard();
            int counter = 7;
            buildBoard.append("<form method=\"post\" action=\"/changeMode\" role=\"form\" id=\"mode\">" +
                                "<input type=\"hidden\" name=\"mode\" value="+ "\"" + 1 + "\"" + ">" +
                                "<button type=\"submit\" class=\"btn btn - default \">PvE</button>" +
                                "</form>" +
                                "</div>" +
                                "<form method=\"post\" action=\"/changeMode\" role=\"form\" id=\"mode\">" +
                                "<input type=\"hidden\" name=\"mode\" value="+ "\"" + 2 + "\"" + ">" +
                                "<button type=\"submit\" class=\"btn btn - default \">PvP</button>" +
                                "</form>" +
                                "</div>");

            buildBoard.append("<div class=\"Board\">");
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    buildBoard.append("<div class=\"square\">");
                    if(board[i][j] == 0){
                        buildBoard.append("<form method=\"post\" action=\"/newplay\" role=\"form\" id=\"board\">" +
                                "<input type=\"hidden\" name=\"square\" value="+ "\"" + counter + "\"" + ">" +
                                "<button type=\"submit\" class=\"btn btn - default \">Submit move</button>" +
                                "</form>" +
                                "</div>");
                    }else if(board[i][j] == 'X'){
                        buildBoard.append("X</div>");

                    }else if(board[i][j] == 'O'){
                        buildBoard.append("O</div>");
                    }
                    counter++;
                }
                counter -= 6;
            }

            int player1wins = game.getHumanWins(1);
            int ties = game.getTies();

            if(game.getGameMode() == 1){
                int computerwins = game.getComputerWins();
                buildBoard.append("</div>" +
                              "<div class=\"player1wins\"> Player 1 wins: " + player1wins + "</div>" +
                              "<div class=\"computerwins\"> Computer wins: "  + computerwins + "</div>" +
                              "<div class=\"ties\"> Ties: " + ties + "</div>");    
            }else{
                int player2wins = game.getHumanWins(2);
                buildBoard.append("</div>" +
                              "<div class=\"player1wins\"> Player 1 wins: " + player1wins + "</div>" +
                              "<div class=\"player2wins\"> Player 2 wins: " + player2wins + "</div>" +
                              "<div class=\"ties\"> Ties: " + ties + "</div>");
            }
            
            return buildBoard.toString();
        });
        
        get("/newgame", (request, response) -> {
            game.newGame();
            response.redirect("/");
            return response;
        });

        get("/computerwon", (request, response) -> {
            game.newGame();
            if(game.nextPlayer() == 3){
                game.computerPlay();
            }
            response.redirect("/");
            return response;
        });

	}
}
