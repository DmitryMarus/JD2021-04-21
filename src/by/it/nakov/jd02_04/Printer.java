package by.it.nakov.jd02_04;

public class Printer {
    void print(Var var) {
        if (var != null) {
            System.out.println(var);
        }
    }
    public void print(CalcException e){
        System.out.println(e.getMessage());
    }
}