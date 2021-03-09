public class Vector3 {
    double xV;
    double yV;
    double zV;

    public Vector3(double xV, double yV, double zV) {
        this.xV = xV;
        this.yV = yV;
        this.zV = zV;
    }

    public double length (){
        return Math.sqrt(xV*xV+yV*yV+zV*zV);
    }

    public double  scal(Vector3 oth){
        return this.xV*oth.xV+this.yV*oth.yV+this.zV*oth.zV;
    }

    public double angle(Vector3 oth){
        return scal(oth)/(this.length()*oth.length());
    }





}
