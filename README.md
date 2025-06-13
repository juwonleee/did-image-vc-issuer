# did-image-vc-issuer

## VC Image Issuer (DID 기반 VC 발급 데모)

이 프로젝트는 사용자가 이미지를 업로드하면, 해당 이미지에 대해 DID 기반 Verifiable Credential(VC)을 생성해주는 전체 흐름을 보여주는 데모입니다.

## 📁 프로젝트 구조
vc-image-issuer/
├── frontend/   # React 기반 프론트엔드
├── backend/    # Spring Boot 기반 백엔드

## 🚀 기능 요약

- ✅ 이미지 업로드 UI (프론트)
- ✅ 이미지 업로드 → 서버 저장
- ✅ 이미지 기반 DID 생성
- ✅ Verifiable Credential 생성 및 응답 반환
- ✅ VC 발급 결과 프론트에서 출력

## 🔧 기술 스택

- Frontend: React + Axios
- Backend: Spring Boot + Java + Multipart 이미지 처리
- DID/VC: 자체 로직 또는 외부 DID lib 사용

## 📦 실행 방법

### 1. 백엔드

```
bash
cd backend
./gradlew bootRun
```

•	서버는 기본적으로 http://localhost:8091 에서 실행됩니다.

### 2. 프론트엔드
```
cd frontend
npm install
npm start
```

•	package.json의 "proxy" 설정으로 /api 요청은 백엔드로 전달됩니다.

