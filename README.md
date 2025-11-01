# ChoiceMate 초이스메이트

## 💡 프로젝트 개요: 밸런스 게임 투표 시스템

사용자는 투표하고 댓글을 남길 수 있고, 관리자는 새 밸런스 게임을 등록·수정·삭제하면서 투표율 통계를 확인할 수 있는 서비스.

##  🧱 프로젝트 주요기능 

### 👤 사용자 기능

| 기능           | 설명                | CRUD      |
| ------------ | ----------------- | --------- |
| 밸런스 게임 목록 보기 | 등록된 게임들 목록        | **R**     |
| 투표하기         | ①번 or ②번 선택       | **C / U** |
| 투표율 보기       | 각 선택지의 비율 시각화     | **R**     |
| 댓글 작성        | 각 밸런스 게임 밑에 댓글 작성 | **C**     |
| 댓글 수정/삭제     | 본인 댓글만 가능         | **U / D** |

### 🛠 관리자 기능

| 기능        | 설명               | CRUD  |
| --------- | ---------------- | ----- |
| 밸런스 게임 등록 | 예: “짜장 vs 짬뽕”    | **C** |
| 밸런스 게임 수정 | 텍스트나 이미지 수정      | **U** |
| 밸런스 게임 삭제 | 오래된 게임 삭제        | **D** |
| 통계 보기     | 각 게임별 투표율, 참여자 수 | **R** |


```
User
 ├─ id (PK)
 ├─ username
 ├─ password
 └─ role (user / admin)

Game
 ├─ id (PK)
 ├─ title (예: 짜장 vs 짬뽕)
 ├─ option_a
 ├─ option_b
 ├─ created_at
 ├─ created_by (FK → User.id)

Vote
 ├─ id (PK)
 ├─ user_id (FK → User.id)
 ├─ game_id (FK → Game.id)
 ├─ choice (A or B)
 ├─ voted_at

Comment
 ├─ id (PK)
 ├─ user_id (FK → User.id)
 ├─ game_id (FK → Game.id)
 ├─ content
 ├─ created_at
 └─ updated_at

```
