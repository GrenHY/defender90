package day03;
/**
 * 作为集合元素进行测试的类
 * @author Administrator
 *
 */
public class Cell {
	public int x;
	public int y;
	public Cell(int x,int y){
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "("+x + "," + y+")";
	}
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (obj instanceof Cell){
			Cell c = (Cell) obj;
			return this.x==c.x&&this.y==c.y;
		}
		return false;
	}
	
}
