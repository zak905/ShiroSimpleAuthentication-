import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class Main {

	public static void main(String[] args) throws Exception {
		
		String userName = "someUserName";
		String userName = "somePassword";

		Authenticator authenticator = new Authenticator();
        Subject currentUser = authenticator.authenticate(userName, password);
        if(currentUser.isAuthenticated()){
        	Session session = currentUser.getSession();

        	//Storing some attributes
        	session.setAttribute("Connected", "yes");


        	//Retrieving attributes later on 

            String attribute = session.getAttribute("Connected").toString();

            System.out.println("Connected : " + attribute);

        }
        else{
           System.out.println("Could not authenticate user");
        }
		
		

	}


}

