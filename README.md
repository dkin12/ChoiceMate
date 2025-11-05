# ChoiceMate 초이스메이트

## 💡 프로젝트 개요: 밸런스 게임 투표 시스템

사용자는 투표하고 댓글을 남길 수 있고, 관리자는 새 밸런스 게임을 등록·수정·삭제하면서 투표율 통계를 확인할 수 있는 서비스

##  🧱 프로젝트 주요기능 


| 구분       | 기능                        | 설명                                |
| -------- | ------------------------- | --------------------------------- |
| 📜 메인 화면| 게시글 상세 보기                 | 제목, 내용, 선택지 A/B, 투표현황, 댓글 표시      |
| 🎯 투표    | 선택지 A 또는 B 클릭 시 해당 카운트 증가 | Post 테이블의 `votes_a`, `votes_b` 증가 |
| 💬 댓글    | 댓글 작성                     | 이름, 비밀번호, 내용 입력하여 댓글 추가           |
|          | 댓글 수정                     | 본인 비밀번호 검증 후 수정 가능                |
|          | 댓글 삭제                     | 본인 비밀번호 검증 후 삭제 가능                |


## POST 

| 컬럼명          | 타입           | 제약조건                        | 설명        |
| ------------ | ------------ | --------------------------- | --------- |
| `id`         | BIGINT       | PK, AUTO_INCREMENT          | 게시글 고유 ID |
| `title`      | VARCHAR(200) | NOT NULL                    | 제목        |
| `content`    | TEXT         |                             | 게시글 내용    |
| `option_a`   | VARCHAR(200) | NOT NULL                    | 선택지 A     |
| `option_b`   | VARCHAR(200) | NOT NULL                    | 선택지 B     |
| `votes_a`    | INT          | DEFAULT 0                   | 선택지 A 투표수 |
| `votes_b`    | INT          | DEFAULT 0                   | 선택지 B 투표수 |
| `created_at` | DATETIME     | DEFAULT CURRENT_TIMESTAMP   | 등록일       |
| `updated_at` | DATETIME     | ON UPDATE CURRENT_TIMESTAMP | 수정일       |


## Comment 
| 컬럼명          | 타입           | 제약조건                        | 설명                 |
| ------------ | ------------ | --------------------------- | ------------------ |
| `id`         | BIGINT       | PK, AUTO_INCREMENT          | 댓글 ID              |
| `post_id`    | BIGINT       | FK → `Post.id`              | 댓글이 달린 게시글         |
| `name`       | VARCHAR(50)  | NOT NULL                    | 작성자 이름             |
| `password`   | VARCHAR(255) | NOT NULL                    | 비밀번호 (수정/삭제 시 검증용) |
| `content`    | TEXT         | NOT NULL                    | 댓글 내용              |
| `created_at` | DATETIME     | DEFAULT CURRENT_TIMESTAMP   | 작성일                |
| `updated_at` | DATETIME     | ON UPDATE CURRENT_TIMESTAMP | 수정일                |


### 🙌 Team Members 
| 이채연 <br/> [@dkin12](https://github.com/dkin12) | 김대영 <br/> [@dae0kim](https://github.com/dae0kim) | 권소령 <br/> [@SoRrrrrrr](https://github.com/SoRrrrrrr) | 박근모 <br/> [@GM-Park](https://github.com/GM-Park) |
|:--:|:--:|:--:|:--:|
