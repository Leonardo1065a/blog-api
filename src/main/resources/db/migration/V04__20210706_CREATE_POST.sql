CREATE TABLE POST (
	ID BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    TITLE VARCHAR(50) NOT NULL,
    DESCRIPTION VARCHAR(255) NOT NULL,
    URL_IMG VARCHAR(255) NOT NULL,
    USER_ID BIGINT(20) NOT NULL,
    DT_CRIACAO DATETIME NOT NULL,
    FOREIGN KEY (USER_ID) REFERENCES USER(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;