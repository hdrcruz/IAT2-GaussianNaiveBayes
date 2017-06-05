import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Helder on 03/06/2017.
 */
public class GaussianCase {

    private int ClassName;
    private Map<Integer, Double> features = new ConcurrentHashMap<>();

    public GaussianCase(){

    }

    public GaussianCase(Map<Integer, Double> features) {
        this.features = features;
    }

    public int getClassName() {
        return ClassName;
    }

    public void setClassName(int className) {
        ClassName = className;
    }

    public Map<Integer, Double> getFeatures() {
        return features;
    }

    public void setFeatures(Map<Integer, Double> features) {
        this.features = features;
    }

    public void setFeaturevalor(int feature, double valor){ features.put(feature,valor); }

    public Double getFeatureValor(int feature){
        return features.get(feature);
    }

    public String toString(){

        StringBuilder caso = new StringBuilder();
        //caso.append("CASO\n");
        for (Map.Entry<Integer,Double> f: features.entrySet()){
            caso.append("( Atributo : ");
            caso.append(f.getKey());
            caso.append(" Valor: ");
            caso.append(f.getValue());
            caso.append(" ) ");
        }
        caso.append(" ( Classe: ");
        caso.append(ClassName);
        caso.append(" ) ");
        return caso.toString();
    }


}
