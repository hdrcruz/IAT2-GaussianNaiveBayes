import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by hdrcruz on 6/5/17.
 */
public interface DataReader {
    public List<GaussianCase> readTxt(File file) throws FileNotFoundException;
}
