package bubble.test.ex00;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Dog{
	 private String name;
 
}


public class LombookTest {
 
	public static void main(String[] args) {
		Dog d = new Dog();
		d.setName("testDog");
		System.out.println(d.getName());
		
	}

	
}
