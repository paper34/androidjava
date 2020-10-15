package bean;

public class CartInfo {
	String name;
	int adult;
	int teen;
	int child;
	int total;
	public CartInfo () {
		adult = 0;
		teen = 0;
		child = 0;
		total = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAdult() {
		return adult;
	}
	public void setAdult(int adult) {
		this.adult = adult;
	}
	public int getTeen() {
		return teen;
	}
	public void setTeen(int teen) {
		this.teen = teen;
	}
	public int getChild() {
		return child;
	}
	public void setChild(int child) {
		this.child = child;
	}
	public int setTotal() {
		total = adult * 12000 + teen * 9000 + child * 6000;
		return total;
	}
	@Override
	public String toString() {
		return "CartInfo [name=" + name + ", adult=" + adult + ", teen=" + teen + ", child=" + child + "]";
	}
}
