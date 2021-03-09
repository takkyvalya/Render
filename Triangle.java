
public class Triangle {
    double x1;
    double y1;
    double z1;
    double x2;
    double y2;
    double z2;
    double x3;
    double y3;
    double z3;


    public Triangle(double x1, double y1, double z1, double x2, double y2, double z2, double x3, double y3, double z3) {
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.x2 = x2;
        this.y2 = y2;
        this.z2 = z2;
        this.x3 = x3;
        this.y3 = y3;
        this.z3 = z3;
    }

    public Vector3 norm(){
        //(1,2)(1,3)
        Vector3 v1 = new Vector3(x2-x1,y2-y1,z2-z1);
        Vector3 v2 = new Vector3(x3-x1,y3-y1,z3-z1);

        return new Vector3(v1.yV*v2.zV-v1.zV*v2.yV,v1.zV*v2.xV-v1.xV*v2.zV,v1.xV*v2.yV-v1.yV*v2.xV);


    }






    public Trian2 trans(){
        return new Trian2(x1,y1,x2,y2,x3,y3);
    }


}


class Trian2{

    double x1;
    double y1;
    double x2;
    double y2;
    double x3;
    double y3;

    public Trian2(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }
}
