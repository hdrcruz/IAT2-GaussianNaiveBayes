import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Helder on 03/06/2017.
 */
public class NBGaussian {

    private List<GaussianCase> treino = new ArrayList<>();
    private Map<Integer,Category> categorias = new ConcurrentHashMap<>();
    private List<GaussianCase> teste = new ArrayList<>();


    public NBGaussian(List<GaussianCase> treino) {
        this.treino = treino;
        train();
    }

    public List<GaussianCase> getRandomTeste(int i) {

        for (int j = 0; j < i; j++) {
            teste.add(treino.get(new Random().nextInt(treino.size())));
        }
        return teste;
    }



    public double train(){
        double res = 0;
        int ocurrences = 0;
        for (GaussianCase caso: treino){
            if (categorias.containsKey(caso.getClassName())){
                categorias.get(caso.getClassName()).setOcurrences(categorias.get(caso.getClassName()).getOcurrences()+1);
            }
            else{
                Category cat = new Category();
                categorias.put(caso.getClassName(),cat);
            }
        }
        for (Map.Entry<Integer, Category> cat: categorias.entrySet()){
            double prob = (double)cat.getValue().getOcurrences()/(double)treino.size();
            cat.getValue().setProbability(prob);
        }
        return res;
    }


    public double probFeatureGivenCategory(double v, double avg, double var) {
        double exp = -(v - avg) * (v - avg) / (2 * var);
        double discrim = 2 * Math.PI * var;
        return Math.exp(exp) / Math.sqrt(discrim);
    }

    public double probFeaturesGivenCategory(Map<Integer, Double> features, int category) {
        double pVGivenC = 1.0;
        double avg, var;


        for (Map.Entry<Integer,Double> entry: features.entrySet()){
            avg = mean(entry.getKey(),category);
            var = variance(entry.getKey(),category);
            pVGivenC *= probFeatureGivenCategory( entry.getValue(), avg, var);
        }
        return pVGivenC;
    }


    public double mean(int feature, int category){
        double total, sum = 0;
        int ocurrences = 0;
        for (GaussianCase caso: treino){
            if (caso.getClassName() == category){
                sum += caso.getFeatureValor(feature);
                ocurrences++;
            }
        }
        return sum/categorias.get(category).getOcurrences();
    }


    public double variance(int feature, int category){
        double mu = mean(feature,category);
        double sum = 0.0;
        int ocurrences = 0;
        double valor;
        for (GaussianCase caso: treino){
            if (caso.getClassName() == category){
                valor = caso.getFeatureValor(feature);
                sum += Math.pow(mu - valor,2);
                ocurrences++;
            }
        }
        double var = sum/(double) categorias.get(category).getOcurrences();
        return var;
    }

    public void classify(List<GaussianCase> teste){
        for (GaussianCase caso: teste) {
            predict(caso);
        }
    }

    public double predict(GaussianCase caso){
        double pC = 1.0 / categorias.size();
        double pV = 0;
        for (Map.Entry<Integer, Category> entry : categorias.entrySet()) {
            double pVGivenC = probFeaturesGivenCategory(caso.getFeatures(), entry.getKey());
            pV += pVGivenC * pC;
        }

        Map<Integer, Double> probability = new HashMap<>();
        for (Map.Entry<Integer, Category> entry : categorias.entrySet()){
            double pVGivenC = probFeaturesGivenCategory(caso.getFeatures(), entry.getKey());
            double pCGivenV = pC * pVGivenC / pV;
            double score = pCGivenV;
            probability.put(entry.getKey(),score);
        }

        StringBuilder str = new StringBuilder();
        str.append(caso.toString());
        str.append("CLASSIFICAÇÃO : \n");
        for (Map.Entry<Integer, Double> entry: probability.entrySet()){
            str.append("( Classe : ");
            str.append(entry.getKey());
            str.append(" Probabilidade : ");
            str.append(String.format( "%.16f", entry.getValue()));
            str.append(" ) \n");
        }
        System.out.println(str.toString());
        return 1;
    }

    public void printCategories(){
        for (Map.Entry<Integer,Category> c: categorias.entrySet()){
            System.out.println(c.toString());
        }
    }

    public void printCases(){
        for (GaussianCase caso: treino){
            System.out.println(caso.toString());
        }
    }




}
