package bubble.test.ex04;

public interface Moveable {
	public abstract void left();
	public abstract void right();
	public abstract void up();
	
         //MoveAdapter를 밑에 메소드 대신 사용해도 되나 다중상속의 제약에 걸려서 요즘에는 안쓴다.
	default public  void down() {}; // default 인터페이스도 몸체가 있는 메서드를 만들수있다 ( 다중상속이 안되는 상황에서 사용하기 위해 )
	default public  void attack() {};
}
