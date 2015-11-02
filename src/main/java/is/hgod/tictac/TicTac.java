package is.hgod.tictac;


import spark.Request;
import spark.Response;
import spark.Route;
 
import static spark.Spark.*;
 
public class TicTac {
 
    public static void main(String[] args) {
     final Engine game = new Engine(1);

        post("/newgame", (request, response) -> {
        	game.newGame();
        	return response;
		});

		post("/newplay", (request, response) -> {
            
            String input = request.queryParams("square");
			game.humanPlay(input, 1);
			response.redirect("/");
			return response;
		});

       get("/", (request, response) -> {

            StringBuilder buildBoard = new StringBuilder();
            char[][] board = game.getBoard();
            buildBoard.append("<div class=\"Board\">");

            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    buildBoard.append("<div class=\"square\">");
                    if(board[i][j] == 0){
                        buildBoard.append("<form method=\"post\" action=\"/newplay\" role=\"form\" id=\"board\">" +
                                "<input type=\"hidden\" name=\"square\" value=\"1\">" +
                                "<button type=\"submit\" class=\"btn btn - default \">Submit move</button>" +
                                "</form>" +
                                "</div>");
                    }else if(board[i][j] == 'X'){
                        buildBoard.append("X");
                    }else if(board[i][j] == 'O'){
                        buildBoard.append("O");
                    }
                    buildBoard.append("</div>");
                }
            }
            buildBoard.append("</div>");
            return buildBoard.toString();
        });
	}
}