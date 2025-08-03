# API 명세서
### 일정 생성
* POST /users/schedules
* 일정 생성 API
* 요청 예시:
```json
{
    "title": "title11",
    "content" : "content11",
    "userName" : "name11",
    "password" : "password11"
}
```

### 전체 사용자 조회
* GET /users/schedules?name=name11
* 전체 사용자 조회 API
* 응답 예시:
```json
[
    {
        "id": 11,
        "title": "진짜 됐다.",
        "content": "content11",
        "userName": "name11",
        "createdAt": "2025-08-04T02:08:33.415861",
        "updatedAt": "2025-08-04T02:08:47.265935"
    },
    {
        "id": 10,
        "title": "진짜 돼라x2",
        "content": "content10",
        "userName": "name11",
        "createdAt": "2025-08-04T02:05:44.843235",
        "updatedAt": "2025-08-04T02:05:53.110045"
    }
]
```

### 제목 수정
* PATCH /schedules/{scheduleId}/titles
* 제목 수정 API
* 요청 예시:
```json
{
    "title" : "진짜 됐다."
}
```

### 사용자 이메일 수정
* PUT /users/{userId}/emails
* 사용자 이메일 수정 API
* 요청 예시:
```json
{
    "userName" : "이름"
}
```

### 일정 삭제
* PUT /schedules/{scheduleId}
* 일정 삭제 API
* 응답 예시:
```json
{
    "password": "password1"
}
```

# ERD
https://www.erdcloud.com/d/hKpkdeAh2NpFLwYBk
