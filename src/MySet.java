import java.util.*;

public class MySet extends HashSet<String> {
    private static final long serialVersionUID = 1L;

    public MySet() {
        super();
    }

    /**
     * @return the union of the elements of this and that
     */
    public MySet union(MySet that) {
        MySet result = new MySet();
        if(that == null) {
            result.addAll(this);
            return result;
        }

        this.stream().forEach(element -> result.add(element));
        that.stream().forEach(element -> result.add(element));
        return result;
    }

    /**
     * @return the intersection of the elements of this and that
     */
    public MySet intersection(MySet that) {
        MySet result = new MySet();
        if(that == null)
            return result;

        this.stream().filter(element -> that.contains(element)).forEach(element -> result.add(element));
        return result;
    }

    /**
     * @return the difference of the elements of this and that
     */
    public MySet difference(MySet that) {
        MySet result = new MySet();
        if(that == null) {
            result.addAll(this);
            return result;
        }

        this.stream().filter(element -> !that.contains(element)).forEach(element -> result.add(element));
        return result;
    }

    /**
     * @return the exclusive or (XOR) of the elements of this and that
     */
    public MySet exclusiveOr(MySet that) {
        MySet result = new MySet();
        if(that == null) {
            result.addAll(this);
            return result;
        }

        result.addAll(this.difference(that));
        result.addAll(that.difference(this));
        return result;
    }

    /**
     * @return a String representation of a MySet object
     */
    public String toString() {
        String s = "<MySet{";
        Iterator<String> it = this.iterator();
        while(it.hasNext())
            s += it.next() + ",";
        s = s.substring(0, s.length()-1);
        s += "}>";
        return s;
    }

}
//
