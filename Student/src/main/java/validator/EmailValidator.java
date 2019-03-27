package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Student;

public class EmailValidator implements Validator<Student>{

	private Pattern regexPattern;
	private Matcher regMatcher;
	public int isValid(Student t) {
		
		
		        regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
		        regMatcher   = regexPattern.matcher(t.getEmail());
		        if(regMatcher.matches()) {
		            return 1;
		        } else {
		            return 0;
		        }
		    
		// TODO Auto-generated method stub
	
	}

}
