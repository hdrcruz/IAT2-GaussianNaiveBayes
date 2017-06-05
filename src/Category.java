import java.util.Map;

/**
 * Created by Helder on 03/06/2017.
 */
public class Category {
    private int ocurrences;
    private String name;
    private double probability;

    public Category() {

        ocurrences = 1;
        probability = 0;
    }

    public int getOcurrences() {
        return ocurrences;
    }

    public void setOcurrences(int ocurrences) {
        this.ocurrences = ocurrences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public String toString(){
        StringBuilder caso = new StringBuilder();
        //caso.append("CASO\n");
        caso.append("( Ocurrences : ");
        caso.append(ocurrences);
        caso.append(" Probability: ");
        caso.append(probability);
        caso.append(" ) ");
        return caso.toString();
    }



}
