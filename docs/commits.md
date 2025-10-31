# **커밋 메시지 형식**

[커밋 컨벤션 출처](https://gist.github.com/stephenparish/9941e89d80e2bc58a153#allowed-type)

기본적인 형식은 다음과 같습니다.

```
<type>(<scope>): <subject>

<body>

<footer>
```

* 모든 줄은 100자를 넘지 않아야 합니다.

### **1. Subject (제목)**

제목 줄은 `<type>(<scope>): <subject>` 형식입니다.

* **`<type>`**: 커밋의 유형을 나타냅니다.
    * `feat`: 새로운 기능
    * `fix`: 버그 수정
    * `docs`: 문서
    * `style`: 코드 스타일 (포맷팅, 세미콜론 등)
    * `refactor`: 코드 리팩토링
    * `test`: 테스트 추가
    * `chore`: 유지보수 (빌드 스크립트 수정 등)
* **`<scope>`** (선택 사항): 커밋이 변경한 부분의 범위를 나타냅니다. (예: `$location`, `$browser`, `ngHref` 등)
* **`<subject>`**: 변경 사항에 대한 간결한 설명입니다.
    * **명령형, 현재 시제**를 사용합니다. (예: "change" - "changed"나 "changes" X)
    * 첫 글자를 대문자로 쓰지 않습니다.
    * 끝에 마침표(.)를 찍지 않습니다.

### **2. Body (본문)**

* 제목(Subject)과 한 줄을 비워(BLANK LINE) 분리합니다.
* **왜** 이 변경 사항이 필요한지, 그리고 **이전 동작과 어떻게 다른지** 설명합니다.
* 제목과 마찬가지로 명령형, 현재 시제를 사용합니다.

### **3. Footer (꼬리말)**

* 본문(Body)과 한 줄을 비워(BLANK LINE) 분리합니다.
* **Breaking Changes (주요 변경 사항)**: 하위 호환성을 깨뜨리는 변경 사항이 있다면 `BREAKING CHANGE:` 키워드로 시작하여 설명, 정당성, 마이그레이션 노트를 포함해야 합니다.
* **Referencing Issues (이슈 참조)**: 닫힌 이슈가 있다면 `Closes #123` 또는 `Closes #123, #245`와 같이 별도의 줄에 기재합니다.