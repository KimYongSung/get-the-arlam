# 알림 발송 API 서버

## 구성 라이브러리

* spring-data-jpa
  * database 사용하기 위해 설정
* spring-session-jdbc
  * 추후 session 클러스터링을 위하여 설정.
  * 서비스가 커진다면 jdbc가 아닌 redis로 변경 가능
* lombok
  * 반복적인 코드들을 줄이기 위해서 사용.
* h2
  * 우선 로컬에서 사용하기 위해 사용.
* spring-oauth2-client
  * 구글, 페이스북 등등 OAuth2 인증을 손쉽게 연동가능.

