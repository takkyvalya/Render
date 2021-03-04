public class Matrix {
    int[][] value;

    public Matrix(int[][] value) {
        this.value = value;
    }


    public static Matrix MatMult(Matrix mat1, Matrix mat2)
    {
        int[][] out = new int[mat1.value.length][];
        for (int i = 0; i < out.length; i++) {
            out[i] = new int[mat2.value[0].length];
            for (int j = 0; j < out[i].length; j++) {
                int arg=0;
                for (int k = 0; k < mat1.value[0].length; k++) {
                    arg+=mat1.value[i][k] * mat2.value[k][j];
                }
                out[i][j]=arg;
            }
        }
        Matrix output = new Matrix(out);
        return output;
    }

    public static Matrix TMatrix(int vx, int vy, int vz)
    {
        int[][] out = {{1, 0, 0, vx}, {0, 1, 0, vy}, {0, 0, 1, vz}, {0, 0, 0, 1}};
        Matrix output = new Matrix(out);
        return output;
    }

    public static Matrix RxMatrix (double phi)
    {
        int[][] out = {{1, 0, 0, 0}, {0, (int)Math.cos(phi), -1*(int)Math.sin(phi), 0}, {0, (int)Math.sin(phi), (int)Math.cos(phi), 0}, {0, 0, 0, 1}};
        Matrix output = new Matrix(out);
        return output;
    }

    public static Matrix RyMatrix (double phi)
    {
        int[][] out = {
                {(int)Math.cos(phi), 0,(int)(Math.sin(phi)), 0},
                {0, 1, 0, 0},
                {-1*(int)(Math.sin(phi)), 0, (int)Math.cos(phi), 0},
                {0, 0, 0, 1}};

        Matrix output = new Matrix(out);
        return output;
    }

    public static Matrix RzMatrix (double phi)
    {
        int[][] out = {{(int)Math.cos(phi), -1*(int)(Math.sin(phi)), 0, 0}, {(int)Math.sin(phi), (int)Math.cos(phi), 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        Matrix output = new Matrix(out);
        return output;
    }



    public static Matrix RMatrix3D (double ax, double ay, double az)
    {
        int[][] out = MatMult(MatMult(RxMatrix(ax), RyMatrix(ay)), RzMatrix(az)).value;
        Matrix output = new Matrix(out);
        return output;
    }

    public static Matrix SMatrix (int vx, int vy, int vz)
    {
        int[][] out = {{vx, 0, 0, 0}, {0, vy, 0, 0}, {0, 0, vz, 0}, {0, 0, 0, 1}};
        Matrix output = new Matrix(out);
        return output;
    }

    public static Matrix TRSMatrix (Matrix tv, Matrix sv, double xangle, double yangle, double zangle, Matrix input)
    {
        int[][] pushkin = MatMult(TMatrix(tv.value[0][0], tv.value[1][0], tv.value[2][0]), MatMult(RMatrix3D(xangle, yangle, zangle),
                MatMult(SMatrix(sv.value[0][0], sv.value[1][0], sv.value[2][0]), input))).value;

        int[][] zeliboba = {{pushkin[0][0]/pushkin[3][0]}, {pushkin[1][0]/pushkin[3][0]}, {pushkin[2][0]/pushkin[3][0]}};

        Matrix output = new Matrix(zeliboba);
        return output;
    }
}
