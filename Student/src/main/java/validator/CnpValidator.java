package validator;

import model.Student;

public class CnpValidator implements Validator<Student> {

	public int isValid(Student t) {
		//System.out.println(t.getCnp().length());
		//System.out.println(t.getCnp().length()!=13);
		if (t.getCnp().length() != 13)
			return 0;
	
		
		
		return 1;
	
	}
}
	