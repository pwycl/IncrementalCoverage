package nl.bigo.curta.function;

public class GetExponent extends Function {

    public GetExponent() {
        super("getExponent");
    }

    @Override
    public Object eval(Object... params) {

        super.checkNumberOfParams(1, 1, params);

        return Math.getExponent(super.getDouble(0, params));
    }
}
