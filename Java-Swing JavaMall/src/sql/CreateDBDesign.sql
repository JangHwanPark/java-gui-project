-- -----------------------------------------------------
-- 데이터 베이스 생성 권한이 없는 관계로 프로젝트 이름과,
-- 테이블 이름을 조합하여 테이블 생성.
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table: java_swing_javaMall_Admin
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `java_swing_javaMall_Admin`
(
    `admin_no`  INT         NOT NULL AUTO_INCREMENT,
    `admin_id`  VARCHAR(30) NOT NULL UNIQUE,
    `admin_pwd` VARCHAR(30) NOT NULL,
    PRIMARY KEY (`admin_no`)
) ENGINE = InnoDB

-- -----------------------------------------------------
-- DEFAULT CHARACTER SET = utf8mb4
-- DB,테이블에서 사용할 기본문자 집합 정의
-- utf8mb4는 유니코드 문자를 최대 4바이트까지 지원 (여러 언어 및 특문 포함)
-- -----------------------------------------------------
  DEFAULT CHARACTER SET = utf8mb4

-- -----------------------------------------------------
-- COLLATE = utf8mb4_0900_ai_ci
-- 문자열 비교 및 정렬시 사용할 규칙(콜레이션) 정의
-- utf8mb4_0900_ai_ci는 대소문자 구분 없이(accents insensitive)문자 비교
-- -----------------------------------------------------
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table: java_swing_javaMall_User
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `java_swing_javaMall_User`
(
    `user_no`       INT                     NOT NULL AUTO_INCREMENT,
    `user_id`       VARCHAR(30)             NOT NULL UNIQUE,
    `user_pwd`      VARCHAR(30)             NOT NULL,
    `address`       VARCHAR(50)             NOT NULL,
    `gender`        ENUM ('Male', 'Female') NULL,
    `phone`         VARCHAR(30)             NOT NULL,
    `birth`         VARCHAR(30)             NULL DEFAULT NULL,
    `admin_user_no` INT                     NOT NULL,
    PRIMARY KEY (`user_no`),
    INDEX `idx_user_admin` (`admin_user_no`),
    CONSTRAINT `fk_user_admin`
        FOREIGN KEY (`admin_user_no`)
            REFERENCES `java_swing_javaMall_Admin` (`admin_no`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table: java_swing_javaMall_Order
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `java_swing_javaMall_Order`
(
    `order_id`     INT                                        NOT NULL AUTO_INCREMENT,
    `price`        DECIMAL(10, 2)                             NOT NULL,
    `state`        ENUM ('Pending', 'Completed', 'Cancelled') NULL,
    `quantity`     INT DEFAULT 1,
    `user_user_no` INT                                        NOT NULL,
    PRIMARY KEY (`order_id`),
    INDEX `idx_order_user` (`user_user_no`),
    CONSTRAINT `fk_order_user`
        FOREIGN KEY (`user_user_no`)
            REFERENCES `java_swing_javaMall_User` (`user_no`)
            ON DELETE CASCADE
            ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table: java_swing_javaMall_Category
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `java_swing_javaMall_Category`
(
    `category_no`   INT         NOT NULL AUTO_INCREMENT,
    `category_name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`category_no`)
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table: java_swing_javaMall_Product
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `java_swing_javaMall_Product`
(
    `product_id`           INT                                              NOT NULL AUTO_INCREMENT,
    `product_name`         VARCHAR(45)                                      NOT NULL UNIQUE,
    `product_img`          VARCHAR(100)                                     NULL,
    `product_state`        ENUM ('Available', 'OutOfStock', 'Discontinued') NOT NULL,
    `order_order_id`       INT                                              NOT NULL,
    `category_category_no` INT                                              NOT NULL,
    PRIMARY KEY (`product_id`),
    INDEX `idx_product_order` (`order_order_id`),
    INDEX `idx_product_category` (`category_category_no`),
    CONSTRAINT `fk_product_order`
        FOREIGN KEY (`order_order_id`)
            REFERENCES `java_swing_javaMall_Order` (`order_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_product_category`
        FOREIGN KEY (`category_category_no`)
            REFERENCES `java_swing_javaMall_Category` (`category_no`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
) ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;