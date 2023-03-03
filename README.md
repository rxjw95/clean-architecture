# clean-architecture
순수 도메인으로 간단한 비즈니스 로직을 처리해보고, 자주 사용되는 패키지를 의존 사이클 없이 구성해보기

> 만들면서 배우는 클린 아키텍처 도서를 참고했습니다.

### 계기

저는 경험은 별로 없지만 평소에 아키텍처에 대해 관심이 많았습니다. 실무에서는 흔히 사용하고 있는 controller, service, repository 구조의 레이어드 아키텍처를 사용하고 있었습니다.

여러 프로젝트에서의 레이어드 아키텍처를 보면서 단순히 패키지만 레이어드 아키텍처이지 실제 레이어드 아키텍처의 의미가 사라져 있었습니다.

예를 들어 하위 레이어들이 상위 레이어의 패키지를 의존하게 되는 상황들과 특정 패키지 내에서 서로 의존 사이클이 존재하는 경우도 있었습니다. 
또한, 스프링은 비침투적 기술을 지향하지만 패키지는 외부 기술의 실제 구현체에 의존하고 있는 모습을 자주 보았습니다.

이로 인해, 테스트는 점점 모킹밭(?)이 되고 정작 테스트해야할 대상보다 모킹하는 녀석들이 더 많아지고 테스트의 의미는 없어진다는 생각을 했습니다.

물론 이런 아키텍처는 귀여울 정도의 거미줄같은 망 형식의 아키텍처(?)도 겪어보았습니다.

그래서 직접 클린 아키텍처의 핵심 규칙을 최대한 지키면서 아키텍처를 구성해보고 싶었습니다.


### 도서 외 고민

첫 번째로 매번 JPA에 종속적으로 개발을 했기 때문에 도메인 엔티티와 jpa 엔티티를 구분해서 jpa로부터의 종속성을 분리해서 비즈니스 로직을 처리한다는 것이 쉽게 이해가 되지 않았는데, 해당 도서를 보면서 종속성을 어떻게 분리를 해야하는지 어떻게 도메인을 고립시키는지에 대해서 이해하게 되었습니다. 

하지만, 도메인에서 비즈니스 로직에 대한 예제가 풍부하진 않아 여러 겨웅에 대해 어떻게 처리를 해야할지 고민해보며 간단한 비즈니스 로직을 처리하는 코드를 추가해보았습니다. (당연하게도 정답이 아닐 수 있습니다.)

하지만, JPA를 보통 사용해서 변경할 일이 없는 상황이라면 JPA Entity를 도메인 모델로 구성하는게 오히려 좋다는 생각을 가지고 있는게, 도메인과 JPA 엔티티를 분리하게 되면 JPA 엔티티가 제공하는 더티 체킹이나 지연 로딩의 기능을 쉽게 사용할 수 없을 것 같다는 생각이 듭니다. 일반적으로 서비스에서 JPA 엔티티 도메인을 가져와서 비즈니스 로직을 처리하지만, 클린 아키텍처를 적용하게 되면 JPA 기술을 외부 영속성 패키지(최외곽 구심)에서 관리하고 있기 때문에 애플리케이션 패키지(도메인과 가장 인접한 구심점)에서 외부를 의존하면 안되기 때문입니다.  

이러한 문제도 결국 은탄환은 없다고 생각합니다. 개발에 있어서 속한 팀 그리고 개발해야할 프로젝트의 환경 등 여러 복합적인 요소들이 고려되기 때문에 JPA 엔티티를 도메인으로 사용해도 틀렸다고 말할 수 없습니다.  
저 또한 토이 프로젝트를 진행할 때 JPA를 사용하고 의존 관계만 주의하면서 일반적인 controller, service, domain으로 간단한 레이어드 아키텍처로 구성하려고 합니다.

두 번째로 예제 이외에 실제로 실무에서 사용되는 패키지(vo, dto, exception, exception handler 등)를 추가해보았습니다. 의존 사이클은 intellij의 analyze 기능을 활용해서 의존 매트릭스를 계속 확인해보며 적절한 위치를 고민해보았습니다.


### 마무리

결과적으로 다음과 같은 다이어그램이 생성되었습니다.
<img width="1273" alt="image" src="https://user-images.githubusercontent.com/62179353/222111904-4fe714e7-29f3-4162-b78b-bcbf616817de.png">

의존의 방향을 볼 수 있듯이 애플리케이션 차원에서 비즈니스 로직이 보호되고 있고, 외부 웹이나 디비에 종속적이지 않고 의존성 역전을 통해 애플리케이션의 서비스는 외부 기술에 대해 알지 못해서 비즈니스 플로우를 유지할 수 있게 됩니다.

은탄환은 없다라는 말을 Robert C. Martin의 [클린 아키텍처 포스트](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)를 보면서 다시 한 번 느꼈습니다.

그 이유는 사실 클린 아키텍처의 핵심 규칙은 사실 그리 많지 않기 때문입니다. 해당 포스트는 기본적인 구성의 4개의 원(4개일 필요는 없음)에서 내부의 원은 외부의 원을 전혀 알 수 없어야 한다는 것과 각 원(혹은 레이어)에서의 역할에 대해 설명하고 있는 글입니다.

이로 인해 다양한 개발자들끼리 더 좋은 아키텍처를 위한 고민들로 토론의 장을 벌이는 아티클도 자주 보게 됩니다. 이러한 고민들이 더 견고한 아키텍처를 만들어나가는 `클린 아키텍처라는 과정`이 아닐까 생각됩니다.
