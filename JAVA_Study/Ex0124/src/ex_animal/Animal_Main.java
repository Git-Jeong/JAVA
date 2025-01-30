package ex_animal;

// Animal_Main 클래스
public class Animal_Main extends Animals {

    public static void main(String[] args) {
        // ** 업캐스팅(Upcasting) **
        // 자식 클래스 객체를 부모 클래스 타입으로 자동 형 변환하는 것
        // 부모 클래스 타입으로 변환되기 때문에 부모 클래스에서 정의된 멤버 변수와 메서드만 접근 가능
    	// 자식인 개, 고양이가 부모인 동물이 되는 것
        Dog dog = new Dog();             // Dog 클래스 객체 생성
        Animals animal_dog = dog;       // 자동 형 변환(업캐스팅)

        // 업캐스팅된 객체를 사용할 경우
        System.out.println("Upcasting된 Dog의 class를 호출");
        animal_dog.bark();              // Animals 클래스에 정의된 메서드만 호출 가능
        // animal_dog.tail();           // 컴파일 에러: Animals에는 tail() 메서드가 없음

        // 원래 객체(Dog)에서는 모든 메서드 호출 가능
        System.out.println("원래 Dog에서 class를 직접 호출");
        dog.bark();                     // Dog 클래스의 메서드
        dog.tail();                     // Dog 클래스의 고유 메서드

        // ** 다운캐스팅(Downcasting) **
        System.out.println("DownCasting : ");
        // 부모 클래스 타입의 객체를 자식 클래스 타입으로 강제 형 변환하는 것
        // 조건: 부모 클래스 타입의 객체가 실제로 자식 클래스 객체일 때만 가능
        Animals animal_dog1 = new Dog(); // 부모 타입에 자식 객체 할당(업캐스팅 상태)

        if (animal_dog1 instanceof Dog) { // 타입 확인: animal_dog1이 실제로 Dog 타입인지 확인
            Dog dog1 = (Dog) animal_dog1; // 안전하게 다운캐스팅
            dog1.bark();                 // Dog 클래스의 메서드 호출
            dog1.tail();                 // Dog 클래스의 고유 메서드 호출
        } else {
            System.out.println("animal_dog1은 Dog 타입이 아닙니다.");
        }

        // ** 잘못된 다운캐스팅의 예시 **
        // 부모 클래스 타입의 객체가 자식 클래스 객체가 아닌 경우 다운캐스팅 시 런타임 오류 발생
        Animals animal_dog2 = new Animals(); // Animals 클래스의 객체 생성
        try {
            Dog dog2 = (Dog) animal_dog2;    // 강제 형 변환 시도 (잘못된 다운캐스팅)
        } catch (ClassCastException e) {
            System.out.println("다운캐스팅 실패: " + e.getMessage());
        }
    }
}
