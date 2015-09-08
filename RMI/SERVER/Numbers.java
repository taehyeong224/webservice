import java.util.HashMap;
import java.io.Serializable;

public class Numbers implements Serializable {
	HashMap numbers;

	public Numbers(int size){
		numbers = new HashMap(size);
	}

	public void setNumber(int key, int value) {
		numbers.put(key,value);
	}

	public int getNumber(int key) {
		return (Integer)numbers.get(key);
	}

	public int size() {
		return numbers.size();
	}
}