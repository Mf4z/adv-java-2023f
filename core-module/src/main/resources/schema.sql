-- src/main/resources/schema.sql
CREATE TABLE IF NOT EXISTS COMPETITOR (
                                          id INT AUTO_INCREMENT PRIMARY KEY,
                                          family_name VARCHAR(255),
    given_name VARCHAR(255),
    gender VARCHAR(50),
    country VARCHAR(255),
    birth_date DATE,
    height INT,
    belt VARCHAR(255)
    );
