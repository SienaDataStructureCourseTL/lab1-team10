import java.util.Random;

/**
 *  A class representing a square matrix with some methods to manipulate
 *  such matrices.
 *  
 * @author Jim Teresco, modified by Prof. White and (Alex Stein and Tesfa Tesfaye)
 * @version Spring 2020
 */
public class Matrix2D 
{   
    // the actual matrix data storage, space to be allocated by the constructor
    private int [][] data;

    /**
     * A basic constructor to allocate but not otherwise initialize a matrix, so
     * by the rules of Java, all entries are initially 0.
     * 
     * @param size The desired size of the square matrix.
     */
    public Matrix2D(int size) 
    {
        data = new int[size][size];
    }

    /**
     * Initialize the entries randomly within a range.
     * 
     * @param low The low end of the range.
     * @param high The high end of the range.
     */ 
    public void randomInit(int low, int high) 
    {    
        Random r = new Random();

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data.length; col++) {
                data[row][col] = r.nextInt(high-low) + low;
            }
        }      
    }

    /**
     * Make this the identity matrix.
     */ 
    public void setToIdentity() {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data.length; col++) {
                if (row == col) {
                    data[row][col] = 1;
                }
                else {
                    data[row][col] = 0;
                }
            }
        }      
    }

    /**
     * Element mutator.  Throws an exception of the row or column is not valid.
     * 
     * @param row The row index of the element to be changed.
     * @param col The column index of the element to be changed.
     * @param value The new value to be assigned at the input row and column location.
     */ 
    public void set(int row, int col, int value) throws Matrix2DIndexOutOfBoundsException 
    {    
        if (row < 0 || row >= data.length) {
            throw new Matrix2DIndexOutOfBoundsException("Row", row, data.length);
        }

        if (col < 0 || col >= data.length) {
            throw new Matrix2DIndexOutOfBoundsException("Column", col, data.length);
        }

        data[row][col] = value;
    }

    /**
     * Element accessor.  Throws an exception if row or column is not valid.
     * 
     * @param The row of the element to be returned.
     * @param The column of the element to be returned.
     * @return The element located at the input row and column.
     */
    public int get(int row, int col) throws Matrix2DIndexOutOfBoundsException 
    {    
        if (row < 0 || row >= data.length) {
            throw new Matrix2DIndexOutOfBoundsException("Row", row, data.length);
        }

        if (col < 0 || col >= data.length) {
            throw new Matrix2DIndexOutOfBoundsException("Column", col, data.length);
        }

        return data[row][col];
    }

    /**
     * Returns the largest value in the matrix.
     * 
     * @param Returns the largest value in the matrix.
     */
    public int maxValue()
    {
        //add your code here
        int max = 0;
        for (int i=1; i < data.length; i++) {
            for(int j=0; j<data.length; j++){
                if (data[i][j] > max) {
                    max = data[i][j];
                }

            }
        }
        return max;
    }

    /**
     *  Compare two matrices for equality.  Two matricies are equal if they have the
     *  same dimensions and the same elements at every location in the matrix.
     *  
     *  Note that we must take a parameter of type Object to override the inherited 
     *  equals method. 
     *  
     *  @param other The Matrix2D object to be compared to this matrix.
     */ 
    public boolean equals(Object other) 
    {
        Matrix2D otr = (Matrix2D) other;

        if (data.length != otr.data.length){
            return false;
        }
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data.length;i++) {
                try {
                    if(data[i][j]!=(otr.get(i,j))){
                        return false;

                    }
                } catch (Matrix2DIndexOutOfBoundsException m2de) {
                    m2de.printStackTrace();

                }
            }
        }
        return true;

    }

    /**
     *  Nondestructive matrix-matrix add.  Throws an exception if the input 
     *  matrix does not have the same dimensions as this matrix.
     *  
     *  Create a new array whose elements are the sum of the elements of
     *  the input matrix and this matrix for the same row and column 
     *  indexes.
     *  
     *  @param other The Matrix2D object to be compared to this matrix.
     *  @return A new matrix whose elements are the sum of the input
     *          matrix and this matrix for the same row and column
     *          indexes.
     */ 
    public Matrix2D add(Matrix2D other) throws Matrix2DSizeMismatchException,Matrix2DIndexOutOfBoundsException
    {    
        int[][] newArr;
        newArr = new int[data.length][data.length];
        int sum1=0;

        if (data.length != other.data.length) {
            throw new Matrix2DSizeMismatchException(data.length, other.data.length);
        }

<<<<<<< HEAD
=======
        //add your code here
>>>>>>> 69a1e46bdb6c5a1cd8a7d32b8481454b22f36ed4
        Matrix2D sum = new Matrix2D(data.length);
        for (int i=0; i<data.length; i++) {
            for(int j=0; j<data.length; j++){
                sum.set(i,j,data[i][j] + other.get(i,j));
            }

        }

        return sum;
    }

    /**
     * Multiples every entry in this matrix by the input value.
     * 
     * @param by The amount by which the matrix is scaled.
     */
    public void scale(int by)
    {
        for(int i=0;i< data.length;i++){
            for(int j=0;j<data.length;i++){
                data[i][j]=data[i][j]*2;
            }
        }
    }

    /**
     * Return the matrix as a String that will print in a nice format.
     * 
     * @return The matrix as a String that will print in a nice format.
     */
    public String toString() 
    {    
        // use a StringBuffer to build up an answer more efficiently
        StringBuffer sb = new StringBuffer();

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data.length; col++) {
                sb.append(data[row][col]);
                if (col != data.length-1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}