MySQL 8.0의 caching_sha2_password 인증 방식 이슈 → mysql_native_password로 전환
DBeaver MySQL 드라이버 설정 이슈 (Maven 좌표 com.mysql:mysql-connector-j 사용, Driver Class 수동 지정 필요)
Hibernate 7.x에서 MySQL8Dialect 클래스 제거됨 → dialect 설정 제거하고 자동 인식 사용
application.yaml 파일 위치 오류 (templates 폴더 안 → resources 바로 아래로 이동 필요)

# TOEIC 단어장 웹앱

비전공자 1인 개발 CRUD 프로젝트 (14일 완성 목표)

## 스택
- Java 21
- Spring Boot 4.1
- Gradle
- MariaDB 11.4 (Docker Compose)
- Thymeleaf
- Lombok

## DB 스키마
\`\`\`sql
CREATE TABLE word_tbl (
id INT PRIMARY KEY AUTO_INCREMENT COMMENT '단어 고유 번호',
vocabulary VARCHAR(100) NOT NULL COMMENT '영단어',
meaning VARCHAR(255) NOT NULL COMMENT '뜻',
example_sentence VARCHAR(500) NOT NULL COMMENT '예문',
is_memorized BOOLEAN NOT NULL DEFAULT FALSE COMMENT '암기 여부',
created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시'
);
\`\`\`

## 로컬 실행
\`\`\`bash
cd docker/mariadb
docker compose up -d
\`\`\`
IntelliJ에서 `ToeicVocabularyApplication` 메인 클래스 실행 → http://localhost:8080

## 진행 로그
- [x] 1~2일차: 환경 세팅, MariaDB Docker 연결, Spring Boot 기동 확인
- [Δ] 3~4일차: Entity/Repository  entity까지 완료
- [ ] 5~7일차: Service + Controller (REST API)
- [ ] 8~10일차: 화면(Thymeleaf) / 검증 로직
- [ ] 11~12일차: 암기 토글, 검색, 페이징
- [ ] 13일차: 통합 테스트
- [ ] 14일차: GitHub 정리 + 배포 연습
