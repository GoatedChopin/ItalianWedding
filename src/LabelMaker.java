public class LabelMaker {

    public String makeLabel(Person person) {
        int spouseNumber = person.spouses.size();
        String label = person.name+":\n";
        for (int i = 0; i < spouseNumber; i++) {
            label = label.concat("Spouse no. " + (i + 1) + ":\n");
            Person spouse = person.spouses.get(i);
            for (int n = 0; n < spouse.labelQs.keySet().size(); n++) {
                label = label.concat(spouse.labelQuestions[n] + " : " + spouse.qOrder[n] + "\n");
            }

        }
        label = label.concat("\n***************************************************************************\n");
        System.out.println(label);
        return label;
    }
}
