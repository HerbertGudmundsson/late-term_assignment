package is.hgod.tictac;

import static spark.Spark.*;

public class WebApp {
    private Engine game1 = new Engine(1);
    private Engine game2 = new Engine(2);
    private Engine game = game1;
    
    public void startApp() {
        staticFileLocation("/public");

        post("/newplay", (request, response) -> {
            String input = request.queryParams("square");
            game.getPlay(input, game.nextPlayer()); 
            if(game.getGameMode() == 1 && game.getTurn() != 9){
            	game.computerPlay();
            }
            response.redirect("/");
            return response;
        
        });


        post("/changeMode", (request, response) -> {
            String input = request.queryParams("mode");
            int mode = Integer.parseInt(input);
            if(mode == 1){
                game = game1;     
            }
            else if(mode == 2){
                game = game2;
            }
            response.redirect("/");
            return response;
        });

        get("/", (request, response) -> {
            StringBuilder buildBoard = new StringBuilder();
            char[][] board = game.getBoard();           
            int counter = 7;

            buildBoard.append("<head><link href=\"css/style.css\" rel=\"stylesheet\"   type=\"text/css\" /></head>" 
                );
            
            buildBoard.append("<div class=\"Board\">");
            if(game.isWon() || game.getTurn() == 9){
            	buildBoard.append("<form method=\"post\" action=\"/reset\" role=\"form\" id=\"resetgame\">" +
                                "<button type=\"submit\" class=\"btn-reset btn - default \">Reset</button>");
        	}
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    buildBoard.append("<div class=\"square\" id=\"square" + counter + "\">");
                    if(board[i][j] == 0 && !game.isWon()){
                        buildBoard.append("<form method=\"post\" action=\"/newplay\" role=\"form\" id=\"board\">" +
                                "<input type=\"hidden\" name=\"square\" value="+ "\"" + counter + "\"" + ">" +
                                "<button type=\"submit\" class=\"btn btn - default squarebtn \">Submit move</button>" +
                                "</form>" +
                                "</div>");
                    }else if(board[i][j] == 'X'){
                        buildBoard.append("<img src=\"./images/x.png\" /></div>");

                    }else if(board[i][j] == 'O'){
                        buildBoard.append("<img src=\"./images/o.png\" /></div>");
                    }
                    else{
                    	buildBoard.append("</div>");
                    }
                    counter++;
                }
                counter -= 6;
            }
            //Logic for the scoreboard
            int player1wins = game.getHumanWins(1);
            int ties = game.getTies();
            if(game.isWon() || game.getTurn() == 9){
            	buildBoard.append("</form>");
            }
            buildBoard.append("</div>" + "<div class=\"scoreboard\">" +
                              "<div class=\"player1wins\"> X wins: " + player1wins + "</div>");
            if(game.getGameMode() == 1){
                int computerwins = game.getComputerWins();
                buildBoard.append("<div class=\"computerwins\"> O wins: "  + computerwins + "</div>" +
                              "<div class=\"ties\"> Ties: " + ties + "</div>");    
            }else{
                int player2wins = game.getHumanWins(2);
                buildBoard.append("<div class=\"player2wins\"> O wins: " + player2wins + "</div>" +
                              "<div class=\"ties\"> Ties: " + ties + "</div>");
            }

            buildBoard.append("<form method=\"post\" action=\"/changeMode\" role=\"form\" id=\"mode\">" +
                                "<input type=\"hidden\" name=\"mode\" value="+ "\"" + 2 + "\"" + ">" +
                                "<button type=\"submit\" class=\"btn-pvp btn - default \">PvP</button>" +
                                "</form>" +
                                "<form method=\"post\" action=\"/changeMode\" role=\"form\" id=\"mode\">" +
                                "<input type=\"hidden\" name=\"mode\" value="+ "\"" + 1 + "\"" + ">" +
                                "<button type=\"submit\" class=\"btn-pve btn - default \">PvE</button>" +
                                "</form>" +
                                "</div>");
            
            return buildBoard.toString();
        });
        
        get("/newgame", (request, response) -> {
            game.newGame();
            if(game.nextPlayer() == 3){
                game.computerPlay();
            }
            response.redirect("/");
            return response;
        });

        post("/reset", (request, response) -> {
            response.redirect("/newgame");
            return response;
        });

	}
}