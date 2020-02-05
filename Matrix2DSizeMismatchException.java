
/**
 * An exception to indicate that two Matrix2D objects are not the same size when
 * that is required.
 * 
 * @author Jim Teresco & (Alex Stein & Tesfa Tesfaye) 
 * @version Spring 2020
 */
public class Matrix2DSizeMismatchException extends Exception
{

    public Matrix2DSizeMismatchException(int size1, int size2) {
        super("Matrix2D size mismatch: " + size1 + "!=" + size2);
    }
}
