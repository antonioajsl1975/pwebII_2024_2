-- INSERT INTO veiculo (marca, modelo, preco, ano_fabricacao) VALUES ('Toyota', 'Corolla', '95000', '2020');
-- INSERT INTO veiculo (marca, modelo, preco, ano_fabricacao) VALUES ('Honda', 'Civic', '105000', '2019');
-- INSERT INTO veiculo (marca, modelo, preco, ano_fabricacao) VALUES ('Ford', 'Fusion', '115000', '2018');
-- INSERT INTO veiculo (marca, modelo, preco, ano_fabricacao) VALUES ('Chevrolet', 'Cruze', '98000', '2021');
--
--
-- INSERT INTO pessoa(nome) values('Antonella');
-- INSERT INTO pessoa(nome) values('Maria');
-- INSERT INTO pessoa(nome) values('Francisco');

INSERT INTO marca(nome) values('Toyota');
INSERT INTO marca(nome) values('Ford');
INSERT INTO marca(nome) values('Honda');
INSERT INTO marca(nome) values('Wolksvagen');
INSERT INTO marca (nome) VALUES ('Chery');
INSERT INTO marca (nome) VALUES ('BYD');

-- Modelos
INSERT INTO modelo(nome, marca_id) values('Corolla', 1);
INSERT INTO modelo(nome, marca_id) values('Hilux', 1);
INSERT INTO modelo(nome, marca_id) values('Ranger', 2);
INSERT INTO modelo(nome, marca_id) values('Civic', 3);
INSERT INTO modelo(nome, marca_id) values('Gol', 4);
INSERT INTO modelo(nome, marca_id) values('Tiggo 5', 5);


-- Alternância de modelos para veículos
INSERT INTO veiculo (modelo_id, preco, ano_fabricacao) VALUES (1, 95000, '2020');   -- Corolla (Toyota)
INSERT INTO veiculo (modelo_id, preco, ano_fabricacao) VALUES (3, 120000, '2020');  -- Ranger (Ford)
INSERT INTO veiculo (modelo_id, preco, ano_fabricacao) VALUES (4, 85000, '2020');   -- Civic (Honda)
INSERT INTO veiculo (modelo_id, preco, ano_fabricacao) VALUES (5, 45000, '2019');   -- Gol (Volkswagen)
INSERT INTO veiculo (modelo_id, preco, ano_fabricacao) VALUES (6, 70000, '2021');   -- Tiggo 5 (Chery)
INSERT INTO veiculo (modelo_id, preco, ano_fabricacao) VALUES (7, 80000, '2021');   -- Coolray (Geely)
INSERT INTO veiculo (modelo_id, preco, ano_fabricacao) VALUES (8, 130000, '2022');  -- Song Plus (BYD)
INSERT INTO veiculo (modelo_id, preco, ano_fabricacao) VALUES (9, 180000, '2022');  -- Poer (Great Wall)
INSERT INTO veiculo (modelo_id, preco, ano_fabricacao) VALUES (10, 50000, '2021');  -- Hongguang (Wuling)

INSERT INTO veiculo (modelo_id, preco, ano_fabricacao) VALUES (2, 180000, '2019');  -- Hilux (Toyota)
INSERT INTO veiculo (modelo_id, preco, ano_fabricacao) VALUES (3, 125000, '2021');  -- Ranger (Ford)
INSERT INTO veiculo (modelo_id, preco, ano_fabricacao) VALUES (4, 90000, '2021');   -- Civic (Honda)
INSERT INTO veiculo (modelo_id, preco, ano_fabricacao) VALUES (5, 47000, '2020');   -- Gol (Volkswagen)
INSERT INTO veiculo (modelo_id, preco, ano_fabricacao) VALUES (6, 75000, '2022');   -- Tiggo 5 (Chery)
INSERT INTO veiculo (modelo_id, preco, ano_fabricacao) VALUES (7, 85000, '2022');   -- Coolray (Geely)
INSERT INTO veiculo (modelo_id, preco, ano_fabricacao) VALUES (8, 135000, '2023');  -- Song Plus (BYD)
INSERT INTO veiculo (modelo_id, preco, ano_fabricacao) VALUES (9, 185000, '2023');  -- Poer (Great Wall)
INSERT INTO veiculo (modelo_id, preco, ano_fabricacao) VALUES (10, 52000, '2022');  -- Hongguang (Wuling)

