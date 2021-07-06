package by.it._classwork_.jd02_04;

public interface Patterns {

    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
    String OPERATION = "(?<=[^-+*/=,{])([-+*/=])";

    //2+2
    //{-1,-2}*{3.0,444.889}
    //{{1,2,3},{4,5,6}}/9
    //{2,3}-7

    //A=2+-4*-2/8
}