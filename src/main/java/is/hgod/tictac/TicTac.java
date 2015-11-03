package is.hgod.tictac;

/**
 * @author Arni Oddsson <arnio13@ru.is>
 * @version 0.1
 * @since 2015-10-30
 */
public class TicTac{

	/**
    * Starts the UI.
    * 
    * @param args String argument input.
    */	
    public static void main(String[] args){
		WebApp ticTac = new WebApp();
        ticTac.startApp();  

        UI ui = new UI();
		ui.startUI();
    }
}
