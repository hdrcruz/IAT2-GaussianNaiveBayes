import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Helder on 05/06/2017.
 */
public class ScalesDataReader implements DataReader{
    GaussianCase caso;
    List<GaussianCase> treino = new ArrayList<>();


    public List<GaussianCase> readTxt(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(new FileReader(file));
        int i = 0;
        String str = new String();
        while(scanner.hasNext()){
            str = scanner.nextLine();
            //str = str.replaceAll(","," ");
            String[] trainData = str.split(",");
            caso = new GaussianCase();
            caso.setFeaturevalor(0,Double.parseDouble(trainData[1]));
            caso.setFeaturevalor(1,Double.parseDouble(trainData[2]));
            caso.setFeaturevalor(2,Double.parseDouble(trainData[3]));
            caso.setFeaturevalor(3,Double.parseDouble(trainData[4]));
            if (trainData[0].equalsIgnoreCase("L")) caso.setClassName(1);
            if (trainData[0].equalsIgnoreCase("B")) caso.setClassName(2);
            if (trainData[0].equalsIgnoreCase("R")) caso.setClassName(3);
            treino.add(caso);
            /*
            switch (i){
                case 0:
                    if (scanner.next().equalsIgnoreCase("L")) caso.setClassName(1);
                    if (scanner.next().equalsIgnoreCase("B")) caso.setClassName(2);
                    if (scanner.next().equalsIgnoreCase("R")) caso.setClassName(3);
                    i++;
                    break;
                case 5:
                    //System.out.println(caso.toString());
                    treino.add(caso);
                    caso = new GaussianCase();
                    i = 0;
                    break;
                default:
                    caso.getFeatures().put(i,Double.parseDouble(scanner.next()));
                    i++;
                    break;
            }*/
            //System.out.println(trainData[4]);
        }
        scanner.close();

        return treino;
    }

}
