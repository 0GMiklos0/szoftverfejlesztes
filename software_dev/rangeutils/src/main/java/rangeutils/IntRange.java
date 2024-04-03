package rangeutils;

/**
 * Represents a range of integers.
 */
public class IntRange {
    public static final IntRange EMPTY = new IntRange();

    public static final IntRange ALL = new IntRange(Integer.MIN_VALUE, Integer.MAX_VALUE);
    private int min;
    private int max;
    private IntRange(int min, int max){
        this.min = min;
        this.max = max;
    }
    private IntRange(){
        this(Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    public static IntRange of(int min, int max){
        if(min < max) {
            return new IntRange(min, max);
        }
        return new IntRange(max, min);
    }
    //statikus gyarto metodus: ertelmes nevadas lehetosege

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
    public boolean isEmpty(){
        return min == Integer.MAX_VALUE && max == Integer.MIN_VALUE;
    }

    public boolean contains(int value){
        return min <= value && value <= max;
    }
    public boolean isOverlapping(IntRange range){
        return contains(range.getMin()) || contains(range.getMax()) || range.contains(min) || range.contains(max);
    }
    public boolean isDisjoint(){
        return false;
    }
    public IntRange intersect(IntRange range){
        if(isOverlapping(range)){
            return IntRange.of(Integer.max(min, range.getMin()), Integer.min(max, range.getMax()));
        }
        return IntRange.EMPTY;
    }
    public IntRange intersect(IntRange... ranges){
        var result = this;
        for (var range: ranges){
            result = result.intersect(range);
            if(result.isEmpty()){
                break;
            }
        }
        return result;
    }



    @Override
    public boolean equals(Object o){
        return (o instanceof IntRange range) && min == range.getMin() && max == range.getMax();
    }

    @Override
    public int hashCode(){
        int result = 3;
        result = result * 7 + min;
        result = result * 7 + max;
        return result;
    }

    @Override
    public String toString() {
        return isEmpty() ? "[EMPTY]" : String.format("[%d,%d]", min, max);
    }
}
