CREATE TABLE IF NOT EXISTS CLIENTS_DATA.CLIENT
(
    id               SERIAL PRIMARY KEY,
    client_name      VARCHAR(250) NOT NULL,
    personnel_number VARCHAR(250) NOT NULL,
    address_id       INT NOT NULL
);

INSERT INTO CLIENTS_DATA.CLIENT (id, client_name, personnel_number, address_id) VALUES (1, 'Lakeshia Jorgensen Denise Seely', 'AS2JF22O5MD8SZ6Q', 5);