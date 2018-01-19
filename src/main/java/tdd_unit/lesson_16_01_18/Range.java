package tdd_unit.lesson_16_01_18;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Range {

    private long lowerBound;
    private long upperBound;

    @Override
    public String toString() {
        return "Range{" +
                "lowerBound=" + lowerBound +
                ", upperBound=" + upperBound +
                '}';
    }

    public Range(long lowerBound, long upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    boolean isBefore(Range otherRange) {
        return this.getUpperBound() < otherRange.getLowerBound();
    }

    boolean isAfter(Range otherRange) {
        return this.getLowerBound() > otherRange.getUpperBound();
    }

    boolean isConcurrent(Range otherRange) {
        return (this.getUpperBound() > otherRange.getLowerBound() && this.getUpperBound() < otherRange.getUpperBound()) ||
                (this.getLowerBound() < otherRange.getUpperBound() && this.getLowerBound() > otherRange.getLowerBound());
    }

    long getLowerBound() {
        return this.lowerBound;
    }

    long getUpperBound() {
        return this.upperBound;
    }

    boolean contains(long value) {
        return this.getLowerBound() <= value && value <= this.getUpperBound();
    }

    List<Long> asList() {
        List<Long> list = new ArrayList<>();
        for (long i=lowerBound; i<=upperBound;i++){
            list.add(i);
        }
        return list;
    }

    Iterator<Long> asIterator() {
        return asList().iterator();
    }
}
