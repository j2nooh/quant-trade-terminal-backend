# Quant Trade Terminal Backend

KIS(한국투자증권) Open API를 활용한 자동매매/시세조회 백엔드 프로젝트

## 기술 스택
- Java 17, Spring Boot 3.x
- Spring WebFlux (WebClient)
- PostgreSQL
- springdoc-openapi (Swagger UI)

## 주요 기능
- [x] KIS OAuth 토큰 발급 및 캐싱
- [x] 국내주식 현재가 조회
- [ ] (진행 예정 기능들 추가 예정)

<img width="2720" height="2144" alt="kis_price_request_flow" src="https://github.com/user-attachments/assets/df34993f-80ce-4e80-9422-8f708c0a3c11" />


## 실행 방법

### 1. 환경 설정
`src/main/resources/application-secret.yml` 파일을 아래 형식으로 생성 (git에 포함되지 않음)

```yaml
kis:
  appkey: [발급받은 appkey]
  appsecret: [발급받은 appsecret]
  base-url: https://openapivts.koreainvestment.com:29443

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/[db명]
    username: [username]
    password: [password]
```

### 2. 실행
```bash
./gradlew bootRun
```

### 3. API 문서 확인
브라우저에서 `http://localhost:8080/swagger-ui.html` 접속

## 프로젝트 구조
```
src/main/java/.../
├── config/          # WebClient, KisProperties 등 설정
├── client/          # KIS API 연동 클라이언트 (Auth, Price 등)
└── controller/       # 테스트/API 엔드포인트
```

## 브랜치 전략
- `main`: 안정 버전
- `feat/*`: 기능 단위 개발 브랜치, PR을 통해 merge

## 참고
- 현재 모의투자 환경(Virtual Trading) 기준으로 개발 중
- [KIS Open API 공식 문서](https://apiportal.koreainvestment.com/)
