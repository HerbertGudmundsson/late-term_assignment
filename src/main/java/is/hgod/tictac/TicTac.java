package is.hgod.tictac;

import static spark.Spark.*;

public class TicTac {
    public static void main(String[] args) {
        staticFileLocation("/public");
        final Engine game = new Engine(1);

        post("/newgame", (request, response) -> {
        	game.newGame();
        	return response;
		});

		post("/newplay", (request, response) -> {
            String input = request.queryParams("square");
            if(game.getPlay(input, 1) == 1){
                return "You won";    
            }
			if(game.computerPlay() == 1){
                return "Computer won";
            }
            response.redirect("/");
			return response;
	    });


        post("/changeMode", (request, response) -> {
            String input = request.queryParams("mode");
            int mode = Integer.parseInt(input);
            if(mode == 1){
                return "PvE";
            }
            else if(mode == 2){
                return "PvP";
            }
            response.redirect("/");
            return response;
        });

        get("/", (request, response) -> {
            StringBuilder buildBoard = new StringBuilder();
            char[][] board = game.getBoard();
            int counter = 1;
            buildBoard.append("<head><link href=\"css/style.css\" rel=\"stylesheet\"   type=\"text/css\" /></head>");
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
                    //buildBoard.append("</div>");
                    counter++;
                }
            }
            buildBoard.append("</div>");
            return buildBoard.toString();
        });
	}
}
