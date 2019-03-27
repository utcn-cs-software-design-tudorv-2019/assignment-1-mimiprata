
package FirstApp.Student;

import presentation.ControllerLogin;
import presentation.LoginView;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	LoginView v = new LoginView();
		
		@SuppressWarnings("unused")
		ControllerLogin c = new ControllerLogin(v);
    }
}
