
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    List<GaussianCase> treino = new ArrayList<>();


    public static void main(String[] args) throws FileNotFoundException {

        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            DataReader reader = new SeedDataReader(); //ScalesDataReader();
            NBGaussian lol;
            lol = new NBGaussian(reader.readTxt(file));
            lol.classify(lol.getRandomTeste(10));
        } else {
            System.out.println("Open command cancelled by user.");
        }


    }




}
