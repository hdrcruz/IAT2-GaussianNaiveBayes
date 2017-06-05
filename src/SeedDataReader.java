/**
 * Created by Helder on 04/06/2017.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class SeedDataReader implements DataReader{


    GaussianCase caso = new GaussianCase();
    List<GaussianCase> treino = new ArrayList<>();


    public List<GaussianCase> readTxt(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileReader(file));
        int i = 0;
        while(scanner.hasNext()){

            switch (i){
                case 7:
                    caso.setClassName(Integer.parseInt(scanner.next()));
                    i++;
                    break;
                case 8:
                    //System.out.println(caso.toString());
                    treino.add(caso);
                    caso = new GaussianCase();
                    i = 0;
                    break;
                default:
                    caso.getFeatures().put(i,Double.parseDouble(scanner.next()));
                    i++;
                    break;
            }
        }
        scanner.close();



        return treino;
    }




}
