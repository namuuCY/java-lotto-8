# java-lotto-precourse

---

# 문서 링크

- [요구사항 정리](docs/requirements.md)
- [커밋 컨벤션](docs/commits.md)
- [예외처리 사항 정리](docs/exceptions.md)
- [테스트 문서](docs/tests.md)

# 기능 목록

| 구분 | 기능 내용                       |           관련 예외            |
|:--:|-----------------------------|:--------------------------:|
| A  | 요구사항에 부합하는 Error Formatting | [🔗](docs/exceptions.md#a) |
| B  | 구입 금액 입력                    | [🔗](docs/exceptions.md#b) |
| C  | 예외 출력 시 구입 금액 입력 요구 재시도     | [🔗](docs/exceptions.md#c) |
| D  | 입력한 금액 만큼의 당첨 번호 출력         | [🔗](docs/exceptions.md#d) |
| E  | 당첨번호 입력                     | [🔗](docs/exceptions.md#e) |
| F  | 예외 출력 시 당첨 번호 입력 요구 재시도     | [🔗](docs/exceptions.md#f) |
| G  | 보너스 번호 입력                   | [🔗](docs/exceptions.md#g) |
| H  | 예외 출력 시 보너스 번호 입력 요구 재시도    | [🔗](docs/exceptions.md#h) |
| I  | 당첨 통계 종합                    | [🔗](docs/exceptions.md#i) |
| J  | 당첨 통계 리스트 출력                | [🔗](docs/exceptions.md#j) |
| K  | 수익률 출력                      | [🔗](docs/exceptions.md#k) |

# 자의적으로 추가한 요구사항

- 구입 금액은 10만원의 한도를 갖습니다.(로또 1인 구매액 한도와 동일)
- 최소 구입 금액은 1000원 입니다.

디렉토리 구조
---

```
.
├── Application.java
├── configuration
│   └── AppConfig.java
├── controller
│   ├── LottoController.java
│   └── dto
│       ├── PurchasedLotto.java
│       └── WinningStatistics.java
├── domain
│   ├── entity
│   │   └── Customer.java
│   ├── service
│   │   ├── LottoGenerator.java
│   │   └── RandomLottoGenerator.java
│   └── vo
│       ├── BonusNumber.java
│       ├── Lotto.java
│       ├── Payment.java
│       ├── ProfitRate.java
│       ├── Rank.java
│       ├── Statistics.java
│       └── WinningLotto.java
├── exception
│   ├── DomainException.java
│   └── ExceptionCode.java
├── service
│   └── LottoService.java
└── view
    ├── Announcement.java
    ├── InputReader.java
    └── OutputWriter.java

```

테스트 디렉토리 구조
---

```
.
├── ApplicationTest.java
├── domain
│   ├── entity
│   │   └── CustomerTest.java
│   ├── service
│   │   └── StubLottoGenerator.java
│   └── vo
│       ├── BonusNumberTest.java
│       ├── LottoTest.java
│       ├── PaymentTest.java
│       ├── ProfitRateTest.java
│       ├── RankTest.java
│       ├── StatisticsTest.java
│       └── WinningLottoTest.java
└── exception

```

