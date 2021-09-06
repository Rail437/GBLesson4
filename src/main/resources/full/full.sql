BEGIN ;

DROP TABLE IF EXISTS Persons;
CREATE TABLE Persons
(
    id         bigserial PRIMARY KEY,
    name       VARCHAR(255),
    product_id bigint NOT NULL,
    CONSTRAINT product_id_fk FOREIGN KEY (product_id)
        REFERENCES product_entity (description) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
INSERT INTO Persons (name, product_id)
VALUES ('Bob', 1);

DROP TABLE IF EXISTS Products;
CREATE TABLE Products
(
    id          bigserial PRIMARY KEY,
    description VARCHAR(255),
    coast       int,
    company     VARCHAR(255)
);

INSERT INTO Products (description, coast, company)
VALUES ('Молоко', 40, 'Звенигово'),
       ('Мясо', 200, 'Йола'),
       ('Яйца', 75, 'Звенигово'),
       ('Колбаса', 189, 'Йола'),
       ('Яблоки', 89, 'Глобал'),
       ('Сыр', 167, 'Йола'),
       ('Сыр', 220, 'Lebendorf');

DROP TABLE IF EXISTS simple_items;
CREATE TABLE simple_items
(
    id    bigserial PRIMARY KEY,
    title VARCHAR(255),
    price int
);
INSERT INTO simple_items (title, price)
VALUES ('box', 10),
       ('sphere', 20),
       ('maul', 100),
       ('door', 50),
       ('camera', 500);

COMMIT;
