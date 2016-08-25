package cc.openhome;

import java.util.Arrays;

public class ArrayList {
    private Object[] list;
    private int next;
    
    public ArrayList() {
        this(16);
    }
   
    public ArrayList(int capacity) {
        list = new Object[capacity];
    }
    
    public void add(Object o) {
        if(next == list.length) {
            list = Arrays.copyOf(list, list.length * 2);
        }
        list[next++] = o;
    }
    
    public Object get(int index) {
        return list[index];
    }
    
    public int size() {
        return next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ArrayList{");
        int last = next - 1;
        for(int i = 0; i < last; i++) {
            builder.append(list[i]);
            builder.append(", ");
        }
        builder.append(list[last]);
        builder.append("}");
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArrayList other = (ArrayList) obj;
        if (this.next != other.next) {
            return false;
        }
        if (!Arrays.deepEquals(this.list, other.list)) {
            return false;
        }
        return true;
    }
}
