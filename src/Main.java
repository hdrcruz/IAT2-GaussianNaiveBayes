
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    List<GaussianCase> treino = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        /*
        GaussianCase caso = new GaussianCase();
        caso.setFeaturevalor(0,12.3);
        caso.setFeaturevalor(1,13.34);
        caso.setFeaturevalor(2,0.8684);
        caso.setFeaturevalor(3,5.243);
        caso.setFeaturevalor(4,2.974);
        caso.setFeaturevalor(5,5.637);
        caso.setFeaturevalor(6,5.063);
        SeedDataReader seedreader = new SeedDataReader();
        File f = new File("C:\\Users\\Helder\\Desktop\\IA\\seeds_dataset.txt");
        NBGaussian lol;
        lol = new NBGaussian(seedreader.readTxt(f));
        lol.prior();
        lol.predict(caso);
        */
        GaussianCase caso = new GaussianCase();
        caso.setFeaturevalor(0,5.0);
        caso.setFeaturevalor(1,5.0);
        caso.setFeaturevalor(2,5.0);
        caso.setFeaturevalor(3,2.0);
        ScalesDataReader scalesreader = new ScalesDataReader();
        File f = new File("C:\\Users\\Helder\\Desktop\\IA\\balance-scale.data");
        //scalesreader.readTxt(f);
        NBGaussian lol;
        lol = new NBGaussian(scalesreader.readTxt(f));
        lol.printCases();
        lol.prior();
        lol.predict(caso);

    }




}
