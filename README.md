# clean-architecture
순수 도메인으로 간단한 비즈니스 로직을 처리해보고, 자주 사용되는 패키지를 의존 사이클 없이 구성해보기

> 만들면서 배우는 클린 아키텍처 도서를 참고했습니다.

### 계기

저는 경험은 별로 없지만 평소에 아키텍처에 대해 관심이 많았습니다. 실무에서는 흔히 사용하고 있는 controller, service, repository 구조의 레이어드 아키텍처를 사용하고 있었습니다.

여러 프로젝트에서의 레이어드 아키텍처를 보면서 단순히 패키지만 레이어드 아키텍처이지 실제 레이어드 아키텍처의 의미가 사라져 있었습니다.

예를 들어 하위 레이어들이 상위 레이어의 패키지를 의존하게 되는 상황들과 특정 패키지 내에서 서로 의존 사이클이 존재하는 경우도 있었습니다. 
또한, 스프링은 비침투적 기술을 지향하지만 패키지는 외부 기술에 깊게 의존하고 있는 모습을 자주 보았습니다.

이로 인해, 테스트는 점점 모킹밭(?)이 되고 정작 테스트해야할 대상보다 모킹하는 녀석들이 더 많아지고 테스트의 의미는 없어진다는 생각을 했습니다.

물론 이런 아키텍처는 귀여울 정도의 거미줄같은 망 형식의 아키텍처(?)도 겪어보았습니다.

그래서 직접 클린 아키텍처의 핵심 규칙을 최대한 지키면서 아키텍처를 구성해보고 싶었습니다.


### 도서 외 고민

첫 번째로 매번 JPA에 종속적으로 개발을 했기 때문에 도메인 엔티티와 jpa 엔티티를 구분해서 jpa로부터의 종속성을 분리해서 비즈니스 로직을 처리한다는 것이 쉽게 이해가 되지 않았는데, 해당 도서를 보면서 종속성을 어떻게 분리를 해야하는지 어떻게 도메인을 고립시키는지에 대해서 이해하게 되었습니다. 

하지만, 도메인에서 비즈니스 로직에 대한 예시 어떻게 처리를 해야할지에 대한 고민해보며 간단한 비즈니스 로직을 처리하는 코드를 추가해보았습니다. (당연하게도 정답이 아닐 수 있습니다.)

여러 비즈니스 로직을 추가한 것이 아니라서 아직 헷갈리는건 영속 과정에서의 입력 모델과 반환 모델을 어떻게 구성해야할지 모르겠습니다. 도서에서는 그것 마저도 정답이 없다고 하는데, 여전히 저는 무엇이 맞는지에 대한 생각에 갇혀있습니다.

구체적으로, Command, Query 객체 모두 port.in, port.out에 입력 모델을 사용해도 될지에 대한 고민입니다. 어차피 포트쪽에 위치하기 때문에 어댑터들은 항상 외부에서 내부로 의존할 수 밖에 없기 때문에 클린 아키텍처의 핵심 규칙은 지키고 있습니다.

두 번째로 예제 이외에 실제로 실무에서 사용되는 패키지(vo, dto, exception, exception handler 등)를 추가해보았습니다. 의존 사이클은 intellij의 analyze 기능을 활용해서 의존 매트릭스를 계속 확인해보며 적절한 위치를 고민해보았습니다.


### 마무리

은탄환은 없다라는 말을 Robert C. Martin의 [클린 아키텍처 포스트](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)를 보면서 다시 한 번 느꼈습니다.

그 이유는 사실 클린 아키텍처의 핵심 규칙은 사실 그리 많지 않기 때문입니다. 해당 포스트는 기본적인 구성의 4개의 원(4개일 필요는 없음)에서 내부의 원은 외부의 원을 전혀 알 수 없어야 한다는 것과 각 원(혹은 레이어)에서의 역할에 대해 설명하고 있는 글입니다.

이로 인해 다양한 개발자들끼리 더 좋은 아키텍처를 위한 고민들로 토론의 장을 벌이는 아티클도 자주 보게 됩니다. 이러한 고민들이 더 견고한 아키텍처를 만들어나가는 `클린 아키텍처라는 과정`이 아닐까 생각됩니다.