import java.util.ArrayList;

public class CheckIfNameMatchesCriteriaParameter {
	public ArrayList<String> names;
	public ArrayList<String> genders;
	public ArrayList<String> name_attr;
	public boolean incorrect_criteria;
	public int index;

	public CheckIfNameMatchesCriteriaParameter(ArrayList<String> names, ArrayList<String> genders,
			ArrayList<String> name_attr, boolean incorrect_criteria, int index) {
		this.names = names;
		this.genders = genders;
		this.name_attr = name_attr;
		this.incorrect_criteria = incorrect_criteria;
		this.index = index;
	}
}