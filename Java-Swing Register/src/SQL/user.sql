# Create UserTable
CREATE TABLE java_swing_register_member
(
    user_no  INT PRIMARY KEY AUTO_INCREMENT,
    user_id  VARCHAR(30) NOT NULL,
    user_pwd VARCHAR(30) NOT NULL,
    address  VARCHAR(50) NOT NULL,
    gender   VARCHAR(10) CHECK (gender IN ('F', 'M')),
    phone    VARCHAR(30) NOT NULL,
    birth    VARCHAR(30),
    UNIQUE KEY unique_name (user_id)
);

# Insert DummyData
INSERT INTO java_swing_register_member (user_id, user_pwd, address, gender, phone, birth)
VALUES ('홍길동', 'pwd01', '서울시 강남구 테헤란로 123', 'F', '010-1234-1236', '1990-01-01'),
       ('김철수', 'pwd02', '서울시 서초구 방배로 456', 'M', '010-1237-6312', '1991-02-01'),
       ('이영희', 'pwd03', '서울시 송파구 올림픽로 789', 'F', '010-2222-1242', '1992-03-01'),
       ('박민수', 'pwd04', '서울시 강동구 천호대로 321', 'M', '010-1234-7231', '1993-04-01'),
       ('정수미', 'pwd05', '부산시 해운대구 구남로 654', 'F', '010-3333-4311', '1994-05-01'),
       ('손흥민', 'pwd06', '경기도 성남시 분당구 황새울로 987', 'M', '010-1234-0006', '1995-06-01'),
       ('강호동', 'pwd07', '강원도 강릉시 경강로 135', 'F', '010-2341-2162', '1996-07-01'),
       ('유재석', 'pwd08', '경기도 고양시 일산로 246', 'M', '010-9642-1241', '1997-08-01'),
       ('이광수', 'pwd09', '대구시 중구 달구벌대로 357', 'F', '010-5436-4141', '1998-09-01'),
       ('김종국', 'pwd10', '울산시 남구 문수로 468', 'M', '010-6453-2523', '1999-10-01');