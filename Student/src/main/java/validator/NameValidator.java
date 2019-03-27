package validator;

import model.Student;

public class NameValidator implements Validator<Student> {
	public int isValid(Student t) {
		String name = t.getName().toLowerCase();
		if (name.length() <3 || name.length()>100)
			return 0;
		for (int i=0; i<name.length(); i++) {
			if ((name.charAt(i)<'a' || name.charAt(i)>'z') )
				return 0;
		}
		return 1;
	}	

}
