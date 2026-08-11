# 📚 TOEIC 단어장 (TOEIC Vocabulary CRUD)

14일 로드맵으로 진행한 Java/Spring Boot 기반 CRUD 웹 애플리케이션입니다.

## 🛠 기술 스택
- Java 21
- Spring Boot 4.1
- Spring Data JPA / Hibernate
- MariaDB 11.4 (Docker Compose)
- Thymeleaf
- Gradle
- JUnit 5, MockMvc (통합 테스트)

## ✨ 주요 기능
- 단어 CRUD (등록/조회/수정/삭제)
- 쿠키 기반 로그인/로그아웃 (BCrypt 암호화, HttpOnly/SameSite 쿠키)
- 인터셉터 기반 접근 제어 (미인증 시 로그인 페이지로 리다이렉트)
- 단어/뜻 검색 + 페이징 처리
- 암기 여부 토글 기능
- REST API (`/api/words`) 및 화면(Thymeleaf, `/words`) 이원 제공
- 통합 테스트 (인증 흐름 포함 전체 시나리오 검증)

## 🚀 실행 방법

### 1. MariaDB 실행 (Docker)
\`\`\`bash
cd docker/mariadb
docker-compose up -d
\`\`\`

### 2. DB 스키마 생성
DBeaver 등으로 아래 SQL 실행:
\`\`\`sql
CREATE TABLE word_tbl (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
vocabulary VARCHAR(100) NOT NULL,
meaning VARCHAR(255) NOT NULL,
example_sentence VARCHAR(500) NOT NULL,
is_memorized BOOLEAN NOT NULL DEFAULT FALSE,
created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE user_tbl (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(50) NOT NULL UNIQUE,
password VARCHAR(255) NOT NULL,
created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
\`\`\`

### 3. 애플리케이션 실행
\`\`\`bash
./gradlew bootRun
\`\`\`

### 4. 접속
브라우저에서 `http://localhost:8080/login` 접속
- 테스트 계정: `kyg` / `test1234` (최초 실행 시 자동 생성)

## 📁 프로젝트 구조
\`\`\`
src/main/java/com/kyg/toeicvocabulary/
├── domain/        # Entity (Word, User)
├── repository/    # JPA Repository
├── service/       # 비즈니스 로직
├── controller/    # REST API + 화면 Controller
├── dto/           # 요청 DTO
├── auth/           # 세션/인터셉터
├── config/        # 보안/웹 설정
└── exception/     # 커스텀 예외 + 전역 예외 처리
\`\`\`

## 🧪 테스트
\`\`\`bash
./gradlew test
\`\`\`
- Repository / Service / Controller(MockMvc) 레벨 테스트 포함

## 📝 개발 회고
14일 로드맵으로 진행하며 Spring Boot 4.1의 패키지 구조 변경(테스트 애노테이션 경로 이동 등)에 자주 부딪혔지만, 공식 문서 확인 습관을 들이며 하나씩 해결했습니다.
