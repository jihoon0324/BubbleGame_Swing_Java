package bubble.test.ex04;

public interface Moveable {
	public abstract void left();
	public abstract void right();
	public abstract void up();
	
         //MoveAdapter를 밑에 메소드 대신 사용해도 되나 다중상속의 제약에 걸려서 요즘에는 안쓴다.
	default public  void down() {};

}
